'''
Created on 2014. 5. 30.

@author: chywoo
'''

if __name__ == '__main__':
    pass
    
def get_plain_in_col(text, col):
 
    for k in range(ord('a'), ord('z')):
        plain = ""
        space_count = 0
        char_count = 0
        plain = ""
        
        for i, t in enumerate(text):
            if i % 3 != col:
                continue
            char_count += 1
            value = t ^ k

            plain += chr(value)
            if chr(value) == ' ':
                space_count += 1

        if space_count >= (char_count * 0.1 ):
            return k, plain
    
    return None, None
        

file = open("cipher1.txt", "rt")
data = file.readline();
file.close()

data=data.split(',')
encrypted_num=map(int, data)

k1,t1=get_plain_in_col(encrypted_num, 0)
k2,t2=get_plain_in_col(encrypted_num, 1)
k3,t3=get_plain_in_col(encrypted_num, 2)

plain=""
i=0
total=0
while 1:
    try:
        plain += t1[i] + t2[i] + t3[i]
        i+=1
        total += ord(t1[i]) + ord(t2[i]) + ord(t3[i])
    except IndexError:
        break
     
print ("Key: {0}\nTotal; {1}\nText: {2}\n".format(chr(k1) + chr(k2) + chr(k3), 
        total, plain))

