<template>
  <div id="app">
    <h1>Budget Tracker</h1>
    <form @submit.prevent="addTransaction">
      <vue-datepicker
        v-model="form.date"
        placeholder="Select Date"
        format="yyyy-MM-dd"
        required
      ></vue-datepicker>
      <input type="text" v-model="form.detail" placeholder="Detail" required />
      <select v-model="form.type" @change="updateTags" required>
        <option value="" disabled>Select Type</option>
        <option value="income">Income</option>
        <option value="expense">Expense</option>
      </select>
      <select v-model="form.tag" required>
        <option v-for="tag in tags" :key="tag" :value="tag">{{ tag }}</option>
      </select>
      <input
        type="text"
        v-model="formattedAmount"
        @input="formatAmount"
        placeholder="Amount"
        required
      />
      <button type="submit">Save</button>
      <button type="button" @click="resetForm">Cancel</button>
    </form>

    <ul>
      <li v-for="transaction in transactions" :key="transaction._id">
        {{ transaction.date }} - {{ transaction.detail }} -
        {{ transaction.tag }} - {{ transaction.amount.toLocaleString() }} -
        {{ transaction.type }}
      </li>
    </ul>
  </div>
</template>

<script>
import axios from 'axios';
import VueDatePicker from 'vue2-datepicker';
import 'vue2-datepicker/index.css';

export default {
  components: {
    VueDatePicker,
  },
  data() {
    return {
      transactions: [],
      form: {
        date: '',
        detail: '',
        type: '',
        tag: '',
        amount: '',
      },
      tags: [],
      incomeTags: ['월급', '이자', '용돈', '이월', '기타'],
      expenseTags: [
        '식비',
        '교통',
        '주거통신',
        '문화생활',
        '쇼핑',
        '적금',
        '기타',
      ],
      formattedAmount: '',
    };
  },
  created() {
    this.fetchTransactions();
  },
  methods: {
    fetchTransactions() {
      axios.get('http://localhost:5000/transactions').then((response) => {
        this.transactions = response.data;
      });
    },
    addTransaction() {
      const transaction = {
        ...this.form,
        amount: parseFloat(this.form.amount.replace(/,/g, '')),
      };

      axios
        .post('http://localhost:5000/transactions', transaction)
        .then((response) => {
          this.transactions.push(response.data);
          this.resetForm();
        });
    },
    resetForm() {
      this.form = {
        date: '',
        detail: '',
        type: '',
        tag: '',
        amount: '',
      };
      this.formattedAmount = '';
      this.updateTags();
    },
    updateTags() {
      this.tags =
        this.form.type === 'income' ? this.incomeTags : this.expenseTags;
      this.form.tag = this.tags[0];
    },
    formatAmount() {
      this.form.amount = this.formattedAmount
        .replace(/,/g, '')
        .replace(/\B(?=(\d{3})+(?!\d))/g, ',');
    },
  },
};
</script>

<style>
label {
  display: block;
  margin-bottom: 10px; /* Adjusted margin for uniform spacing */
}

input,
select,
button {
  width: 100%;
  padding: 10px;
  margin-top: 10px; /* Adjusted margin for uniform spacing */
  box-sizing: border-box;
}

button {
  background-color: #27ae60;
  color: white;
  border: none;
  border-radius: 5px;
  cursor: pointer;
  margin-top: 20px; /* Ensure button has a consistent margin */
}

button:hover {
  background-color: #2ecc71;
}

.cancel-button {
  background-color: #ffffff; /* 하얀 배경 */
  color: #000000; /* 검은 텍스트 */
  border: 1px solid #000000; /* 검은 테두리 */
  padding: 5px 10px; /* 내부 여백 */
  cursor: pointer; /* 마우스 오버 시 커서 모양 */
}

.cancel-button:hover {
  background-color: #dddddd; /* 마우스 오버 시 배경색 변경 */
}
</style>
