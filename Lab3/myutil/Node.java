package myutil;

public class Node<E> {

	private E data;
	private Node<E> next;

	public Node(E data) {
		this.data = data;
	}

	public E getData() {
		return this.data;
	}

	public Node<E> getNext() {
		return this.next;
	}

	public void setNext(Node<E> next) {
		this.next = next;
	}

}
