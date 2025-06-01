package calculator;

import java.util.Scanner;

/**
 * This class represents a smart calculator that can do everything a simple calculator
 * can with additional properties.
 */
public class SmartCalculator implements Calculator {
  private final String result;
  private final String operand1;
  private final String operand2;
  private final String operator;
  private final int answer;

  /**
   * A public constructor that takes in no arguments and constructs a SmartCalculator object.
   */
  public SmartCalculator() {
    this.operand1 = "";
    this.operand2 = "";
    this.result = "";
    this.answer = 0;
    this.operator = "";
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
    this.operand1 = operand1;
    this.operand2 = operand2;
    this.result = result;
    this.answer = answer;
    this.operator = operator;
  }

  /**
   * Helper method that does in-time calculations after another operator input.
   *
   * @param currentNum the number that is operand 1
   * @param newNum     the number that is operand 2
   * @param answer     the current answer
   * @param operator   the current operator
   * @param c          the new operator char that was inputted
   * @return a new SimpleCalculator with the in-time calculations and new operator input
   */
  private Calculator inTimeHelper(String currentNum, String newNum,
                                  int answer, String operator, char c) {
    if (!currentNum.isEmpty() && !newNum.isEmpty()) {
      int currInt = Integer.parseInt(currentNum);
      int newInt = Integer.parseInt(newNum);


      switch (operator) {
        case "+":
          if (currInt > Integer.MAX_VALUE - newInt) {
            currentNum = "0";
          } else {
            currentNum = Integer.toString(currInt + newInt);
          }
          break;
        case "-":
          if (currInt < Integer.MIN_VALUE + newInt) {
            currentNum = "0";
          } else {
            currentNum = Integer.toString(currInt - newInt);
          }
          break;
        case "*":
          if (currInt > Integer.MAX_VALUE / newInt) {
            currentNum = "0";
          } else {
            currentNum = Integer.toString(currInt * newInt);
          }
          break;
        default:
          throw new IllegalArgumentException();
      }

      String rs = currentNum + c;
      newNum = "";
      operator = Character.toString(c);
      answer = Integer.parseInt(currentNum);
      return new SmartCalculator(currentNum, newNum, rs, answer, operator);
    } else {
      throw new IllegalArgumentException();
    }
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
    if (!rs.isEmpty() && (rs.endsWith("+") || rs.endsWith("-") || rs.endsWith("*"))) {
      rs = rs.substring(0, rs.length() - 1) + c;
    } else {
      rs += c;
    }

    String currentNum = newNum;
    newNum = "";
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
      if (!newNum.isEmpty() && answer == 0 && !rs.equals("0")) {
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
      } else {
        switch (operator) {
          case "+":
            if (Integer.parseInt(currentNum) > Integer.MAX_VALUE - Integer.parseInt(newNum)) {
              answer = 0;
            } else {
              answer += Integer.parseInt(newNum);
            }
            break;
          case "-":
            if (Integer.parseInt(currentNum) < Integer.MIN_VALUE + Integer.parseInt(newNum)) {
              answer = 0;
            } else {
              answer -= Integer.parseInt(newNum);
            }
            break;
          case "*":
            if (Integer.parseInt(currentNum) > Integer.MAX_VALUE / Integer.parseInt(newNum)) {
              answer = 0;
            } else {
              answer *= Integer.parseInt(newNum);
              ;
            }
            break;
          default:
            throw new IllegalArgumentException();
        }
      }
    }
    rs = Integer.toString(answer);
//    currentNum = newNum;
//    newNum = "0";
//    operator = "";
    return new SmartCalculator(currentNum, newNum, rs, answer, operator);
  }

  /**
   * Determines how to process the given number input based on some conditionals.
   *
   * @param num        the inputted number
   * @param currentNum the number that is operand 1
   * @param newNum     the number that is operand 2
   * @param rs         the current resulting string
   * @param answer     the current answer
   * @param operator   the current operator
   * @return a SimpleCalculator object after processing the number input
   */
  private Calculator processInputHelper(int num, String currentNum, String newNum,
                                        String rs, int answer, String operator) {
    if (num < 0 || num > 9) {
      throw new IllegalArgumentException();
    }

    // if there is an answer and operator,
    // that means it has already gone through calculation once
    if (newNum.isEmpty() && answer != 0 && !operator.isEmpty()) {
      rs += num;
      currentNum = Integer.toString(answer);
      newNum = Integer.toString(num);
      answer = 0;
    }
    // if operator is empty, it means they hit the = button and now a num, so it resets
    else if (answer != 0) {
      rs = Integer.toString(num);
      currentNum = "";
      newNum = Integer.toString(num);
      answer = 0;
    }
    // else, if there is no answer, build expression
    else {
      if ((newNum + num).length() > 10) {
        throw new IllegalArgumentException();
      }
      // gets rid of leading zeroes
      else if (newNum.equals("0")) {
        if (num != 0) {
          newNum = Integer.toString(num);
          rs = currentNum + operator + newNum;
        }
      } else {
        rs += num;
        newNum += num;
        answer = 0;
      }
    }
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

    Scanner scan = new Scanner(String.valueOf(c));

    if (scan.hasNextInt()) {
      num = scan.nextInt();
      return processInputHelper(num, currentNum, newNum, rs, answer, operator);
    }

    // if there is already an expression before this new operator
    boolean conditional = !operator.isEmpty() && !currentNum.isEmpty() && answer == 0;

    switch (c) {
      case '+':
        if (conditional) {
          return inTimeHelper(currentNum, newNum, answer, operator, c);
        }
        return buildExpression(newNum, rs, answer, "+", c);
      case '-':
        if (conditional) {
          return inTimeHelper(currentNum, newNum, answer, operator, c);
        }
        return buildExpression(newNum, rs, answer, "-", c);
      case '*':
        if (conditional) {
          return inTimeHelper(currentNum, newNum, answer, operator, c);
        }
        return buildExpression(newNum, rs, answer, "*", c);
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
