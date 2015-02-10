__author__ = 'chywoo'

m = [[1, 2, 3], [4, 5, 6], [7, 8, 9]]


def rotate(size_x, size_y, data):
    r = data[:][:]

    print(r)
    print(data)

    for y in range(size_y):
        for x in range(size_x):
            r[x][size_y - 1 - y] = data[y][x]

    return r



result = rotate(3, 3, m)

print("Result: ", result)
