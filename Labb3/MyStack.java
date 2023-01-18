
public class MyStack<E> {

	private Node<E> head;

	public MyStack() {
		this.head = null;
	}

	public void push(E element) {
		Node<E> temp = head;
		head = new Node<E>();
		head.setData(element);
		head.setNext(temp);
	}

	public E pop() throws ElementNotFoundException {

		if (head == null) {
			throw new ElementNotFoundException();
		}
		E data = head.getData();
		head = head.getNext();
		return data;

	}
	// Kastar exception om det ej finns något att poppa

	public boolean isEmpty() {
		return (head != null) ? true : false;
	}

	public int size() {
		int size = 0;
		Node<E> node = head;
		while (node != null) {
			size++;
			node = node.getNext();
		}
		return size;
	}

	public static void main(String[] args) throws ElementNotFoundException {
		MyStack<String> stack = new MyStack<String>();
		stack.push("Hej");
		stack.push("Apa");

		System.out.println(stack.size());
		System.out.println(stack.pop());
		System.out.println(stack.size());
		System.out.println(stack.isEmpty());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
	}

}
