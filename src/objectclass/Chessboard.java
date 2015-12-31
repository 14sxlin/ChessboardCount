package objectclass;

public class Chessboard {

	//public boolean [][] chessboard;
	public int [][] content;
	
	public Chessboard(int [][] content) {
		this.content=content;
	}
	
	/**
	 * 深拷贝
	 * @return 返回棋盘的拷贝对象
	 */
	public Chessboard copyChessboard()
	{
		int temp[][]= new int[content.length][content.length];
		for(int i=0 ; i<content.length; i++)
			for(int j=0; j<content[i].length ; j++)
				temp[i][j] = content[i][j];
		
		return new Chessboard(temp);
		
	}
	

	/**
	 * 转换成棋盘的形式输出
	 */
	public String toString()
	{
		StringBuilder sd= new StringBuilder();
		for(int i = 0; i<content.length ; i++)
		{
			for(int j=0; j<content[i].length; j++)
			{
				if(content[i][j] == 0)
					sd.append(" "+"0"+" ");
				else
					sd.append(" "+"#"+" ");
			}
			sd.append("\n");
		}
		return sd.toString();
	}
	

}
