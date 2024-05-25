async function init() {
  try {
    // try : 요청이 성공했을 때 작동
    const Response = await fetch('http://jsonplaceholder.typicode.com/users');
    await response.json();
    const users = await response.json();
    console.log(users);
  } catch (err) {
    // catch : 요청이 실패했을 때 작동
    console.log(err);
  }
}

init();
