let human = {
  name: '김상형',
  age: 29,
  intro: function () {
    console.log('name = ' + this.name);
    console.log('age = ' + this.age);
  },
};

human.intro();
