
public class MyMap<K, V> {
	
	private KeyValuePair head = null;
	
	private class KeyValuePair{
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
		KeyValuePair temp = new KeyValuePair(key,value);
		if (head != null) {
			head.setNext(temp);
		} else {
			head = temp;
		}
	}

	// Ska l�gga till ett nytt nyckel-v�rde-par i strukturen.

	public V get(K key) {
		KeyValuePair temp = head;
		while (temp.key != key) {
			temp = temp.getNext();
		}
		
		return temp.value;
	}
	// Ska returnera v�rdet som �r associerat med nyckeln K. Om det inte
	// finns n�got v�rde associerat med den nyckeln returneras null.

	public boolean isEmpty() {
		return (head != null) ? true : false;
	}

	public int size() {
		int size = 0;
		KeyValuePair temp = head;
		while (temp != null) {
			size++;
			temp = temp.getNext();
		}
		return size;
	}
	
	public static void main(String[] args) {
		MyMap<String,String> map = new MyMap<>();
		
		map.put("Hej", "123");
		map.put("Apa", "bajs");
		
		System.out.println(map.get("XS"));
		System.out.println(map.get("XS"));
	}
	// Returnerar antal nyckel-v�rde-par i strukturen.
}