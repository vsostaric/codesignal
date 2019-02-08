package growingPlant

import (
	"log"
	"math"
)

func Solution(upSpeed int, downSpeed int, desiredHeight int) int {
	if desiredHeight <= upSpeed {
		return 1
	}

	return  int(math.Ceil(1.0 + float64(desiredHeight-upSpeed)/float64(upSpeed-downSpeed)))

}

func Test() {
	log.Printf("Testing growingPlant")
	log.Printf("%d %s", Solution(100, 10, 910), " --> Should be 10")
	log.Printf("%d %s", Solution(10, 9, 4), " --> Should be 1")
	log.Printf("%d %s", Solution(5, 2, 7), " --> Should be 2")
}
