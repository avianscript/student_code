
let uhOhArea;
let nameField;

const uhOhMsg = "You hacked the code!!!";


/*

Here's how to see the dangers of innerHTML injection:

1) start this page with Live Server
2) Try entering your name in the input field and clicking Save button
3) Now add this in the box instead and click the Save button

<img src='x' onerror='alert(uhOhMsg)'>

4) In the code below, change innerText to innerHTML in the line under
    the comment
    
    // Change to innerHTML to see the dangers of injection

5) Now try the scenario in #3 again
6) You should now see the danger of injection
7) Once you have seen this. Try entering this into the box and
   clicking Save. This behavior is A LOT more dramatic!

<img src='x' onerror='location.href="http://www.techelevator.com"'>

*/


document.addEventListener('DOMContentLoaded', () => {
    console.log('Ready');
    uhOhArea = document.getElementById('uh-oh');

    nameField = document.getElementById('name');

    const btn = document.getElementById('save');
    btn.addEventListener('click', () => {

        // Change to innerHTML to see the dangers of injection
        uhOhArea.innerText = nameField.value;
    });
});
