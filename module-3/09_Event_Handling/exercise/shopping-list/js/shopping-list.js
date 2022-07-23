let allItemsIncomplete = true;
const pageTitle = 'My Shopping List';
const groceries = [
  { id: 1, name: 'Oatmeal', completed: false },
  { id: 2, name: 'Milk', completed: false },
  { id: 3, name: 'Banana', completed: false },
  { id: 4, name: 'Strawberries', completed: false },
  { id: 5, name: 'Lunch Meat', completed: false },
  { id: 6, name: 'Bread', completed: false },
  { id: 7, name: 'Grapes', completed: false },
  { id: 8, name: 'Steak', completed: false },
  { id: 9, name: 'Salad', completed: false },
  { id: 10, name: 'Tea', completed: false }
];

/**
 * This function will get a reference to the title and set its text to the value
 * of the pageTitle variable that was set above.
 */
function setPageTitle() {
  const title = document.getElementById('title');
  title.innerText = pageTitle;
}

/**
 * This function will loop over the array of groceries that was set above and add them to the DOM.
 */
function displayGroceries() {
  const ul = document.querySelector('ul');
  groceries.forEach((item) => {
    const li = document.createElement('li');
    li.innerText = item.name;
    const checkCircle = document.createElement('i');
    checkCircle.setAttribute('class', 'far fa-check-circle');
    li.appendChild(checkCircle);
    ul.appendChild(li);
  });
}

function markCompleteSingle() {
const totalList = document.querySelector('ul');
const list = totalList.children;
Array.from(list).forEach( (product) => {
  const checkButton = product.querySelector('i');
  product.addEventListener('click', () => {
    product.classList.add('completed');
    checkButton.classList.add('completed');
  })
  product.addEventListener('dblclick', () => {
    product.classList.remove('completed');
    checkButton.classList.remove('completed');
  })
});
}

function markAll() {
  const totalList = document.querySelector('ul');
  const list = totalList.children;
  const buttonAll = document.getElementById('toggleAll');
  buttonAll.addEventListener('click', evt => {
    if (allItemsIncomplete) {
      Array.from(list).forEach( (product) => {
    product.classList.add('completed');
    product.querySelector('i').classList.add('completed');
    buttonAll.innerText = 'Mark All Incomplete';
    allItemsIncomplete = false;
    })
    } else {
      Array.from(list).forEach( (product) => {
    product.classList.remove('completed');
    product.querySelector('i').classList.remove('completed');
    buttonAll.innerText = 'Mark All Complete';
    allItemsIncomplete = true;
    })}
  })};

  document.addEventListener('DOMContentLoaded', () => {
    setPageTitle();
    displayGroceries();
    markCompleteSingle();
    markAll();
  });