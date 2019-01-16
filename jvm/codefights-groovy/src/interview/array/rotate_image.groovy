package interview.array

static List<List<Integer>> rotateImage(List<List<Integer>> a) {

    List<List<Integer>> rotatedImage = new ArrayList<>()
    int n = a.size()-1

    for (int i = 0; i <= n; i++) {
        List<Integer> line = new ArrayList<Integer>()
        for(int j = 0; j <= n; j++) {
            line.add(Integer.MIN_VALUE)
        }
        rotatedImage.add(line)
    }

    for (int i = 0; i < a.size(); i++) {
        for (int j = 0; j < a.get(i).size(); j++) {

            int newX = j
            int newY = n - i

            rotatedImage.get(newX).set(newY, a.get(i).get(j))

        }
    }

    return rotatedImage

}

List<List<Integer>> image = new ArrayList<>()

List<Integer> row1 = new ArrayList<>()
row1.add(1)
row1.add(2)
row1.add(3)
image.add(row1)

List<Integer> row2 = new ArrayList<>()
row2.add(4)
row2.add(5)
row2.add(6)
image.add(row2)

List<Integer> row3 = new ArrayList<>()
row3.add(7)
row3.add(8)
row3.add(9)
image.add(row3)

System.out.println(rotateImage(image) + " ---> Should be [[7, 4, 1], [8, 5, 2], [9, 6, 3]]")