function arrayReplace(inputArray, elemToReplace, substitutionElem) {

    const replaceArray = new Array(inputArray.length);

    for (let i = 0; i < inputArray.length; i++) {
        let replace_element;
        if (inputArray[i] === elemToReplace) {
            replace_element = substitutionElem;
        } else {
            replace_element = inputArray[i];
        }
        replaceArray[i] = replace_element
    }

    return replaceArray
}

console.log(`Result: ${arrayReplace([1, 2, 1], 1, 3)} ; Should be [3, 2, 3]`);
