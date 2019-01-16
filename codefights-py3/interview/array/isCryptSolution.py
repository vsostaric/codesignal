def decrypt(solution, encrypted):
    str_val = ''
    for c in encrypted:
        str_val += solution[c]

    try:
        int_val = int(str_val)
        if len(str_val) != len(str(int_val)):
            return 'NaN'
        return int(str_val)
    except:
        return 'NaN'


def is_crypt_solution(crypt, solution):
    dSolution = {}
    for sol in solution:
        dSolution[sol[0]] = sol[1]

    add1 = decrypt(dSolution, crypt[0])
    add2 = decrypt(dSolution, crypt[1])
    res = decrypt(dSolution, crypt[2])

    if 'NaN' in (add1, add2, res):
        return False

    return add1 + add2 == res


crypt = ["SEND", "MORE", "MONEY"]
solution = [['O', '0'],
            ['M', '1'],
            ['Y', '2'],
            ['E', '5'],
            ['N', '6'],
            ['D', '7'],
            ['R', '8'],
            ['S', '9']]

print(str(is_crypt_solution(crypt, solution)) + ' ---> Should be True')

crypt = ["TEN", "TWO", "ONE"]
solution = [['O', '1'],
            ['T', '0'],
            ['W', '9'],
            ['E', '5'],
            ['N', '4']]

print(str(is_crypt_solution(crypt, solution)) + ' ---> Should be False')
