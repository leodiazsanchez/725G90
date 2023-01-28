package myutil;

public class MyStack<E> {

	private Node<E> head;
	private int size = 0;

	public void push(E element) {
		Node<E> temp = head;
		head = new Node<E>(element);
		head.setNext(temp);
		this.size++;
	}

	public E pop() throws ElementNotFoundException {

		if (this.head == null) {
			throw new ElementNotFoundException("Stack is empty.");
		}

		E data = head.getData();
		head = head.getNext();
		this.size--;
		return data;

	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	public int size() {
		return this.size;
	}

}
