{% include nav.html %}

# Tech Talk Notes

### (TPT) Study Group Challenge 2

Assignment:
1. Build a calculator to process expressions and ultimately change RPN to a calculation.
    1. Build in Power of operator ^: 2 ^ 1 = 2, 2 ^ 2 = 4, 2 ^ 3 = 8
    2. Extra credit. Build variable assignment and evaluation into your expressions (a = 2; a + 1).
    3. Extra credit. Investigate Wikipedia article and pseudo code and try adding a SQRT(). Try building Pythagoras expression.

### [Tri 3: Tech Talk 2: Calculator](https://github.com/nighthawkcoders/nighthawk_csa/wiki/Tri-3:-Tech-Talk-2:-Calculator)

Math Symbols:
* PEMDAS, each operator has its own precedence (priority)
    * Add exponent ^ operator with priority 3
```Java
// Helper definition for supported operators
    private final Map<String, Integer> OPERATORS = new HashMap<>();
    {
        // Map<"token", precedence> 
        OPERATORS.put("*", 3);
        OPERATORS.put("/", 3);
        OPERATORS.put("%", 3);
        OPERATORS.put("+", 4);
        OPERATORS.put("-", 4);
    }
```

Math Original Expression (String):
```Java
2 + 2
4 * 6 + 3
5 + 1 * 8
(7 + 5) * 9
```

Tokenization (Array):
```Java
[2, +, 2]
[4, *, 6, +, 3]
[5, +, 1, *, 8]
[(, 7, +, 5, ), *, 9]
```

Reverse Polish Notation (Array, works well with Stack):
```Java
[2, 2, +]
[4, 6, *, 3, +]
[5, 1, 8, *, +]
[7, 5, +, 9, *]
```

[Youtube Video](https://www.youtube.com/watch?v=Wz85Hiwi5MY)
* Sorting the values within the Reverse Polish Notation arrayList
    * Is it an operator (+ - * / %)?
        * Is the existing operator of greater precedence?
            * Push to Stack
        * Else
            * Pop out operator underneath
            * Push to Stack
            * Push the popped operator back to Stack
    * Is it a seperator (" ")?
        * Skip it
    * Is it a number (1 2 3 4 5)?
        * Put it in a Queue

Result (Double):
```Java
4.0
27.0
13.0
108.0
```

# Tech Talk 1

## Linked Lists

- Most "Data Structures" conversations usually begin with Arrays
>- Is built into most Computer Programming Languages
- College Board has Units 6-8 which discuss Arrays, ArrayLists, and 2-Dimensional Arrays
- Most Data Structures conversations continue with the discussions of Linked Lists which are the foundation for Stacks and Queues

# Tech Talk 0

## Data Structures

- A data structure is a method of organizing data
- Think of a variable holding a single integer value(ex: int n=4;) or sequences of numbers(ex: int[] numbers=new int[]{ 1,2,3 };) or tables of data, or databases: these are all well-defined data structures.
- Data Structures and organizing data will require students to become more algorithmic in coding.

## Data Structure Algorithms
- There are many algorithms for different purposes and they interact with different data structures.
- Think of algorithms as dynamic underlying pieces that interact with data structures.
- EX:
```
public void swapToLowHighOrder(IntByReference i) {
        if (this.value > i.value) {
            int temp = this.value;
            this.value = i.value;
            i.value = temp;
        }
    }
```
- Together, data structures and algorithms combine and allow programmers to build whatever computer programs they’d like.
- Good managed data structures and algorithms ensures well-optimized and efficient code.
## Paradigms
#### Imperative Paradigms
- An imperative program consists of commands for the computer to perform to achieve a result. Imperative programming focuses on describing "how" a program code works.
#### OO Paradigm
- OOP models complex things as reproducible, simple structures.
- Reusable, OOP classes can be used across programs by simply making an object.
- We have learned about many key aspects of OOP.
- OO based matrix alteration
```
public String reverse() {
        // outer loop starting at end row
        StringBuilder output = new StringBuilder();
        for (int i = matrix.length;  0 < i; i--) {
            // inner loop for column
            for (int j =  matrix[i-1].length; 0 < j; j--) {
                output.append((matrix[i-1][j-1]==-1) ? " " : String.format("%x",matrix[i-1][j-1])).append(" ");
            }
            output.append("\n"); // new line
        }
        return output.toString();
    }
```
