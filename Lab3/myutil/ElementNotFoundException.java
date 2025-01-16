package myutil;

import java.util.NoSuchElementException;

public class ElementNotFoundException extends NoSuchElementException {
	public ElementNotFoundException(String message) {
		super(message);
	}

}
