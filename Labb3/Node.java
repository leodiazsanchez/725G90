
public class Node<E> {

    private E data;
    private Node<E> next;

    public E getData() { return data; }
    
    public void  setData(E data) { this.data = data; }
    
    public Node<E> getNext() { return next; }
    
    public void setNext(Node<E> top) {next = ((Node<E>) top);}
    
//    public static void main(String[] args) {
//
//    	Node n3 = new Node(1,null);
//      	Node<String> n2 = new Node<String>("N2",n3);
//    	Node<String> n1 = new Node<String>("Head",n2);
//  
//    	
//    	Node n = n1;
//    	while ((Node) n.getNext()!= null) {
//    		System.out.println(n.getData());
//    		//n = (Node) n.getNext();
//    	}
//    	
//    	
//    }
}
