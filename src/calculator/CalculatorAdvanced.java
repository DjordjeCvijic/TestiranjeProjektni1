package calculator;

import exception.NotSupportedOperationException;
import exception.NumberNotInAreaException;
/**
* <h1>CalculatorAdvanced</h1>
* The class CalculatorAdvanced extends class Calculator and also provides additional special methods.
* 
* @author  Djordje Cvijic
* @version 1.0
* @since   2020-12-26
*/
public class CalculatorAdvanced extends Calculator {
	/**
	 * Default constructor.
	 */
	public CalculatorAdvanced() {
		super();
	}
	/**
	 * Method that performs a grading operation or factorial calculation based on the passed parameter.
	 * @param action Defines the operation to be performed. 
	 * In the case of a number between 0 and 9 the currentValue is graded and in the case of ! the factorial is calculated.
	 * @throws NumberNotInAreaException In the case when the currentValue,during the factorial calculation, is not in the interval  [0.0,10.0]
	 * @throws NotSupportedOperationException In case the required mathematical operation is not supported.
	 */
	public void calculateAdvanced(char action) throws NumberNotInAreaException, NotSupportedOperationException {
		int actionLikeInt=(int)action-'0';
		int currentValueLikeInt=currentValue.intValue();
		if(actionLikeInt>=0 && actionLikeInt <=9) {
			if(actionLikeInt==0) currentValue=1.0;
			else {
				int tmp=currentValueLikeInt;
				for(int i=1;i<actionLikeInt;i++)
					currentValueLikeInt*=tmp;
				currentValue=(double) currentValueLikeInt;
			}
		}
		else if(action=='!'){
			if(currentValue>=0.0 && currentValue<=10.0) {
				int factorial=1;
				for(int i=1;i<=currentValueLikeInt;i++)
					factorial*=i;
				
				currentValue=(double) factorial;
			}else throw new NumberNotInAreaException("The current value is not within the allowable range");
			
		}else throw new NotSupportedOperationException("The forwarded operation is invalid");
	}

	/**
	 * Method that checks whether the currentValue is an Armstrong number or a perfect number.
	 * @param value Defines which verification should be performed.
	 * @return Method returns true if the number currentValue meets the required conditions
	 * @throws NotSupportedOperationException In case the required verification is not supported.
	 * @throws NumberNotInAreaException In the case when the currentValue is not in the interval  
	 */
	public Boolean hasCharacteristic(char value) throws NotSupportedOperationException, NumberNotInAreaException {
		if(currentValue.intValue()<1.0)
			throw new NumberNotInAreaException("The current value is not within the allowable range");
		switch (value) {
		case 'A':
			return isArmstrongNumber(currentValue.intValue());
		case 'P':
			return isPerfectNumber(currentValue.intValue());
		default:
			throw new NotSupportedOperationException("The forwarded operation is invalid");
		}
	}
	
	/**
	 * Auxiliary private method that checks if number currentValue is a perfect number.
	 * @param intValue Define which number would be check.
	 * @return Method returns true if the number currentValue is a perfect number.
	 */
	private Boolean isPerfectNumber(int intValue) {
		int rem, sum = 0, i;
		 for (i = 1; i < intValue ; i++)
		    {
		        rem = intValue % i;
			if (rem == 0)
		        {
		            sum = sum + i;
		        }
		    }
		 if (sum == intValue)
		        return true;
		   return false;
	}

	/**
	 * Auxiliary private method that checks if number currentValue is an Armstrong number.
	 * @param intValue Define which number would be check.
	 * @return Method returns true if the number currentValue is an Armstrong number.
	 */
	private Boolean isArmstrongNumber(int intValue) {
		   int check, rem, sum = 0;
		   if(intValue<10) return true;

		   check = intValue;

		   while(check != 0) {
		      rem = check % 10;
		      sum = sum + (rem * rem * rem);
		      check = check / 10;
		   }
		   if(sum == intValue) 
			      return true;
			
		   return false;
	}

}
