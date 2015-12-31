package objectclass;

public class Chessboard {

	//public boolean [][] chessboard;
	public int [][] content;
	
	public Chessboard(int [][] content) {
		this.content=content;
	}
	
	/**
	 * ���
	 * @return �������̵Ŀ�������
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
	 * ת�������̵���ʽ���
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
