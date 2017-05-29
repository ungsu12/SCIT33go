package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import game.GameGUI;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Color;

public class EducationSelectGUI extends JFrame {

	private JPanel contentPane;
	private JButton btnNewButton;
	private JButton button;
	private JButton button_1;
	private JFrame evevryGUI;
	private JLabel lblNewLabel;
	ImageIcon image = new ImageIcon("Img\\kodomo20.jpg");
	public JLabel lblNewLabel_1;
	public JLabel label;
	public JLabel label_1;
	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { EducationSelectGUI frame = new
	 * EducationSelectGUI(); } catch (Exception e) { e.printStackTrace(); } }
	 * }); }
	 */

	/**
	 * Create the frame.
	 */
	//난이도 설정창
	public EducationSelectGUI(JFrame maingui) {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("Img\\mark.PNG"));
		this.evevryGUI = maingui;

		//X버튼을 누르면 메인화면으로 넘어감
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

			@Override
			public void windowClosing(WindowEvent e) {
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
		setTitle("학습 선택");
		/* setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); */
		setBounds(100, 100, 515, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getButton_2());
		contentPane.add(getButton_3());
		contentPane.add(getButton_1_1());
		contentPane.add(getLblNewLabel_1());
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("Img\\selectImg2.PNG"));
		lblNewLabel_2.setBounds(146, 12, 347, 100);
		contentPane.add(lblNewLabel_2);
		contentPane.add(getLabel());
		
		JLabel label_3 = new JLabel("New label");
		label_3.setIcon(new ImageIcon("Img\\selectImg2.PNG"));
		label_3.setBounds(146, 137, 347, 100);
		contentPane.add(label_3);
		contentPane.add(getLabel_1());
		
		//이전버튼을 누르면 메인화면으로 넘어감
		JButton button_2 = new JButton("");
		button_2.setIcon(new ImageIcon("Img\\backspaceButton1.png"));
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == button_2){
					MainGUI mg = new MainGUI();
					mg.setVisible(true);
					setVisible(false);
				}
			}
		});
		
		JLabel label_4 = new JLabel("New label");
		label_4.setIcon(new ImageIcon("Img\\selectImg2.PNG"));
		label_4.setBounds(146, 259, 347, 105);
		contentPane.add(label_4);
		button_2.setFont(new Font("HY수평선M", Font.BOLD, 19));
		button_2.setBounds(411, 377, 82, 58);
		contentPane.add(button_2);
		contentPane.add(getLblNewLabel());
		setVisible(true);
	}

	//초급버튼. 게임, 평가, 학습에 따라 들어가는 화면이 달라짐
	private JButton getButton_2() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("");
			btnNewButton.setIcon(new ImageIcon("Img\\educationButton1.png"));
			btnNewButton.setFont(new Font("HY수평선M", Font.BOLD, 19));
			btnNewButton.setBounds(19, 23, 113, 79);
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (e.getSource() == btnNewButton) {
						if (getTitle().equals("게임 선택")) {
							GameGUI gg;
							try {
								gg = new GameGUI(1);
								gg.setTitle("초보자");
								gg.setVisible(true);
								setVisible(false);
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						} else if (getTitle().equals("평가 선택")) {
							ScreenPYGUI spy = new ScreenPYGUI(1);
							spy.setTitle("평가 초급");
							spy.setVisible(true);
							setVisible(false);
						}
						else {
							ScreenGUI sg = new ScreenGUI(1);
							sg.setTitle("학습 초급");
							sg.setVisible(true);
							setVisible(false);

						}
					}
				}
			});
		}
		return btnNewButton;
	}

	//중급버튼. 게임, 평가, 학습에 따라 들어가는 화면이 달라짐
	private JButton getButton_3() {
		if (button == null) {
			button = new JButton("");
			button.setIcon(new ImageIcon("Img\\educationButton2.png"));
			button.setFont(new Font("HY수평선M", Font.BOLD, 19));
			button.setBounds(19, 147, 113, 79);
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (e.getSource() == button) {
						if (getTitle().equals("게임 선택")) {
							GameGUI gg;
							try {
								gg = new GameGUI(2);
								gg.setTitle("중급자");
								gg.setVisible(true);
								setVisible(false);
							} catch (IOException e1) {
								e1.printStackTrace();
							}
						} else if (getTitle().equals("평가 선택")) {
							ScreenPYGUI spy = new ScreenPYGUI(2);
							spy.setTitle("평가 중급");
							spy.setVisible(true);
							setVisible(false);
						}

						else {
							ScreenGUI sg = new ScreenGUI(2);
							sg.setTitle("학습 중급");
							sg.setVisible(true);
							setVisible(false);

						}
					}
				}
			});
		}
		return button;
	}

	//고급버튼. 게임, 평가, 학습에 따라 들어가는 화면이 달라짐
	private JButton getButton_1_1() {
		if (button_1 == null) {
			button_1 = new JButton("");
			button_1.setIcon(new ImageIcon("Img\\educationButton3.png"));
			button_1.setFont(new Font("HY수평선M", Font.BOLD, 19));
			button_1.setBounds(19, 273, 113, 79);
			button_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (e.getSource() == button_1) {
						if (getTitle().equals("게임 선택")) {
							GameGUI gg;
							try {
								gg = new GameGUI(3);
								gg.setTitle("상급자");
								gg.setVisible(true);
								setVisible(false);
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						} else if (getTitle().equals("평가 선택")) {
							ScreenPYGUI spy = new ScreenPYGUI(3);
							spy.setTitle("평가 고급");
							spy.setVisible(true);
							setVisible(false);
						}

						else {
							ScreenGUI sg = new ScreenGUI(3);
							sg.setTitle("학습 고급");
							sg.setVisible(true);
							setVisible(false);

						}
					}
				}
			});
		}
		return button_1;
	}
	
	//배경이미지
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("New label");
			lblNewLabel.setIcon(image);
			lblNewLabel.setBounds(0, 0, 509, 447);
		}
		return lblNewLabel;
	}
	
	//초급에 대한 설명
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("   히라가나 50음도를 학습합니다\r\n");
			lblNewLabel_1.setForeground(Color.WHITE);
			lblNewLabel_1.setFont(new Font("한컴 백제 M", Font.BOLD, 22));
			lblNewLabel_1.setBounds(146, 12, 347, 100);
		}
		return lblNewLabel_1;
	}
	
	//중급에 대한 설명
	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("   가타카나 50음도를 학습합니다");
			label.setForeground(Color.WHITE);
			label.setFont(new Font("한컴 백제 M", Font.BOLD, 22));
			label.setBounds(146, 135, 347, 100);
		}
		return label;
	}
	
	//고급에 대한 설명
	private JLabel getLabel_1() {
		if (label_1 == null) {
			label_1 = new JLabel("   일본어 기초단어를 학습합니다");
			label_1.setForeground(Color.WHITE);
			label_1.setFont(new Font("한컴 백제 M", Font.BOLD, 22));
			label_1.setBounds(146, 260, 347, 100);
		}
		return label_1;
	}
}
