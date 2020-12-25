package calculator;

import exception.NotSupportedOperationException;
import exception.NumberNotInAreaException;

public class CalculatorAdvanced extends Calculator {
	
	public CalculatorAdvanced() {
		super();
	}
	
	public void calculateAdvanced(char action) throws NumberNotInAreaException, NotSupportedOperationException {
		int actionLikeInt=action;
		int currentValueLikeInt=currentValue.intValue();
		if(actionLikeInt>=0 && actionLikeInt <=9) {
			if(actionLikeInt==0) currentValue=1.0;
			else {
				int tmp=currentValueLikeInt;
				for(int i=0;i<actionLikeInt;i++)
					currentValueLikeInt+=tmp;
				currentValue=(double) currentValueLikeInt;
			}
		}
		else if(action=='!'){
			if(currentValue<=0 && currentValue<=10) {
				int factorial=1;
				for(int i=1;i<=currentValueLikeInt;i++)
					factorial*=i;
				
				currentValue=(double) factorial;
			}else throw new NumberNotInAreaException("Trenutna vrijednost nije u dozvoljenom opsegu");
			
		}else throw new NotSupportedOperationException("Prosljedjena operacija nije validna");
	}

	
	public Boolean hasCharacteristic(char value) throws NotSupportedOperationException, NumberNotInAreaException {
		if(currentValue.intValue()<1)
			throw new NumberNotInAreaException("Trenutna vrijednost nije u dozvoljenom opsegu");
		switch (value) {
		case 'A':
			return isArmstrongNumber(currentValue.intValue());
		case 'P':
			return isPerfectNumber(currentValue.intValue());
		default:
			throw new NotSupportedOperationException("Prosljedjena operacija nije validn");
		}
	}

	private Boolean isPerfectNumber(int intValue) {
		int rem, sum = 0, i;
		 for (i = 1; i <= (intValue - 1); i++)
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

	private Boolean isArmstrongNumber(int intValue) {
		   int check, rem, sum = 0;

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
