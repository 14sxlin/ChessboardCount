package chessBoardGenerator;

import objectclass.Chessboard;

/**
 * 这个类用于生成棋盘
 * @author think
 *
 */
public interface ChessboardGenerator {
	
	/**
	 * 生成棋盘 用一个二维数组来表示这个棋盘
	 * true表示给位置可以放,false表示该位置不可以放
	 * @return 返回生成的棋盘
	 */
	public abstract Chessboard createChessboard();

}
