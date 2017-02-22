//
//  main.c
//  PalindromeTester
//
//  Created by Joel Perez on 10/3/15.
//  Copyright © 2015 Joel Perez. All rights reserved.
//
#include <stdio.h>
#include <string.h>


//function prototype for invert
void invert(char *s1, char *s2, int length, int oi);



//begin main
int main(int argc, const char * argv[])
{
    
    //initialize the variables
    char word[50];//entered word
    char flip[50];//flipped word
    int fi = 0;//flipped array index//length of entered word
    unsigned int length;
    
    //welcome message and user input prompt
    printf("Welcome to the Palindrome Tester!\n"
           "---------------------------------\n\n"
           "Please enter the word you would like to check: ");
    //read user input and determine its length
    scanf("%s", word);

    
    length = (unsigned int)strlen(word) - 1;
    
    //invert the word entered
    invert(word, flip, length, fi);
    
    //determine if the word is palindrome
    if (strcasecmp(word, flip) == 0)
        printf("The word is palindrome\n");
    else
        printf("The word is not palindrome\n");
    
    return 0;
}





/**
 *funciton definition for invert
 *inverts the values of the first array in the second array
 *@param *s1 the value of the current index in the first array
 *@param *s2 the value of the current index in the second array
 *@param length the length of the word in the first array
 *@param oi the current index of the first array
 */
void invert(char *s1, char *s2, int length, int oi)
{
    for (int i = length; i >= 0; i--)
    {
        s2[oi] = s1[i];
        oi++;
    }
    s2[length + 1] = '\0';
}