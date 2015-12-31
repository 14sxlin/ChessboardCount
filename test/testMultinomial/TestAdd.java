package testMultinomial;

import static org.junit.Assert.*;

import org.junit.Before;

import objectclass.Multinomial;

public class TestAdd {

	Multinomial mul ;
	int a[]={1,2,3,5,6};
	int b[]={2,4,5} ;
	int expected[] = {3,6,8,5,6};
	@Before
	public void setUp() throws Exception {
		mul = new Multinomial(a);
	}

	@org.junit.Test
	public void test() {
		System.out.println(mul.toString());
		mul.add(new Multinomial(b));
		System.out.println(new Multinomial(b));
		assertArrayEquals(expected, mul.coefficient);
		System.out.println(mul.toString());
	}

}
