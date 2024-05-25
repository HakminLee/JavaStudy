// 비동기 방식은 순서대로가 아닌 급한 순서대로 처리한다.
function displayA() {
  console.log('A');
}
function displayB() {
  setTimeout(() => {
    console.log('B');
  }, 2000);
}
function displayC() {
  console.log('C');
}

displayA();
displayB();
displayC();
