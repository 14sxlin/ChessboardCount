package calculator;

import objectclass.Chessboard;
import objectclass.Multinomial;

/**
 * ����������̵���
 * @author think
 *
 */
public class RectangleCaltor extends Calculator {

	
	public RectangleCaltor() {
	}
	
	/**
	 * ������Ӱ���ֵĸ�����
	 * @param chessboard
	 * @return
	 */
	private  int countShadowCell(Chessboard chessboard)
	{
		int shadowCount=0;
		for(int i=0; i<chessboard.content.length; i++)
			for(int j = 0; j<chessboard.content.length; j++)
				if( chessboard.content[i][j] != 0)
					shadowCount++;
		return shadowCount;
	}

	/**
	 * ȥ���������ĵ�һ����
	 * @param chessboard
	 * @return ȥ����֮��ĵط�
	 */
	public Chessboard cutOnePoint(Chessboard chessboard)
	{
		int x = 0 , y = 0;								//��¼��Ҫɾ���ĵ������
		boolean find = false;
		if(countShadowCell(chessboard) != 0)
			for(int i=0; i<chessboard.content.length && !find ; i++)
				for(int j = 0; j<chessboard.content.length && !find ; j++)
				{
					//�ҵ�һ����Ӱ,��¼������λ��
					if( chessboard.content[i][j] != 0)
					{
						x=i;
						y=j;
						find=true;														
					}
				}
		else return chessboard;
		chessboard.content[x][y] = 0;				//�Ѹ���Ӱ��ȥ��
		return chessboard;
	}
	
	/**
	 * ȥ����һ���������ĵ���к���
	 * @param chessboard
	 * @return
	 */
	public Chessboard cutLineColunm(Chessboard chessboard)
	{
		int x = 0 , y = 0;																		//��¼��Ҫɾ�����еĵ������
		boolean find = false;
		if(countShadowCell(chessboard) != 0)
			for(int i=0; i<chessboard.content.length && !find ; i++)
				for(int j = 0; j<chessboard.content.length && !find ; j++)
				{
					//�ҵ�һ����Ӱ,��¼������λ��
					if( chessboard.content[i][j] != 0)
					{
						x=i;
						y=j;
						find=true;														
					}
				}
		else return chessboard;
		
		//ɾ���к���
		for(int i=0 ;  i < chessboard.content.length ; i++)
		{	chessboard.content[x][i] = 0;
			chessboard.content[i][y] = 0;
		}
		
		return chessboard;
	}
	

	@Override
	public Multinomial calShadowCount(Chessboard chessboard) {
		
		//�õݹ����
		if(countShadowCell(chessboard) == 0)
			return new Multinomial() ;		
		else if(countShadowCell(chessboard) == 1)
			return new Multinomial(1);
		else 
		{
			Chessboard cuttedOnePointChess = cutOnePoint(chessboard.copyChessboard());
			Chessboard cuttedLineColunmChess = cutLineColunm(chessboard.copyChessboard());
			return calShadowCount(cuttedLineColunmChess).mulitplyX()
					.add(calShadowCount(cuttedOnePointChess));
		}
	}
	
	@Override
	public Multinomial calAvialCount(Chessboard chessboard) {
		// TODO Auto-generated method stub
		return null ;
	}
	
}
