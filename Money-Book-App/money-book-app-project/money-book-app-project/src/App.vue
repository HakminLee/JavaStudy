<template>
  <div id="app">
    <h1></h1>
    <form @submit.prevent="addTransaction" class="form">
      <!-- 날짜 선택 -->
      <input type="date" v-model="form.date" required class="input-field" />

      <!-- 상세 내용 입력 -->
      <!-- 분류 선택 -->
      <select
        v-model="form.type"
        @change="updateTags"
        required
        class="input-field"
      >
        <option value="" disabled>분류를 선택해주세요</option>
        <option value="income">수입</option>
        <option value="expense">지출</option>
      </select>

      <!-- 태그 선택 -->
      <select v-model="form.tag" required class="input-field">
        <option value="" disabled selected>상세 카테고리를 선택하세요</option>
        <option v-for="tag in tags" :key="tag" :value="tag">{{ tag }}</option>
      </select>

      <!-- 상세 내용 입력 -->
      <input
        type="text"
        v-model="form.detail"
        placeholder="수입/지출의 내용을 입력하세요"
        required
        class="input-field"
      />
      <!-- 금액 입력 -->
      <input
        type="text"
        v-model="formattedAmount"
        @input="formatAmount"
        placeholder="금액"
        required
        class="input-field"
      />

      <!-- 저장 및 취소 버튼 -->
      <button type="submit" class="submit-button">저장</button>
      <button type="button" class="cancel-button" @click="resetForm">
        취소
      </button>
    </form>

    <!-- 추가된 거래 목록 -->
    <ul class="transaction-list">
      <li
        v-for="transaction in transactions"
        :key="transaction._id"
        class="transaction-item"
      >
        {{ transaction.date }} - {{ transaction.detail }} -
        {{ transaction.tag }} - {{ transaction.amount.toLocaleString() }} -
        {{ transaction.type }}
      </li>
    </ul>
  </div>
</template>

<script>
import axios from 'axios';

export default {
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
      // 입력된 숫자에서 쉼표를 제거하고, 정규식을 사용하여 천단위마다 쉼표를 추가합니다.
      let amount = parseFloat(this.formattedAmount.replace(/[^0-9]/g, ''));
      // 만약 입력된 값이 숫자가 아니라면 무시합니다.
      if (isNaN(amount)) return;

      // 숫자를 천단위 구분 기호가 추가된 문자열로 포맷합니다.
      this.formattedAmount = amount.toLocaleString() + '원';
    },
  },
};
</script>

<style scoped>
.container {
  max-width: 400px;
  margin: 0 auto;
  padding: 20px;
  border: 1px solid #ccc;
  border-radius: 5px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
}

.form {
  display: flex;
  flex-direction: column;
}

.input-field {
  margin-bottom: 10px;
  padding: 10px;
  border: 1px solid #ccc;
  border-radius: 5px;
}

.submit-button {
  background-color: #776264;
  color: white;
  border: none;
  border-radius: 5px;
  cursor: pointer;
  padding: 10px;
}

.submit-button:hover {
  background-color: #776264;
}

.cancel-button {
  background-color: #ffffff;
  color: #000000;
  border: 1px solid #000000;
  padding: 5px 10px;
  cursor: pointer;
}

.cancel-button:hover {
  background-color: #dddddd;
}

.transaction-list {
  list-style-type: none;
  padding: 0;
}

.transaction-item {
  margin-top: 10px;
}
</style>
