package differentSymbolsNaive

import "log"

func Solution(s string) int {
	characters := map[string]bool{}

	for _, char := range s {
		characters[string(char)] = true
	}

	return len(characters)
}

func Test() {
	log.Printf("%d %s", Solution("cabca"), " --> Should be 3")
	log.Printf("%d %s", Solution("aba"), " --> Should be 2")
	log.Printf("%d %s", Solution("ccccccccccc"), " --> Should be 1")
	log.Printf("%d %s", Solution("bcaba"), " --> Should be 3")
}
