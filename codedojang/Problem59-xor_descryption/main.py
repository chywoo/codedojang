'''
Created on 2014. 5. 30.

@author: chywoo
'''

if __name__ == '__main__':
    pass
    
    
def get_candidated_alpha(encryption):
    candidate_keys=""
    
    for alpha in range(ord('a'),ord('z')):
        i = 0;
        flag = True

        print("Try ", chr(alpha), "... ", end=" ")        
        while ( i < len(encryption)):
            value = ord(encryption[i]) ^ alpha
            print( "{0}, {1}".format(value, chr(value)))
            
            if value not in range(ord('a'),ord('Z')):
                flag = False
                break

        if flag == True: candiate_keys=candiate_keys + chr(alpha);
        
    return candidate_keys

                
    
    
encrypted_text_file = open("cipher1.txt", "rt")
encrypted_text = encrypted_text_file.readline();

print(get_candidated_alpha(encrypted_text))



