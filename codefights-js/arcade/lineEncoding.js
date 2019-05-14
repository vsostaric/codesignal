// Can actually be done in few lines of code using regex
function lineEncoding(s) {

    const brokenLine = [];
    let i = 0;
    let j = 1;
    while (j < s.length) {
        if (s[i] !== s[j]) {
            brokenLine.push(s.substring(i, j));
            i = j;
            j++;
        } else {
            j++;
        }
    }
    brokenLine.push(s.substring(i));

    let encoded = "";
    for (part in brokenLine) {
        encoded += (brokenLine[part].length > 1) ?
            `${brokenLine[part].length}${brokenLine[part][0]}` : `${brokenLine[part][0]}`
    }

    return encoded;
}


console.log(`Result: ${lineEncoding("aabbbc")} ; Should be 2a3bc`);
console.log(`Result: ${lineEncoding("abbcabb")} ; Should be a2bca2b`);
console.log(`Result: ${lineEncoding("abcd")} ; Should be abcd`);
console.log(`Result: ${lineEncoding("zzzz")} ; Should be 4z`);
