fs = require('fs');

// 기본 리턴 값은 Buffer 객체기 때문에 인코딩을 해야 제대로 볼 수 있다
fs.readFile('./chapter03/sec03/example.txt', 'utf-8', (err, data) => {
  if (err) {
    console.error(err);
    return;
  }
  console.log(data);
});
