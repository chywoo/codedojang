import math
def Star(n):
    a = 0
    c = 0.0
    p =n/2
    _list = []
    while a < p:
        a += 1
        for b in range(a,p-a):
            c = math.sqrt(a*a + b*b)
            if c % 1 == 0:
                _list.append( a+b+c )
    return max(set(_list),key=_list.count)


print Star(1000)
print Star(10000)