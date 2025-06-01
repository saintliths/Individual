package calculator;

/**
 * This interface represents a single calculator.
 */
public interface Calculator {

  /**
   * Processes the given input and returns a Calculator.
   *
   * @param c the given character input
   * @return a Calculator object as a result of processing the input
   */
  Calculator input(char c);

  /**
   * Get the result of this Calculator before or after an input.
   *
   * @return the current result of the Calculator as a String
   */
  String getResult();
}
