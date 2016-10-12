package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.test;
public class CalculatorTest {
	@test
	public void testEmptyString() {
		assertEquals(0, Calculator.add(""));
	}
}