package objectclass;

/**
 * ����ʽ��
 * @author think
 *
 */
public class Multinomial {
	
	/**
	 * ֱ����һ����������ʾ����ʽ,�±����x��ϵ��Ҳ����������
	 * �����ֵ��ʾ��ǰ���ϵ��
	 */
	public int[] coefficient;
	
	public Multinomial(int[] coefficient) {
		this.coefficient = coefficient;
	}
	
	/**
	 * �޲εĹ��캯��,���鸳Ϊ1,��ֻ��һ��Ԫ��
	 * ��Ϊ0�����ӵĻ����ǲ���,����1��
	 */
	public Multinomial() {
		this.coefficient=new int[1];
		coefficient[0] = 1;
	}
	
	/**
	 * ��1�Ĳ����Ĺ��캯��
	 * @param i ����Ϊ1
	 */
	public Multinomial(int i)
	{
		if(i == 1)
		{
			this.coefficient=new int[i+1];
			coefficient[0] = 1;
			coefficient[1] = 1;
		}
		else
		{
			this.coefficient=new int[1];
			coefficient[0] = 0;
		}
	}

	/**
	 * ת���ɶ���ʽ����ʽ���
	 * �����ϵ��Ϊ0����
	 */
	@Override
	public String toString() throws NullPointerException
	{
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<coefficient.length ; i++)
		{
			if(coefficient[i] != 0)
				if(i == 0)
					sb.append("1+");
				else sb.append(" "+coefficient[i]+"x^"+i+"+");
		}
		return sb.toString().substring(0 , sb.length()-1);
//		return sb.toString().substring(0 , sb.length());
	}
	
	/**
	 * �����x������
	 * ��ĳһ�Ϊ0���ʼ,<br>
	 * ��һ����ǰһ���ֵ<br>
	 * @return 
	 */
	public Multinomial mulitplyX() 
	{
		int start=coefficient.length;
		for(int i=0 ; i<coefficient.length; i++)
		{
			if(coefficient[i] != 0)
			{ start = i;
			  break;
			}
		}
		
		//���ȫ����0�Ļ��Ͳ��ÿ���
		if(start == coefficient.length)
			return new Multinomial();
		
		int temp[] = new int[coefficient.length+1];
		for(int i = 0; i<coefficient.length ; i++)
		{
			if( i<start)
				temp[i] = 0;
			else
				temp[i+1] = coefficient[i];//����һ����Ϊǰ��һ���ֵ
		}
		temp[start]=0;
		
		coefficient = temp;
		return new Multinomial(coefficient);
	}

	/**
	 * ����һ���ӷ�����
	 * @param chessboard
	 * @return 
	 */
	public Multinomial add(Multinomial mul) throws NullPointerException
	{
		//��ȡ�������
		int maxArray[]= this.coefficient.length>mul.coefficient.length?
				this.coefficient:mul.coefficient;
		//��ȡС�����鳤��
		int minLength= this.coefficient.length<mul.coefficient.length?
				this.coefficient.length:mul.coefficient.length;
		
		int sum[] = new int[maxArray.length];
		
		for(int i=0; i<maxArray.length ; i++)
		{
			if( i<minLength)
				sum[i] = coefficient[i] + mul.coefficient[i] ;
			else sum[i] = maxArray[i];
		}
		
		coefficient = sum;
		return new Multinomial(this.coefficient);
		
	}
	
}
