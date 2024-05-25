// 동기 방식은 순서대로 실행한다.
function displayA() {
  console.log('A');
}
function displayB() {
  console.log('B');
}
function displayC() {
  console.log('C');
}

displayA();
displayB();
displayC();
