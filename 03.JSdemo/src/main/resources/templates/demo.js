function printStars(count){
    console.log("*".repeat(count));
}

printStars(10);
// printStars("test");

function separator(){
  console.log("---------");
}
separator();

let stars = function printStars(){
    console.log("*".repeat(20));
}
stars();
separator();

console.log(testHosting+ " " + typeof testHosting);

var testHosting;
testHosting = "41";
console.log(testHosting + " " + typeof testHosting);
separator();

num = 6;
console.log(num);
var num;
// let num; - ReferenceError without var/let also
separator();

let person = {
  firstName: "John",
  lastName: "Doe",
  age: 50, documentsNumbers: {id:25, carId: 53},
  function: {printStars}
};
// console.log(person);

let keys = Object.keys(person);
let values = Object.values(person);

console.log(keys);
console.log(values);
separator();
if(person.hasOwnProperty("firstName")){
  console.log(person.firstName);
}
separator();

let obj = {a: 1, b: 2, c: 3};
for (const key in person) {
  console.log(`person.${key} = ${person[key]}`);
}
separator();
// person.functions.printStars();
console.log(person.documentsNumbers.id);
separator();
for (const key of keys) {
  console.log(`person.${key} = ${person[key]}`);
}
separator();

values.forEach(v => console.log(v));