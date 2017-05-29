package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Client.ClientManager;
import VO.Dictionary;
import VO.Grade;
import connection.ConnectionManager;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JEditorPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.JToggleButton;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.Toolkit;

public class ScreenPYGUI extends JFrame {
	private Connection conn;
	private PreparedStatement pstmt;
	private JPanel contentPane;
	private JTextField textField;
	private ArrayList<Dictionary> dic = new ArrayList<>();
	private JEditorPane editorPane;
	private int score = 0;
	private int testNumber = 0;
	private ClientManager cm = new ClientManager();
	private int select = 0;
	private Font font = null;
	private String level = null;
	ImageIcon image = new ImageIcon("Img\\kodomo22.jpg");
	//screenPYGUI 시작
	public ScreenPYGUI(int x) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("Img\\mark.PNG"));
		setResizable(false);
		
			select = x;
		
		    //X창을 눌렀을시 메인GUI로 복귀.
		    this.addWindowListener(new WindowListener() {

			@Override
			public void windowOpened(WindowEvent e) {

			}

			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub

			}
             
			//X창을 눌렀을 경우 점수가 나옴.
			@Override
			public void windowClosing(WindowEvent e) {
				JOptionPane.showMessageDialog(null, "시험이 끝났습니다. 당신의 점수는 " + score + "점 입니다", "종합 결과", JOptionPane.INFORMATION_MESSAGE);
				if(x == 1){
					Grade grade = new Grade(null, null, score, "초급");
					cm.result(grade);
				}
				else if(x == 2){
					Grade grade = new Grade(null, null, score, "중급");
					cm.result(grade);
				}
				else if(x == 3){
					Grade grade = new Grade(null, null, score, "고급");
					cm.result(grade);
				}
				MainGUI mg = new MainGUI();
				mg.setVisible(true);
				setVisible(false);

			}

			@Override
			public void windowClosed(WindowEvent e) {

			}

			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub

			}
		});
		    if(x == 1){
		    	level = "평가 난이도 : 초급";
				dic = cm.test(1);	
			}
			else if (x == 2){
				level = "평가 난이도  : 중급";
				dic = cm.test(2);
			}
			else if (x == 3){
				level = "평가 난이도 : 고급";
				dic = cm.test(3);
			}
		    
		setBounds(100, 100, 766, 416);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
			
		
		JLabel lblNewLabel = new JLabel(level);
		lblNewLabel.setBounds(598, 12, 139, 40);

		// 문제패스버튼
		JButton button_1 = new JButton("");
		button_1.setIcon(new ImageIcon("Img\\passButton1.png"));
		button_1.setFont(new Font("HY수평선M", Font.BOLD, 18));
		button_1.setBounds(14, 295, 272, 56);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(testNumber < 20){
					int random = ((int)(Math.random()*dic.size()));
					String words = dic.get(random).getMean();
					editorPane.setText(words);
					testNumber++;
					textRemove();
					return;
				}
				else{
					JOptionPane.showMessageDialog(null, "시험이 끝났습니다. 당신의 점수는 " + score + "점 입니다", "종합 결과", JOptionPane.INFORMATION_MESSAGE);
					if(x == 1){
						Grade grade = new Grade(null, null, score, "초급");
						cm.result(grade);
					}
					else if(x == 2){
						Grade grade = new Grade(null, null, score, "중급");
						cm.result(grade);
					}
					else if(x == 3){
						Grade grade = new Grade(null, null, score, "고급");
						cm.result(grade);
					}
					setVisible(false);
					MainGUI mg = new MainGUI();
					mg.setVisible(true);
				}
			}
		});

		// 종료를 눌렀을 경우에는 메인으로 복귀함.
		JButton button_2 = new JButton("");
		button_2.setIcon(new ImageIcon("Img\\pygEndButton1.png"));
		button_2.setFont(new Font("HY수평선M", Font.BOLD, 18));
		button_2.setBounds(621, 295, 116, 56);
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == button_2) {
					JOptionPane.showMessageDialog(null, "시험이 끝났습니다. 당신의 점수는 " + score + "점 입니다", "종합 결과", JOptionPane.INFORMATION_MESSAGE);
					if(x == 1){
						Grade grade = new Grade(null, null, score, "초급");
						cm.result(grade);
					}
					else if(x == 2){
						Grade grade = new Grade(null, null, score, "중급");
						cm.result(grade);
					}
					else if(x == 3){
						Grade grade = new Grade(null, null, score, "고급");
						cm.result(grade);
					}
					setVisible(false);
					MainGUI mg = new MainGUI();
					mg.setVisible(true);
					setVisible(false);
				}
			}
		});

		textField = new JTextField();
		textField.setBounds(300, 304, 256, 40);
		Font font1 = new Font("여기에 쓰세요", Font.BOLD, 20);
		textField.setFont(font1);
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(testNumber < 20){
					for(int i = 0; i < dic.size(); i++){
						if (dic.get(i).getWord().equals(textField.getText())){
							if(dic.get(i).getMean().equals(editorPane.getText())){
								score += 5;
								JOptionPane.showMessageDialog(null, "정답입니다","결과",JOptionPane.INFORMATION_MESSAGE);
								int random = ((int)(Math.random()*dic.size()));
								String words = dic.get(random).getMean();
								editorPane.setText(words);
								testNumber++;
								textRemove();
								return;
							}
						}
					}JOptionPane.showMessageDialog(null, "틀렸습니다" , "결과", JOptionPane.YES_OPTION);
				}
				else{
					JOptionPane.showMessageDialog(null, "시험이 끝났습니다. 당신의 점수는 " + score + "점 입니다", "종합 결과", JOptionPane.INFORMATION_MESSAGE);
					if(x == 1){
						Grade grade = new Grade(null, null, score, "초급");
						cm.result(grade);
					}
					else if(x == 2){
						Grade grade = new Grade(null, null, score, "중급");
						cm.result(grade);
					}
					else if(x == 3){
						Grade grade = new Grade(null, null, score, "고급");
						cm.result(grade);
					}
					setVisible(false);
					MainGUI mg = new MainGUI();
					mg.setVisible(true);
				}
			}
		});
		textField.setColumns(10);
		contentPane.setLayout(null);
		contentPane.add(lblNewLabel);
		contentPane.add(textField);
		contentPane.add(button_1);
		contentPane.add(button_2);
		contentPane.add(getEditorPane());
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(0, 0, 760, 383);
		lblNewLabel_1.setIcon(image);
		contentPane.add(lblNewLabel_1);

	}
	private JEditorPane getEditorPane() {
		if (editorPane == null) {
			editorPane = new JEditorPane();
			editorPane.setEditable(false);
			editorPane.setBounds(17, 49, 720, 228);
			int random = ((int)(Math.random()*dic.size()));
			String words = dic.get(random).getMean();
			if(select != 3){
				font = new Font(words, Font.BOLD, 130);
			}
			else{
				font = new Font(words, Font.BOLD, 70);
			}
			editorPane.setFont(font);
			editorPane.setText(words);
		}
		return editorPane;
	}
	private void textRemove(){
		textField.setText("");
	}
}
	
