import java.util.LinkedList;

class Node{
    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", leftChild=" + ((leftChild==null)? "null":leftChild.getValue()) +
                ", rightChild=" + ((rightChild==null)? "null":rightChild.getValue()) +
                '}';
    }

    private int value;
    private Node leftChild;
    private Node rightChild;

    public void setValue(int value) {
        this.value = value;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }

    public Node(int value) {
        this.value = value;
        this.leftChild=null;
        this.rightChild=null;
    }

    public int getValue() {
        return value;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public boolean haveLeftChild() {
        if (this.getLeftChild()!=null)
            return true;
        else
            return false;
    }

    public boolean haveRightChild() {
        if (this.getRightChild()!=null)
            return true;
        else
            return false;
    }
}


public class BinaryTree {

    private Node rootNode;

    public void addNode(int value){
        if (rootNode==null) {
            rootNode=new Node(value);
            return;
        }

        Node currentNode=rootNode;

        while (true){
            if (value>currentNode.getValue()){
                if (!currentNode.haveRightChild()){
                    currentNode.setRightChild(new Node(value));
                    break;
                }
                else
                    currentNode=currentNode.getRightChild();
            }
            else {
                if (!currentNode.haveLeftChild()){
                    currentNode.setLeftChild(new Node(value));
                    break;
                }

                else currentNode=currentNode.getLeftChild();
            }

        }

    }


    private void printTreeRecursion(Node node){
        System.out.print(node.getValue()+" ");
        if (node.haveLeftChild()) printTreeRecursion(node.getLeftChild());
        if (node.haveRightChild()) printTreeRecursion(node.getRightChild());
    }

    public void printTreeRecursion(){
        System.out.println("Recursion print");
        printTreeRecursion(rootNode);
        System.out.println();
    }

    public void printTreeQueue(){

        System.out.println("Queue print");

        LinkedList<Node> nodeList=new LinkedList<>();
        nodeList.add(rootNode);

        while (nodeList.size()>0){
            Node currentNode=nodeList.peekLast();
            System.out.print(currentNode.getValue()+" ");
            if (currentNode.haveLeftChild()) nodeList.addFirst(currentNode.getLeftChild());
            if (currentNode.haveRightChild()) nodeList.addFirst(currentNode.getRightChild());
            nodeList.pollLast();
        }

        System.out.println();
    }


    public Node searchNodeByValue(int value){


        return searchNodeByValue(value,rootNode);
    }

    private Node searchNodeByValue(int value, Node node) {

        if (node.getValue()==value) return node;

        if  (value> node.getValue() && node.haveRightChild())
            return searchNodeByValue(value, node.getRightChild());
        else if (node.haveLeftChild())
            return searchNodeByValue(value, node.getLeftChild());
        else
            return null;
    }

    public Node searchNodeWithMaxValue(){
        Node currentNode=rootNode;

        while (currentNode.haveRightChild()){
            currentNode=currentNode.getRightChild();
        }

        return currentNode;
    }
    public Node searchNodeWithMinValue(){
        Node currentNode=rootNode;

        while (currentNode.haveLeftChild()){
            currentNode=currentNode.getLeftChild();
        }

        return currentNode;
    }



    public static void main(String[] args) {

        BinaryTree binaryTree=new BinaryTree();

        binaryTree.addNode(6);
        binaryTree.addNode(8);
        binaryTree.addNode(5);
        binaryTree.addNode(8);
        binaryTree.addNode(2);
        binaryTree.addNode(9);
        binaryTree.addNode(7);
        binaryTree.addNode(4);
        binaryTree.addNode(10);
        binaryTree.addNode(3);
        binaryTree.addNode(1);


        binaryTree.printTreeRecursion();
        binaryTree.printTreeQueue();

        System.out.println("Node with value=2:");
        System.out.println("\t"+binaryTree.searchNodeByValue(2)+"\n");

        System.out.println("Node with maximum value:");
        System.out.println("\t"+binaryTree.searchNodeWithMaxValue()+"\n");

        System.out.println("Node with minimum value:");
        System.out.println("\t"+binaryTree.searchNodeWithMinValue()+"\n");

    }

}
