import org.junit.Before;
import org.junit.Test;

import calculator.Calculator;
import calculator.SmartCalculator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * This class represents some tests for the SmartCalculator implementation.
 */
public class SmartCalculatorTest {
  Calculator calculator1;
  Calculator calculator2;
  Calculator calculator3;
  Calculator calculator4;
  Calculator calculator5;
  Calculator calculator6;
  Calculator calculator7;

  @Before
  public void setUp() {
    calculator1 = new SmartCalculator();
    calculator2 = new SmartCalculator();
    calculator3 = new SmartCalculator();
    calculator4 = new SmartCalculator();
    calculator5 = new SmartCalculator();
    calculator6 = new SmartCalculator();
    calculator7 = new SmartCalculator();
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
      calculator1.input('/');
      fail("IllegalArgumentException expected");

      a2.input('c');
      fail("IllegalArgumentException expected");

      calculator4.input('-');
      fail("IllegalArgumentException expected");

      a3.input(']');
      fail("IllegalArgumentException expected");

      a3.input(')');
      fail("IllegalArgumentException expected");

      a3.input('/');
      fail("IllegalArgumentException expected");

      b3.input('?');
      fail("IllegalArgumentException expected");

      calculator1.input('a');
      fail("IllegalArgumentException expected");

    } catch (IllegalArgumentException e) {
      // passes
    }
  }


  @Test
  public void testAddition() {
    this.setUp();

    Calculator a1 = calculator1.input('1');
    assertEquals("1", a1.getResult());

    Calculator b1 = a1.input('+');
    assertEquals("1+", b1.getResult());

    Calculator c1 = b1.input('1');
    assertEquals("1+1", c1.getResult());

    Calculator d1 = c1.input('=');
    assertEquals("2", d1.getResult());

    Calculator e1 = d1.input('4');
    assertEquals("4", e1.getResult());

    Calculator f1 = e1.input('5');
    assertEquals("45", f1.getResult());

    Calculator g1 = f1.input('+');
    assertEquals("45+", g1.getResult());

    Calculator h1 = g1.input('5');
    assertEquals("45+5", h1.getResult());

    Calculator i1 = h1.input('5');
    assertEquals("45+55", i1.getResult());

    Calculator j1 = i1.input('=');
    assertEquals("100", j1.getResult());


    Calculator a2 = calculator2.input('5');
    Calculator b2 = a2.input('0');
    assertEquals("50", b2.getResult());

    Calculator c2 = b2.input('+');
    assertEquals("50+", c2.getResult());

    Calculator d2 = c2.input('2');
    assertEquals("50+2", d2.getResult());

    Calculator e2 = d2.input('+');
    assertEquals("52+", e2.getResult());

    Calculator f2 = e2.input('8');
    assertEquals("52+8", f2.getResult());

    Calculator g2 = f2.input('=');
    assertEquals("60", g2.getResult());
    Calculator h2 = g2.input('=');
    assertEquals("68", h2.getResult());
    Calculator i2 = h2.input('=');
    assertEquals("76", i2.getResult());
    Calculator j2 = i2.input('=');
    assertEquals("84", j2.getResult());


    Calculator a3 = calculator3.input('0');
    assertEquals("0", a3.getResult());

    Calculator b3 = a3.input('+');
    assertEquals("0+", b3.getResult());

    Calculator c3 = b3.input('1');
    assertEquals("0+1", c3.getResult());

    Calculator d3 = c3.input('=');
    assertEquals("1", d3.getResult());

    Calculator e3 = d3.input('+');
    assertEquals("1+", e3.getResult());

    Calculator f3 = e3.input('C');
    assertEquals("", f3.getResult());


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

  }

  @Test
  public void testSubtraction() {
    this.setUp();

    Calculator a1 = calculator1.input('9').input('3').input('4').input('5');
    assertEquals("9345", a1.getResult());

    Calculator b1 = a1.input('-');
    assertEquals("9345-", b1.getResult());

    Calculator c1 = b1.input('7');
    assertEquals("9345-7", c1.getResult());

    Calculator d1 = c1.input('-');
    assertEquals("9338-", d1.getResult());

    Calculator e1 = d1.input('5');
    assertEquals("9338-5", e1.getResult());

    Calculator f1 = e1.input('=');
    assertEquals("9333", f1.getResult());

    Calculator g1 = f1.input('-');
    assertEquals("9333-", g1.getResult());

    Calculator i1 = g1.input('3');
    assertEquals("9333-3", i1.getResult());

    Calculator j1 = i1.input('3');
    assertEquals("9333-33", j1.getResult());

    Calculator k1 = j1.input('=');
    assertEquals("9300", k1.getResult());


    Calculator a2 = calculator2.input('4');
    Calculator b2 = a2.input('2');
    assertEquals("42", b2.getResult());

    Calculator c2 = b2.input('-');
    assertEquals("42-", c2.getResult());

    Calculator d2 = c2.input('2');
    assertEquals("42-2", d2.getResult());

    Calculator e2 = d2.input('0');
    assertEquals("42-20", e2.getResult());

    Calculator f2 = e2.input('-');
    assertEquals("22-", f2.getResult());

    Calculator g2 = f2.input('C');
    assertEquals("", g2.getResult());


    Calculator a3 = calculator3.input('0');
    assertEquals("0", a3.getResult());

    Calculator b3 = a3.input('-');
    assertEquals("0-", b3.getResult());

    Calculator c3 = b3.input('1');
    assertEquals("0-1", c3.getResult());

    Calculator d3 = c3.input('=');
    assertEquals("-1", d3.getResult());

    Calculator e3 = d3.input('-');
    assertEquals("-1-", e3.getResult());

    Calculator f3 = e3.input('5').input('0').input('0');
    assertEquals("-1-500", f3.getResult());

    Calculator g3 = f3.input('=');
    assertEquals("-501", g3.getResult());


    Calculator a4 = calculator4.input('0');
    assertEquals("0", a4.getResult());

    Calculator b4 = a4.input('0');
    assertEquals("0", b4.getResult());

    Calculator c4 = b4.input('0');
    assertEquals("0", c4.getResult());

    Calculator d4 = c4.input('1');
    assertEquals("1", d4.getResult());

    Calculator e4 = d4.input('0');
    assertEquals("10", e4.getResult());

    Calculator f4 = e4.input('-').input('0');
    assertEquals("10-0", f4.getResult());

    Calculator g4 = f4.input('2');
    assertEquals("10-2", g4.getResult());


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

  }

  @Test
  public void testMultiplication() {
    this.setUp();

    Calculator a1 = calculator1.input('6');
    assertEquals("6", a1.getResult());

    Calculator b1 = a1.input('=');
    assertEquals("6", b1.getResult());

    Calculator c1 = b1.input('3');
    assertEquals("3", c1.getResult());

    Calculator d1 = c1.input('*');
    assertEquals("3*", d1.getResult());

    Calculator e1 = d1.input('9');
    assertEquals("3*9", e1.getResult());

    Calculator f1 = e1.input('4');
    assertEquals("3*94", f1.getResult());

    Calculator g1 = f1.input('*');
    assertEquals("282*", g1.getResult());

    Calculator h1 = g1.input('4').input('9');
    assertEquals("282*49", h1.getResult());


    Calculator a2 = calculator2.input('7');
    assertEquals("7", a2.getResult());

    Calculator b2 = a2.input('=');
    assertEquals("7", b2.getResult());

    Calculator c2 = b2.input('6');
    assertEquals("6", c2.getResult());

    Calculator d2 = c2.input('6');
    assertEquals("66", d2.getResult());

    Calculator e2 = d2.input('6');
    assertEquals("666", e2.getResult());

    Calculator f2 = e2.input('6');
    assertEquals("6666", f2.getResult());

    Calculator g2 = f2.input('*');
    assertEquals("6666*", g2.getResult());

    Calculator h2 = g2.input('3').input('2').input('2')
            .input('1').input('5').input('5');
    assertEquals("6666*322155", h2.getResult());

    Calculator i2 = h2.input('=');
    assertEquals("0", i2.getResult());


    Calculator a3 = calculator3.input('0');
    assertEquals("0", a3.getResult());

    Calculator b3 = a3.input('*');
    assertEquals("0*", b3.getResult());

    Calculator c3 = b3.input('1');
    assertEquals("0*1", c3.getResult());

    Calculator d3 = c3.input('=');
    assertEquals("0", d3.getResult());

    Calculator e3 = d3.input('*');
    assertEquals("0*", e3.getResult());

    Calculator f3 = e3.input('9');
    assertEquals("0*9", f3.getResult());

    Calculator g3 = f3.input('*');
    assertEquals("0*", g3.getResult());


    Calculator a4 = calculator4.input('3');
    assertEquals("3", a4.getResult());

    Calculator b4 = a4.input('0');
    assertEquals("30", b4.getResult());

    Calculator c4 = b4.input('+');
    assertEquals("30+", c4.getResult());

    Calculator d4 = c4.input('5');
    assertEquals("30+5", d4.getResult());

    Calculator e4 = d4.input('*');
    assertEquals("35*", e4.getResult());

    Calculator f4 = e4.input('8');
    assertEquals("35*8", f4.getResult());

    Calculator g4 = f4.input('=');
    assertEquals("280", g4.getResult());

  }

  @Test
  public void testOverflow() {
    this.setUp();

    Calculator a1 = calculator1.input('1');
    assertEquals("1", a1.getResult());

    Calculator b1 = a1.input('1');
    assertEquals("11", b1.getResult());

    Calculator c1 = b1.input('1');
    assertEquals("111", c1.getResult());

    Calculator d1 = c1.input('1');
    assertEquals("1111", d1.getResult());

    Calculator e1 = d1.input('1');
    assertEquals("11111", e1.getResult());

    Calculator f1 = e1.input('1');
    assertEquals("111111", f1.getResult());

    Calculator g1 = f1.input('1');
    assertEquals("1111111", g1.getResult());

    Calculator i1 = g1.input('1');
    assertEquals("11111111", i1.getResult());

    Calculator j1 = i1.input('1');
    assertEquals("111111111", j1.getResult());

    Calculator k1 = j1.input('1');
    assertEquals("1111111111", k1.getResult());

    try {
      k1.input('1');
      fail("IllegalArgumentException expected");
    } catch (IllegalArgumentException e) {
      // passes
    }

    assertEquals("1111111111", k1.getResult());


    Calculator a2 = calculator2.input('2').input('1').input('4').
            input('7').input('4').input('8').input('3').input('6').
            input('4').input('7');
    assertEquals("2147483647", a2.getResult());

    Calculator b2 = a2.input('+');
    assertEquals("2147483647+", b2.getResult());

    Calculator c2 = b2.input('1').input('0').input('0').input('0').input('0');
    assertEquals("2147483647+10000", c2.getResult());

    Calculator d2 = c2.input('=');
    assertEquals("0", d2.getResult());


    Calculator a3 = calculator3.input('0');
    assertEquals("0", a3.getResult());

    Calculator b3 = a3.input('-');
    assertEquals("0-", b3.getResult());

    Calculator c3 = b3.input('2').input('1').input('4').
            input('7').input('4').input('8').input('3').input('6').
            input('4').input('7');
    assertEquals("0-2147483647", c3.getResult());

    Calculator d3 = c3.input('=');
    assertEquals("-2147483647", d3.getResult());

    Calculator e3 = d3.input('-');
    assertEquals("-2147483647-", e3.getResult());

    Calculator f3 = e3.input('1').input('0').input('0').input('0').input('0');
    assertEquals("-2147483647-10000", f3.getResult());

    Calculator g3 = f3.input('=');
    assertEquals("0", g3.getResult());

    Calculator h3 = g3.input('-');
    assertEquals("0-", h3.getResult());

    Calculator i3 = h3.input('1');
    assertEquals("0-1", i3.getResult());

    Calculator j3 = i3.input('=');
    assertEquals("-1", j3.getResult());

  }
}