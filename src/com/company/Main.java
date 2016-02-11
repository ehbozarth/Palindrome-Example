/*
Disclaimer:
I did not personally write any of these methods or functions. I did some research on the internet
and found a few examples of detecting a palindrome in java code. Each example is unique in its own
fashion (Case sensitivity, regular expressions, spaces between letters/words). I wanted to have a collection of
different ideas and code to in case anyone else wanted to see how the same example sentences would react to the
different methods/functions. All examples have a source link that you can type into your browser to see the discussions
and comments.
 */

package com.company;

import javax.print.DocFlavor;
import java.util.Date;

public class Main {

    /*
    Example 1
    Source: http://stackoverflow.com/questions/4138827/check-string-for-palindrome
    All one line (not really attractive)
    Is Successful with complex sentences AND simple words
    Does Handle regex such as "!"
    NOT Case Sensitive
     */
    public static boolean isPalindrome1(String arg) {
    return arg.
        replaceAll("[^A-Za-z]", "").
        equalsIgnoreCase(new StringBuilder(arg).
        reverse().
        toString().
        replaceAll("[^A-Za-z]", ""))  ? true : false;
    }

    /*
    Example 2
    Source: http://stackoverflow.com/questions/4138827/check-string-for-palindrome
    Is Successful with complex sentences AND simple words
    Simplest code, by using delimiter to get rid of empty spaces
    Does NOT Handle regex such as "!"
    NOT CASE SENSITIVE
     */
    public static boolean isPalindrome2(String word) {
        String myWord = word.replaceAll("\\s+","");
        String reverse = new StringBuffer(myWord).reverse().toString();
        return reverse.equalsIgnoreCase(myWord);
    }

    /*
    Example 3
    Source: http://stackoverflow.com/questions/15401630/java-check-if-a-string-is-a-palindrome-case-insensitive
    Is Successful with complex sentences AND simple words
    Does Handle regex such as "!"
    NOT CASE SENSITIVE
     */
    public static void isPalindrome3(String ispalindrome){
        boolean notPalindrome = false;
        String string = ispalindrome;

        string = string.replaceAll("[^a-zA-Z0-9]+","").toLowerCase();

        char[] array = string.toCharArray();
        for(int i=0, j=array.length-1; i<j; i++, j--) {
            if(array[i] == array[j]) {
                notPalindrome = true;
            }
            else{
                notPalindrome = false;
            }
        }
        System.out.println(string + " is palindrome? " + notPalindrome);
    }

    /*
    Example 4 (Palindrome Dates between two different years)
    Source: http://www.careercup.com/question?id=3236729
    01/02/2010
    11/02/2011
    02/02/2020
    12/02/2021
    03/02/2030
    04/02/2040
    05/02/2050
     */
    static void printPalindromeDates(int start, int end) {
        for (int yyyy = start; yyyy <= end; yyyy++) {
            //System.out.println("This is year " + yyyy);
            String mm = Integer.toString(yyyy % 10)
                    + Integer.toString((yyyy / 10) % 10);
            //System.out.println("This is mm " + mm);
            String dd = Integer.toString((yyyy / 100) % 10)
                    + Integer.toString((yyyy / 1000) % 10);
            //System.out.println("This is dd " + dd);
            int m = Integer.parseInt(mm);
            //System.out.println("This is m " + m);
            int d = Integer.parseInt(dd);
            //System.out.println("This is d " + d);


            if (m >= 1 && m <= 12) { // Valid month.
                if (d >= 1) {// Valid lower limit for day.
                    // Upper limit must be less than number of days in each
                    // month (including leap year)
                    boolean validDay = false;
                    int days[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30,
                            31 };
                    if (m == 2) { // Since its Feb, we need to check for leap
                        // year.
                        if ((yyyy % 4 == 0 && yyyy % 100 != 0)
                                || yyyy % 400 == 0) {
                            if (d <= 29) {
                                validDay = true;
                            }
                        } else {
                            if (d <= days[m - 1]) {
                                validDay = true;
                            }
                        }
                    } else { // Not feb, just pick days from the array.
                        if (d <= days[m - 1]) {
                            validDay = true;
                        }
                    }
                    if (validDay) { // Valid day && Valid month
                        System.out.println(mm + "/" + dd + "/" + yyyy);

                    }
                }
            }
        }
    }


    public static void main(String[] args) {

        /*
        Example 1 isPalindrome1
         */
        System.out.println("Is Palindrome Example 1\n");
        System.out.println("hiya = " + isPalindrome1("hiya")); //false
        System.out.println("star buttons not tub rats =" + isPalindrome1("star buttons not tub rats")); //true, Example complex sentence
        System.out.println("Never Odd or Even1 = " + isPalindrome1("Never Odd or Even1"));//comes up true, disregards the 1, should be FALSE
        System.out.println("Never Odd or Even = " + isPalindrome1("Never Odd or Even"));//true, Example complex Sentence
        System.out.println("stab nail at ill Italian bats! = " + isPalindrome1("stab nail at ill Italian bats!")); //true, Example complex sentence with expression
        System.out.println("raceCAR = " + isPalindrome1("raceCAR"));//true, Not case sensitive
        System.out.println("Doc, note, I dissent! A fast /never * prevents a fatness. I diet on cod? = " +
                isPalindrome1("Doc, note, I dissent! A fast /never * prevents a fatness. I diet on cod?"));
                //true, ignores regex, NOT CASE SENSITIVE
        System.out.println();
        System.out.println();

        /*
        Example isPalindrome2
         */
        System.out.println("Is Palindrome Example 2\n");
        System.out.println("hiya = " + isPalindrome2("hiya"));//false
        System.out.println("star buttons not tub rats =" + isPalindrome2("star buttons not tub rats"));//true, Example complex sentence
        System.out.println("Never Odd or Even1 = " + isPalindrome2("Never Odd or Even1")); //false, Example 2 of complex Sentence
        System.out.println("Never Odd or Even = " + isPalindrome2("Never Odd or Even")); //true, Example of complex Sentence
        System.out.println("stab nail at ill Italian bats! = " + isPalindrome2("stab nail at ill Italian bats!")); //false, Example complex Sentence with expression
        System.out.println("raceCAR = " + isPalindrome2("raceCAR")); //true, Example of Not-Case Sensitive
        System.out.println("Doc, note, I dissent! A fast /never * prevents a fatness. I diet on cod? = " +
                isPalindrome2("Doc, note, I dissent! A fast /never * prevents a fatness. I diet on cod?"));
                //false, does NOT ignore regex, NOT CASE SENSITIVE
        System.out.println();
        System.out.println();

        /*
        Example 3 isPalindrome3
         */
        System.out.println("Is Palindrome Example 3\n");
        isPalindrome3("hiya");//false
        isPalindrome3("star buttons not tub rats");//true Example complex sentence
        isPalindrome3("Never Odd or Even1");//false, fixed to include numbers as part of string
        isPalindrome3("Never Odd or Even");//true Example complex sentence
        isPalindrome3("stab nail at ill Italian bats!");//true Example complex sentence with "!"
        isPalindrome3("raceCAR");//true NOT CASE SENSITIVE
        isPalindrome3("Doc, note, I dissent! A fast /never * prevents a fatness. I diet on cod?");
        //true Example complex sentence with regex

        /*
        Example 4 Palindrome Dates between 2 Years
        01/02/2010
        11/02/2011
        02/02/2020
        12/02/2021
        03/02/2030
        04/02/2040
        05/02/2050
         */
        printPalindromeDates(2000, 2050);


    }//End of main method

}//End of Main Class



