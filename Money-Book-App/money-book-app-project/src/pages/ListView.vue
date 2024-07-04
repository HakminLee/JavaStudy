<template>
  <div>
    <!-- Your template here -->
  </div>
</template>

<script>
import axios from 'axios';

export default {
  data() {
    return {
      transactions: [],
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
  },
};
</script>

<style>
/* Your styles here */
</style>
