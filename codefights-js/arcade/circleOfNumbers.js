function circleAddition(a, b, n) {
    add = a + b;
    return (add > n - 1) ? (add % n) : add
}

function circleOfNumbers(n, firstNumber) {
    return circleAddition(firstNumber, (n / 2), n);
}

console.log(`Result: ${circleOfNumbers(10, 2)} ; Should be 7`);
console.log(`Result: ${circleOfNumbers(10, 7)} ; Should be 2`);
console.log(`Result: ${circleOfNumbers(4, 1)} ; Should be 3`);
console.log(`Result: ${circleOfNumbers(6, 3)} ; Should be 0`);
