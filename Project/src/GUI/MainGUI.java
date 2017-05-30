package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.sun.glass.events.WindowEvent;

import Client.ClientManager;
import VO.Human;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Color;

public class MainGUI extends JFrame {

	private JPanel contentPane;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JButton button;
	private JButton button_1;
	private JButton button_2;
	private JButton btnNewButton_4;
    private ClientManager cm = new ClientManager();
    private JButton button_3;
    private JLabel lblNewLabel;
    ImageIcon image = new ImageIcon("Img\\kodomo15.jpg");
    ImageIcon image1 = new ImageIcon("Img\\kodomo25.jpg");
    ImageIcon image2 = new ImageIcon("Img\\kodomo26.jpg");
    ImageIcon image3 = new ImageIcon("Img\\kodomo27.jpg");
    ImageIcon image4 = new ImageIcon("Img\\gameButton1.png");
    ImageIcon image5 = new ImageIcon("Img\\gameButton2.png");
    ImageIcon image6 = new ImageIcon("Img\\gameButton3.png");
    private JLabel lblNewLabel_1;
    private JLabel label;
    private JLabel label_1;
    private JLabel label_2;
    private JLabel lblNewLabel_3;
    private JLabel label_3;
    private JLabel label_4;
    private Human h;

    //메인화면 창
	public MainGUI(Human h) {
		this.h = h;
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent e) {
				ClientGUI cg = new ClientGUI();
				cg.setVisible(true);
				setVisible(false);
			}
		});
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("Img\\mark.PNG"));
		setTitle("쎄쎄세(せっせっせ）");
		setBounds(100, 100, 674, 540);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getBtnNewButton_3());
		contentPane.add(getButton());
		contentPane.add(getButton_1());
		contentPane.add(getButton_2());
		contentPane.add(getBtnNewButton_2());
		contentPane.add(getButton_3());
		contentPane.add(getBtnNewButton_4());
		
		JLabel lblNewLabel_2 = new JLabel("     그림을 보고 단어를 학습할 수 있습니다\r\n");
		lblNewLabel_2.setFont(new Font("한컴 백제 M", Font.BOLD, 21));
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(189, 51, 464, 80);
		contentPane.add(lblNewLabel_2);
		contentPane.add(getLblNewLabel_1());
		contentPane.add(getLblNewLabel_3());
		contentPane.add(getLabel());
		contentPane.add(getLabel_1());
		contentPane.add(getLabel_3());
		contentPane.add(getLabel_2());
		contentPane.add(getLabel_4());
		contentPane.add(getLblNewLabel());
		setVisible(true);
	}
	
	//EXIT를 눌렀을 경우 로그인 창으로 복귀함.
	private JButton getBtnNewButton_2() {
		if (btnNewButton_2 == null) {
			btnNewButton_2 = new JButton("");
			btnNewButton_2.setIcon(new ImageIcon("Img\\exitButton1.png"));
			btnNewButton_2.setFont(new Font("HY수평선M", Font.BOLD, 19));
			btnNewButton_2.setBounds(480, 444, 170, 47);
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ClientGUI cg = new ClientGUI();
					cg.setVisible(true);
					setVisible(false);
				}
			});
		}
		return btnNewButton_2;
	}
	
	//학습버튼을 누를 시 난이도 선택으로 들어감.
	private JButton getBtnNewButton_3() {
		if (btnNewButton_3 == null) {
			btnNewButton_3 = new JButton("");
			btnNewButton_3.setToolTipText("");
			btnNewButton_3.setIcon(new ImageIcon("Img\\mainButton1.PNG"));
			btnNewButton_3.setFont(new Font("HY수평선M", Font.BOLD, 19));
			btnNewButton_3.setBounds(19, 53, 153, 80);
			btnNewButton_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(e.getSource() == btnNewButton_3){
						EducationSelectGUI eg = new EducationSelectGUI(MainGUI.this, h);
						eg.lblNewLabel.setIcon(image1);
						eg.setVisible(true);
						setVisible(false);
					}
				}
			});
		}
		return btnNewButton_3;
	}
	
	//게임버튼을 누를 시 난이도 선택으로 들어감.
	private JButton getButton() {
		if (button == null) {
			button = new JButton("");
			button.setIcon(new ImageIcon("Img\\mainButton2.png"));
			button.setFont(new Font("HY수평선M", Font.BOLD, 19));
			button.setBounds(19, 141, 153, 80);
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(e.getSource() == button){
						EducationSelectGUI eg = new EducationSelectGUI(MainGUI.this, h);
						eg.lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 22));
						eg.label.setFont(new Font("굴림", Font.BOLD, 22));
						eg.label_1.setFont(new Font("굴림", Font.BOLD, 22));
						eg.lblNewLabel_1.setText("<html>&nbsp;&nbsp;&nbsp;히라가나가 떨어지면<br>&nbsp;&nbsp;&nbsp;맞추는 게임입니다<br></html>");
						eg.label.setText("<html>&nbsp;&nbsp;&nbsp;가타카나가 떨어지면<br>&nbsp;&nbsp;&nbsp;맞추는 게임입니다<br></html>");
						eg.label_1.setText("<html>&nbsp;&nbsp;&nbsp;단어가 떨어지면<br>&nbsp;&nbsp;&nbsp;맞추는 게임입니다<br></html>");
						eg.lblNewLabel.setIcon(image2);
						eg.getButton_2().setIcon(image4);
						eg.getButton_3().setIcon(image5);
						eg.getButton_1_1().setIcon(image6);
						eg.setVisible(true);
						eg.setTitle("게임 선택");
						setVisible(false);
					}
				}
			});
		}
		return button;
	}
	
	//평가버튼을 누를 시 난이도 선택으로 들어감.
	private JButton getButton_1() {
		if (button_1 == null) {
			button_1 = new JButton("");
			button_1.setIcon(new ImageIcon("Img\\mainButton3.png"));
			button_1.setFont(new Font("HY수평선M", Font.BOLD, 19));
			button_1.setBounds(19, 233, 153, 80);
			button_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//평가버튼을 눌러서 
					if(e.getSource() == button_1){
						EducationSelectGUI eg = new EducationSelectGUI(MainGUI.this, h);
						eg.lblNewLabel_1.setText("<html>&nbsp;&nbsp;&nbsp;한국어 발음이 보이면<br>&nbsp;&nbsp;&nbsp;히라가나로 적는 평가입니다<br></html>");
						eg.label.setText("<html>&nbsp;&nbsp;&nbsp;한국어 발음이 보이면<br>&nbsp;&nbsp;&nbsp;가타카나로 적는 평가입니다<br></html>");
						eg.label_1.setText("<html>&nbsp;&nbsp;&nbsp;단어의 의미가 보이면<br>&nbsp;&nbsp;&nbsp;단어를 적는 평가입니다<br></html>");
						eg.lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 22));
						eg.label.setFont(new Font("굴림", Font.BOLD, 22));
						eg.label_1.setFont(new Font("굴림", Font.BOLD, 22));
						eg.lblNewLabel.setIcon(image3);
						eg.setVisible(true);
						eg.setTitle("평가 선택");
						setVisible(false);
					}
				}
			});
		}
		return button_1;
	}
	
	//기록화면 result로 넘어감.
	private JButton getButton_2() {
		if (button_2 == null) {
			button_2 = new JButton("");
			button_2.setIcon(new ImageIcon("Img\\mainButton4.png"));
			button_2.setFont(new Font("HY수평선M", Font.BOLD, 19));
			button_2.setBounds(19, 325, 153, 80);
			button_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					RecordGUI rg = new RecordGUI(h);
					rg.setVisible(true);
					setVisible(false);
				}
			});
		}
		return button_2;
	}
	
	//회원정보 수정을 누르면 수정된 joingui를 불러옴.
	private JButton getBtnNewButton_4() {
		if (btnNewButton_4 == null) {
			btnNewButton_4 = new JButton("");
			btnNewButton_4.setIcon(new ImageIcon("Img\\changeHumanButton1.png"));
			btnNewButton_4.setFont(new Font("HY수평선M", Font.BOLD, 16));
			btnNewButton_4.setBounds(509, 12, 144, 27);
			btnNewButton_4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				   if(e.getSource() == btnNewButton_4){
					   JoinGUI jg = new JoinGUI(2, h);
					   jg.setTitle("회원 정보 수정");
					   jg.getRadioMan().setEnabled(false);
					   jg.getRadioWoman().setEnabled(false);
					   jg.setVisible(true);
					   setVisible(false);
					   JOptionPane.showMessageDialog(null, "아이디와 패스워드를 입력하세요.", "확인", JOptionPane.INFORMATION_MESSAGE);
				   }
				}
			});
		}
		return btnNewButton_4;
	}
	
	//탈퇴를 누르면 현재로그인된 아이디가 삭제됨.
	private JButton getButton_3() {
		if (button_3 == null) {
			button_3 = new JButton("");
			button_3.setIcon(new ImageIcon("Img\\withdrawButton1.png"));
			button_3.setFont(new Font("HY수평선M", Font.BOLD, 16));
			button_3.setBounds(422, 12, 73, 27);
			button_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int result = JOptionPane.showConfirmDialog(null, "정말 삭제 하시겠습니까?", "탈퇴", JOptionPane.WARNING_MESSAGE);
					if(result == 0){
						int i = cm.delete(h.getId());
						if(i == 1){
							JOptionPane.showMessageDialog(null, "삭제 완료하였습니다!", "삭제 완료", JOptionPane.INFORMATION_MESSAGE);
							new ClientGUI();
							setVisible(false);
						}
					}
					else if(result == 2){
						
					}
				}
			});
		}
		return button_3;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("New label");
			lblNewLabel.setIcon(image);
			lblNewLabel.setBounds(0, 0, 668, 505);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("");
			lblNewLabel_1.setIcon(new ImageIcon("Img\\selectImg1.PNG"));
			lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 18));
			lblNewLabel_1.setBounds(186, 55, 464, 76);
		}
		return lblNewLabel_1;
	}
	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("");
			label.setIcon(new ImageIcon("Img\\selectImg1.PNG"));
			label.setFont(new Font("굴림", Font.BOLD, 18));
			label.setBounds(186, 141, 464, 76);
		}
		return label;
	}
	private JLabel getLabel_1() {
		if (label_1 == null) {
			label_1 = new JLabel("     의미를 보고 단어를 입력하는 평가입니다\r\n");
			label_1.setForeground(Color.WHITE);
			label_1.setFont(new Font("한컴 백제 M", Font.BOLD, 21));
			label_1.setBounds(186, 233, 464, 80);
		}
		return label_1;
	}
	private JLabel getLabel_2() {
		if (label_2 == null) {
			label_2 = new JLabel("     게임과 평가 후 점수를 확인할 수 있습니다");
			label_2.setForeground(Color.WHITE);
			label_2.setFont(new Font("한컴 백제 M", Font.BOLD, 21));
			label_2.setBounds(184, 325, 466, 80);
		}
		return label_2;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("     산성비 게임으로 일본어를 학습할 수 있습니다\r\n");
			lblNewLabel_3.setForeground(Color.WHITE);
			lblNewLabel_3.setFont(new Font("한컴 백제 M", Font.BOLD, 21));
			lblNewLabel_3.setBounds(186, 141, 464, 76);
		}
		return lblNewLabel_3;
	}
	private JLabel getLabel_3() {
		if (label_3 == null) {
			label_3 = new JLabel("");
			label_3.setIcon(new ImageIcon("Img\\selectImg1.PNG"));
			label_3.setFont(new Font("굴림", Font.BOLD, 18));
			label_3.setBounds(186, 233, 464, 80);
		}
		return label_3;
	}
	private JLabel getLabel_4() {
		if (label_4 == null) {
			label_4 = new JLabel("");
			label_4.setIcon(new ImageIcon("Img\\selectImg1.PNG"));
			label_4.setFont(new Font("굴림", Font.BOLD, 18));
			label_4.setBounds(186, 325, 464, 80);
		}
		return label_4;
	}
}