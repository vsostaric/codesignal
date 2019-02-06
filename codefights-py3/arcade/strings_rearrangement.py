def is_one_char_away(string1, string2):
    if len(string1) != len(string2) or string1 == string2:
        return False

    found_one = False
    for char_index, char_value in enumerate(string1):

        if not found_one and string1[char_index] != string2[char_index]:
            found_one = True
        elif found_one and string1[char_index] != string2[char_index]:
            return False

    return True


class PartialSolution:
    solution = []
    used_indices = set()

    def get_solution(self):
        return self.solution

    def get_used_indices(self):
        return self.used_indices

    def __add_start__(self, other, index):
        self.solution = [str(other)] + self.solution
        self.used_indices.add(index)

    def __add__(self, other, index):
        self.solution.append(str(other))
        self.used_indices.add(index)

    def __init__(self, solution, indices):
        self.solution = solution
        self.used_indices = indices

    def __len__(self):
        return len(self.solution)

    def __eq__(self, other):
        return \
            type(self) == type(other) and \
            self.solution == other.solution

    def __hash__(self) -> int:
        return str(self.solution).__hash__() + str(self.used_indices).__hash__()


def stringsRearrangement(inputArray):
    first_element = inputArray[0]

    partial_solutions = set()

    for i in range(1, len(inputArray)):
        if is_one_char_away(first_element, inputArray[i]):
            partial_solutions.add(PartialSolution([inputArray[0], inputArray[i]], {0, i}))

    if len(partial_solutions) == 0:
        return False

    while len(partial_solutions) > 0:

        partial_solution = next(iter(partial_solutions))

        if len(partial_solution.solution) == len(inputArray):
            return True

        tail_element = partial_solution.solution[len(partial_solution.solution) - 1]
        head_element = partial_solution.solution[0]

        for i in range(0, len(inputArray)):
            if i in partial_solution.used_indices:
                continue

            unused_element = inputArray[i]

            if is_one_char_away(tail_element, unused_element):
                indices = partial_solution.used_indices.copy()
                indices.add(i)

                new_partial_solution = PartialSolution(partial_solution.solution + [unused_element], indices)
                if len(new_partial_solution.solution) == len(inputArray):
                    return True
                partial_solutions.add(new_partial_solution)

            if is_one_char_away(head_element, unused_element):
                indices = partial_solution.used_indices.copy()
                indices.add(i)

                new_partial_solution = PartialSolution([unused_element] + partial_solution.solution, indices)
                if len(new_partial_solution.solution) == len(inputArray):
                    return True
                partial_solutions.add(new_partial_solution)

        partial_solutions.remove(partial_solution)

    return False


print(str(stringsRearrangement(["aba", "bbb", "bab"])) + ' ---> Should be False')

print(str(stringsRearrangement(["ab", "bb", "aa"])) + ' ---> Should be True')

print(str(stringsRearrangement(["q", "q"])) + ' ---> Should be False')

print(str(stringsRearrangement(["zzzzab", "zzzzbb", "zzzzaa"])) + ' ---> Should be True')

print(str(stringsRearrangement(["ab", "ad", "ef", "eg"])) + ' ---> Should be False')

print(str(stringsRearrangement(["abc", "bef", "bcc", "bec", "bbc", "bdc"])) + ' ---> Should be True')


print('Is one char away!!!')

print(str(is_one_char_away("ab", "bb")) + ' --> Should be True')

print(str(is_one_char_away("aba", "bbb")) + ' --> Should be False')

print(str(is_one_char_away("q", "q")) + ' --> Should be False')
