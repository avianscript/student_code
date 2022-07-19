/**
 * All named functions will have the function keyword and
 * a name followed by parentheses.
 * 
 * @returns {number} 1
 */
function returnOne() {
  return 1;
}

/**
 * Functions can also take parameters. These are just variables that are filled
 * in by whoever is calling the function.
 *
 * Also, we don't *have* to return anything from the actual function.
 *
 * @param {any} value the value to print to the console
 */
function printToConsole(value) {
  console.log(value);
}

/**
 * Write a function called multiplyTogether that multiplies two numbers together. But 
 * what happens if we don't pass a value in? What happens if the value is not a number?
 *
 * @param {number} firstParameter the first parameter to multiply
 * @param {number} secondParameter the second parameter to multiply
 */
function multiplyTogether(firstParameter, secondParameter) {
  return firstParameter * secondParameter;
}

/**
 * This version makes sure that no parameters are ever missing. If
 * someone calls this function without parameters, we default the
 * values to 0. However, it is impossible in JavaScript to prevent
 * someone from calling this function with data that is not a number.
 * Call this function multiplyNoUndefined
 *
 * @param {number} [firstParameter=0] the first parameter to multiply
 * @param {number} [secondParameter=0] the second parameter to multiply
 * @returns {number} firstParameter multiplied by secondParameter
 */
 function multiplyNoUndefined(firstParameter = 0, secondParameter = 0) {
  return firstParameter * secondParameter;
}

/**
 * Outputs all the contents of the passed in array
 * @param {array} data  defaults to empty array
 */
function printArray(data = []) {
  for (let i = 0; i < data.length; i++) {
    console.log(data[i]);
  }
}
 
function printPerson(person = { firstName: '', lastName: ''}) {
  console.log(person.firstName + ' ' + person.lastName);
  printArray()
}


function printGreeting(name, greeting, message = greeting + ' ' + name) {
  console.log(`${name} ${greeting} ${message}`);
}
/**
 * Functions can return earlier before the end of the function. This could be useful
 * in circumstances where you may not need to perform additional instructions or have to
 * handle a particular situation.
 * In this example, if the firstParameter is equal to 0, we return secondParameter times 2.
 * Observe what's printed to the console in both situations.
 * 
 * @param {number} firstParameter the first parameter
 * @param {number} secondParameter the second parameter
 */
function returnBeforeEnd(firstParameter, secondParameter) {
  console.log("This will always fire.");

  if (firstParameter == 0) {
    console.log("Returning secondParameter times two.");
    return secondParameter * 2;
  }

  //this only runs if firstParameter is NOT 0
  console.log("Returning firstParameter + secondParameter.");
  return firstParameter + secondParameter;
}

/**
 * Scope is defined as where a variable is available to be used.
 *
 * If a variable is declare inside of a block, it will only exist in
 * that block and any block underneath it. Once the block that the
 * variable was defined in ends, the variable disappears.
 */
function scopeTest() {
  // This variable will always be in scope in this function
  let inScopeInScopeTest = true;

  if (inScopeInScopeTest) {
    // this variable lives inside this block and doesn't
    // exist outside of the block
    let scopedToBlock = inScopeInScopeTest;
  }

  
  // scopedToBlock doesn't exist here so an error will be thrown
  if (inScopeInScopeTest && scopedToBlock) {
    console.log("This won't print!");
  }
  
}

/**
 * Take the details of a person and create and English sentence that
 * uses the information to describe them. Join the quirks with the separator
 * or ',' by default.
 * 
 * @param {string} name 
 * @param {number} age 
 * @param {string[]} listOfQuirks 
 * @param {string} separator 
 * @returns {string} the full sentence
 */
function createSentenceFromUser(name, age, listOfQuirks = [], separator = ', ') {
  let description = `${name} is currently ${age} years old. Their quirks are: `;
  return description + listOfQuirks.join(separator);
}

function demoAnonAssignedToVar() {
  const sumTwoNums = (num1, num2) => { return num1 + num2 };

  console.log(sumTwoNums(5, 8));

}



/**
 * Takes an array and, using the power of anonymous functions, generates
 * their sum.
 *
 * @param {number[]} numbersToSum numbers to add up
 * @returns {number} sum of all the numbers
 */
function sumAllNumbers(numbersToSum) {
  const sumTwoNums = (num1, num2) => { return num1 + num2 };
  const multTwoNums = (num1, num2) => { return num1 * num2 };
  // return numbersToSum.reduce(multTwoNums);

  // return numbersToSum.reduce( (num1, num2) => { return num1 * num2} );
  return numbersToSum.reduce( (num1, num2) => num1 + num2  );
}

/**
 * Takes an array and returns a new array of only numbers that are
 * multiples of 3
 *
 * @param {number[]} numbersToFilter numbers to filter through
 * @returns {number[]} a new array with only those numbers that are
 *   multiples of 3
 */
function allDivisibleByThree(numbersToFilter) {
return numbersToFilter.filter( (value) => { return value % 3 === 0} );

}

function allDivisibleByFive(numbersToFilter) {
  return numbersToFilter.filter( (value) => { return value % 5 === 0} );
  
  }


function includesX(data) {
  // return data.filter( (value) => { return value.includes('X')});
  // return data.filter( value => { return value.includes('X')});
  return data.filter( value => value.includes('X') );
}


function filterEven(values) {
  return values.filter( linda => linda % 2 === 0  )
}

/**
 * Takes an array of numbers and returns a new array with the values from the original 
 * array but with 3 added to each value
 * 
 * @param {number[]} numbersArray 
 * @returns {number[]} a new array with values from the original 
 * array but with 3 added to each value
 */
function addThreeToAll(numbersArray) {
  return numbersArray.map( value => value + 3);
}

function returnLengths(arrayOfStrings) {
  return arrayOfStrings.map( val => {
    const length = val.length;
    return `Length is ${length}`;
   }
  );
}


/**
 * Takes an array and outputs each value in the array to the console
 * @param {[]} values 
 */
function dumpArray(values) {
  values.forEach( linda => console.log(linda));
}



function allEvens(numbers) {
  return numbers.every( val => val % 2 === 0 );
}

function someEvens(numbers) {
  return numbers.some( val => val % 2 === 0 );
}


function sortDescending(numbers) {
  return numbers.sort( (val1, val2) => 
    {
          if (val1 > val2) {
            return -1;
          } else if (val2 > val1) {
            return 1;
          }
          return 0;
    }
  );
}


function demoArguments(param1) {

  console.log(param1);

  /*
  every function has an arguments array available to it that indicates
  what arguments (parameters) were passed to it - whether the function
  expects any or not
  */

  for (let i = 0; i < arguments.length; i++) {
    console.log(`argument ${i}: ${arguments[i]}`);
  }

  /*
  arguments is a legacy object though which doesn't support the Array
  prototype, so this won't work! 
  */
  return Array.from(arguments).filter( val => val % 2 === 0);

  
}