class AbsoluteValuesSumMinimization
  def absoluteValuesSumMinimization(a)

    input_length = a.length
    if input_length < 3
      return a[0]
    end

    if input_length % 2 == 1
      return a[(input_length) / 2]
    end

    solution1_index = (input_length) / 2 - 1
    solution2_index = (input_length) / 2

    if (a[solution1_index] - a[solution1_index - 1]) > a[solution2_index] - a[solution2_index + 1]
    then
      return a[solution1_index]
    else
      return a[solution2_index]
    end

  end
end

c = AbsoluteValuesSumMinimization.new
print(" #{c.absoluteValuesSumMinimization([2, 4, 7])} ---> Should be 4")
print("\n")
print(" #{c.absoluteValuesSumMinimization([1, 1, 3, 4])} ---> Should be 1")
print("\n")
print(" #{c.absoluteValuesSumMinimization([23])} ---> Should be 23")
print("\n")
print(" #{c.absoluteValuesSumMinimization(
    [-10, -10, -10, -10, -10, -9, -9, -9, -8, -8, -7, -6, -5, -4, -3, -2, -1, 0, 0, 0, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50])}
---> Should be 15")