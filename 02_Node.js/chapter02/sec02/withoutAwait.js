fetch('http://jsonplaceholder.typicode.com/users')
  // 요청이 성공했을 때 받아온 데이터를 json으로 변경
  .then((Response) => Response.json())
  // json으로 변경 후 콘솔에 출력
  .then((data) => console.log(data))
  // 요청이 실패했을 때 출력
  .catch((err) => console.log(err));
