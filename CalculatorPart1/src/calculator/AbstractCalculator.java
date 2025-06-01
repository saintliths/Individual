package calculator;

/**
 * This class represents an abstract class for the SimpleCalculator and SmartCalculator classes.
 */
public abstract class AbstractCalculator implements Calculator {
  protected final String result;
  protected final String operand1;
  protected final String operand2;
  protected final String operator;
  protected final int answer;

  /**
   * A public constructor that takes in no arguments and constructs an AbstractCalculator object.
   * This is used for both SimpleCalculator and SmartCalculator.
   */
  public AbstractCalculator() {
    this.operand1 = "";
    this.operand2 = "";
    this.result = "";
    this.answer = 0;
    this.operator = "";
  }

  /**
   * A protected constructor with arguments that constructs an AbstractCalculator object. This
   * is used for both SimpleCalculator and SmartCalculator.
   *
   * @param operand1 the first operand
   * @param operand2 the second operand
   * @param result   the resulting String
   * @param answer   the final answer
   * @param operator the operator
   */
  protected AbstractCalculator(String operand1, String operand2, String result,
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
   * @param operator   the current operator
   * @param c          the new operator char that was inputted
   * @return either a new SimpleCalculator or a new SmartCalculator depending on where it is called
   */
  protected Calculator inTimeHelper(String currentNum, String newNum,
                                    String operator, char c) {
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
      int answer = Integer.parseInt(currentNum);
      return getCalculator(currentNum, newNum, rs, answer, operator);
    } else {
      throw new IllegalArgumentException();
    }
  }

  protected abstract Calculator getCalculator(String operand1, String operand2, String result,
                                              int answer, String operator);

  /**
   * Determines how to process the given number input based on some conditionals.
   *
   * @param num        the inputted number
   * @param currentNum the number that is operand 1
   * @param newNum     the number that is operand 2
   * @param rs         the current resulting string
   * @param answer     the current answer
   * @param operator   the current operator
   * @return either a new SimpleCalculator or a new SmartCalculator depending on where it is called
   */
  protected Calculator processInputHelper(int num, String currentNum, String newNum,
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
      }
    }
    return getCalculator(currentNum, newNum, rs, answer, operator);
  }

}
