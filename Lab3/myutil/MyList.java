package myutil;

public class MyList<E> {

	private Node<E> head;
	private int size = 0;

	public void add(E element) {
		Node<E> temp = new Node<E>(element);
		if (head == null) {
			head = temp;
		} else {
			Node<E> node = head;
			while (node.getNext() != null) {
				node = node.getNext();
			}
			node.setNext(temp);
		}
		this.size++;
	}


	public E getElementAt(int i) throws ElementNotFoundException {

		if (i >= this.size) {
			throw new ElementNotFoundException("This element does not exist!");
		}
		Node<E> node = head;
		for (int j = 0; j < i; j++) {
			node = node.getNext();
		}
		return node.getData();

	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	public int size() {
		return this.size;
	}

}
