# Comp 124 - Build Your own HashMap Lab Instructions

In this lab, you'll be completing a simple hashtable implementation.
Before you start, make sure you understand the types of the instance variables in the map:

1. A single key / value pair is stored in a MyEntry object.
MyEntry is a generic type with type parameters for the key and the value: `MyEntry<K, V>`.
2. A single hash bucket is a list of MyEntry objects: `List<MyEntry<K, V>>`
3. The type for the array of hash buckets is a simple extension of the previous data structure: `List<MyEntry<K, V>> []`

You should complete this lab in three parts:

1. Complete the put() method. Do this by first writing out pseudo code for the steps.
    * Hint: the key may already exist!
    * Hint: every Java Object has a hashCode() and equals() method.
    * After you complete the put() method, the first unit test in TestMyMap should pass. 
    (Right-click inside the code for the method to execute only it.)
2. Complete the get() method, again by first writing pseudo code.  
   The first two unit tests in TestMyMap should pass.
3. Complete the expandIfNecessary() method.
    * This method should decide whether or not to double the size of the array based on the loadFactor.
    * If the size is doubled, all the entries have to be put into their new spots, or "rehashed."
    * All three unit tests should now pass.
