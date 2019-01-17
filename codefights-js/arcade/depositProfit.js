function calculateNumberOfRates(n, deposit, rate, threshold) {

    if (deposit >= threshold) {
        return n;
    }

    return calculateNumberOfRates(n + 1, deposit + deposit * rate / 100, rate, threshold)

}

function depositProfit(deposit, rate, threshold) {
    return calculateNumberOfRates(0, deposit, rate, threshold)
}

console.log(`Result: ${depositProfit(100, 20, 170)} ; Should be 3`);
console.log(`Result: ${depositProfit(100, 1, 101)} ; Should be 1`);
console.log(`Result: ${depositProfit(1, 100, 64)} ; Should be 6`);
console.log(`Result: ${depositProfit(20, 20, 50)} ; Should be 6`);