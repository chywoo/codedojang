'''
Created on 2014. 6. 2.

@author: chywoo
'''

if __name__ == '__main__':
    pass

def count_8(value):
    cnt = 0
    txt_num = str(value)
    
    for i in range(0, len(txt_num)):
        if txt_num[i] == '8': cnt += 1
    
    return cnt
    
    
# count = 0
# 
# for i in range(1,10000):
#     count += count_8(i)
#     
# print("Total count: ", count)


print str(range(1,10001)).count('8')
print(range(1,10))
a=[1,1,2,22]
print(a)
b=str(a)
print(b)
print(b[1].count('2'))