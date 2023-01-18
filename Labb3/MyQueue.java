
public class MyQueue<E> {

	private Node<E> head;

	public MyQueue() {
		this.head = null;
	}

	public void enqueue(E element) {
		if (head.getData() == null) {
			head.setData(element);
		} else {
			Node<E> temp = new Node<E>();
			temp.setData(element);
			head.setNext(temp);
		}

	}

	public E dequeue() {
		Node<E> temp = head;
		head = head.getNext();
		return temp.getData();
	}
	// Kastar exception on det inte finns något att avköa

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

	public static void main(String[] args) {

		MyQueue<String> queue = new MyQueue<String>();
		queue.enqueue("Hej");
		queue.enqueue("Apa");

		System.out.println(queue.size());
		System.out.println(queue.dequeue());
		System.out.println(queue.size());
		System.out.println(queue.isEmpty());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
	}
}
