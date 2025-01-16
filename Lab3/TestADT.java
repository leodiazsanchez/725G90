import myutil.*;

public class TestADT {

	public static void main(String[] args) {
		System.out.println("TESTING QUEUE\n");
		queueTest();
		System.out.println("\nTESTING STACK\n");
		stackTest();
		System.out.println("\nTESTING LIST\n");
		listTest();
		System.out.println("\nTESTING MAP\n");
		mapTest();
	}

	public static void queueTest() {
		MyQueue<String> queue = new MyQueue<String>();

		// Testar enqueue
		queue.enqueue("first");
		queue.enqueue("second");
		queue.enqueue("third");
		System.out.println("Expected size: 3 | Actual size: " + queue.size());

		// Testar dequeue
		String dequeued = queue.dequeue();
		System.out.println("Expected dequeued: first | Actual dequeued: " + dequeued);
		System.out.println("Expected size: 2 | Actual size: " + queue.size());

		// Testar isEmpty
		queue.dequeue();
		queue.dequeue();
		System.out.println("Expected isEmpty: true | Actual isEmpty: " + queue.isEmpty());
		queue.enqueue("fourth");
		System.out.println("Expected isEmpty: false | Actual isEmpty: " + queue.isEmpty());

		// Testar dequeue på en tom kö
		try {
			queue.dequeue();
			queue.dequeue();
			System.out.println("Test failed: ElementNotFoundException not thrown");
		} catch (ElementNotFoundException e) {
			System.out.println("Test passed: ElementNotFoundException thrown as expected");
		}

	}

	public static void stackTest() {
		MyStack<Integer> stack = new MyStack<Integer>();

		// Testar push metoden
		stack.push(1);
		stack.push(2);
		stack.push(3);

		// Testar size metoden
		int size = stack.size();
		System.out.println("Expected size: 3 | Actual size: " + size);

		// Test pop metoden
		int popped = stack.pop();
		System.out.println("Expected pop: 3 | Popped element: " + popped);
		System.out.println("Expected size: 2 | Actual size: " + stack.size());

		// Testar isEmpty metoden
		boolean empty = stack.isEmpty();
		System.out.println("Expected isEmpty: false | Actual isEmpty: " + empty);

		// Tesar pop på en tom stack
		try {
			stack.pop();
			stack.pop();
			stack.pop();
			// NoSuchElementException borde kastas
			System.out.println("Test failed: ElementNotFoundException not thrown.");
		} catch (ElementNotFoundException e) {
			System.out.println("Test passed: ElementNotFoundException caught as expected.");
		}
	}

	public static void listTest() {
		MyList<Integer> list = new MyList<>();

		// Testar add metoden
		list.add(1);
		list.add(2);
		list.add(3);

		// Testar getElementAt metoden
		System.out.println("Expected output: 1 | Actual output: " + list.getElementAt(0));
		System.out.println("Expected output: 2 | Actual output: " + list.getElementAt(1));
		System.out.println("Expected output: 3 | Actual output: " + list.getElementAt(2));
		try {
			System.out.println("Expected output: ElementNotFoundException | Actual output: " + list.getElementAt(3));
		} catch (ElementNotFoundException e) {
			System.out.println("ElementNotFoundException thrown as expected.");
		}

		// Testar size metoden
		System.out.println("Expected output: 3 | Actual output: " + list.size());
	}

	public static void mapTest() {

		MyMap<Integer, String> map = new MyMap<Integer, String>();

		// Testar put metoden
		map.put(1, "One");
		map.put(2, "Two");
		map.put(3, "Three");
		map.put(4, "Four");
		map.put(5, "Five");
		map.put(6, "Six");

		// Testar size metoden
		System.out.println("Expected size: 6 | Actual size: " + map.size());
		
		// Testar get metoden
		System.out.println("Expected value : One | Actual value: " + map.get(1));
		System.out.println("Expected value : Two | Actual value: " + map.get(2));
		System.out.println("Expected value : Three | Actual value: " + map.get(3));
		System.out.println("Expected value : Four | Actual value: " + map.get(4));
		System.out.println("Expected value : Five | Actual value: " + map.get(5));
		System.out.println("Expected value : Six | Actual value: " + map.get(6));

		// Testar isEmpty metoden
		System.out.println("Expected isEmpty: false | Actual isEmpty: " + map.isEmpty());

		// Testar get metoden på nyckel som inte finns
		System.out.println("Expected value : null | Actual value: " + map.get(7));

	}

}
