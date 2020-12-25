package calculator;

import exception.DivisionByZeroException;
import exception.NotSupportedOperationException;

public class Calculator {
	protected Double currentValue=0.0;
	
	public Calculator(){}

	public Double getCurrentValue() {
		return currentValue;
	}

	public void setCurrentValue(Double currentValue) {
		this.currentValue = currentValue;
	}
	
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
				throw new DivisionByZeroException("Dijeljenje sa nulom nije dozvoljeno");
			currentValue/=value;
			break;
		
		default:
			throw new NotSupportedOperationException("Proslijedjena operacija nije validna");
		}
	}
	

}
