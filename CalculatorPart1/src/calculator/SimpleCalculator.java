package calculator;

import java.util.Scanner;

/**
 * This class represents a simple calculator that can do three operations:
 * addition, subtraction, and multiplication.
 */
public class SimpleCalculator extends AbstractCalculator {

  /**
   * A public constructor that takes in no arguments and constructs a SimpleCalculator object.
   */
  public SimpleCalculator() {
    super();
  }

  /**
   * A private constructor with arguments that constructs a SimpleCalculator object.
   *
   * @param operand1 the first operand
   * @param operand2 the second operand
   * @param result   the resulting String
   * @param answer   the final answer
   * @param operator the operator
   */
  private SimpleCalculator(String operand1, String operand2, String result,
                           int answer, String operator) {
    super(operand1, operand2, result, answer, operator);
  }

  /**
   * A getter that returns this SimpleCalculator object.
   *
   * @param operand1 the first operand
   * @param operand2 the second operand
   * @param result   the resulting String
   * @param answer   the final answer
   * @param operator the operator
   * @return a SimpleCalculator object with these fields.
   */
  protected Calculator getCalculator(String operand1, String operand2, String result,
                                     int answer, String operator) {
    return new SimpleCalculator(operand1, operand2, result, answer, operator);
  }

  /**
   * Helper method that builds the expression.
   *
   * @param newNum   the number that is operand 2
   * @param rs       the current resulting string
   * @param answer   the current answer
   * @param operator the current operator
   * @param c        the inputted char
   * @return a new SimpleCalculator object after building the expression
   */
  private Calculator buildExpression(String newNum, String rs,
                                     int answer, String operator, char c) {
    rs += c;
    String currentNum = newNum;
    newNum = "";
    return new SimpleCalculator(currentNum, newNum, rs, answer, operator);
  }

  /**
   * Helper method that calculates the answer after '=' input.
   *
   * @param currentNum the number that is operand 1
   * @param newNum     the number that is operand 2
   * @param answer     the current answer
   * @param operator   the current operator
   * @return a SimpleCalculator object with the calculated answer
   */
  private Calculator calculateHelper(String currentNum, String newNum,
                                     int answer, String operator) {
    if (!currentNum.isEmpty() && !newNum.isEmpty()) {
      switch (operator) {
        case "+":
          if (Integer.parseInt(currentNum) > Integer.MAX_VALUE - Integer.parseInt(newNum)) {
            answer = 0;
          } else {
            answer = Integer.parseInt(currentNum) + Integer.parseInt(newNum);
          }
          break;
        case "-":
          if (Integer.parseInt(currentNum) < Integer.MIN_VALUE + Integer.parseInt(newNum)) {
            answer = 0;
          } else {
            answer = Integer.parseInt(currentNum) - Integer.parseInt(newNum);
          }
          break;
        case "*":
          if (Integer.parseInt(currentNum) > Integer.MAX_VALUE / Integer.parseInt(newNum)) {
            answer = 0;
          } else {
            answer = Integer.parseInt(currentNum) * Integer.parseInt(newNum);
          }
          break;
        default:
          throw new IllegalArgumentException();
      }
    }
    String rs = Integer.toString(answer);
    newNum = "0";
    operator = "";
    return new SimpleCalculator(currentNum, newNum, rs, answer, operator);
  }


  @Override
  public Calculator input(char c) {
    int num;
    String rs = this.result;
    String currentNum = this.operand1;
    String newNum = this.operand2;
    int answer = this.answer;
    String operator = this.operator;

    if ((c == '+' || c == '-' || c == '*' || c == '=') && rs.isEmpty()) {
      throw new IllegalArgumentException();
    }

    Scanner scan = new Scanner(String.valueOf(c));

    if (scan.hasNextInt()) {
      num = scan.nextInt();
      return processInputHelper(num, currentNum, newNum, rs, answer, operator);
    }

    // if there is already an expression before this new operator
    boolean conditional = !operator.isEmpty() && !currentNum.isEmpty();

    switch (c) {
      case '+':
        if (conditional) {
          return inTimeHelper(currentNum, newNum, operator, c);
        }
        return buildExpression(newNum, rs, answer, "+", c);
      case '-':
        if (conditional) {
          return inTimeHelper(currentNum, newNum, operator, c);
        }
        return buildExpression(newNum, rs, answer, "-", c);
      case '*':
        if (conditional) {
          return inTimeHelper(currentNum, newNum, operator, c);
        }
        return buildExpression(newNum, rs, answer, "*", c);
      case '=':
        if (operator.isEmpty()) {
          answer = Integer.parseInt(newNum);
        } else {
          return calculateHelper(currentNum, newNum, answer, operator);
        }
        return new SimpleCalculator(currentNum, newNum, rs, answer, operator);
      case 'C':
        return new SimpleCalculator();
      default:
        throw new IllegalArgumentException();
    }
  }

  @Override
  public String getResult() {
    return this.result;
  }
}
