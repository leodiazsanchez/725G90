
public class MyQueue<E> {

	private Node<E> head;
	private int size = 0;

	public void enqueue(E element) {
		Node<E> temp = new Node<E>();
		temp.setData(element);
		if (head != null) {
			head.setNext(temp);
		} else {
			head = temp;
		}
		this.size++;

	}

	public E dequeue() throws ElementNotFoundException {
		if (head == null) {
			throw new ElementNotFoundException();
		}
		Node<E> temp = head;
		head = head.getNext();
		this.size--;
		return temp.getData();
	}
	// Kastar exception on det inte finns något att avköa

	public boolean isEmpty() {
		return (head == null) ? true : false;
	}

	public int size() {
		return this.size;
	}

	public static void main(String[] args) throws ElementNotFoundException{

		MyQueue<String> queue = new MyQueue<String>();
		queue.enqueue("Hej");
		queue.enqueue("Apa");

		System.out.println(queue.size());
		System.out.println(queue.dequeue());
		System.out.println(queue.size());
		System.out.println(queue.isEmpty());
		System.out.println(queue.dequeue());
		System.out.println(queue.size());
		System.out.println(queue.isEmpty());
	}
}
