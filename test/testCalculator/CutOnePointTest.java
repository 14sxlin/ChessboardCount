package testCalculator;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import calculator.RectangleCaltor;
import objectclass.Chessboard;

public class CutOnePointTest {
	
	RectangleCaltor rec;
	Chessboard chessboard ;
	
	@Before
	public void setUp() throws Exception {
		
		rec= new RectangleCaltor();
		
		int [][] content = {{0,1,0}, {1,1,0}, {0,0,1}};
		chessboard = new Chessboard(content);
		
		
	}

	@Test
	public void testCutOnePoint() {
		
		//��һ�β���
		Chessboard temp = rec.cutOnePoint(chessboard);
		int [][] expecteds = {{0,0,0}, {1,1,0}, {0,0,1}};
		assertArrayEquals(expecteds, temp.content);
		
		//�ڶ��β���
		temp = rec.cutOnePoint(chessboard);
		int [][] expecteds1 = {{0,0,0}, {0,1,0}, {0,0,1}};
		assertArrayEquals(expecteds1, temp.content);
		
		//����0��ʱ��
		for( int i=0; i<3; i++)
			temp = rec.cutOnePoint(chessboard);
		int [][] expecteds2 = {{0,0,0}, {0,0,0}, {0,0,0}};
		assertArrayEquals(expecteds2, temp.content);
	}

}
