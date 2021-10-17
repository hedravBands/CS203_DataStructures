class BinaryNode {
    private String volunteerID, volunteerName, homeAddress, phoneNumber;
    private BinaryNode left, right;

    // Constructor
    public BinaryNode(String id, String name, String address, String phone) {
        volunteerID = id;
        volunteerName = name;
        homeAddress = address;
        phoneNumber = phone;
        left = null;
        right = null;
    } // constructor


    // setters and getters
    public String getId() { return this.volunteerID;}
    public String getName() {return this.volunteerName;}
    public String getAddress() {return this.homeAddress;}
    public String getNumber() {return this.phoneNumber;}

    public BinaryNode getRight(){
        return this.right;
    }
    public BinaryNode getLeft(){ return this.left; }

    public void setRight(BinaryNode bn) { this.right = bn; }
    public void setLeft(BinaryNode bn) { this.left = bn; }

} // Node

