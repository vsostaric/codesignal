function getPath(rowIndex, cellIndex) {
    return [
        [rowIndex + 1, cellIndex],
        [rowIndex + 1, cellIndex - 1],
        [rowIndex, cellIndex - 1],
        [rowIndex - 1, cellIndex - 1],
        [rowIndex - 1, cellIndex],
        [rowIndex - 1, cellIndex + 1],
        [rowIndex, cellIndex + 1],
        [rowIndex + 1, cellIndex + 1],
    ]
}

function isPositionValid(position, matrix) {

    row_num = matrix.length
    col_num = matrix[0].length

    return position[0] >= 0 && position[0] < row_num && position[1] >= 0 && position[1] < col_num;
}

function minesweeper(matrix) {

    result = [];
    matrix.forEach(function (row, row_index) {
        result_row = [];
        row.forEach(function (cell, cell_index) {
            minesAroundCell = 0;
            getPath(row_index, cell_index).forEach(function (position) {
                if (isPositionValid(position, matrix) && matrix[position[0]][position[1]]) {
                    minesAroundCell++
                }
            });
            result_row.push(minesAroundCell)
        });
        result.push(result_row)
    });
    return result
}

console.log(`Result: ${minesweeper(
    [[true, false, false],
        [false, true, false],
        [false, false, false]]
)} ; Should be 
    ${[[1, 2, 1],
    [2, 1, 1],
    [1, 1, 1]]}`);