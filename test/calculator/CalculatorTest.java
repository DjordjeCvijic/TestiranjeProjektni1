package calculator;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import exception.DivisionByZeroException;
import exception.NotSupportedOperationException;

import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class CalculatorTest {
	Calculator calculator;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		calculator=new Calculator();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testCalculator() {
		assertThat(calculator.getCurrentValue(),is(0.0));
	}

	@Test
	void testGetCurrentValue() {
		calculator.setCurrentValue(11.0);
		assertThat(calculator.getCurrentValue(), is(11.0));
	}

	@Test
	void testSetCurrentValue() {
		calculator.setCurrentValue(21.0);
		assertThat(calculator.getCurrentValue(), is(21.0));
	}

	@ParameterizedTest
	@DisplayName("Testing of method calculate")
	@MethodSource("methodWithParameters")
	void testCalculateParametrized(Double currentV,Double value,char operator,Double result) throws NotSupportedOperationException, DivisionByZeroException {
		calculator.setCurrentValue(currentV);
		calculator.calculate(value, operator);
		assertThat(calculator.getCurrentValue(), is(result));
		
	}
	
	private static Stream<Arguments> methodWithParameters() {
	    return Stream.of(
	      Arguments.of(6.0,7.0,'+',13.0),
	      Arguments.of(2.0,-9.0,'+',-7.0),
	      Arguments.of(-5.0,9.0,'+',4.0),
	      Arguments.of(-16.0,-27.0,'+',-43.0),
	
	      Arguments.of(16.0,7.0,'-',9.0),
	      Arguments.of(6.0,-17.0,'-',23.0),
	      Arguments.of(-1.0,29.0,'-',-30.0),
	      Arguments.of(-13.0,-23.0,'-',10.0),
	      
	      Arguments.of(2.0,7.0,'*',14.0),
	      Arguments.of(-3.0,3.0,'*',-9.0),
	      Arguments.of(4.0,-8.0,'*',-32.0),
	      Arguments.of(-5.0,-7.0,'*',35.0),
	      Arguments.of(0.0,7.0,'*',0.0),
	      Arguments.of(2.0,1.0,'*',2.0),
	      
	      Arguments.of(7.0,2.0,'/',3.5),
	      Arguments.of(-14.0,7.0,'/',-2.0),
	      Arguments.of(22.0,-2.0,'/',-11.),
	      Arguments.of(-27.0,-3.0,'/',9.0),
	      Arguments.of(0.0,2.0,'/',0.0)
	    );
	}
	
	@Test
	@DisplayName("Testing irregular input parameters of method calculate")
	void testCalculateException() {
		calculator.setCurrentValue(1.0);
		
		Exception exception1 = assertThrows(
        		DivisionByZeroException.class, 
	            () -> calculator.calculate(0.0, '/'));
        assertThat(exception1, is(instanceOf(DivisionByZeroException.class)));
        
        Exception exception2 = assertThrows(
        		NotSupportedOperationException.class, 
	            () -> calculator.calculate(3.0, '#'));
        assertThat(exception2, is(instanceOf(NotSupportedOperationException.class)));
	}
	

}
