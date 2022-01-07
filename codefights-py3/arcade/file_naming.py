def solution(names):
    result = list()
    name_set = set()

    for name in names:

        name_set_length = len(name_set)
        iteration = 0
        result_name = name
        while name_set_length == len(name_set):

            name_set.add(result_name)
            if name_set_length != len(name_set):
                break

            iteration = iteration + 1
            result_name = _iterate_name(name, iteration)
            name_set_length = len(name_set)

        result.append(result_name)

    return result


def _iterate_name(name, iteration):
    return name + "({})".format(iteration)


print("{} should be {}".format(solution(["doc", "doc", "image", "doc(1)", "doc"]),
                               "[\"doc\", \"doc(1)\", \"image\", \"doc(1)(1)\", \"doc(2)\"]"))
