'''
Created on 2014. 6. 1.

@author: chywoo
'''
import math

if __name__ == '__main__':
    pass

max_triangles=0
max_number=0

for p in range(3,1000):
    cnt_triangle=0
    
    for a in range(1, p/2):

            c=math.sqrt(a*a + b*b)
            
            if p == a+b+c:
                cnt_triangle += 1

    if max_triangles < cnt_triangle:
        max_triangles = cnt_triangle
        max_number = p
    
print("{0}: {1}".format(max_number, max_triangles))
    
