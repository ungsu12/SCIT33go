package GUI;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Canvas;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JSpinner;
import javax.swing.JScrollPane;
import java.awt.Panel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.UIManager;

import Client.ClientManager;
import VO.Human;
import sun.audio.AudioData;
import sun.audio.AudioDataStream;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BorderFactory;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


//로그인 창
public class ClientGUI extends JFrame {
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JPasswordField passwordField;
	private ClientManager cm = new ClientManager();
	private JLabel lblNewLabel_2;
	private AudioStream as = null;
	private Human h;
	public ClientGUI() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		setIconImage(Toolkit.getDefaultToolkit().getImage("Img\\mark.PNG"));
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setEnabled(false);
		
		//확인 버튼
		JButton Button2 = new JButton("");
		Button2.setBounds(275, 289, 267, 86);
		Button2.setIcon(new ImageIcon("Img\\login.jpg"));
		Button2.setBorder(BorderFactory.createEmptyBorder(0 , 0, 0 , 0));
		Button2.addActionListener(new ActionListener() {
			//아이디와 비밀번호가 일치하지 않으면 로그인 불가능
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == Button2){
					enter();
				}
			}
		});
		
		//아이디 텍스트필드
		textField = new JTextField();
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == textField){
				enter();
			}
			}
		});
		textField.setBounds(229, 146, 191, 26);
		textField.setColumns(15);
		
		//패스워드 텍스트필드
		passwordField = new JPasswordField();
		passwordField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == passwordField){
					enter();
				}
			}
		});
		passwordField.setBounds(231, 222, 191, 26);
		passwordField.setColumns(15);

		//로그인 아이콘
		JLabel label = new JLabel("");
		label.setBounds(97, 116, 118, 77);
		label.setIcon(new ImageIcon("Img\\loginLabel1.PNG"));
		label.setFont(new Font("����", Font.PLAIN, 20));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		
		//패스워드 아이콘
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(105, 200, 110, 77);
		lblNewLabel_1.setIcon(new ImageIcon("Img\\passwordLable.PNG"));
		lblNewLabel_1.setFont(new Font("����", Font.PLAIN, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		
		getContentPane().setLayout(null);
		getContentPane().add(lblNewLabel_1);
		getContentPane().add(label);
		getContentPane().add(textField);
		getContentPane().add(passwordField);
		getContentPane().add(Button2);
		
		//환영합니다 메인로고
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("Img\\pm4ratdoc.jpg"));
		lblNewLabel.setBounds(129, 12, 300, 106);
		getContentPane().add(lblNewLabel);
		
		//회원가입 버튼. 버튼을 누르면 회원가입 창으로 넘어감.
		JButton button = new JButton("\uD68C\uC6D0\uAC00\uC785");
		button.setBounds(0, 289, 261, 86);
		button.setBorder(BorderFactory.createEmptyBorder(0 , 0, 0 , 0));
		button.setIcon(new ImageIcon("Img\\join.jpg"));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == button){
		               JoinGUI jg = new JoinGUI(1, null);
		               jg.setVisible(true);
		       		AudioPlayer.player.stop(as);
		               setVisible(false);
		            }
			}
		});
		getContentPane().add(button);
		getContentPane().add(getLblNewLabel_2());
		
		JLabel label_1 = new JLabel("New label");
		label_1.setIcon(new ImageIcon("Img\\hikei2.png"));
		label_1.setBounds(344, 55, 184, 193);
		getContentPane().add(label_1);
		setTitle("로그인");
		setBounds(750, 300, 560, 428);
		mainSound();
		setVisible(true);
	}
	
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("New label");
			lblNewLabel_2.setIcon(new ImageIcon("Img\\hikei1.png"));
			lblNewLabel_2.setBounds(14, 55, 184, 193);
		}
		return lblNewLabel_2;
	}
	private void enter(){
		String id = textField.getText();
		String passWord = passwordField.getText();
		h = new Human(id, passWord, null, null, null);
		if(cm.login(h) != null){
		new MainGUI(h);
		setVisible(false);
		AudioPlayer.player.stop(as);
		}
		else{
		  JOptionPane.showMessageDialog(null, "아이디와 비밀번호를 확인하십시오.", "로그인 실패", JOptionPane.ERROR_MESSAGE);
		}
	}
	private void mainSound(){
		byte[] sound =cm.sound(62);
		AudioData ad = new AudioData(sound);
		AudioDataStream ads = new AudioDataStream(ad);
		try {
			as = new AudioStream(ads);
		} catch (IOException e) {
			e.printStackTrace();
		}
		AudioPlayer.player.start(as);
	}
}
