package myutil;

public class MyQueue<E> {
	private Node<E> head;
	private Node<E> tail;
	private int size;

	public MyQueue() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}

	public void enqueue(E element) {
		Node<E> temp = new Node<>(element);
		if (this.tail != null) {
			this.tail.setNext(temp);
		}
		this.tail = temp;
		if (this.head == null) {
			this.head = temp;
		}
		this.size++;
	}

	public E dequeue() throws ElementNotFoundException {
		if (this.head == null) {
			throw new ElementNotFoundException("Queue is empty.");
		}
		E element = this.head.getData();
		this.head = this.head.getNext();
		if (this.head == null) {
			this.tail = null;
		}
		this.size--;
		return element;
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	public int size() {
		return this.size;
	}

}
