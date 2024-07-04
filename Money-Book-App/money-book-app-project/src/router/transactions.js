const express = require('express');
const router = express.Router();
const Transaction = require('../models/transaction');

// GET all transactions
router.get('/', async (req, res) => {
  const transactions = await Transaction.find();
  res.json(transactions);
});

// POST a new transaction
router.post('/', async (req, res) => {
  const transaction = new Transaction(req.body);
  await transaction.save();
  res.status(201).json(transaction);
});

module.exports = router;
