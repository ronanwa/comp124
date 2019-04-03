# COMP 124 Stack Lab

This lab contains the code for a stack ADT (`StackADT`) definition and the two implementations
taken from the Java Foundations textbook: one for the `ArrayStack` and one for the
`LinkedStack`.

You will be completing the
implementations and developing unit tests to ensure that the implementation
is correct.

## Generic type declaration in Java

Study the code for the `ArrayStack` class, which implements the StackADT interface.
Before you begin coding, note the use of the letter T throughout the code.
Discuss with your neighbor what this represents. Why is this use of what we call a 
generic type useful for the implementation of collection classes like this?

## ArrayStack: complete needed methods and test

There are four methods that are not yet completed in the `ArrayStack` class:

- `push`
- `isEmpty`
- `size`
- `toString`

Start with the `push` method. Push should expand the array if necessary and then add the element at the appropriate position. Don't forget to update any variables as needed.
Once you have completed push, complete `isEmpty` and `size`. Study the implementation
of `ArrayStack` to determine the simplest way to implement these methods. They both will be 
very easy: do not over-think it. It is helpful to look at the `pop` and `peek`
methods and study how they work. Be certain that you understand why `peek` returns what it does. 
For implementation purposes, what does the instance variable called 
top represent? Is this value different from what the programmer who is using
`ArrayStack` might conceptually think of the top?

The test methods called `testPushPop` and `testExpand` in `ArrayStackTest` should pass 
when you have implemented 
these three methods (`push`, `isEmpty`, and `size`) correctly.

Now complete the `toString` method. The method should return a string representing the contents of the stack.
The string representation should consist of a list of the stack's elements from top to bottom, enclosed in square brackets ("[]"). Adjacent elements are separated by the characters ", " (comma and space). Elements are converted to strings by calling toString on each one.
Look at the `testToString` method for an example of the string format. You can use a [StringBuilder](https://docs.oracle.com/javase/8/docs/api/java/lang/StringBuilder.html) object to build up the string that you will return from your method. Once you have implemented the method correctly, the test should pass.

Now we want to try some other tests. **Note**: When you are implementing these tests,
you are now doing what we would call **white box testing**, because you are aware
of the implementation (you just implemented a couple of methods, after all). There
might be other circumstances in which you are totally unaware of the implementation
and only given the StackADT interface. In this case, when you write test cases
you would be doing **black box testing**. Here are some tests for you to write.

1. Create a new test method in `ArrayStackTest` that will push several elements
onto the stack and verify that the `size` is still correct.

3. Look at the `ArrayStack` code and note which methods throw new Exceptions
and under what conditions they do so. For example, if you push, then pop, all is well.
However, if your then try to pop again, an EmptyCollectionException will be
thrown. The way to handle this is shown in the test method called `testEmpty`
in `ArrayStackTest`.  Note how we can do an `assertEquals` if we know what message
String will be returned. Further note that the class `EmptyCollectionException`
in the exceptions package extends Java's `RuntimeException`, which 
extends `Throwable`. Look at the documentation for Java 8 `Throwable` class
and find the method `printStacktrace`.
Try adding another line to `testEmpty` that calls e.printStacktrace(). Note
what it does.

4. Add similar tests to those that you have done, but this time to test the
`peek` method of `ArrayStack`. 

## LinkedStack: complete needed methods and test

Now take a look at the `LinkedStack` class and its associated `LinkedNode`
class. Complete these methods:

- `push`
- `peek`
- `isEmpty`
- `size`
- `toString`

Then write new test methods in the class called `LinkedStackTest` in the test directory.
Devise tests that properly test whether your new methods work.

## Optional Practice: Generating documentation

We've been using Javadoc in class and you have been writing javadoc style comments in your assignments.
If you have time at the end of lab, let's try creating the documentation for these two collection classes and their interface.

1. Make a new directory in 124-stack-lab called docs (same level as src).

2. Click on the src directory.

3. From the Tools menu at the top, choose 'Generate Javadoc'. Choose 'module 124-stack-lab'
   from the radio buttons. For output directory, use the ... button to navigate to your
   docs directory that you just created (note that you may have to go back up to find it).

4. View your files in the docs directory and familiarize yourself with them.

