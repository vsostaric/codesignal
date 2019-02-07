package arrayMaxConsecutiveSum

import "log"

func Solution(inputArray []int, k int) int {

	max_sum := 0

	for i := k; i <= len(inputArray); i++ {
		slice := inputArray[i-k : i]
		sum_of_slice := 0

		for _, value := range slice {
			sum_of_slice += value
		}

		if sum_of_slice > max_sum {
			max_sum = sum_of_slice
		}

	}

	return max_sum
}

func Test() {
	log.Printf("Testing arrayMaxConsecutiveSum")
	log.Printf("%d %s", Solution([]int{2, 3, 5, 1, 6}, 2), " --> Should be 8")
	log.Printf("%d %s", Solution([]int{2, 4, 10, 1}, 2), " --> Should be 14")
	log.Printf("%d %s", Solution([]int{1, 3, 2, 4}, 3), " --> Should be 9")
}
