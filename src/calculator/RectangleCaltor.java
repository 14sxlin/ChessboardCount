package calculator;

import objectclass.Chessboard;
import objectclass.Multinomial;

/**
 * 计算矩形棋盘的类
 * @author think
 *
 */
public class RectangleCaltor extends Calculator {

	
	public RectangleCaltor() {
	}
	
	/**
	 * 计算阴影部分的格子数
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
	 * 去掉检索到的第一个点
	 * @param chessboard
	 * @return 去掉点之后的地方
	 */
	public Chessboard cutOnePoint(Chessboard chessboard)
	{
		int x = 0 , y = 0;								//记录下要删除的点的坐标
		boolean find = false;
		if(countShadowCell(chessboard) != 0)
			for(int i=0; i<chessboard.content.length && !find ; i++)
				for(int j = 0; j<chessboard.content.length && !find ; j++)
				{
					//找到一个阴影,记录下它的位置
					if( chessboard.content[i][j] != 0)
					{
						x=i;
						y=j;
						find=true;														
					}
				}
		else return chessboard;
		chessboard.content[x][y] = 0;				//把该阴影点去掉
		return chessboard;
	}
	
	/**
	 * 去掉第一个检索到的点的列和行
	 * @param chessboard
	 * @return
	 */
	public Chessboard cutLineColunm(Chessboard chessboard)
	{
		int x = 0 , y = 0;																		//记录下要删除行列的点的坐标
		boolean find = false;
		if(countShadowCell(chessboard) != 0)
			for(int i=0; i<chessboard.content.length && !find ; i++)
				for(int j = 0; j<chessboard.content.length && !find ; j++)
				{
					//找到一个阴影,记录下它的位置
					if( chessboard.content[i][j] != 0)
					{
						x=i;
						y=j;
						find=true;														
					}
				}
		else return chessboard;
		
		//删除行和列
		for(int i=0 ;  i < chessboard.content.length ; i++)
		{	chessboard.content[x][i] = 0;
			chessboard.content[i][y] = 0;
		}
		
		return chessboard;
	}
	

	@Override
	public Multinomial calShadowCount(Chessboard chessboard) {
		
		//用递归调用
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
