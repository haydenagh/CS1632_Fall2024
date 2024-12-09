package edu.pitt.cs;

import static org.junit.Assert.*;

import org.junit.*;
import org.mockito.*;

public class ValueTest {
	Value value;

	@Before
	public void setUp() {
		value = Mockito.mock(Value.class);
	}
	
	@Test
	public void testIncValNone() {
		Mockito.when(value.getVal()).thenReturn(0);
		assertEquals(0, value.getVal());
	}
	
	@Test
	public void testIncValOnce() {
		value.incVal();
		Mockito.when(value.getVal()).thenReturn(1);
		assertEquals(1, value.getVal());
	}

	@Test
	public void testIncValTwice() {
		value.incVal();
		value.incVal();
		Mockito.when(value.getVal()).thenReturn(2);
		assertEquals(2, value.getVal());
	}
}