// add pageTitle
let pageTitle = 'My Shopping List';
// add groceries
let groceries = ["taco seasoning", "taco meat", "lettuce", "tomatoes", "salsa", "cheddar cheese", "tortillas", "sour cream", "lime", "napkins"];
/**
 * This function will get a reference to the title and set its text to the value
 * of the pageTitle variable that was set above.
 */
function setPageTitle() {
 document.getElementById('title').innerText = pageTitle;
}

/**
 * This function will loop over the array of groceries that was set above and add them to the DOM.
 */
function displayGroceries() {
  groceries.forEach( (product) => {
    const singleItem = document.createElement('li');
    singleItem.innerText = product;
    document.getElementById('groceries').appendChild(singleItem);
  }); 
}

/**
 * This function will be called when the button is clicked. You will need to get a reference
 * to every list item and add the class completed to each one
 */
function markCompleted() {
 const list = document.getElementById('groceries');
 const items = list.children;
 Array.from(items).forEach ( (item) => {
   item.classList.add('completed');
 });
}



setPageTitle();

displayGroceries();

// Don't worry too much about what is going on here, we will cover this when we discuss events.
document.addEventListener('DOMContentLoaded', () => {
  // When the DOM Content has loaded attach a click listener to the button
  const button = document.querySelector('.btn');
  button.addEventListener('click', markCompleted);
});
