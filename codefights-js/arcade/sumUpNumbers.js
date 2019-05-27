function sumUpNumbers(inputString) {

    const numbers = inputString.match(/[0-9]*/g).filter(num => num !== "");
    if (numbers.length === 0) {
        return 0;
    }
    return numbers.map(num => Number.parseInt(num)).reduce((sum, x) => sum + x);
}

console.log(`${sumUpNumbers("2 apples, 12 oranges")} --> should be 14`);
console.log(`${sumUpNumbers("123450")} --> should be 123450`);
console.log(`${sumUpNumbers("Your payment method is invalid")} --> should be 0`);
console.log(`${sumUpNumbers("there are some (12) digits 5566 in this 770 string 239")} --> should be 6587`);
console.log(`${sumUpNumbers("42+781")} --> should be 823`);

