function evenDigitsOnly(n) {
    return n.toString().split("").every(digit => digit % 2 == 0)
}

console.log(`Result: ${evenDigitsOnly(248622)} ; Should be true`);
console.log(`Result: ${evenDigitsOnly(642386)} ; Should be false`);