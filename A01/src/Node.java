class Node {
    private String primarySequence, dotBracketString;
    private boolean validity;
    private Node prev, next;


    // Constructor with initial validity set to false,
    // @var ps,db String key info
    public Node(String ps, String db) {
        primarySequence = ps;
        dotBracketString = db;
        validity = false;
        prev = null;
        next = null;
    };

    /*
    Constructor for dummy header and trailer
     */
    public Node(){
        primarySequence = null;
        dotBracketString = null;
        validity = false;
        prev = null;
        next = null;
    }
    //setters and getters
    public void setNext(Node nxt) { this.next = nxt; }

    public void setPrev(Node prv) { this.prev = prv; }

    public Node getNext(){
        return this.next;
    }

    public Node getPrev(){ return this.prev; }

    public void changeValidity(){ this.validity = !this.validity; }

    public String getPrimarySequence() { return this.primarySequence; }

    public String getDotBracketString() { return this.dotBracketString; }

    public String getValidity(){ return this.validity ? "1" : "0"; }


} // Node

