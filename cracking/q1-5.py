__author__ = 'chywoo'

data1 = "aabccccccccaaa"
data2 = "abc"
data3 = "akdccccccckkkkkkkkkkkkkkkklklsjsjsnnnnna"


def compress(plain):
    size = len(plain)

    result = ""
    prev = None
    cnt = 0

    for i in range(size):
        data = plain[i:i+1]

        if prev is not None:
            if prev == data:
                cnt += 1
            else:
                result += prev + str(cnt)
                cnt = 1
        else:
            cnt = 1

        prev = data

    result += prev + str(cnt)

    if len(result) >= size:
        return plain
    else:
        return result

print("%s : %s" % (data1, compress(data1)))
print("%s : %s" % (data2, compress(data2)))
print("%s : %s" % (data3, compress(data3)))