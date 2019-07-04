## Algorithms-and-Complexity-Homeworks
Includes 4 homeworks: file reading and sorting, simple database application, maze solver, hashing

## Development Environment
The IDE that used in this work is NetBeans IDE 8.2, the version of the Java SE Runtime Environment on the machine that runs IDE is 1.8.0_181-b13. The project was tested on Intel Core i7-7700 machine that running Windows 10 Education (Build 17134) and Intel Core i5-480M laptop that running Windows 7 Service Pack 1 and no problems were found while testing.

## File Reading and Sorting
In this assignment, the application is supposed to open a text file consisting of student IDs, names, ages, and admission year to university. The first line of the file indicates the number of records. Then application reads the content of the file and sort the students according to:
* sort_ID : The students will be sorted according to their ID’s
* sort_Year : The students will be sorted according to their admission year
* sort_Age : The students will be sorted according to their ages.

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
