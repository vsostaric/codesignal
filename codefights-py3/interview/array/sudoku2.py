import numpy as np
import itertools


def check_numbers(numbers):
    numbers = [num for num in numbers if num != '.']
    return len(numbers) == len(set(numbers))


def sudoku2(grid):
    columns = grid
    rows = [list(row) for row in list(zip(*grid))]

    sections = []
    for i, j in itertools.product([0, 3, 6], [0, 3, 6]):
        section = np.array(grid)[i:(i + 3), j:(j + 3)].tolist()
        section = [item for sublist in section for item in sublist]
        sections.append(section)

    for numberLists in (columns + rows + sections):
        if not check_numbers(numberLists):
            return False

    return True


grid = [['.', '.', '.', '1', '4', '.', '.', '2', '.'],
        ['.', '.', '6', '.', '.', '.', '.', '.', '.'],
        ['.', '.', '.', '.', '.', '.', '.', '.', '.'],
        ['.', '.', '1', '.', '.', '.', '.', '.', '.'],
        ['.', '6', '7', '.', '.', '.', '.', '.', '9'],
        ['.', '.', '.', '.', '.', '.', '8', '1', '.'],
        ['.', '3', '.', '.', '.', '.', '.', '.', '6'],
        ['.', '.', '.', '.', '.', '7', '.', '.', '.'],
        ['.', '.', '.', '5', '.', '.', '.', '7', '.']]

print(str(sudoku2(grid)) + ' ---> Should be True')

grid = [['.', '.', '.', '.', '2', '.', '.', '9', '.'],
        ['.', '.', '.', '.', '6', '.', '.', '.', '.'],
        ['7', '1', '.', '.', '7', '5', '.', '.', '.'],
        ['.', '7', '.', '.', '.', '.', '.', '.', '.'],
        ['.', '.', '.', '.', '8', '3', '.', '.', '.'],
        ['.', '.', '8', '.', '.', '7', '.', '6', '.'],
        ['.', '.', '.', '.', '.', '2', '.', '.', '.'],
        ['.', '1', '.', '2', '.', '.', '.', '.', '.'],
        ['.', '2', '.', '.', '3', '.', '.', '.', '.']]

print(str(sudoku2(grid)) + ' ---> Should be False')
