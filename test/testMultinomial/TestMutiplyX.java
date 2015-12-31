package testMultinomial;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import objectclass.Multinomial;

public class TestMutiplyX {

	Multinomial mul;
	@Before
	public void setUp() throws Exception {
		int [] testints = {0,0,1,2,3,4,5};
		mul = new Multinomial(testints);
	}

	@Test
	public void testMultiplyXWorkWell() {
		System.out.println(mul.toString());
		//第一次乘X
		mul.mulitplyX();
		int expected1[] = {0,0,0,1,2,3,4,5 };
		assertArrayEquals(expected1, mul.coefficient);
		System.out.println(mul.toString());
		
		//第二次乘X
		mul.mulitplyX();
		int expected2[] = {0,0,0,0,1,2,3,4,5 };
		assertArrayEquals(expected2, mul.coefficient);
		System.out.println(mul.toString());
	}

}
