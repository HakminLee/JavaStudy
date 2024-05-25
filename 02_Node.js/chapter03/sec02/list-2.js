const fs = require('fs');

//fs.readdir: 비동기로 폴더를 읽어온다.
fs.readdir('./', (err, files) => {
  if (err) {
    console.error(err);
    // return을 만나면 함수 종료.(에러가 났을 경우)
    return;
  }
  console.log(files);
});
