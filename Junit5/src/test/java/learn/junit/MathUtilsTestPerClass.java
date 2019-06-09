package learn.junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MathUtilsTestPerClass {
	
	/*
	 * Junit create a new instance for each test case but by using @TestInstance we can change the behavior of class     
	 * and this time we do not need static method for BeforeAll and AfterAll
	 */
	
	
	MathUtils mathUtils;
	@BeforeAll
	void beforeAll() {
		System.out.println("this needs to run before all");
	}
	@AfterAll
	void afterAll() {
		System.out.println("This needs to run after all");
	}
	
	//Initialize before each method
	@BeforeEach
	void init() {
	this.mathUtils = new MathUtils();	
	}
	
	// Tear down after each method
	@AfterEach
	void cleanUp() {
		// perform the clean up operation
	}

	@Test
	void test() {
		// Create the instance of class
		//Setup inputs 
		// execute the code you want to test 
		// comapre the result
		
//		MathUtils obj = new MathUtils();
		int expected =6;
		int actual=this.mathUtils.add(3, 3);
		assertEquals(expected, actual);
//		When it fails, it will generate This method should return sum message
//		assertEquals(expected, actual, "This method should return sum  ");
		
		System.out.println("TEST RUNNER updated");
		System.out.println("TEST RUNNER updated");
	}
	
	@Test
	void testDivide() {
//		MathUtils mathUtils = new MathUtils();
		int expected ;
//		Here we are using lamda expression but it wasn't present in junit4
		assertThrows(ArithmeticException.class, ()-> mathUtils.divide(1, 0), "Divide by zero should throw exception");
		
//		Negative
//		assertThrows(ArithmeticException.class, ()-> mathUtils.divide(1, 9), "Divide by zero should throw exception");
		
	}
	@Test
	void testComputeCircleArea() {
//		MathUtils obj = new MathUtils();
		double expected = 153.93804002589985;
		double actual = mathUtils.computeCircleArea(7);
		assertEquals(expected, actual,"This method should return area of circle");
	}
	
	
	

}
