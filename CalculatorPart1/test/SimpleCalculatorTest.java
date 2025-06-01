import org.junit.Test;

import calculator.Calculator;
import calculator.SimpleCalculator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * This class represents some tests for SimpleCalculator that differs from SmartCalculator.
 */
public class SimpleCalculatorTest extends AbstractTest {

  /**
   * Forms a SimpleCalculator object for initialization.
   *
   * @return a SimpleCalculator object.
   */
  protected Calculator formCalculator() {
    return new SimpleCalculator();
  }

  @Test
  public void InvalidInputs() {
    this.setUp();

    Calculator a2 = calculator2.input('2');
    Calculator b2 = a2.input('+');
    assertEquals("2+", b2.getResult());

    Calculator a3 = calculator3.input('3');
    Calculator b3 = a3.input('-');

    try {

      calculator4.input('+');
      fail("IllegalArgumentException expected");

      b2.input('+');
      fail("IllegalArgumentException expected");

      b2.input('-');
      fail("IllegalArgumentException expected");

      b2.input('*');
      fail("IllegalArgumentException expected");

      b2.input('=');
      fail("IllegalArgumentException expected");

      b3.input('+');
      fail("IllegalArgumentException expected");

    } catch (IllegalArgumentException e) {
      // passes
    }
  }

  @Test
  public void testOperatorAfterEquals() {
    this.setUp();

    Calculator a1 = calculator1.input('1');
    assertEquals("1", a1.getResult());

    Calculator b1 = a1.input('1');

    assertEquals("11", b1.getResult());

    Calculator c1 = b1.input('+');
    assertEquals("11+", c1.getResult());

    Calculator d1 = c1.input('9');
    assertEquals("11+9", d1.getResult());

    Calculator e1 = d1.input('=');
    assertEquals("20", e1.getResult());

    Calculator f1 = e1.input('+');
    assertEquals("20+", f1.getResult());

    try {
      f1.input('-');
      fail("IllegalArgumentException expected");
      f1.input('+');
      fail("IllegalArgumentException expected");
      f1.input('*');
    } catch (IllegalArgumentException e) {
      // passes
    }
  }

}