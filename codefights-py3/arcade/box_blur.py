import numpy as np


def get_pixels_to_blur(x, y, image):
    np_image = np.array(image)
    return list(np_image[x - 1:x + 2, y - 1:y + 2].ravel())


def get_blurred_value_for_pixel(x, y, cell, image):
    column_count = len(image) - 1
    row_count = len(image[0]) - 1

    if x == 0 or x == column_count or y == 0 or y == row_count:
        return cell

    pixel_values = get_pixels_to_blur(x, y, image)
    return int(sum(pixel_values) / float(len(pixel_values)))


def boxBlur(image):
    blurred_image = []

    for i, row in enumerate(image):
        blurred_row = []
        for j, cell in enumerate(row):
            blurred_row.append(get_blurred_value_for_pixel(i, j, cell, image))
        blurred_image.append(blurred_row)

    np_blurred_image = np.array(blurred_image)

    column_count = len(image)
    row_count = len(image[0])

    np_blurred_image_sliced = np_blurred_image[1:column_count - 1, 1:row_count - 1]
    return list(np_blurred_image_sliced)


def testBoxBlur(input, expected):
    result = True

    output = boxBlur(input)

    for i in enumerate(expected):
        result = result and (expected[i[0]] == output[i[0]]).all()

    print('Test passed' if str(result) else 'Failed')


testBoxBlur([[1, 1, 1],
             [1, 7, 1],
             [1, 1, 1]],
            [[1]])

testBoxBlur([[7, 4, 0, 1],
             [5, 6, 2, 2],
             [6, 10, 7, 8],
             [1, 4, 2, 0]]
            ,
            [[5, 4], [4, 4]])

testBoxBlur([[1, 1, 1],
             [1, 7, 1],
             [1, 1, 1]],
            [[1]])

testBoxBlur([[36, 0, 18, 9],
             [27, 54, 9, 0],
             [81, 63, 72, 45]]
            ,
            [[40, 30]])

testBoxBlur([[36, 0, 18, 9, 9, 45, 27],
             [27, 0, 54, 9, 0, 63, 90],
             [81, 63, 72, 45, 18, 27, 0],
             [0, 0, 9, 81, 27, 18, 45],
             [45, 45, 27, 27, 90, 81, 72],
             [45, 18, 9, 0, 9, 18, 45],
             [27, 81, 36, 63, 63, 72, 81]]
            ,
            [[39, 30, 26, 25, 31],
             [34, 37, 35, 32, 32],
             [38, 41, 44, 46, 42],
             [22, 24, 31, 39, 45],
             [37, 34, 36, 47, 59]])
