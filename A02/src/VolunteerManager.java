import java.io.*;
import java.util.Scanner;

public class VolunteerManager {
    //reading file
    final File inputFile = new File(".\\src\\volunteer_data.txt");

    //output file
    final FileWriter outputFile = new FileWriter(".\\src\\results.txt");
    final BufferedWriter bw = new BufferedWriter(outputFile);
    private BinaryNode[] nodeList;
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

    } // constructor




    /*
   This method reads data from a given file and load the double-end Linked List
    */
    private void createBST() throws IOException {
        Scanner sc = new Scanner(inputFile);

        //count lines , only data
        int lines = -1; //remove labels, keep data
        while (sc.hasNextLine()) {
            lines++;
            sc.nextLine();
        }
        sc.close();

        //populate nodeList
        sc = new Scanner(inputFile);
        sc.nextLine(); //skip labels
        nodeList = new BinaryNode[lines];
        for (int i = 0; i < lines; i++){
            nodeList[i] = new BinaryNode(""+sc.next(), ""+sc.next(),
                    ""+sc.next()+" "+sc.next()+" "+sc.next(), ""+sc.next());
            sc.nextLine();
        }
        sc.close();

        // Requirement Item 1: calling insert() from createBST()
        root = insert(nodeList, 0, nodeList.length - 1);

    }

    // this method inserts new nodes to the tree
    public BinaryNode insert(BinaryNode[] nodeList, int from, int upto) {
        




        /*
        // base case
        if (from > upto) return null;

        // recurrence down the tree in [from, upto]
        // root of a given subtree
        BinaryNode node = nodeList[from];
        // find k, the point of insertion
        int k;
        for (k = from; k <= upto; k++){
            if (Integer.valueOf(nodeList[k].getId()) > Integer.valueOf(node.getId()) ) break;
        }
        // k holds position now
        // set left and right pointers
        node.setLeft(insert(nodeList, from + 1, k - 1));
        node.setRight(insert(nodeList, k, upto));

        // node is ready
        return node;

         */
    }

    private void printAll() throws IOException {
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
    private void printPost(BinaryNode node) throws IOException {
        if (node == null) { return; }
        printPost(node.getLeft());
        printPost(node.getRight());
        printData(node);

    }

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

    private void height() throws IOException {
        //recursion inside getHeight()
        int result = getHeight(root);

        //print
        System.out.print("Item 3: Height of BST"+"\n");
        System.out.println("Value: "+ result+"\n");

        //write
        bw.write("Item 3: Height of BST"+"\n");
        bw.write("Value: " + result+"\n");


    }
    private int getHeight(BinaryNode node){
        if (node == null) return -1;
        return 1 +  Math.max(getHeight(node.getLeft()),getHeight(node.getRight()));
    }




    private void depth() throws IOException {
        //recursion inside getDepth
        int result = getDeepest(root);

        //print
        System.out.print("Item 4: Deepest Node"+"\n");
        System.out.println("Value: "+ result+"\n");

        //write
        bw.write("Item 4: Depth of BST"+"\n");
        bw.write("Value: " + result+"\n");

        bw.close();
    }
    private getDeepest(BinaryNode node, int value){
        if (node == null) {
            return (0, null )
        }
        if ((node.getRight() == null) && (node.getLeft() == null)){
            return (1, node)
        }
        leftMax, node.getLeft() = getDeepest(node.getLeft());
        rightMax, node.getRight() = getDeepest(node.getRight());

        if (leftMax > rightMax) return (leftMax +1 , node.getLeft())
        else return (rightMax +1 , node.getRight())



    }

    public static void main(String[] args) throws IOException {
      VolunteerManager vm = new VolunteerManager();

    }
}
