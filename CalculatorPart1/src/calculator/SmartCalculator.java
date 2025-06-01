package calculator;

import java.util.Scanner;

/**
 * This class represents a smart calculator that can do everything a simple calculator
 * can with additional properties.
 */
public class SmartCalculator extends AbstractCalculator {

  /**
   * A public constructor that takes in no arguments and constructs a SmartCalculator object.
   */
  public SmartCalculator() {
    super();
  }

  /**
   * A private constructor with arguments that constructs a SmartCalculator object.
   *
   * @param operand1 the first operand
   * @param operand2 the second operand
   * @param result   the resulting String
   * @param answer   the final answer
   * @param operator the operator
   */
  private SmartCalculator(String operand1, String operand2, String result,
                          int answer, String operator) {
    super(operand1, operand2, result, answer, operator);
  }


  /**
   * A getter that returns this SmartCalculator object.
   *
   * @param operand1 the first operand
   * @param operand2 the second operand
   * @param result   the resulting String
   * @param answer   the final answer
   * @param operator the operator
   * @return a SmartCalculator object with these fields.
   */
  protected Calculator getCalculator(String operand1, String operand2, String result,
                                     int answer, String operator) {
    return new SmartCalculator(operand1, operand2, result, answer, operator);
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
  private Calculator buildExpression(String currentNum, String newNum, String rs,
                                     int answer, String operator, char c) {
    if (!rs.isEmpty() && (rs.endsWith("+") || rs.endsWith("-") || rs.endsWith("*"))) {
      rs = rs.substring(0, rs.length() - 1) + c;
    } else {
      rs += c;
      currentNum = newNum;
      newNum = "";
    }
    return new SmartCalculator(currentNum, newNum, rs, answer, operator);
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
                                     int answer, String rs, String operator) {
    if (!currentNum.isEmpty()) {
      switch (operator) {
        case "+":
          if (Integer.parseInt(currentNum) > Integer.MAX_VALUE - Integer.parseInt(newNum)) {
            answer = 0;
          } else {
            if (!newNum.isEmpty() && answer == 0 && !rs.equals("0")) {
              answer = Integer.parseInt(currentNum) + Integer.parseInt(newNum);
            } else {
              answer += Integer.parseInt(newNum);
            }
          }
          break;
        case "-":
          if (Integer.parseInt(currentNum) < Integer.MIN_VALUE + Integer.parseInt(newNum)) {
            answer = 0;
          } else {
            if (!newNum.isEmpty() && answer == 0 && !rs.equals("0")) {
              answer = Integer.parseInt(currentNum) - Integer.parseInt(newNum);
            } else {
              answer -= Integer.parseInt(newNum);
            }
          }
          break;
        case "*":
          if (Integer.parseInt(currentNum) > Integer.MAX_VALUE / Integer.parseInt(newNum)) {
            answer = 0;
          } else {
            if (!newNum.isEmpty() && answer == 0 && !rs.equals("0")) {
              answer = Integer.parseInt(currentNum) * Integer.parseInt(newNum);
            } else {
              answer *= Integer.parseInt(newNum);
            }
          }
          break;
        default:
          throw new IllegalArgumentException();
      }
    }
    rs = Integer.toString(answer);
    return new SmartCalculator(currentNum, newNum, rs, answer, operator);
  }

  @Override
  public Calculator input(char c) {
    int num;
    String rs = this.result;
    String currentNum = this.operand1;
    String newNum = this.operand2;
    int answer = this.answer;
    String operator = this.operator;

    if ((c == '-' || c == '*' || c == '=') && rs.isEmpty()) {
      throw new IllegalArgumentException();
    }

    if (c == '+' && rs.isEmpty()) {
      return new SmartCalculator(currentNum, newNum, rs, answer, operator);
    }

    Scanner scan = new Scanner(String.valueOf(c));

    if (scan.hasNextInt()) {
      num = scan.nextInt();
      return processInputHelper(num, currentNum, newNum, rs, answer, operator);
    }

    // if there is already an expression before this new operator
    boolean conditional = !operator.isEmpty() && !currentNum.isEmpty() && answer == 0
            && !(rs.endsWith("+") || rs.endsWith("-") || rs.endsWith("*"));

    switch (c) {
      case '+':
        if (conditional) {
          return inTimeHelper(currentNum, newNum, operator, c);
        }
        return buildExpression(currentNum, newNum, rs, answer, "+", c);
      case '-':
        if (conditional) {
          return inTimeHelper(currentNum, newNum, operator, c);
        }
        return buildExpression(currentNum, newNum, rs, answer, "-", c);
      case '*':
        if (conditional) {
          return inTimeHelper(currentNum, newNum, operator, c);
        }
        return buildExpression(currentNum, newNum, rs, answer, "*", c);
      case '=':
        if (operator.isEmpty()) {
          answer = Integer.parseInt(newNum);
          rs = Integer.toString(answer);
          return new SmartCalculator(currentNum, newNum, rs, answer, operator);
        } else if (newNum.isEmpty()) {
          newNum = currentNum;
          return calculateHelper(currentNum, newNum, answer, rs, operator);
        } else {
          return calculateHelper(currentNum, newNum, answer, rs, operator);
        }
      case 'C':
        return new SmartCalculator();
      default:
        throw new IllegalArgumentException();
    }
  }

  @Override
  public String getResult() {
    return this.result;
  }
}
