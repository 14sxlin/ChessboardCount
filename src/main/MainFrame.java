package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import calculator.Calculator;
import calculator.RectangleCaltor;
import chessBoardGenerator.RecChessboardGenetor;
import objectclass.Chessboard;
import objectclass.Multinomial;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private RecChessboardGenetor rectChessboardGen;
	private Calculator rectCaculator;
	private Chessboard chessboard;
	private Multinomial multinomial;
	
	
	private JPanel contentPane;
	private JButton button;
	private JTextPane textPane;
	private JButton designButton;
	private JTextField resultTextField;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private void initGui()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JToolBar toolBar = new JToolBar();
		contentPane.add(toolBar, BorderLayout.NORTH);
		toolBar.setForeground(Color.DARK_GRAY);
		
		designButton = new JButton("\u8BBE\u8BA1\u68CB\u76D8");
		toolBar.add(designButton);
		designButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				rectChessboardGen = new RecChessboardGenetor();
				rectChessboardGen.okButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						try {
							chessboard = rectChessboardGen.createChessboard();
							textPane.setText(chessboard.toString());
							rectChessboardGen.dispose();
						} catch (NullPointerException e1) {
							rectChessboardGen.dispose();
						}
					}
				});
				
			}
		});
		
		JPanel panel_2 = new JPanel();
		toolBar.add(panel_2);
		
		button = new JButton("\u8BA1\u7B97");
		toolBar.add(button);
		button.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JToolBar toolBar_1 = new JToolBar();
		contentPane.add(toolBar_1, BorderLayout.SOUTH);
		
		JLabel lblX = new JLabel("#\u90E8\u5206\u68CB\u76D8\u591A\u9879\u5F0F:");
		toolBar_1.add(lblX);
		
		resultTextField = new JTextField();
		toolBar_1.add(resultTextField);
		resultTextField.setColumns(10);
		
		textPane = new JTextPane();
		contentPane.add(textPane, BorderLayout.CENTER);
		textPane.setEditable(false);
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				rectCaculator = new RectangleCaltor();
				if(chessboard != null)
				{	multinomial=rectCaculator.calShadowCount(chessboard);
					resultTextField.setText(multinomial.toString());
				}
			}
		});
		
	}
	
	public MainFrame() {
		initGui();
		
	}

}
