/*
To tackle the task in checkValidity, you should define a class for the stack named stackForDotBracket
with all necessary methods (push, pop, isEmpty, isFull, size, and top), and use an instance of this
class as a data attribute in your rnaSecStruAnalysis class. (2 marks)
 */

public class stackForDotBracket {
    private char[] dataArray;
    private int topIndex;
    private int arrayCapacity;

    /* Constructor to initialize the stack, using a list of char
    @var capacity int length of array
    @var topIndex int set to -1 as null for empty array
     */
    stackForDotBracket(int capacity) {
        dataArray = new char[capacity];
        arrayCapacity = capacity;
        topIndex = -1;
    }

    /*
    This method adds an element to List, placed in front of List
    @var elementC char element to be inserted
    @return boolean true if operation is successful / false for overflow
     */
    public boolean push(char elementC) {
        // check overflow
        if (isFull()) {
            return false;
        }
        dataArray[++topIndex] = elementC;
        return true;
    }

    /*
    This method removes the top element of list and return it
    @return '\0' char if array is empty (underflow)
     */
    public char pop() {
        // check underflow
        if (isEmpty()) {
            return '\0';
        }
        // last element is now lost (garbage collector: lost reference)
        return dataArray[topIndex--];
    }

    /*
    This method checks whether dataArray is empty
    @returns boolean true if empty / false if contains at least 1 element
     */
    public Boolean isEmpty() {
        return topIndex == -1;
    }

    /*
    This method check whether dataArray is full
    @returns boolean true if full / false if contains at least 1 remained spot
     */
    public Boolean isFull() {
        return topIndex == arrayCapacity - 1;
    }

    /*
    This method returns the size of stack, i.e. spots occupied by data
    @return size int size of stack
     */
    public int size() {
        return topIndex + 1;
    }

    /*
    This method returns the top element of the stack, without removing it from List
    @return topElement char top element of stack, '\0' if empty
     */
    public char top() {
        if (isEmpty()) {
           return '\0';
        }
        return dataArray[topIndex];
    }
}