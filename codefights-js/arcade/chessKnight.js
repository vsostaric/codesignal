const moves = [
    (x, y) => [(x + 2), (y + 1)],
    (x, y) => [(x + 2), (y - 1)],
    (x, y) => [(x - 2), (y + 1)],
    (x, y) => [(x - 2), (y - 1)],
    (x, y) => [(x + 1), (y + 2)],
    (x, y) => [(x + 1), (y - 2)],
    (x, y) => [(x - 1), (y + 2)],
    (x, y) => [(x - 1), (y - 2)]

];

const xCoordinate = {
    "a": 1,
    "b": 2,
    "c": 3,
    "d": 4,
    "e": 5,
    "f": 6,
    "g": 7,
    "h": 8
};

isValidPosition = (position) => {
    return (position[0] > 0) && (position[0] < 9) && (position[1] > 0) && (position[1] < 9);
};

function chessKnight(cell) {

    const x = xCoordinate[cell[0]];
    const y = parseInt(cell[1]);

    return moves.filter(move => isValidPosition(move(x, y))).length;

}

console.log(`Result: ${chessKnight("a1")} ; Should be 2`);
console.log(`Result: ${chessKnight("c2")} ; Should be 6`);
console.log(`Result: ${chessKnight("d4")} ; Should be 8`);
console.log(`Result: ${chessKnight("g6")} ; Should be 6`);
console.log(`Result: ${chessKnight("a3")} ; Should be 4`);
