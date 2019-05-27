// A string representing time in HH:MM format.
// It is guaranteed that the first two characters, as well as the last two characters, are digits.

function validTime(time) {

    const timeArr = time.split(":");
    return 0 <= timeArr[0] && 24 > timeArr[0] && 0 <= timeArr[1] && 60 > timeArr[1];

}

console.log(`Result: ${validTime("13:58")} ; Should be true`);
console.log(`Result: ${validTime("25:51")} ; Should be false`);
console.log(`Result: ${validTime("02:76")} ; Should be false`);
console.log(`Result: ${validTime("24:00")} ; Should be false`);
console.log(`Result: ${validTime("01:60")} ; Should be false`);
console.log(`Result: ${validTime("01:59")} ; Should be true`);
console.log(`Result: ${validTime("00:11")} ; Should be true`);
console.log(`Result: ${validTime("00:01")} ; Should be true`);
console.log(`Result: ${validTime("-1:01")} ; Should be false`);
console.log(`Result: ${validTime("2:1")} ; Should be true`);

function test(numberOfTests) {

    const validTimes = new Set();

    function createTimeString(n) {
        return n < 10 ? "0" + n : "" + n;
    }

    function getRandomInt(min, max) {
        min = Math.ceil(min);
        max = Math.floor(max);
        return Math.floor(Math.random() * (max - min)) + min;
    }

    for (i of Array(24).keys()) {
        const hour = createTimeString(i);
        for (j of Array(60).keys()) {
            const minutes = createTimeString(j);
            validTimes.add(hour + ":" + minutes);
        }
    }

    let testNum = 0;
    while (testNum < numberOfTests) {

        testTime = createTimeString(getRandomInt(-20, 150)) + ":" + createTimeString(getRandomInt(-20, 150));

        if (validTimes.has(testTime) !== validTime(testTime)) {
            console.log(`Found error: ${testTime}`);
            break;
        }
        testNum++;
    }
    console.log(`Ran ${testNum} tests and found no errors`)

}

test(5000);
