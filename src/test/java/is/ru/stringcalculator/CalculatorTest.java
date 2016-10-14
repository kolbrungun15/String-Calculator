package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
public class CalculatorTest {
	@Test
	public void testEmptyString() {
		assertEquals(0, Calculator.add(""));
	}

	@Test 
	public void testOneNumber(){
		assertEquals(1, Calculator.add("1"));
	}

	@Test
	public void testTwoNumbers(){
		assertEquals(3, Calculator.add("1,2"));
	}

	@Test
	public void testFivrNumbers(){
		assertEquals(13, Calculator.add("1,2,5,2,3"));
	}

	@Test
	public void testNewLine(){
		assertEquals(6, Calculator.add("1\n2,3"));
	}

	@Test
	public void testNewLine2(){
		assertEquals(11, Calculator.add("1\n2,3\n5"));
	}
	//Skoða betur ... ekki viss hvort þetta sé rétt.
	@Test
	public void testNegativeNumbers() {
	  try {
	    new String("-1,2");
	  } catch (IllegalArgumentException e) {
	  }
	}

	@Test
	public void TestBigNumbers(){
		assertEquals(2, Calculator.add("1002,2"));
	}

	@Test
	public void TestDelimite(){
		assertEquals(2, Calculator.add("//;1;2"));
	}

}