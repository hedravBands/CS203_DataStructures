/*
Define a method named readData to load the provided data to your class instance. Each data item,
including a sequence and a dot-bracket string, should be stored in a node of a doubly linked list with
header and tail. This list instance should be the data attribute of your class. Key information in a
node of the list includes: primarySequence, dotBracketString, and validity. (2 marks)
Check Node.java <--
 */

import java.io.*;
import java.util.Scanner;

public class rnaSecStrcAnalysis {
    //reading file
    private File inputFile = new File(".\\src\\rna_data.txt");
    private Scanner sc = new Scanner(inputFile);
    //writing file
    private FileWriter outputFile = new FileWriter(".\\out\\production\\A01\\rna_data_output.txt");
    private BufferedWriter bw = new BufferedWriter(outputFile);
    //Dummy head and tail
    private Node head = new Node(); //dummy head
    private Node tail = new Node(); //dummy tail


    public rnaSecStrcAnalysis() throws IOException {
        readData();
        checkValidity();
        writeData();
        System.out.println("All Done! UID 6967483");
    } //constructor


    /*
    This method reads data from a given file and load the double-end Linked List
     */
    private void readData() {
        // start up head and tail
        head.setNext(tail);
        tail.setPrev(head);
        // determine insertion point
        Node lastUsed = head;
        //insert new nodes in-between head and tail
        while (sc.hasNextLine()) {
            //load data
            Node newNode = new Node(sc.nextLine(), sc.nextLine());
            //rearrange pointers
            newNode.setPrev(lastUsed);
            newNode.setNext(tail);
            tail.setPrev(newNode);
            lastUsed.setNext(newNode);
            lastUsed = newNode;
        }
        sc.close();
    }

    private void checkValidity(){
        Node newNode = head.getNext();

        while (newNode.getNext() != null){
            //test sequence of dots and brackets
            if (isValid(newNode.getDotBracketString())){
                newNode.changeValidity();
            }
            newNode = newNode.getNext();
            }
        }

    private Boolean isValid(String s) {
        //standard result is false
        //defining delimiters
        final String initials   = "({[";
        final String endings    = ")}]";
        stackForDotBracket sequence = new stackForDotBracket(s.length());
        for (char c : s.toCharArray()) {
            // store if it is one of initials
            if (initials.indexOf(c) != -1) {
                sequence.push(c);
            }
            // evaluate if it is one of endings
            else if (endings.indexOf(c) != -1) {
                // either the stack is empty
                if (sequence.isEmpty()) {
                    return false;
                }
                // or there is a mismatch
                if (endings.indexOf(c) != initials.indexOf(sequence.pop())) {
                    return false;
                }
            }
        }
        // return whether sequence is empty: false is mismatch, true is a match
        return sequence.isEmpty();
        }


        /*
        This method writes results into a file
         */
        private void writeData() throws IOException {
            Node newNode = head.getNext();
            while (newNode.getNext() != null) {
                //write to file key info from each node
                bw.write(newNode.getPrimarySequence());
                bw.newLine();
                bw.write(newNode.getDotBracketString());
                bw.newLine();
                bw.write(newNode.getValidity());
                bw.newLine();
                //go to next node
                newNode = newNode.getNext();
            }
            bw.close();
        }

    public static void main (String[] args) throws IOException {
        rnaSecStrcAnalysis rna = new rnaSecStrcAnalysis();
    }

}




