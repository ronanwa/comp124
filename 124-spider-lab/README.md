Making a Web Crawler, or Spider
================================

The World Wide web is aptly named when you consider the URL links found in pages.  One page can have many links in it 
that take a viewer to another page, which has more links, and so on, forming a very large cyclic graph of interconnected 
pages.



In this lab, you will start from some code and complete it to create a web crawler, or spider, that will start with a ‘seed’ URL to a web page 
and read it to find links to other pages. For each new link it finds it will repeat the process, searching each web page for new links.
Given enough time and memory, the web crawler would eventually explore the entire internet, which is why these processes are used by Google and other search engine 
companies to map the Internet.

 
The links found on each page will be placed in a queue for further processing (we’ll call this 
the work queue).  When the initial page is processed, it is placed on another data structure to indicate that it has been 
visited already – this is the finished queue. This process is repeated for the next page whose link is first in the work queue.
 

As you can imagine, this will be a great deal of work for one program. Web search companies like Google
write sophisticated programs to use many computers simultaneously to get this job done.  This is referred to as 
parallel and distributed programming solutions. For this lab, you will use a set of instructions written as part of the CSinParallel project, which is
directed by Professor Libby Shoop.  You will first write the single program crawler, which we refer to as the
*sequential* version.  Then next lab you will see how a *parallel* version, using concurrently 
running spider programs called threads, can improve the workload that can be completed.

In the first week of this lab, you should complete the sequential, or single version of the Spider, in the package called
`spider` (part 1 below).

In the following lab, you will complete the version in the package called `concurrentSpider` (part 2 below).

## Part 1 (week 1)

Fork and clone the repository. Then explore the following files in the spider package, which you will use as your starting point.

| Class | Description |
|--- | --- |
| AllUrlsCounter.java    | contains a ‘dictionary’ to hold counts of how often a URL is encounterd |
| HttpHelper.java         | contains methods to read html pages and extract links |
| RunSpider.java          | has main() |
| Spider.java             | the workhorse and the one you will be changing |
| TestHttpHelper.java     | JUnit test class |
| TestSpider.java         | JUnit test class |
| UrlCount.java           | small helper class that holds a url and a count |

The Spider.java class is the one that you should work on for this assignment.  The RunSpider class contains main() and uses it.  
As the code stands now it doesn't really do anything if you run it.

Become familiar with the data structures that are used in this program. The diagram below illustrates them.

The class called `AllUrlCounter` is able to return an array of UrlCount objects, each of which contains two data elements: 
a URL for a page, and a count of the number of times that URL was encountered by the crawler. In the Spider class, the 
method `getUrlCounts` will return this array, shown on the left in the picture below. This array can be used to examine 
what the spider encountered when it is finished running.

The Spider class also contains a Queue called work and a List called finished. The Spider will start at a given, predetermined 
page and read all the links to URLs on it (this is called scraping the page, which you will implement in the processPage method). 
The links it finds, illustrated on the far upper right in the following diagram, should be added to the work queue **if they 
have not already been finished**, and a counter for that link should be updated.

The Spider class will repeat this process in the crawl method by continuing to pull each URL to a page off the work queue, 
checking if it has already been finished, **processing it if it has not been finished**, and placing it in the finished queue. 
This is done for a certain number of times as designated by the integer called maxUrls.

![Web scraping process diagram](http://selkie.macalester.edu/csinparallel/modules/CDS_java/build/html/_images/Spider1.png)

### Your Task

Your task is to finish the Spider class by doing the following:

1. Complete the processPage method as described by the algorithm above. When it works, one of the TestSpider unit tests should pass.
2. Complete the crawl() method.  When it works, both TestSpider unit tests should pass.

    Note There are comments in these methods to help assist you.
    Once your unit tests pass, you should be able to run the code by executing the main method of the RunSpider class, which 
    is currently ‘hard-coded’ to start at macalester.edu, and see it produce the URLs found when crawling, along with how many 
    times it saw them.

3. Add a class method called `getDifference` to the `RunSpider` class that takes two arrays of UrlCount objects, set1 and set2, as parameters. The method should 
return a list of UrlCount objects that appear in set2 but not in set1. Uncomment the method in TestUrlCounter. It should now pass.
4. Modify the main method to create a second spider object with `maxurls` set to double the amount of the first spider. 
Using the `getDifference` method you just wrote, how many new urls were encountered when you double the maxurls value? 
5. Experiment by creating more spiders with different numbers of `maxurls`. Edit this readme to fill in the following table (you may need to add some getter methods for work and finished):

    | maxurls | Size of finished list | Number of new urls found | Size of remaining work queue |
    |--- | --- | --- | --- |
    | 10 | | | |
    | 20 | | | |
    | 30 | | | |
    
5. Experiment with the BEGNNING_URL variable found in RunSpider by choosing some other pages of interest to you as starting points.

## Part 2 (Week 2)

In the first part of this lab, the original web crawling spider that you've  worked on looks like this:
* 3 data structures holding information, accessed individually by the Spider class
* The Spider class does all the work, one step at a time

Looking at the table you filled in above, you should see that as the `maxurls` variable increases the amount of remaining 
works grows much faster. In this case, the ‘work is piling up! Each page that is visited has many more links to follow.

Now let's examine how we can use multiple spiders working at the same time on this problem to speed it up. We will use a 
technique called threads to run many spiders at the same time. To run something concurrently in java, you create a class that 
implements the [Runnable interface](https://docs.oracle.com/javase/8/docs/api/java/lang/Runnable.html) and pass an instance of the 
class to a [Thread](https://docs.oracle.com/javase/7/docs/api/java/lang/Thread.html) object. Each Thread calls the run method 
from the Runnable interface which executes the code at the same time as other threads once they are started.

There is a concurrentSpider package included in the code. Examine the `RunThreadedSpider` class.  Note that we now use the 
Java Thread class to begin running multiple instances of the ConcurrentSpider, one each per Thread that is started. 
The Spider is now in this class called `ConcurrentSpider`, and implements the Runnable interface.

A key feature of concurrently running Spiders is that they must share the same data structures in order to work together.  
To do this, we need to place the data structures they are working on in one class and create one instance of that class 
in `RunConcurrentSpider`.  Then each new 'Runnable' `ConcurrentSpider` will receive a reference to that class of shared data 
structures. We provide a class called `SharedSpiderData` for this purpose.

Running the concurrent spiders looks like this:
![Concurrent Spider Diagram](http://selkie.macalester.edu/csinparallel/modules/CDS_java/build/html/_images/Spider2.png)

Running programs concurrently in multiple threads can cause issues with shared data structures. Imagine yourself as a 
spider working with a group of others. Think about what actions are involved when you:
* Grab a new page to work on from the `work` data structure
* Save new links to the `work` data structure
* Store the completed page in `finished` data structure

What happens when several threads need to read and write from the ‘work’ data structure at the same time?
 We could attempt to use the original LinkedList and ArrayList data structures and share those among the threads. However, 
these are not ‘thread safe’, that is they are not guaranteed to behave properly when multiple threads are accessing and 
updating them at the same time. 

To ensure our code will work correctly using multiple threads, we will use the new Java Concurrent Data Structures from 
the package java.util.concurrent.  Begin with the file `SharedSpiderData` to see the types of shared, thread-safe data structures 
we will use for this version of the multi-threaded crawler.

We're using:
* [ArrayBlockingQueue](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/ArrayBlockingQueue.html)
* [ConcurrentLinkedQueue](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/ConcurrentLinkedQueue.html)
* (ConcurrentHashMap, inside another class provided for you to hold the counts of the URLs)

The ArrayBlockingQueue has a maximum length. When multiple threads are accessing it, it's possible that it will be full when 
one of the spiders tries to add a new url. In this case the thread should block, i.e. wait, until an opening becomes available.
When removing a url, the queue could be empty. In this case, the thread should wait until something is added before removing from 
the queue. Look carefully over the javadoc linked above to find the two methods with this behavior. **Confirm with a preceptor
that your answers are correct** before moving on with the next tasks.


### Your Task

1. Finish the class called `ConcurrentSpider`. The processPage and crawl methods should be very similar to the sequential spider version; 
 however, it should use the new concurrent data structures when scraping the pages and keeping track of what has finished. 
 You will need to use the correct methods on the concurrent data structures (ArrayBlockingQueue, ConcurrentLinkedQueue) for adding and removing elements.

2. You can try using different numbers of threads, depending on how much your machine can handle (usually between 4 and 16), by changing the NUM_THREADS 
variable in the RunThreadedSpider class.

3. Speedup is a number we can compute by running experiments. It gives us an indication of how much faster our threaded version 
    is than our original ‘sequential’ version with one Spider.

    We measure speedup by taking the time to run the original non-threaded version and dividing it by the time to run the 
    threaded version. If when using 2 threads on the same number of URLS the code takes half the amount of time, we would 
    have perfect speedup of 2. This rarely happens, and we expect our speedup to be less than perfect due to some amount of 
    overhead incurred when running threads that are updating shared data structures.

    To calculate the speed up, add code to the RunSpider classes to time how long they take to complete: 
    ```java
    long start = System.currentTimeMillis();
    //Run spider code here...
    long end = System.currentTimeMillis();
    double elapsedTime = (double) (end - start);
    ```
        
    Determine the speedup of your threaded version and complete the following table by editing this Readme.md file:
    
    | Number of Threads | Speedup (non-threaded time / threaded time)|
    | --- | --- |
    | 1 |  |
    | 2 |  |
    | 3 |  |
    | 4 |  |
    | 5 |  |
    | 6 |  |
    | 7 |  |
    | 8 |  | 
    


4. Optionally, Experiment with the parameter found in ComcurrentSpider constructor:  maxUrls.  If you double it, 
    how many new urls were encountered?  Now that you have all these spider threads, you can likely scrape more URLs.

5. Optionally, Experiment with the BEGNNING_URL variable found in RunSpider by choosing some other pages of interest to 
    you as starting points.
    
## Attribution

This lab is part of the [CSInParallel Project](http://selkie.macalester.edu/csinparallel/modules/CDS_java/build/html/TheSpiderLabonecrawler/TheSpiderLabonecrawler.html) directed by Libby Shoop.
The text above comes straight from the project description with some slight modifications by Bret Jackson to make the expectations 
for the tasks clearer.



