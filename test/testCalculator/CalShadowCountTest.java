package testCalculator;

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;

import calculator.RectangleCaltor;
import objectclass.Chessboard;
import objectclass.Multinomial;

public class CalShadowCountTest {
	
	RectangleCaltor rec;
	Chessboard chessboard ;
	
	@Before
	public void setUp() throws Exception {
		
		rec= new RectangleCaltor();
	}

	@Test
	public void testCalShadowCount() {
		Multinomial mul;
		
		int[][] value1= {{1,0} , {0,1}};
		int[]  ex1= {1,2,1};
		chessboard = new Chessboard(value1);
		mul= rec.calShadowCount(chessboard);
		System.out.println(mul.toString());
		assertArrayEquals(ex1, mul.coefficient);
		
		int[][] value2= { {0,1,0,0} , {0,1,1,0},  {0,0,1,1} , {0,0,0,1} };
		int ex2[] = {1,6,10,4};
		chessboard = new Chessboard(value2);
		mul= rec.calShadowCount(chessboard);
		System.out.println(mul.toString());
		assertArrayEquals(ex2, mul.coefficient);
		
		int[][] value3= { {0,1,0} , {0,1,1},  {0,1,1}  };
		int ex3[] = {1,5,4};
		chessboard = new Chessboard(value3);
		mul= rec.calShadowCount(chessboard);
		System.out.println(mul.toString());
		assertArrayEquals(ex3, mul.coefficient);
		
	}

}
