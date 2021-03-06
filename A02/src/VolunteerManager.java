import java.io.*;
import java.util.Scanner;

public class VolunteerManager {
    //reading file
    final File inputFile = new File(".\\src\\volunteer_data.txt");

    //output file
    final FileWriter outputFile = new FileWriter(".\\src\\results.txt");
    final BufferedWriter bw = new BufferedWriter(outputFile);
    private BinaryNode root;


    // default constructor
    VolunteerManager() throws IOException {
        // Item 1
        createBST();
        // Item 2
        printAll();
        // Item 3
        height();
        // Item 4
        depth();
        // Item 5
        depth2();
        // Item 6
        delete();

        bw.close();

    } // constructor


    /*
   Fulfill A02-1
   This method reads data from a given file and load BST root
    */
    public void createBST() throws IOException {
        Scanner sc = new Scanner(inputFile);
        sc.nextLine(); //skip labels
        while (sc.hasNextLine()) {
            insert(root, new BinaryNode("" + sc.next(), "" + sc.next(),
                    "" + sc.next() + " " + sc.next() + " " + sc.next(), "" + sc.next()));
            sc.nextLine();
        }
        sc.close();
    }

    // this method inserts new nodes to BST
    private BinaryNode insert(BinaryNode tree, BinaryNode node) {
        // Assign root 1st time
        if (root == null) { root = node; }
        //base case
        if (tree == null) {
            tree = node;
        } else {
            if (Integer.parseInt(node.getId()) < Integer.parseInt(tree.getId())) {
                tree.setLeft(insert(tree.getLeft(), node));
            } else {
                tree.setRight(insert(tree.getRight(), node));
            }
        }
        return tree;
    }

    // Fulfill A02-2
    public void printAll() throws IOException {
        String labels = "VolunteerID" + "\t"+ "Name" + "\t" + "Address" + "\t" + "Contact" + "\n";

        // Item 02-a
        System.out.print("Item 02-a: preOrder\n");
        System.out.print(labels);
        bw.write("Item 02-a: preOrder\n");
        bw.write(labels);
        // data
        printPre(root);
        System.out.println("\n");
        bw.newLine();

        // Item 02-b
        System.out.print("Item 02-b: inOrder\n");
        System.out.print(labels);
        bw.write("Item 02-b: inOrder\n");
        bw.write(labels);
        //data
        printIn(root);
        System.out.println("\n");
        bw.newLine();

        // Item 02-c
        System.out.print("Item 02-c: postOrder\n");
        System.out.print(labels);
        bw.write("Item 02-c: postOrder\n");
        bw.write(labels);
        // data
        printPost(root);
        System.out.println("\n");
        bw.newLine();
    }

    // print tree PreOrder
    private void printPre(BinaryNode node) throws IOException {
        if (node == null) { return; }
        printData(node);
        printPre(node.getLeft());
        printPre(node.getRight());
    }

    // print tree InOrder
    private void printIn(BinaryNode node) throws IOException {
        if (node == null) { return; }
        printIn(node.getLeft());
        printData(node);
        printIn(node.getRight());
    }

    // print tree PostOrder
    private void printPost(BinaryNode node) throws IOException {
        if (node == null) { return; }
        printPost(node.getLeft());
        printPost(node.getRight());
        printData(node);
    }

    // Prints the content of a given node and writes to file
    private void printData(BinaryNode node) throws IOException {
        // print to screen
        System.out.print("" + node.getId() + "\t" + node.getName() + "\t" +
                "\t" + node.getAddress() + "\t" + node.getNumber());
        System.out.println();

        // write to file
        bw.write("" + node.getId() + "\t" + node.getName() + "\t" +
                "\t" + node.getAddress() + "\t" + node.getNumber());
        bw.newLine();
    }

    //Fulfill A02-3
    public void height() throws IOException {
        //recursion inside getHeight()
        int result = getHeight(root);

        //print
        System.out.print("Item 3: Height of BST"+"\n");
        System.out.println("Value: "+ result+"\n");

        //write
        bw.write("Item 3: Height of BST"+"\n");
        bw.write("Value: " + result+"\n");
        bw.newLine();
    }

    //recursive method
    private int getHeight(BinaryNode node){
        if (node == null) {
            return -1;
        }
        return 1 + Math.max(getHeight(node.getLeft()),getHeight(node.getRight()));
    }

    // Fulfill A02-4
    public void depth() throws IOException {
        //recursion inside getMaxDepth
        int result = getMaxDepth(root);

        //print
        System.out.print("Item 4: Maximum Depth"+"\n");
        System.out.println("Value: "+ result+"\n");

        //write
        bw.write("Item 4: Depth of BST"+"\n");
        bw.write("Value: " + result+"\n");
        bw.newLine();
    }

    private int getMaxDepth(BinaryNode node){
        if (node == null) {
            return -1;
        }
        return 1 + Math.max(getMaxDepth(node.getLeft()),getMaxDepth(node.getRight()));
    }

    // Fulfill A02-5
    public void depth2() throws IOException {
        // value to be searched
        int id = Integer.parseInt("077");
        //iteration inside getDepth
        int result = getDepth(root, id);

        //print
        System.out.print("Item 5: Depth of 077" + "\n");
        System.out.println("Value: " + result + "\n");

        //write
        bw.write("Item 5: Depth of 077" + "\n");
        bw.write("Value: " + result+"\n");
        bw.newLine();
    }

    private int getDepth(BinaryNode node, int key){
        int count = 0;
        BinaryNode curr = node;
        while (Integer.parseInt(curr.getId()) != key){
            if (key < Integer.parseInt(curr.getId())){
                curr = curr.getLeft();
            } else {
                curr = curr.getRight();
            }
            if ( curr == null) { return -1; } //not found
            count++; //down one level
        }
        return count;
    }

    // Fulfill A02-6
    public void delete() throws IOException {
        String labels = "VolunteerID" + "\t"+ "Name" + "\t" + "Address" + "\t" + "Contact" + "\n";
        // value to be searched
        int id1 = Integer.parseInt("024");
        int id2 = Integer.parseInt("060");
        int id3 = Integer.parseInt("071");
        //recursion inside deleteNode
        deleteNode(root, id1);
        deleteNode(root, id2);
        deleteNode(root, id3);

        //print InOrder after deletion
        System.out.print("Item 06: inOrder after deletion\n");
        System.out.print(labels);
        bw.write("Item 06: inOrder after deletion\n");
        bw.write(labels);
        //data
        printIn(root);

    }
    // recursive method to delete a node in BST
    private BinaryNode deleteNode(BinaryNode node, int key){
        if (node == null) {return node;}  // null tree, or not found

        if (Integer.parseInt(node.getId()) > key) {
            node.setLeft(deleteNode(node.getLeft(), key));  //del from left, update
        } else {
            if (Integer.parseInt(node.getId()) < key){
                node.setRight(deleteNode(node.getRight(), key));  // del from right, update
            } else { // (id = key)

                if ((node.getLeft() != null) && (node.getRight() != null)) { // 2 children
                    // find inorder successor
                    BinaryNode temp = findMin(node.getRight());
                    //transfer data
                    node.setId(temp.getId());
                    node.setName(temp.getName());
                    node.setAddress(temp.getAddress());
                    node.setNumber(temp.getNumber());
                    //delete inorder successor
                    node.setRight(deleteNode(node.getRight(), Integer.parseInt(node.getId())));
                } else { // only 1 child, update
                    node = (node.getLeft() != null) ? node.getLeft() : node.getRight();
                }
            }
        }
        return node;
    }

    // min key is within the leftmost node
    private BinaryNode findMin(BinaryNode node){
        if(node != null) {
            while(node.getLeft() != null)
                node = node.getLeft();
        }
        return node;
    }


    public static void main(String[] args) throws IOException {
      VolunteerManager vm = new VolunteerManager();
    } //main

} //VolunteerManager
