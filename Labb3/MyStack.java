
public class MyStack<E> {

	private Node<E> head;
	private int size = 0;

	public void push(E element) {
		Node<E> temp = head;
		head = new Node<E>();
		head.setData(element);
		head.setNext(temp);
		this.size++;
	}

	public E pop() throws ElementNotFoundException {

		if (head == null) {
			throw new ElementNotFoundException();
		}
		E data = head.getData();
		head = head.getNext();
		this.size--;
		return data;

	}
	// Kastar exception om det ej finns något att poppa

	public boolean isEmpty() {
		return (head == null) ? true : false;
	}

	public int size() {
		return this.size;
	}

	public static void main(String[] args) throws ElementNotFoundException {
		MyStack<String> stack = new MyStack<String>();
		stack.push("Hej");
		stack.push("Apa");

		System.out.println(stack.size());
		System.out.println(stack.pop());
		System.out.println(stack.size());
		stack.push("XD");
		System.out.println(stack.size());
		System.out.println(stack.isEmpty());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
	}

}
