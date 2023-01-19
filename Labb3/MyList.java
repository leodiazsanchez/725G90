
public class MyList<E> {

	private Node<E> head;
	private int size = 0;

	public void add(E element) {
		Node<E> temp = new Node<E>();
		temp.setData(element);
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
	// Ska lägga till ett nytt element i listan

	public E getElementAt(int i) throws ElementNotFoundException {

		if (i >= this.size) {
			throw new ElementNotFoundException();
		}
		Node<E> node = head;
		for (int j = 0; j < i; j++) {
			node = node.getNext();
		}
		return node.getData();

	}
	// Ska returnera ett element på index i (första elementet ligger på
	// index 0) utan att ta bort det ur listan. Kastar exception om i är
	// större än eller lika med listans storlek.

	public boolean isEmpty() {
		return (head == null) ? true : false;
	}

	public int size() {
		return size;
	}

	public static void main(String[] args) throws ElementNotFoundException {

		MyList<String> list = new MyList<String>();
		list.add("Hej");
		list.add("Apa");
		list.add("XD");

		System.out.println(list.size());
		System.out.println(list.getElementAt(2));
		System.out.println(list.size());
		System.out.println(list.isEmpty());
	}
}
