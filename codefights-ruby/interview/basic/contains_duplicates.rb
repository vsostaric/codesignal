class ContainsDuplicates

  require 'set'

  def containsDuplicates(input_array)

    elements = Set.new

    for el in input_array
      if elements.include?(el)
        return true
      else
        elements.add(el)
      end
    end

    return false

  end
end

c = ContainsDuplicates.new
print(" #{c.containsDuplicates([1, 2, 3, 1])} ---> Should be true")
print("\n")
print(" #{c.containsDuplicates([3, 1])} ---> Should be false")