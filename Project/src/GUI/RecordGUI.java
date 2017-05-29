package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Client.ClientManager;
import VO.Game;
import VO.Grade;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JEditorPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.Toolkit;
import javax.swing.JLabel;

public class RecordGUI extends JFrame {

	private JPanel contentPane;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton button;
	private ClientManager cm = new ClientManager();
	private ArrayList<Grade> gList = new ArrayList<>();
	private ArrayList<Game> ggList = new ArrayList<>();
	private JPanel panel;
	private JScrollPane scrollPane;
	private DefaultListModel<Grade> gDlm;
	private DefaultListModel<Game> ggDlm;
	private JList<Grade> gradeList;
	private JList<Game> gameList;
	ImageIcon image1 = new ImageIcon("Img\\kodomo24.jpg");
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RecordGUI frame = new RecordGUI();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	
	//redcordGUI 시작 
	public RecordGUI() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("Img\\mark.PNG"));
		setResizable(false);
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
		setTitle("기록");
		setBounds(100, 100, 836, 745);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getBtnNewButton());
		contentPane.add(getBtnNewButton_1());
		contentPane.add(getButton());
		contentPane.add(getPanel());
		
		//배경이미지
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 830, 712);
		lblNewLabel.setIcon(new ImageIcon("Img\\kodomo28.jpg"));
		contentPane.add(lblNewLabel);
		setVisible(true);
	}
	
	//나가기를 눌렀을 경우 메인GUI로 복귀함.
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("");
			btnNewButton.setIcon(new ImageIcon("Img\\pygEndButton1.png"));
			btnNewButton.setFont(new Font("HY수평선M", Font.BOLD, 19));
			btnNewButton.setBounds(667, 628, 120, 58);
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				  if(e.getSource() == btnNewButton){
					  MainGUI mg = new MainGUI();
					  mg.setVisible(true);
					  setVisible(false);
				  }
				}
					  
			});
		}
		return btnNewButton;
	}
	//평가기록 버튼 눌렀을 때
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("");
			btnNewButton_1.setIcon(new ImageIcon("Img\\pygRecordButton1.png"));
			btnNewButton_1.setFont(new Font("HY수평선M", Font.BOLD, 19));
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(e.getSource() == btnNewButton_1){
						scrollPane.setViewportView(getList());
						gDlm.removeAllElements();
						gradeList.removeAll();
						showList();
					}
				}
			});
			btnNewButton_1.setBounds(24, 628, 129, 58);
		}
		return btnNewButton_1;
	}
	
	//게임기록 버튼 눌렀을 때 게임기록을 보여줌
	private JButton getButton() {
		if (button == null) {
			button = new JButton("");
			button.setIcon(new ImageIcon("Img\\gameRecordButton1.png"));
			button.setFont(new Font("HY수평선M", Font.BOLD, 19));
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(e.getSource() == button){
						scrollPane.setViewportView(gameGetList());
						ggDlm.removeAllElements();
						gameList.removeAll();
						gameShowList();
					}
				}
			});
			button.setBounds(180, 628, 129, 57);
		}
		return button;
	}
	
	//
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBounds(24, 12, 780, 604);
			panel.setLayout(new BorderLayout(0, 0));
			panel.add(getScrollPane_1());
		}
		return panel;
	}
	
	
	private JScrollPane getScrollPane_1() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setViewportView(gameGetList());
		}
		return scrollPane;
	}
	
	//성적리스트를 받아옴
	private JList<Grade> getList() {
		if (gradeList == null) {
			gradeList = new JList<>();
			gDlm = new DefaultListModel<>();
			Font font = new Font("Bold", Font.PLAIN, 22);
			gradeList.setFont(font);
			gradeList.setModel(gDlm);
		}
		return gradeList;
	}
	
	//게임기록 리스트를 받아옴
	private JList<Game> gameGetList() {
		if (gameList == null) {
			gameList = new JList<>();
			ggDlm = new DefaultListModel<>();
			Font font = new Font("Bold", Font.PLAIN, 18);
			gameList.setFont(font);
			gameList.setModel(ggDlm);
		}
		return gameList;
	}
	
	//성적을 보여줌
	private void showList(){
		gList = cm.record();
		gDlm.removeAllElements();
		for (Grade grade : gList) {
			gDlm.addElement(grade);
		}
	}
	
	//게임을 보여줌
	private void gameShowList(){
		ggList = cm.gameRecord();
		ggDlm.removeAllElements();
		for (Game game : ggList) {
			ggDlm.addElement(game);
		}
	}
}
