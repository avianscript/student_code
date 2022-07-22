

/*
Step 1: Add an eventListener to the document which will listen
for the event indicating the DOM is ready. Once the event is fired
add this eventListener is triggered, the code inside it will run
*/
document.addEventListener('DOMContentLoaded', () => {


    /*
    Step 2: create a word div that looks like the divs with the item-text class
    its id will be music-word-div and add it to the div with the class item-grid
    */

    // <div class="item-text" id="cheers-word-div"> 
    const musicWordDiv = document.createElement('div');
    musicWordDiv.classList.add('item-text');
    musicWordDiv.setAttribute('id', 'music-word-div');

    // <div class="item-grid">

    const itemGrid = document.querySelector('.item-grid');
    // itemGrid.insertAdjacentElement('beforeend', musicWordDiv);
    itemGrid.appendChild(musicWordDiv);





    /* Step 3 create a span element with the id music-word
    */
    const musicWordSpan = document.createElement('span');
    musicWordSpan.setAttribute('id', 'music-word');


    /* Step 4: set the new spans contents to the word MUSIC */

    musicWordSpan.innerText = 'MUSIC';


    /* Step 5: add the span you created to word div you created above */

    musicWordDiv.appendChild(musicWordSpan);




    /* Step 6: a method called createXYPosDiv has been created to
        add the XYPos panel to the given parent. call this method
        with the grid element as a parameter to add the panel to the grid*/
    createXYPosDiv(itemGrid);



    /* Step 7: fill out the item-grid class in styles.css to be a grid with 3 columns
        with ratio 3:5:2 and 3 rows.

        the rows should each contain the item-image and corresponding item-text
        (i.e. cheers-image-div cheers-word-div) in the first 2 columns.

        the final row should contain the mouse-coords-div in the 3rd column
    */



    /* Step 8: create a function which will select all the text items and
        update them to have the text-italic class. use forEach to iterate
        over the items */

    function textItalic() {
        const items = document.querySelectorAll('.item-text');
        items.forEach(text => {
            text.classList.add('text-italic');

            /* If you do this you will OVERWRITE the existing style (item-text) rather than
                adding the text-italic style to what is already there
            */
            // text.setAttribute('class', 'text-italic');
        });
    }


    /* Step 9: call the method you wrote in step 9 */
    textItalic();



    /*
        Step 10: Add a listener for the mouse being over the element with the id cheers-word
        
        The listener should call the existing toggleColor method with the element 
        that fired the event

    */
    const cheersWord = document.getElementById('cheers-word');
    cheersWord.addEventListener('mouseover', evt => {

        /* only do this if I am handling my OWN event. If target and currentTarget
            are NOT the same, this means I got this event as a side effect of one
            that was triggered by something else (I am currentTarget, triggering element is target)
            */
        if (evt.target === evt.currentTarget) {
            toggleColor(evt.target);
        }
    });



    /* Step 11: Add a listener to the cheers-word span that calls the toggleColor
        method with the element that fired the event when the mouse moves
        out of the element
    */



        cheersWord.addEventListener('mouseleave', evt => {

            /* only do this if I am handling my OWN event. If target and currentTarget
                are NOT the same, this means I got this event as a side effect of one
                that was triggered by something else (I am currentTarget, triggering element is target)
                */
            if (evt.target === evt.currentTarget) {
                toggleColor(evt.target);
            }
        });

    /*
        Step 12: Add a listener for the mouse being clicked 
        on the element with the id cheers-image
        
        The listener should call the existing toggleColor method with the element 
        that fired the event

    */
    const cheersImg = document.getElementById('cheers-image');
    cheersImg.addEventListener( 'click', evt => {
        toggleColor(evt.target);
    } );


    /* Step 13: call the provided method addListenersToOtherWordsAndImages method
         (no params) to
         attach similar listeners to the other words and images */
         addListenersToOtherWordsAndImages();

    /* Step 14: Write a function that takes the x and y coordinates and
     updates them in the x y position panel */
    


    /*
    Step 15: Add a listener for the mouse moving that uses the function you created above
    */
   document.addEventListener('mousemove', evt => updateXYPos(evt.clientX, evt.clientY));
   
});

function updateXYPos(x, y) {
    const xPosSpan = document.getElementById('x-pos');
    const yPosSpan = document.getElementById('y-pos');

    xPosSpan.innerText = x;
    yPosSpan.innerText = y;
}
