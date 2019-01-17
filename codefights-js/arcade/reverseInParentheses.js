function reverseString(inputString) {
    return inputString.split("").reverse().join("")
}

function findInnermostLeftIterator(inputString) {

    let finalIndex = 0;
    inputString.split("").forEach(function (letter, index) {
        if (letter === '(') {
            finalIndex = index
        }
    });

    return finalIndex

}

function reverseInParentheses(inputString) {

    if (!inputString.includes("(")) {
        return inputString
    }

    let leftIterator = findInnermostLeftIterator(inputString);
    let rightIterator = leftIterator + 1;

    while (inputString[leftIterator] !== "(") {
        leftIterator--
    }
    while (inputString[rightIterator] !== ")") {
        rightIterator++
    }

    resultString =
        inputString.substring(0, leftIterator) +
        reverseString(inputString.substring(leftIterator + 1, rightIterator)) +
        inputString.substring(rightIterator + 1)

    return reverseInParentheses(resultString)
}

console.log(`${reverseInParentheses("(bar)")} --> should be rab`);
console.log(`${reverseInParentheses("foo(bar)baz")} --> should be foorabbaz`);
console.log(`${reverseInParentheses("foo(bar)baz(blim)")} --> should be foorabbazmilb`);
console.log(`${reverseInParentheses("foo(bar(baz))blim")} --> should be foobazrabblim`);
console.log(`${reverseInParentheses("foo(bar(baz))blim(lim)dd")} --> should be foobazrabblimmildd`);
