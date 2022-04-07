# Key Learnings of the Trimester

## Week 0 | Dynamically creating a menu page 
![a](https://files.catbox.moe/vdk6p0.png)

Probably one of the most valuable things I got from the challenges. I was introduced to some of the many different methods of creating menus. The one I used this trimester was using runnables and hashmaps to assign methods to each week. Each of these weeks then had another version of the same menu that ran the algorithms
Through the many different crossover gradings I've done, the different methods of implementation was a great opportunity of learning for me. One I remember in particular was Bryant's menu. All trimester, I was a little annoyed by how long the code had to be for each menu. The runnable hashmap lambda method was usually over a 100 lines of code because they required all of the following:
- Creating a MenuRow class that houses each week and their respective algorithms
- Instantiate a MenuRow for every week
- Storing the title and their respective lambda method in every instance of MenuRow
- Creating a hashmap that stores all of these MenuRow objects
- Iterating through the hashmap to print and run each object based on user input

As you can see, it's a lot of code just to run some methods. Although we're doing it dynamically, one can argue that a simple switchboard would look much cleaner and be easier to understand. That's why when I saw Bryant's method of dynamically creating classes, I was excited.

![a](https://files.catbox.moe/o4ee63.png)

Here's a rundown of how this one works (a lot cleaner)
- Store every week as an Array inside of an array (this creates a table like 2d array for text displayed, class location, and method name)
- Iterate through Array to instantiate objects and assign methods 
- Invoke the method from the class that matches user input

This is obviously much simpler and superior. I had used this method of dynamically creating classes in javascript but I never knew that there was a javaway to create classes with a line of code. I'll be using this from now on

## Week 1 | Queues and Linked Lists
lol
## Week 2 | Calculator and RPN
lol
## Week 3 | Sorts
lol
