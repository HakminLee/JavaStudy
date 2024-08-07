let obj1 = { name: '박문수', age: 29 };
let obj2 = obj1; // obj1 객체의 주소를 복사했다.
let obj3 = { ...obj1 }; // obj1 객체의 값을 복사
let obj4 = { ...obj1, email: 'mspark@gmail.com' };

obj2.age = 19;
// obj1과 obj2sms 같은 주소를 가르키고 있기 때문에 값이 같이 변경된다.
console.log(obj1);
console.log(obj2);
// obj3dms 값만 복사했기 때문에 같이 변경되지 않는다.
console.log(obj3);
console.log(obj1 == obj2); // 같은 주소기 때문에 true
console.log(obj1 == obj3); // 다른 주소기 때문에 false

let arr1 = [100, 200, 300];
// 전개 연산자를 통해 원하는 값들을 중간에 삽입 가능
let arr2 = ['hello0', ...arr1, 'world'];
console.log(arr1);
console.log(arr2);
