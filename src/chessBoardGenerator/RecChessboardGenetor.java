package chessBoardGenerator;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JToolBar;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import objectclass.Chessboard;

/**
 * 这个类融合了用户操作界面,让用户来输入棋盘
 * @author think
 *
 */
public class RecChessboardGenetor extends JDialog
										implements ChessboardGenerator {

	private static final long serialVersionUID = 1L;
	
	private final JPanel contentPanel = new JPanel();
	private JCheckBox checkBox[][];
	private JPanel displayPanel;
    private GridLayout gridlayout;
    public JButton okButton;
    private JButton cancelButton;
    
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RecChessboardGenetor dialog = new RecChessboardGenetor();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RecChessboardGenetor() {
		initGui();
	}
	
	private void initGui()
	{
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JToolBar toolBar = new JToolBar();
			contentPanel.add(toolBar, BorderLayout.NORTH);
			{
				JLabel label = new JLabel("\u884C(\u5217)\u6570N:");
				toolBar.add(label);
			}
			//这个是用来指定棋盘的大小的,划定一个n*n的棋盘
			JSpinner nSpinner = new JSpinner(new SpinnerNumberModel(5, 1, 50, 1));
			toolBar.add(nSpinner);
			{
				
				//这个按钮是生成棋盘的按钮
				JButton button = new JButton("\u751F\u6210N*N\u7A7A\u767D\u68CB\u76D8");
				button.setBackground(Color.LIGHT_GRAY);
				toolBar.add(button);
				{
					JToolBar toolBar_1 = new JToolBar();
					contentPanel.add(toolBar_1, BorderLayout.SOUTH);
					{
						JLabel label = new JLabel("\u52FE\u9009\u7684\u90E8\u5206\u4E3A\u68CB\u76D8\u7684\u7981\u533A,\u5C06\u8BA1\u7B97\u8BE5\u90E8\u5206\u7684\u68CB\u76D8\u591A\u9879\u5F0F");
						toolBar_1.add(label);
						label.setAlignmentX(Component.CENTER_ALIGNMENT);
						label.setHorizontalAlignment(SwingConstants.LEFT);
					}
					okButton = new JButton("  OK  ");
					toolBar_1.add(okButton);
					okButton.setAlignmentX(Component.RIGHT_ALIGNMENT);
					okButton.setActionCommand("OK");
					getRootPane().setDefaultButton(okButton);
					{
						cancelButton = new JButton("Cancel");
						toolBar_1.add(cancelButton);
						cancelButton.setAlignmentX(1.0f);
						cancelButton.setActionCommand("Cancel");
						cancelButton.addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent arg0) {
								dispose();
							}
						});
					}
				}
				button.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						int size = Integer.parseInt( (""+nSpinner.getValue()).trim());
						//初始化显示窗口
						if (displayPanel != null)
						{	
							displayPanel.setVisible(false);//把其他的设置为不可见就行了
							displayPanel = new JPanel(gridlayout);
							displayPanel.setVisible(true);
						}else displayPanel = new JPanel(gridlayout);
						
						contentPanel.add(displayPanel, BorderLayout.CENTER);
						displayPanel.setLayout(new GridLayout(size, size, 0, 0));	
						
						//初始化checkbox
						checkBox = new JCheckBox[size][size];
						for ( int i=0; i<size ; i++)
							for ( int j=0; j<size; j++)
							{
								
								checkBox[i][j] = new JCheckBox("("+i+","+j+")");
								checkBox[i][j].addItemListener(new ItemListener() {
									
									@Override
									public void itemStateChanged(ItemEvent e) {
//										if(e.getStateChange() == ItemEvent.SELECTED)
//										{   JCheckBox tempCheckbox =(JCheckBox)e.getSource();
//											System.out.println(this.getClass().getName()+"   "+tempCheckbox.getText());
//										}
									}
								});
								displayPanel.add(checkBox[i][j]);
							}
						
//						System.out.println(checkBox.length);
//						System.out.println(checkBox[0].length);
						
						setVisible(true);
					}
				});
			}
		}
		
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}

	@Override
	public Chessboard createChessboard() throws NullPointerException{
		int [][]temp = new int[checkBox.length][checkBox.length];
		
		for( int i=0; i<checkBox.length; i++)
			for( int j=0; j<checkBox[i].length ; j++)
			{
				if(checkBox[i][j].isSelected())
					temp[i][j] = 1;			//1表示被选中了 这个位置不可以放
				else temp[i][j] = 0;		//0表示没有被选中 这个位置可以放棋子
					
			}
		return new Chessboard(temp);
	}

}
