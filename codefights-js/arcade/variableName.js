// Correct variable names
// consist only of English letters, digits and underscores and
// they can't start with a digit.

function isNumber(character) {
    return Number.isInteger(parseInt(character))
}

function isLetter(character) {
    return (/[a-z]/i).test(character);
}

function variableName(name) {

    return !isNumber(name[0]) && name.split("").every(character => isLetter(character) || isNumber(character) || character === '_')
}

console.log(`Result: ${variableName('var_1__Int')} ; Should be true`);
console.log(`Result: ${variableName('qq-q')} ; Should be false`);
console.log(`Result: ${variableName('2w2')} ; Should be false`);



