package model.exceptions;

public class LimitException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public LimitException(String msg) {
		super(msg);
	}
}
