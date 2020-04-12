package ua.dima.challanges.kyu6;

/*
#Find the missing letter

Write a method that takes an array of consecutive (increasing) letters as input and that returns the missing letter
in the array.

You will always get an valid array. And it will be always exactly one letter be missing.
The length of the array will always be at least 2.
The array will always contain letters in only one case.

Example:

['a','b','c','d','f'] -> 'e' ['O','Q','R','S'] -> 'P'

["a","b","c","d","f"] -> "e"
["O","Q","R","S"] -> "P"
(Use the English alphabet with 26 letters!)

Have fun coding it and please don't forget to vote and rank this kata! :-)

I have also created other katas. Take a look if you enjoyed this kata!
 */

public class Kata {

    public static char findMissingLetter(char[] array) {
        char upper = 65;
        char lower = 97;
        char res;

        for (int i = 0; i < 26; i++) {
            if (array[0] == upper + i) {
                int j = 0;
                upper = array[0];
                while(array[j] == upper + j){
                    j++;
                }
                return (char)(upper + j);
            } else if( array[0] == lower + i){
                int j = 0;
                lower = array[0];
                while(array[j] == lower + j){
                    j++;
                }
                return (char)(lower + j);
            }
        }
        return '-';
    }

}
