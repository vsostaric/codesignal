function electionsWinners(votes, k) {

    function getMax(votes) {
        let max_value = -1;
        let max_count = 0;

        votes.forEach(function (vote) {

            if (vote >= max_value) {
                max_value = vote;
                max_count++;
            }

        });

        return {max_value: max_value, max_count: max_count};
    }

    const max = getMax(votes);

    let winners = [];
    votes.forEach(function (candidate) {
        if (candidate + k > max.max_value) {
            winners.push(candidate);
        }
    });

    return (winners.length === 0 && max.max_count === 1) ? 1 : winners.length
}

console.log(`Result: ${electionsWinners([2, 3, 5, 2], 3)} ; Should be 2`);
console.log(`Result: ${electionsWinners([1, 3, 3, 1, 1], 0)} ; Should be 0`);
console.log(`Result: ${electionsWinners([5, 1, 3, 4, 1], 0)} ; Should be 1`);
console.log(`Result: ${electionsWinners([1, 1, 1, 1], 1)} ; Should be 4`);
console.log(`Result: ${electionsWinners([1, 1, 1, 1], 0)} ; Should be 0`);
console.log(`Result: ${electionsWinners([3, 1, 1, 3, 1], 2)} ; Should be 2`);
console.log(`Result: ${electionsWinners([3, 1, 1, 3, 1, 7], 2)} ; Should be 1`);
