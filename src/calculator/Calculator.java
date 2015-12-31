package calculator;

import objectclass.Chessboard;
import objectclass.Multinomial;

/**
 * 用来计算棋盘排列数的类
 * @author think
 *
 */
public abstract class Calculator {

	/**
	 * 计算不可放置的区域的棋盘排列数
	 * 也就是勾选了1的地方,也就是可以自己构造形状的
	 * @param 传入一个棋盘
	 * @return 棋盘排列数
	 */
	public  abstract Multinomial  calShadowCount(Chessboard chessboard);
	
	/**
	 * 计算棋盘中排除不可放置的棋盘位置之后的棋盘排列数
	 * @param 传入一个棋盘
	 * @return 棋盘排列数
	 */
	public  abstract Multinomial  calAvialCount(Chessboard chessboard);
}
