# Comp 124: Homework 1

## Setup

Follow the "Cloning a repo" section of the [IntelliJ setup doc](https://docs.google.com/a/macalester.edu/document/d/15F5NFm5hoibSV9E5IDO8icvp3ddiJ4cjQ-dXgCP6S9Y/edit?usp=sharing) to fork this repository.

## Problem 1: Unit Conversions  (~6 points)


We have created a `UnitConversions` class that converts between Sheppey and miles. A Sheppey is a measure of distance equal to (7/8) of a mile. It is defined as the closest distance at which sheep remain picturesque! More information on the definition can be
  found at Wikipedia's [List of Humorous Units of Measure](https://en.wikipedia.org/wiki/List_of_humorous_units_of_measurement#Sheppey). Unfortunately, the UnitConversion class is broken: it always returns zero!

1. Implement the conversion methods correctly, so that the tests in `UnitConversionsTest` all pass.
   (**The tests are already correct.** You only need to change the code in `UnitConversions`.) 
   Note that the code you are given for each method returns 0.0. This is designed for you to replace 
   this with the propoer converted value.
2. Using the sheppey methods as an example, add your own **pair** of methods to convert back
   and forth between two units of your choice.
3. Add tests for your new methods to `UnitConversionsTest`.

### Acknowledgements:

Paul Cantrell developed the unit conversions assignment using Fahrenheit and Celsius. Bret Jackson updated it to use Sheppy. :stuck_out_tongue_winking_eye:


## Problem 2: Minimize Bills and Coins (~12 points)


You will be writing a new class called **MoneyCalculator**. Follow the coding guidelines document provided on moodle when documenting this class and choosing variable names. Remember that you should create a main method as the starting point for your program.

The purpose of your program is to take a float value from the user that represents a monetary amount, such as 17.89, and print back out the least number of each type of US bill and coin needed to represent that amount, starting with the highest. As a simplification, assume that the ten dollar bill is the maximum size bill that you have to work with.

For example, if the user enters 47.63, your program should print:

    4 ten dollar bills
    1 five dollar bill
    2 one dollar bills
    2 quarters
    1 dime
    0 nickels
    3 pennies

**Hint**: Your program should match the output above. Note, the appropriate use of plural for 'bills' vs. 'bill', quarters, dimes, nickels, pennies, etc.

**Hint**: Rounding up or down from float to its nearest int requires use of the round() method in the Math package.

You must use a read-until-sentinel loop pattern to keep asking the user if they wish to enter a new value (Y/N). Your program should always complete one calculation as above before asking whether they want to try again.

**Testing your program**: This program is an example of a program that must be tested using what we call *functional* testing, as opposed to the unit testing that you have done on previous problems. In this case, you test out your program by trying various amounts to insure that it is correct. Be sure that you try enough cases to ensure that all parts of your code solution execute. This means that you choose examples so that all parts of conditional if statements get tried and the possible range of amounts for each bill and coin get used. 

### High-level pseudocode for this problem
For this homework we will provide some pseudocode so that you can see how writing out pseudocode can help you write the code for such a problem faster. For future homework, practice writing pseudocode first for each method that has some complextiy to it.

    While not done:
        Ask user for input monetary value with not more than two decimal places
        Split input value into dollars (left of decimal) and cents (right of decimal)
        Determine bill breakdown of dollars and print a line for each bill (ten, five, one)
        Determine coin breakdown of cents and print a line for each coin (quarter, dime, nickel, penny)
        Get user input whether they wish to continue with another value
        If user says no, set done

### Acknowledgements:

This is based on problem PP2.9 on page 71 in the Java Foundations book, with some additions for Macalester COMP 124.

## Submitting your assignment

Make sure you add, commit, and push all your code for both problems to your private repo. Come back here to github and check your fork's code to see that it has been updated.

