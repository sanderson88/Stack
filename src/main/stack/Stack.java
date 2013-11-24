package main.stack;

/**
 * A basic statically sized Stack class.
 * 
 * @author Sean
 */
public class Stack<E> {
	private static final int DEFAULT_SIZE = 5;
	private Object [] stack;
	private int position = -1;
	
	/**
	 * Default constructor. Creates a 5 object stack.
	 */
	public Stack() {
		stack = new Object[DEFAULT_SIZE];
	}
	
	/**
	 * Creates a stack of the given size.
	 * @param size The size of the stack.
	 */
	public Stack(int size) {
		stack = new Object[size];
	}
	
	/**
	 * Push an object onto the stack and increment the location.
	 * @param object The object to be pushed.
	 * @throws StackOverFlowException
	 */
	public void push(Object object) throws StackOverFlowException {
		if (position < stack.length-1) {
			stack[++position] = object;
		} else {
			throw new StackOverFlowException();
		}
	}
	
	/**
	 * Pop an item off the stack and decrement the location.
	 * @return The last object on the stack.
	 * @throws StackUnderFlowException
	 */
	public E pop() throws StackUnderFlowException {
		E returnObject;
		if (position >= 0) {
			returnObject = (E)stack[position];
			stack[position--] = null;
			return returnObject;
		} else {
			throw new StackUnderFlowException();
		}
	}
	
	/**
	 * Get the last object on the stack without removing it.
	 * @return The last object on the stack.
	 * @throws StackUnderFlowException
	 */
	public E peek() throws StackUnderFlowException {
		if(position >= 0) {
			return (E)stack[position];
		} else {
			throw new StackUnderFlowException();
		}
	}
	
	@SuppressWarnings("serial")
	public static class StackUnderFlowException extends RuntimeException {
		public StackUnderFlowException() {}
		
		public StackUnderFlowException(String message) {
			super(message);
		}
	}

	@SuppressWarnings("serial")
	public static class StackOverFlowException extends RuntimeException {
		public StackOverFlowException() {}
		
		public StackOverFlowException(String message) {
			super(message);
		}
	}
	
	
}
