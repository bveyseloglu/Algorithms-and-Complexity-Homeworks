## Algorithms-and-Complexity-Homeworks
Includes 4 homeworks: file reading and sorting, simple database application, maze solver, hashing

## Development Environment
The IDE that used in this work is NetBeans IDE 8.2, the version of the Java SE Runtime Environment on the machine that runs IDE is 1.8.0_181-b13. These projects were tested on Intel Core i7-7700 machine that running Windows 10 Education (Build 17134).

## File Reading and Sorting
In this assignment, the application is supposed to open a text file consisting of student IDs, names, ages, and admission year to university. The first line of the file indicates the number of records. Then application reads the content of the file and sort the students according to:
* **sort_ID:** The students will be sorted according to their ID’s
* **sort_Year:** The students will be sorted according to their admission year
* **sort_Age:** The students will be sorted according to their ages.

Finally, sorted list will be displayed on the screen.

Sorting algorithms are based on bubble sort. For each value of the array, let’s say N, algorithm looks foward from N. For each value that located after N, the algorithm compares that value with N, if that value is less than N, the algorithm swaps the student that has that value with the student that has the value N. The complexity of this algorithm is proportional with n^2.

In sorting algorithms of StudentdBase Class doesn’t have any priority feature. If any related property of the students are the same, the algoritm prioritize the student which comes first in the StudentArray.

## Simple Database Application
Implementation of a simple database using link list structure where this list will be used in an inventory program of EE Department.

The program collects and stores circuit device information by using link lists. There is one primary inventory link list defined at the top of the main metod. It stores all of the data about circuit elements, their properties, and their amounts.

The program asks user to input circuit elements. Every time user inputs a circuit element, the program waits for a new circuit element input from the user. If user inputs “menu” at the circuit element adding phase of the program, the program returns to the main menu. Entering negative amount of a specific circuit element decreases that amount of that circuit element if it’s exist and amount of that element is greater or equal than that much in the inventory.

Algorithm that adds a new circuit element is very simple. When user types an input at any of the add/remove phase of the program, the program searches for that item in the inventory. If it’s exists, the program manipulates the item’s amount, if it’s not exists, the program adds a new node to store the information of that circuit element. The complexity of this algorithm is proportional to 𝑇ℎ𝑒𝑡𝑎(𝑛).
The program can also prints all of the inventory information that collected while the execution of the program. Printing all of the inventory items can done by creating 4 new inventory that collects the values of resistors, capacitors, inductors and transistors seperately. The program scans all of the items of the main inventory from the first element to last, and then for each element it copies that element to a newly created proper inventory to classify them.

After classifying all of the items to newer inventories, the program prints all of the new inventories by a specific order. The complexity of this algorithm is proportional to 𝑇ℎ𝑒𝑡𝑎(𝑛).

## Maze Solver
In the figure given below there is a definitive path from 1 to 32. This program finds this path using an algorithm. The path
can from one point to N, S, E, W, NE, NW, SE, SW.

<p align="center"> 
  <img src="https://dl.dropboxusercontent.com/s/tslqi9m9ppp54fu/maze.PNG">
</p>

A stack class written to satisfy the needs of the main path finder algorithm. The stack algoritm is very simple, it can pushes, peeks or pops two integer values which represents a coordinate at once.
Main path finder algorithm firstly searches for the cells that holds the value 1. Path finder algorithm calls “proceedPoint” method for each cell that holds 1 until it returns “true”. After “proceedPoint” method returns true, the main algorithm calls “PrintSolution” method then exits.

The complexity of the maze finder algorithm is proportional to 𝑇ℎ𝑒𝑡𝑎(𝑛).

### The "proceedPoint" Method
“proceedPoint” is a recursive method that has an input arguments that specifies the x and y coordinate of a cell that are supposed to find a proceeding step to it.

This method returns “true” if the correct path is found, “false” if method rolled back to its starting point.
The algorithm calls itself with a coordinate of its neighborhood cell when that neighborhood cell has a value that one more than its value. If there is no such neighborhood cell available, the algorithm calls itself to roll back to its previous coordinate by marking the current cell as “don’t proceed by that cell”. After finding a cell that holds the ending value that given by the user at the starting phase of the program, the method returns “true” then the path will be printed to the console output.

### Known Bugs
The program may generate an error if the path moves crosswise.

## Hashing
This programs counts the word of a given paragraph by using hash table and linekd list.

### Specifications
* This hash structure is used to trace a text file. The program will get a path of a text file written in English. The program will trace each word and keep track the positions of them using the hash tables and their related links.
* After the table is organized, the program ask a user a word and this word is searched through the hash table. If it is found in the text, the program inform user it’s first place in the text.

### Algorithms
The LinkedListNode is a class that holds the word’s hash, locations and repetition count. If the word found more than once, the capacity of array that holds the locations of word increases. That makes the algoritm more complex but memory efficient.

The HashTable class organizes every row of the hash table by creating a LinkedListNode array. Every element of the array represents a row of the hash table. The “AddItem” method is clearly explained by comments in the code.

The sorting algorithm, which is called Sort, sorts the words by checking the hash table from top to below. For each word, the algorithm places the word into a sub-array of two-dimensional array’s 𝑛th array, where 𝑛 represents the repetition of that word.

Finding hash is the main point of the application. The ConvertInt function converts the input string to a long by summing the value of a char such that, multiplying the ASCII representation of each character of string by the index of that character. For example, the integer representation of the “Test” is

<p align="center">
T: 84 × 1 = 84
e: 101 × 2 = 202
s: 115 × 3 = 345
t: 116 × 4 = 464
</p>

and then,

<p align="center">
84 + 202 + 345 + 464 = 1095.
  </p>

The FindHash fuction finalizes the hashing by calculating mod of the input number with the size of the table to fit every word into the table. That means, if the size of the table changes, the hash of the word would be change too. To prevent this situation, the size of the table is fixed to 512 for each session. Continuing the example given above, the hast of the “Test” is

<p align="center">
1095 mod 512 ≡ 71.
  </p>
  
## License
Licensed under MIT License.
