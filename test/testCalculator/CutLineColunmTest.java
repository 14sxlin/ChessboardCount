package testCalculator;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import calculator.RectangleCaltor;
import objectclass.Chessboard;

public class CutLineColunmTest {

	RectangleCaltor rec;
	Chessboard chessboard ;
	
	@Before
	public void setUp() throws Exception {
		
		rec= new RectangleCaltor();
		
		int [][] content = {{0,1,0}, {1,1,0}, {0,0,1}};
		chessboard = new Chessboard(content);
	}

	@Test
	public void testCutLineColunm() {
		
		//第一次测试
		Chessboard temp = rec.cutLineColunm(chessboard);
		int [][]ex1 = { {0,0,0} , {1,0,0} , {0,0,1} };
	//	System.out.println(temp.toString());
		assertArrayEquals(ex1, temp.content);
		
		//第二次测试
		temp = rec.cutLineColunm(chessboard);
		int [][]ex2 = { {0,0,0} , {0,0,0} , {0,0,1} };
	//	System.out.println(temp.toString());
		assertArrayEquals(ex2, temp.content);
		
		//0测试
		for( int i=0 ; i <3 ;i++)
			temp= rec.cutLineColunm(chessboard);
		int [][]ex3 = { {0,0,0} , {0,0,0} , {0,0,0} };
		assertArrayEquals(ex3, temp.content);
		
	}

}
