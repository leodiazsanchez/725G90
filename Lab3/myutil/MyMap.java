package myutil;

public class MyMap<K, V> {

	private KeyValuePair head;
	private KeyValuePair tail;
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
		if (this.tail != null) {
			this.tail.setNext(temp);
		}
		this.tail = temp;
		if (this.head == null) {
			this.head = temp;
		}
		this.size++;
	}

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

	public boolean isEmpty() {
		return this.size == 0;
	}

	public int size() {
		return this.size;
	}

}
