fs = require('fs');

const data = fs.readFileSync('./chapter03/sec03/example.txt', 'utf-8');
fs.writeFileSync('./chapter03/sec03/text-1.txt', data);
