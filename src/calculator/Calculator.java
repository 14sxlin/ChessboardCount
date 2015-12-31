package calculator;

import objectclass.Chessboard;
import objectclass.Multinomial;

/**
 * ����������������������
 * @author think
 *
 */
public abstract class Calculator {

	/**
	 * ���㲻�ɷ��õ����������������
	 * Ҳ���ǹ�ѡ��1�ĵط�,Ҳ���ǿ����Լ�������״��
	 * @param ����һ������
	 * @return ����������
	 */
	public  abstract Multinomial  calShadowCount(Chessboard chessboard);
	
	/**
	 * �����������ų����ɷ��õ�����λ��֮�������������
	 * @param ����һ������
	 * @return ����������
	 */
	public  abstract Multinomial  calAvialCount(Chessboard chessboard);
}
