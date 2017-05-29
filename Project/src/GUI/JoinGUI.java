package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.TypeCheckError;
import com.sun.org.apache.xerces.internal.impl.dv.xs.IntegerDV;

import Client.ClientManager;
import VO.Human;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Toolkit;

public class JoinGUI extends JFrame  {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JTextField idtf;
	private JPasswordField pf;
	private JTextField nametf;
	private JTextField agetf;
	private JRadioButton radioman;
	private JRadioButton radioWoman;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private String sex = null;
	public ButtonGroup gender = null;
	private ClientManager cm = new ClientManager();
	ImageIcon image = new ImageIcon("Img\\kodomo12.jpg");
	private int select;
	/**
	 * Launch the application.
	 */
	private JFrame everyGUI;
	
	//회원가입 창
	public JoinGUI(int x) {
		select = x;
		setIconImage(Toolkit.getDefaultToolkit().getImage("Img\\mark.PNG"));
		
		//X를 누르면 로그인화면으로 돌아감
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
				ClientGUI cg = new ClientGUI();
				cg.setVisible(true);
				setVisible(false);
			}
			
			@Override
			public void windowClosed(WindowEvent e) {
				System.out.println("bbb");
				
			}
			
			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		setTitle("회원가입");
		
		
		/*setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);*/
		setBounds(100, 100, 336, 461);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		gender = new ButtonGroup();
		gender.add(radioman);
		gender.add(radioWoman);
		contentPane.setLayout(null);
		contentPane.add(getLblNewLabel_4());
		contentPane.add(getLblNewLabel());
		contentPane.add(getLblNewLabel_1());
		contentPane.add(getLblNewLabel_2());
		contentPane.add(getLblNewLabel_3());
		contentPane.add(getNametf());
		contentPane.add(getPf());
		contentPane.add(getIdtf());
		contentPane.add(getAgetf());
		contentPane.add(getRadioMan());
		contentPane.add(getRadioWoman());
		contentPane.add(getBtnNewButton());
		contentPane.add(getBtnNewButton_1());
		ButtonGroup group = new ButtonGroup();
		group.add(getRadioWoman());
		group.add(getRadioMan());
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setBounds(0, 0, 321, 420);
		lblNewLabel_5.setIcon(image);
		contentPane.add(lblNewLabel_5);
		setVisible(true);
	}

	//아이디 라벨
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("아이디");
			lblNewLabel.setFont(new Font("굴림", Font.BOLD, 16));
			lblNewLabel.setBounds(56, 12, 56, 18);
		}
		return lblNewLabel;
	}

	//패스워드 라벨
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("패스워드");
			lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 16));
			lblNewLabel_1.setBounds(56, 78, 75, 18);
		}
		return lblNewLabel_1;
	}

	//이름 라벨
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("이름");
			lblNewLabel_2.setFont(new Font("굴림", Font.BOLD, 16));
			lblNewLabel_2.setBounds(56, 137, 46, 18);
		}
		return lblNewLabel_2;
	}

	//나이 라벨
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("나이");
			lblNewLabel_3.setFont(new Font("굴림", Font.BOLD, 16));
			lblNewLabel_3.setBounds(56, 203, 46, 18);
		}
		return lblNewLabel_3;
	}

	//성별 라벨
	private JLabel getLblNewLabel_4() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("성별");
			lblNewLabel_4.setFont(new Font("굴림", Font.BOLD, 16));
			lblNewLabel_4.setBounds(56, 269, 46, 18);
		}
		return lblNewLabel_4;
	}

	//아이디를 입력받는 텍스트필드
	public JTextField getIdtf() {
		if (idtf == null) {
			idtf = new JTextField();
			idtf.setBounds(56, 42, 226, 24);
			idtf.setColumns(20);
		}
		return idtf;
	}

	//패스워드를 입력받는 텍스트필드
	public JPasswordField getPf() {
		if (pf == null) {
			pf = new JPasswordField();
			pf.setBounds(56, 101, 226, 24);
			pf.setColumns(20);
		}
		return pf;
	}

	//이름을 입력받는 텍스트필드
	public JTextField getNametf() {
		if (nametf == null) {
			nametf = new JTextField();
			nametf.setBounds(56, 167, 226, 24);
			nametf.setColumns(20);
		}
		return nametf;
	}

	//나이를 입력받는 텍스트필드
	public JTextField getAgetf() {
		if (agetf == null) {
			agetf = new JTextField();
			agetf.setBounds(56, 233, 226, 24);
			agetf.setColumns(20);
		}
		return agetf;
	}
	
	//남자를 선택할 수 있는 라디오 버튼
	public JRadioButton getRadioMan() {
		if (radioman == null) {
			radioman = new JRadioButton("남자");
			radioman.setFont(new Font("굴림", Font.BOLD, 16));
			radioman.setBounds(79, 314, 68, 27);
			radioman.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					sex = "1";
				}
			});
		}
		return radioman;
	}

	//여자를 선택할 수 있는 라디오 버튼
	public JRadioButton getRadioWoman() {
		if (radioWoman == null) {
			radioWoman = new JRadioButton("여자");
			radioWoman.setFont(new Font("굴림", Font.BOLD, 16));
			radioWoman.setBounds(173, 314, 70, 27);
			radioWoman.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					sex = "2";
				}
			});
		}
		return radioWoman;
	}

	//확인버튼을 눌러 DB에 회원정보를 저장함.
	public JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("");
			btnNewButton.setIcon(new ImageIcon("C:\\Users\\user\\git\\SCIT33go\\Project\\Img\\chackButton1.png"));
			btnNewButton.setFont(new Font("HY수평선M", Font.BOLD, 16));
			btnNewButton.setBounds(72, 367, 75, 39);
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//회원정보 수정창과 동일한 GUI를 사용하기에 확인일 경우와 수정일경우를 나누어줌
					//가입으로 들어와서 DB에 회원정보를 저장함
					if (e.getSource() == btnNewButton) {
						if(select == 1){
							if (getIdtf().getText().equals("") || getPf().getText().equals("")
									|| getNametf().getText().equals("") || getAgetf().getText().equals("")||
									!radioman.isSelected() && !radioWoman.isSelected()){
								JOptionPane.showMessageDialog(null, "빈칸을 모두 입력하시오.", "가입결과", JOptionPane.ERROR_MESSAGE);
								return;
							} 
							else if(getIdtf().getText().length() < 4 || getIdtf().getText().length() > 13){
								JOptionPane.showMessageDialog(null, "아이디는  4~12자리입니다.", "가입결과", JOptionPane.ERROR_MESSAGE);
								return;
							}
							else if(getPf().getText().length() < 4 || getPf().getText().length() > 21){
								JOptionPane.showMessageDialog(null, "비밀번호는  4~20자리입니다.", "가입결과", JOptionPane.ERROR_MESSAGE);
								return;
							}
							else if(Pattern.matches("^[0-9]+$", getNametf().getText())){
								JOptionPane.showMessageDialog(null, "이름은 문자를 넣어주십시오.", "가입결과", JOptionPane.ERROR_MESSAGE);
								return;
							}
							else if(getAgetf().getText().length() > 3 ){
								JOptionPane.showMessageDialog(null, "나이는 3자리입니다.", "가입결과", JOptionPane.ERROR_MESSAGE);
								return;
							}
							else if(!(Pattern.matches("^[0-9]+$", getAgetf().getText()))){
								JOptionPane.showMessageDialog(null, "나이는 숫자를 넣어주십시오.", "가입결과", JOptionPane.ERROR_MESSAGE);
								return;
							}
							else {
								System.out.println(getAgetf().getText().length());
								Human h = null;
								String id = getIdtf().getText();
								String passWord = getPf().getText();
								String name =  getNametf().getText();
								String age = getAgetf().getText();
								h = new Human(id, passWord, name, age, sex);
								int i = cm.insert(h);
								if(i == 0){
									JOptionPane.showMessageDialog(null, "중복된 아이디가 있습니다.", "가입결과", JOptionPane.ERROR_MESSAGE);
									return;
								}
								ClientGUI cg = new ClientGUI();
								cg.setVisible(true);
								setVisible(false);
							}
						}
						//회원정보 수정으로 들어와서 정보를 수정함.
						if(select == 2){
							if(getPf().getText().equals("")
									|| getNametf().getText().equals("") || getAgetf().getText().equals("")){
								JOptionPane.showMessageDialog(null, "빈칸을 모두 입력하십시오.", "수정결과", JOptionPane.ERROR_MESSAGE);
							}else if(getPf().getText().length() < 4 || getPf().getText().length() > 21){
								JOptionPane.showMessageDialog(null, "비밀번호는  4~20자리입니다.", "가입결과", JOptionPane.ERROR_MESSAGE);
								return;
							}
							else if(Pattern.matches("^[0-9]+$", getNametf().getText())){
								JOptionPane.showMessageDialog(null, "이름은 문자를 넣어주십시오.", "가입결과", JOptionPane.ERROR_MESSAGE);
								return;
							}
							else if(getAgetf().getText().length() > 4 ){
								JOptionPane.showMessageDialog(null, "나이는 3자리입니다.", "가입결과", JOptionPane.ERROR_MESSAGE);
								return;
							}
							else if(!(Pattern.matches("^[0-9]+$", getAgetf().getText()))){
								JOptionPane.showMessageDialog(null, "나이는 숫자를 넣어주십시오.", "가입결과", JOptionPane.ERROR_MESSAGE);
								return;
							}
							else{
								Human h = null;
								String passWord = getPf().getText();
								String name =  getNametf().getText();
								String age = getAgetf().getText();
								h = new Human("", passWord, name, age, "");
								cm.update(h);
								MainGUI mg = new MainGUI();
								mg.setVisible(true);
								setVisible(false);
							}
						}
					}
					
				}
			});
		}
		return btnNewButton;
	}
    
	//취소를 눌러 clientGUI나 mainGUI로 복귀함.
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("");
			btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\user\\git\\SCIT33go\\Project\\Img\\cancleButton1.png"));
			btnNewButton_1.setFont(new Font("HY수평선M", Font.BOLD, 16));
			btnNewButton_1.setBounds(168, 367, 75, 39);
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (e.getSource() == btnNewButton_1) {
						if (getTitle().equals("회원가입")) {
							ClientGUI cg = new ClientGUI();
							cg.setVisible(true);
							setVisible(false);
						}
						else{
							MainGUI mg = new MainGUI();
							mg.setVisible(true);
							setVisible(false);
						}
					}
				}
			});
		}
		return btnNewButton_1;
	}
}
