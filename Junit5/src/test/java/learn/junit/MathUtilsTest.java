package learn.junit;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIf;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.EnabledIfSystemProperty;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;

class MathUtilsTest {
	
	/*
	 * Junit create a new instance for each test case 
	 * 
	 */
	
	Boolean serverStatus;
	MathUtils mathUtils;
	@BeforeAll
	static void beforeAll() {
		System.out.println("this needs to run before all");
		
	}
	@AfterAll
	static void afterAll() {
		System.out.println("This needs to run after all");
	}
	
	//Initialize before each method
	@BeforeEach
	void init() {
	this.mathUtils = new MathUtils();
	serverStatus= false;
	}
	
	// Tear down after each method
	@AfterEach
	void cleanUp() {
		// perform the clean up operation
	}

	@Test
	// Display name annotation use to give name to method that would get display in Junit runner 
	@DisplayName("Testing add method")
	void testAdd() {
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
	@Disabled
	@DisplayName("TDD - this method should not run")
	void testAdd2() {
		// created this method just to show the use of @Disabled annotation
		// very use full method while development phase  
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
	
	/*
	 *  Conditional Execution -enable only on satisfying conditionn else disabled 
	 *	@EnabledIf
		@EnabledIfEnvironmentVariable
		@EnabledOnJre(JRE.JAVA_11)
		@EnabledIfSystemProperty
		@EnabledOnOs(OS.LINUX)
  
	 * 
	 * 
	 */
	
	@Test
	@EnabledOnOs(OS.LINUX)
	@DisplayName("Add test for Linux")
	void testAddForLinux() {
		
	}
	
	/*
	 * Assumption - suppose we want to run test case only on server is 
	 * up otherwise we just want to ignore it that time we can assume some value
	 *  
	 */
	@Test
	@DisplayName("Assumptiion test")
	void testAddWithAssumption() {
		assumeTrue(serverStatus);
	}
	

}
