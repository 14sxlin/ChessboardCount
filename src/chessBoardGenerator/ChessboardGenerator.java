package chessBoardGenerator;

import objectclass.Chessboard;

/**
 * �����������������
 * @author think
 *
 */
public interface ChessboardGenerator {
	
	/**
	 * �������� ��һ����ά��������ʾ�������
	 * true��ʾ��λ�ÿ��Է�,false��ʾ��λ�ò����Է�
	 * @return �������ɵ�����
	 */
	public abstract Chessboard createChessboard();

}
