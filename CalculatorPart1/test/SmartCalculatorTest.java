import org.junit.Test;

import calculator.Calculator;
import calculator.SmartCalculator;

import static org.junit.Assert.assertEquals;

/**
 * This class represents some tests for the SmartCalculator implementation that differs from
 * the SimpleCalculator tests.
 */
public class SmartCalculatorTest extends AbstractTest {

  /**
   * Forms a SmartCalculator object for initialization.
   *
   * @return a SmartCalculator object.
   */
  protected Calculator formCalculator() {
    return new SmartCalculator();
  }

  @Test
  public void testAddition() {
    this.setUp();

    Calculator a4 = calculator4.input('6');
    assertEquals("6", a4.getResult());

    Calculator b4 = a4.input('+');
    assertEquals("6+", b4.getResult());

    Calculator c4 = b4.input('=');
    assertEquals("12", c4.getResult());

    Calculator d4 = c4.input('=');
    assertEquals("18", d4.getResult());

    Calculator e4 = d4.input('3');
    assertEquals("3", e4.getResult());

    Calculator f4 = e4.input('2');
    assertEquals("32", f4.getResult());

    Calculator g4 = f4.input('+');
    assertEquals("32+", g4.getResult());

    Calculator h4 = g4.input('=');
    assertEquals("64", h4.getResult());

    Calculator i4 = h4.input('=');
    assertEquals("96", i4.getResult());


    Calculator a5 = calculator5.input('+');
    assertEquals("", a5.getResult());

    Calculator b5 = a5.input('3');
    assertEquals("3", b5.getResult());

    Calculator c5 = b5.input('2');
    assertEquals("32", c5.getResult());

    Calculator d5 = c5.input('C');
    assertEquals("", d5.getResult());


  }

  @Test
  public void testSubtraction() {
    this.setUp();

    Calculator a5 = calculator5.input('6');
    assertEquals("6", a5.getResult());

    Calculator b5 = a5.input('-');
    assertEquals("6-", b5.getResult());

    Calculator c5 = b5.input('=');
    assertEquals("0", c5.getResult());

    Calculator d5 = c5.input('=');
    assertEquals("-6", d5.getResult());

    Calculator e5 = d5.input('=');
    assertEquals("-12", e5.getResult());

    Calculator f5 = e5.input('-');
    assertEquals("-12-", f5.getResult());

    Calculator g5 = f5.input('*');
    assertEquals("-12*", g5.getResult());

    Calculator h5 = g5.input('4');
    assertEquals("-12*4", h5.getResult());

    Calculator i5 = h5.input('-');
    assertEquals("-48-", i5.getResult());

    Calculator j5 = i5.input('+');
    assertEquals("-48+", j5.getResult());

    Calculator k5 = j5.input('2');
    assertEquals("-48+2", k5.getResult());

    Calculator l5 = k5.input('=');
    assertEquals("-46", l5.getResult());


    Calculator a6 = calculator6.input('4');
    assertEquals("4", a6.getResult());

    Calculator b6 = a6.input('9');
    assertEquals("49", b6.getResult());

    Calculator c6 = b6.input('4');
    assertEquals("494", c6.getResult());

    Calculator d6 = c6.input('+');
    assertEquals("494+", d6.getResult());

    Calculator e6 = d6.input('-');
    assertEquals("494-", e6.getResult());

    Calculator f6 = e6.input('4');
    assertEquals("494-4", f6.getResult());

    Calculator g6 = f6.input('=');
    assertEquals("490", g6.getResult());

  }

  @Test
  public void testMultiplication() {
    this.setUp();

    Calculator a5 = calculator5.input('6');
    assertEquals("6", a5.getResult());

    Calculator b5 = a5.input('*');
    assertEquals("6*", b5.getResult());

    Calculator c5 = b5.input('=');
    assertEquals("36", c5.getResult());

    Calculator d5 = c5.input('=');
    assertEquals("216", d5.getResult());

    Calculator e5 = d5.input('=');
    assertEquals("1296", e5.getResult());


    Calculator a6 = calculator6.input('9');
    assertEquals("9", a6.getResult());

    Calculator b6 = a6.input('4');
    assertEquals("94", b6.getResult());

    Calculator c6 = b6.input('*');
    assertEquals("94*", c6.getResult());

    Calculator d6 = c6.input('-');
    assertEquals("94-", d6.getResult());

    Calculator e6 = d6.input('*');
    assertEquals("94*", e6.getResult());

    Calculator f6 = e6.input('2');
    assertEquals("94*2", f6.getResult());

    Calculator g6 = f6.input('=');
    assertEquals("188", g6.getResult());

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

    Calculator g1 = f1.input('-');
    assertEquals("20-", g1.getResult());

    Calculator h1 = g1.input('*');
    assertEquals("20*", h1.getResult());
  }
}