package calculator;

import exception.DivisionByZeroException;
import exception.NotSupportedOperationException;
/**
* <h1>Calculator</h1>
* The class Calculator provides a method for calculating basic mathematical operations.
* 
* @author  Djordje Cvijic
* @version 1.0
* @since   2020-12-26
*/
public class Calculator {
	/**
	 * Variable currentValue saves the result after each completed calculation operation.
	 * Default value is 0.
	 */
	protected Double currentValue=0.0;
	/**
	 * Default constructor.
	 */
	public Calculator(){}
	/**
	 * Method returns the current value of the variable currentValue.
	 * @return Double
	 */
	public Double getCurrentValue() {
		return currentValue;
	}
	
	/**
	 * Method sets the value of the variable currentValue.
	 * @param currentValue The value to be set.
	 */
	public void setCurrentValue(Double currentValue) {
		this.currentValue = currentValue;
	}
	/**
	 * Method that performs a basic mathematical operation that is passed as a method argument.
	 * @param value A value that represents the second parameter in an mathematical operation.
	 * @param operator A symbol of the mathematical operation to be performed [+,-,*,/].
	 * @throws NotSupportedOperationException In case the required mathematical operation is not supported.
	 * @throws DivisionByZeroException In the case of an attempt to division by zero.
	 */
	public void calculate(Double value, char operator) throws NotSupportedOperationException, DivisionByZeroException {
		
		switch (operator) {
		case '+':
			currentValue+=value;
			break;
		case '-':
			currentValue-=value;
			break;
		case '*':
			currentValue*=value;
			break;
		case '/':
			if(value==0)
				throw new DivisionByZeroException("Division by zero is not allowed");
			currentValue/=value;
			break;
		
		default:
			throw new NotSupportedOperationException("The forwarded operation is invalid");
		}
	}
	

}
