function solution(product) {

    if (product === 0) {
        return 10;
    }

    for (let i = product; i < product * 10; i++) {
        if (isSolution(i, product)) {
            return i;
        }
    }


    return -1;
}

function isSolution(solution, product) {
    return solution.toString().split("")
        .map(digit => parseInt(digit))
        .reduce((i, j) => i * j, 1) === product;

}


console.log(`Result: ${solution(12)} ; Should be 26`);
console.log(`Result: ${solution(19)} ; Should be -1`);
console.log(`Result: ${solution(450)} ; Should be 2559`);
console.log(`Result: ${solution(0)} ; Should be 10`);
console.log(`Result: ${solution(13)} ; Should be -1`);
console.log(`Result: ${solution(1)} ; Should be 1`);
console.log(`Result: ${solution(243)} ; Should be 399`);
console.log(`Result: ${solution(576)} ; Should be 889`);
console.log(`Result: ${solution(360)} ; Should be 589`);

/*
*
243

	1. Break into x*N where x is the smallest possible single digit prime number

		Loop through [2,3,5,7]
			2*X = 243 !!!
			3 * X = 243
				=> X = 27

		3 * 27 = 243

		If x doesn't exist return -1

	2. Break X into x*N where x is the smallest possible single digit prime number

		Repeat until x doesn't exist

		3 * 3 * 9 = 243

	3. Create minimum number from given digits

		3, 3, 9 = > 339
*
* */
