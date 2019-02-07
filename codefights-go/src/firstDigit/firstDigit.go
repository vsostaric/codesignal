package firstDigit

import (
	"log"
	"strconv"
)

func Solution(inputString string) string {

	for _, char := range inputString {

		character := string(char)
		if _, err := strconv.Atoi(character); err == nil {
			return character
		}

	}

	return "_"
}

func Test() {
	log.Printf(Solution("var_1__Int") + " --> Should be 1")
	log.Printf(Solution("q2q-q") + " --> Should be 2")
	log.Printf(Solution("0ss") + " --> Should be 0")
	log.Printf(Solution("var_1__Int") + " --> Should be 1")
}
