/*
    Example of a multi-line comment just like in C#/Java
*/

// Single line comment

/**
 * Functions start with the word function.
 * They don't have a return type and the naming convention is camel-case.
 */
function variables() {

  // Declares a variable those value can be changed
  let letVar = "Can change!";
  console.log(letVar);
  letVar = "CHANGED!";
  console.log(letVar);

  // let letVar = "hi";

  // var varVar = "hello!";
  // var varVar = "hi!";
  // console.log(varVar);


  // Declares a variable where the value cannot be changed
  
  const constVar = 'Cannot change';
  console.log(constVar);

  // This will fail
  // constVar = 'New Value';


  // Declares a variable that will always be an array
  const myArray = ['a', 'b'];
  // myArray = ['hi', 'bye'];

  let myNum = 3;
  console.log(myNum);
  myNum = 3.5;
  console.log(myNum);
  myNum = 'Yoav';
  console.log(myNum);

  let forceNum = "5"
  console.log(`forceNum (${forceNum}) is number: ${!isNaN(forceNum)}`);
  forceNum = parseInt("6")
  console.log(`forceNum (${forceNum}) is number: ${!isNaN(forceNum)}`);
  forceNum = Number("10");
  console.log(`forceNum (${forceNum}) is number: ${!isNaN(forceNum)}`);


}

/**
 * Demo null vs undefined
 */
function nullVsUndefined() {
  let nullVal = null;
  let undefVal;


  console.log('nullVal: ' + nullVal);
  console.log('undefVal: ', undefVal);

  if (nullVal === null) {
    console.log("null");
  } else {
    console.log("not null");
  }

  if (undefVal === undefined) {
    console.log("undefined");
  } else {
    console.log("not undefined");
  }



}


/**
 * Compares two values x and y.
 * == is loose equality
 * === is strict equality
 * @param {Object} x
 * @param {Object} y
 */
 function equality(x, y) {
  console.log(`x is ${typeof x}`);
  console.log(`y is ${typeof y}`);

  console.log(`x == y : ${x == y}`); // true
  console.log(`x === y : ${x === y}`); // false
}

/**
 * Each value is inherently truthy or falsy.
 * false, 0, '', null, undefined, and NaN are always falsy
 * everything else is always truthy
 * @param {Object} x The object to check for truthy or falsy,
 */
function falsy(x) {
  if (x) {
    console.log(`${x} is truthy`);
  } else {
    console.log(`${x} is falsy`);
  }
}


/**
 * Demo if, else if, else, swtich
 */
function demoIfElseSwitch(value) {
  if (value === undefined) {
    console.log('value is undefined.');
  } else if (value === null) {
    console.log('value is null.');
  } else if (isNaN(value)) {
    console.log('value is not a number.');
    switch (value) {
      case 'a':
        console.log('value is a');
        break;
      case 'b':
        console.log('value is b');
        break;
      case 'c':
        console.log('value is c');
        break;
      default: {
        console.log('value is not a, b, c');
      }
    }
  } else if (value >= 0) {
    console.log(value + ' is positive.');
  } else {
    console.log(value + ' is negative.');
  }
}

/**
 * Demo for, while, do
 */
function count(maxNum) {

  console.log('for; ');
  for(let i = 1; i <= maxNum; i++) {
    console.log(i);
  }

  console.log('while: ');
  let count = 1;
  while(maxNum >= count) {
    console.log(count);
    count++;
  }

  //

  console.log('do: ');
  count = 1;
  do {
    console.log(count);
    count++;
  } while(maxNum >= count);
}

/**
 * Functions can also accept parameters.
 * Notice the parameters do not have types.
 * @param {Number} param1 The first number to display
 * @param {Number} param2 The second number to display
 */
function printParameters(param1, param2) {
  console.log(`The value of param1 is ${param1}`);
  console.log(`The value of param2 is ${param2}`);
}

/* Scope */
function demoScope() {
  let outer = 'outer';
  if (outer != undefined) {
    let inner = 'inner';
    console.log(`inner: ${inner}  outer: ${outer}`);
  }
  // console.log(`inner: ${inner}  outer: ${outer}`);

  /* shadowing */
  let shadow = "hello";
  console.log(`outer shadow: ${shadow}`);
  if (shadow != undefined) {
    // this will override for the duration of the block
    let shadow = 'bye';

    // this would UPDATE the original variable
    // shadow = 'bye';
    console.log(`inner shadow: ${shadow}`);
  }
  console.log(`outer shadow: ${shadow}`);
}

/**
 * Demo arrays
 */
function demoArrays() {
  let names = ['Yoav', 'Jim', 'Andrea'];
  console.log(`names[1]=${names[1]}`);

  for (let i = 0; i < names.length; i++) {
    console.log(`names[${i}]: ${names[i]}`);
  }


  console.log('----------------------------------')


  console.log(`elements in names: ${names.length}`);

  names.push('Amber');

  for (let i = 0; i < names.length; i++) {
    console.log(`names[${i}]: ${names[i]}`);
  }


  let popped = names.pop();
  console.log('----------------------------------');

  names.unshift('Tom');

  console.log('----------------------------------');

  let shifted = names.shift();
  console.log('----------------------------------');

  console.log(`includes Yoav: ${names.includes('Yoav')}`);
  console.log(`includes Tom: ${names.includes('Tom')}`);

  console.log(`indexOf Andrea: ${names.indexOf('Andrea')}`)
  console.log(`indexOf Tom: ${names.indexOf('Tom')}`)

}

/**
 *  Objects are simple key-value pairs
    - values can be primitive data types
    - values can be arrays
    - or they can be functions
*/
function objects() {
  const person = {
    firstName: "Bill",
    lastName: "Lumbergh",
    age: 42,
    employees: [
      "Peter Gibbons",
      "Milton Waddams",
      "Samir Nagheenanajar",
      "Michael Bolton"
    ]
  };

  // Log the object
  console.log(person);

  // Log the first and last name
  console.log(`${person.firstName} ${person.lastName}`);

  // Log each employee
  for (let i = 0; i < person.employees.length; i++) {
    console.log(`${person.employees[i]}`);
  }


  // CAN change property of existing object
  person.age = 50;
  console.log(person);

  // CANNOT assign a NEW object to const variable
  /*
  person = {
    firstName: "Donna",
    lastName: "Lumbergh",
    age: 42,
    employees: [
      "Peter Gibbons",
      "Milton Waddams",
      "Samir Nagheenanajar",
      "Michael Bolton"
    ]
  };
  */
}

function sumNums(val1, val2) {
  const sum = parseInt(val1 + val2);
  // console.log(sum);
  return sum;
}

// This will return NaN if the either param is not a number you can use for division
function div(val1, val2) {
  const sum = val1 / val2;
  return sum;
}


/*
########################
Function Overloading
########################

Function Overloading is not available in Javascript. If you declare a
function with the same name, more than one time in a script file, the
earlier ones are overriden and the most recent one will be used.
*/

function Add(num1, num2) {
  return num1 + num2;
}

function Add(num1, num2, num3) {
  return num1 + num2 + num3;
}

/*
########################
Math Library
########################

A built-in `Math` object has properties and methods for mathematical constants and functions.
*/

function mathFunctions() {
  console.log("Math.PI : " + Math.PI);
  console.log("Math.LOG10E : " + Math.LOG10E);
  console.log("Math.abs(-10) : " + Math.abs(-10));
  console.log("Math.floor(1.99) : " + Math.floor(1.99));
  console.log("Math.ceil(1.01) : " + Math.ceil(1.01));
  console.log("Math.random() : " + Math.random());
}

/*
########################
String Methods
########################

The string data type has a lot of properties and methods similar to strings in Java/C#
*/

function stringFunctions(value) {
  console.log(`.length -  ${value.length}`);
  console.log(`.endsWith('World') - ${value.endsWith("World")}`);
  console.log(`.startsWith('Hello') - ${value.startsWith("Hello")}`);
  console.log(`.indexOf('Hello') - ${value.indexOf("Hello")}`);

  /*
    Other Methods
        - split(string)
        - substr(number, number) [second param is NOT ending index - it is the LENGTH you want (how many characters)]
        - substring(number, number)  [works like substring in Java... second param is the index AFTER the last index you want]
        - toLowerCase()
        - trim()
        - https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/String
    */
}
