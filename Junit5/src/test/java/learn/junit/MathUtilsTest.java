package learn.junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MathUtilsTest {

	@Test
	void test() {
		// Create the instance of class
		//Setup inputs 
		// execute the code you want to test 
		// comapre the result
		
		MathUtils obj = new MathUtils();
		int expected =6;
		int actual=obj.add(3, 3);
		assertEquals(expected, actual);
//		When it fails, it will generate This method should return sum message
//		assertEquals(expected, actual, "This method should return sum  ");
		
		System.out.println("TEST RUNNER updated");
		System.out.println("TEST RUNNER updated");
	}
	
	@Test
	void testComputeCircleArea() {
		MathUtils obj = new MathUtils();
		double expected = 153.93804002589985;
		double actual = obj.computeCircleArea(7);
		assertEquals(expected, actual,"This method should return area of circle");
	}

}
