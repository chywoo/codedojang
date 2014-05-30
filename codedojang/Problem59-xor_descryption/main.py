'''
Created on 2014. 5. 30.

@author: chywoo
'''

if __name__ == '__main__':
    pass
    
ALPHABET="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ ,"

def get_candidated_alpha(encryption):
    candidate_keys=""
    
    for alpha in range(ord('a'),ord('z')):
        i = 0;
        flag = True

        print("Try ", chr(alpha), "... ", end=" ")        
        while ( i < len(encryption)):
            value = int(encryption[i]) ^ alpha
            print( "{0}, {1}".format(value, chr(value)))
            
            if ALPHABET.find(chr(value)) == -1:
                flag = False
                break

        if flag == True: candiate_keys=candiate_keys + chr(alpha);
        
    return candidate_keys


encrypted_text_file = open("cipher1.txt", "rt")
encrypted_text = encrypted_text_file.readline();
encrypted_words=encrypted_text.split(',')

print(get_candidated_alpha(encrypted_words))


