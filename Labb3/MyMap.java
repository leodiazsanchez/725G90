
public class MyMap<K, V> {

	private KeyValuePair head;
	private int size = 0;

	private class KeyValuePair {
		private K key;
		private V value;
		private KeyValuePair next;

		private KeyValuePair(K key, V value) {
			this.key = key;
			this.value = value;
		}

		public KeyValuePair getNext() {
			return next;
		}

		public void setNext(KeyValuePair next) {
			this.next = next;
		}
	}

	public void put(K key, V value) {
		KeyValuePair temp = new KeyValuePair(key, value);
		if (head != null) {
			head.setNext(temp);
		} else {
			head = temp;
		}
		this.size++;
	}

	// Ska lägga till ett nytt nyckel-värde-par i strukturen.

	public V get(K key) {
		KeyValuePair temp = head;
		while (temp.key != key) {
			temp = temp.getNext();
			if (temp == null) {
				return null;
			}
		}

		return temp.value;
	}
	// Ska returnera värdet som är associerat med nyckeln K. Om det inte
	// finns något värde associerat med den nyckeln returneras null.

	public boolean isEmpty() {
		return (head == null) ? true : false;
	}

	public int size() {
		return this.size;
	}

	public static void main(String[] args) {
		MyMap<String, String> map = new MyMap<>();

		map.put("Hej", "123");
		map.put("Apa", "bajs");

		System.out.println(map.get("XS"));
		System.out.println(map.get("Hej"));
		System.out.println(map.size());
	}
	// Returnerar antal nyckel-värde-par i strukturen.
}
