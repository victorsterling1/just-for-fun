# -*- coding: utf-8 -*-
#Author:Victor
#Date:2016-01-06

import string

def xselections(items, n):
    if n==0: yield []
    else:
        for i in xrange(len(items)):
            for ss in xselections(items, n-1):
                yield [items[i]]+ss



def main():
	minimum=input('Please enter the minimum length of password to be generated: ')
	maximum=input('Please enter the maximum length of password to be generated: ')
	lower=raw_input('Please enter if the password contain lower case letter(Y/N):')
	upper=raw_input('Please enter if the password contain upper case letter(Y/N):')
	digit=raw_input('Please enter if the password contain digit(Y/N):')
	special=raw_input('Please enter if the password contain special letter(Y/N):')

	alphabet = ''

	if lower == 'Y':
		alphabet += string.letters[0:26]
	if upper == 'Y':
		alphabet += string.letters[26:52]
	if digit == 'Y':
		alphabet += string.digits
	if special == 'Y':
		alphabet += string.punctuation

	elist = list(alphabet)
	File= open("dic.txt","w")

	for i in range(minimum,maximum+1):
		for s in xselections(elist,i): 
			File.write(''.join(s) + '\n')

	File.close()
	print 'DONE!'




if __name__ == "__main__":
    print '''
                 ***           Ladies and Gentlemen            ***
                 *** Welcome to use this dictionary generator  ***
                 ***           Created on 2016-01-06           ***
                 ***             @author : victor              ***
          '''
    main()