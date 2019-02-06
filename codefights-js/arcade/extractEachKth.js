function extractEachKth(inputArray, k) {
    return inputArray.filter(function (element, index) {
        return (index + 1) % k !== 0
    });
}

console.log(`Result: ${extractEachKth([1, 2, 3, 4, 5, 6, 7, 8, 9, 10], 3)} ; Should be [1, 2, 4, 5, 7, 8, 10]`);
console.log(`Result: ${extractEachKth([1, 1, 1, 1, 1], 1)} ; Should be []`);
console.log(`Result: ${extractEachKth([1, 2, 1, 2, 1, 2, 1, 2], 2)} ; Should be [1, 1, 1, 1]`);