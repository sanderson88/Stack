package test.stack;

import static org.junit.Assert.*;
import main.stack.*;

import org.junit.Before;
import org.junit.Test;

public class StackTest {
	Stack testStack;
	Stack smallStack;
	
	@Before
	public void setUp() throws Exception {
		testStack = new Stack();
	}
	
	private void pushMultipleObjects(Object ... objects) {
		for (Object object : objects) {
			testStack.push(object);
		}
	}
	
	private void pushNumberOfObjects(int numberOfObjects) {
		for (int i = 0; i < numberOfObjects; i++) {
			testStack.push(i);
		}
	}
	
	@Test
	public void basicPush() {
		testStack.push(0);
		assertEquals(0, testStack.peek());	
	}
	
	@Test
	public void basicPop() {
		testStack.push(12);
		testStack.push(24);	//Don't want to Underflow in this test
		assertEquals(24, testStack.pop());
		assertEquals(12, testStack.peek());	//Verify it decremented correctly
	}
	
	@Test
	public void fillStack() {
		pushMultipleObjects(1, 2, 3, 4, 5);
		assertEquals(5, testStack.peek());
	}
	
	@Test
	public void fillAndEmptyStack() {
		pushNumberOfObjects(5);
		assertEquals(4, testStack.pop());
		assertEquals(3, testStack.pop());
		assertEquals(2, testStack.pop());
		assertEquals(1, testStack.pop());
		assertEquals(0, testStack.pop());
	}
	
	@Test(expected=Stack.StackOverFlowException.class)
	public void pushTooManyElements() {
		pushNumberOfObjects(6);
	}
	
	@Test(expected=Stack.StackUnderFlowException.class)
	public void popAnEmptyStack() {
		testStack.pop();
	}
	
	@Test(expected=Stack.StackUnderFlowException.class)
	public void peekAnEmptyStack() {
		testStack.peek();
	}
	
	@Test
	public void smallStackBasic() {
		testStack = new Stack(3);
		pushNumberOfObjects(3);
		assertEquals(2, testStack.peek());
		assertEquals(2, testStack.pop());
		assertEquals(1, testStack.pop());
		assertEquals(0, testStack.pop());
	}
	
	@Test(expected=Stack.StackOverFlowException.class)
	public void pushTooManyElementsToSmallStack() {
		testStack = new Stack(3);
		pushNumberOfObjects(4);
	}
	
	@Test(expected=Stack.StackUnderFlowException.class)
	public void popAnEmptyStackToSmallStack() {
		testStack = new Stack(3);
		testStack.pop();
	}
	
	@Test(expected=Stack.StackUnderFlowException.class)
	public void peekAnEmptyStackToSmallStack() {
		testStack = new Stack(3);
		testStack.peek();
	}
}
