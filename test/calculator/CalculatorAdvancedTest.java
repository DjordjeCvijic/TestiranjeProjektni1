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


import exception.NotSupportedOperationException;
import exception.NumberNotInAreaException;

import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class CalculatorAdvancedTest {
	
	private CalculatorAdvanced calculatorAdvanced;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		calculatorAdvanced=new CalculatorAdvanced();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@ParameterizedTest
	@DisplayName("Testing of method calculateAdvanced")
	@MethodSource("methodWithParameters1")
	void calculateAdvancedTest(Double carentValue,char action,Double result) throws NumberNotInAreaException, NotSupportedOperationException {
		calculatorAdvanced.setCurrentValue(carentValue);
		calculatorAdvanced.calculateAdvanced(action);
		assertThat(calculatorAdvanced.getCurrentValue(), is(result));
		
	}
	
	private static Stream<Arguments> methodWithParameters1() {
	    return Stream.of(
	      Arguments.of(2.0,'0',1.0),
	      Arguments.of(3.0,'9',19683.0),
	      Arguments.of(0.0,'8',0.0),
	      Arguments.of(0.0,'0',1.0),
	      Arguments.of(-5.0,'4',625.0),
	      Arguments.of(-3.0,'3',-27.0),
	      
	      Arguments.of(5.0,'!',120.0),
	      Arguments.of(0.0,'!',1.0),
	      Arguments.of(10.0,'!',3628800.0)
	    );
	}
	@Test
	@DisplayName("Testing irregular input parameters of method calculateAdvanced")
	void calculateAdvancedException() {
		calculatorAdvanced.setCurrentValue(3.0);
		Exception exception1 = assertThrows(
				NotSupportedOperationException.class, 
	            () -> calculatorAdvanced.calculateAdvanced((char)('0'-1)));
        assertThat(exception1, is(instanceOf(NotSupportedOperationException.class)));
        
        calculatorAdvanced.setCurrentValue(3.0);
		Exception exception2 = assertThrows(
				NotSupportedOperationException.class, 
	            () -> calculatorAdvanced.calculateAdvanced((char)('9'+1)));
        assertThat(exception2, is(instanceOf(NotSupportedOperationException.class)));
        
        calculatorAdvanced.setCurrentValue(-0.1);
		Exception exception3 = assertThrows(
				NumberNotInAreaException.class, 
	            () -> calculatorAdvanced.calculateAdvanced('!'));
        assertThat(exception3, is(instanceOf(NumberNotInAreaException.class)));
        
        calculatorAdvanced.setCurrentValue(10.1);
		Exception exception4 = assertThrows(
				NumberNotInAreaException.class, 
	            () -> calculatorAdvanced.calculateAdvanced('!'));
        assertThat(exception4, is(instanceOf(NumberNotInAreaException.class)));
      
	}
	
	@ParameterizedTest
	@DisplayName("Testing of method hasCharacteristic")
	@MethodSource("methodWithParameters2")
	void hasCharacteristicTest(Double carentValue,char value,boolean result) throws NotSupportedOperationException, NumberNotInAreaException {
		calculatorAdvanced.setCurrentValue(carentValue);
		assertThat(calculatorAdvanced.hasCharacteristic(value),is(result));
		
	}
	private static Stream<Arguments> methodWithParameters2() {
	    return Stream.of(
	      Arguments.of(153.0,'A',true),
	      Arguments.of(10.0,'A',false),
	      Arguments.of(1.0,'A',true),
	      Arguments.of(28.0,'P',true),
	      Arguments.of(496.0,'P',true),
	      Arguments.of(3.0,'P',false),
	      Arguments.of(9.0,'P',false)

	    );
	}

	@Test
	@DisplayName("Testing irregular input parameters of method hasCharacteristic")
	void hasCharacteristicException() {
		calculatorAdvanced.setCurrentValue(0.9);
		Exception exception1 = assertThrows(
				NumberNotInAreaException.class, 
	            () -> calculatorAdvanced.hasCharacteristic('A'));
        assertThat(exception1, is(instanceOf(NumberNotInAreaException.class)));
        
        calculatorAdvanced.setCurrentValue(9.9);
		Exception exception2 = assertThrows(
				NotSupportedOperationException.class, 
	            () -> calculatorAdvanced.hasCharacteristic('a'));
        assertThat(exception2, is(instanceOf(NotSupportedOperationException.class)));
        
      
	}
}
