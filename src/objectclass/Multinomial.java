package objectclass;

/**
 * 多项式类
 * @author think
 *
 */
public class Multinomial {
	
	/**
	 * 直接用一个数组来表示多项式,下标代表x的系数也就是棋子数
	 * 数组的值表示他前面的系数
	 */
	public int[] coefficient;
	
	public Multinomial(int[] coefficient) {
		this.coefficient = coefficient;
	}
	
	/**
	 * 无参的构造函数,数组赋为1,且只有一个元素
	 * 因为0个棋子的话就是不放,就是1种
	 */
	public Multinomial() {
		this.coefficient=new int[1];
		coefficient[0] = 1;
	}
	
	/**
	 * 用1的参数的构造函数
	 * @param i 必须为1
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
	 * 转换成多项式的形式输出
	 * 不输出系数为0的项
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
	 * 定义乘x的运算
	 * 从某一项不为0的项开始,<br>
	 * 后一项是前一项的值<br>
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
		
		//如果全部是0的话就不用看了
		if(start == coefficient.length)
			return new Multinomial();
		
		int temp[] = new int[coefficient.length+1];
		for(int i = 0; i<coefficient.length ; i++)
		{
			if( i<start)
				temp[i] = 0;
			else
				temp[i+1] = coefficient[i];//后面一项设为前面一项的值
		}
		temp[start]=0;
		
		coefficient = temp;
		return new Multinomial(coefficient);
	}

	/**
	 * 定义一个加法运算
	 * @param chessboard
	 * @return 
	 */
	public Multinomial add(Multinomial mul) throws NullPointerException
	{
		//获取大的数组
		int maxArray[]= this.coefficient.length>mul.coefficient.length?
				this.coefficient:mul.coefficient;
		//获取小的数组长度
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
