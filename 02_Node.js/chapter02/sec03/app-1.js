const user = require('./user'); // user/.js 에서 user 가져오기
const hello = require('./hello'); //hello.js 에서 hello 가져오기

console.log(user);
console.log(hello);

hello(user);
