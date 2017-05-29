package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.sun.media.sound.WaveFileWriter;

import Client.ClientManager;
import sun.audio.AudioData;
import sun.audio.AudioDataStream;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import javax.swing.JLabel;
import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JEditorPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JProgressBar;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;

public class ScreenGUI extends JFrame implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private BufferedImage image;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JButton btnNewButton;
	private JProgressBar progressBar;
	private JButton btnNewButton_1;
	private JButton button;
	private JPanel panel;
	private JLabel lblNewLabel_1;
	private int selectImg = 1;
	private ClientManager cm = new ClientManager();
	private int select;
	private int selectSound = 1;
	private JButton button_1;
	private JLabel lblNewLabel_2;
	ImageIcon image1 = new ImageIcon("Img\\kodomo21.jpg");
    private int progressNext1 = 0;
    private int progressNext2 = 0;
    private int progressNext3 = 0;
	
	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { ScreenGUI frame = new ScreenGUI();
	 * frame.setVisible(true); } catch (Exception e) { e.printStackTrace(); } }
	 * }); }
	 */

	/**
	 * Create the frame.
	 */
    //screenGUI 시작
	public ScreenGUI(int x) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("Img\\mark.PNG"));
		setResizable(false);
			select = x;
			if(select == 3){
				selectSound = 47;
			}
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
		setTitle("_학습");
		/* setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); */
		setBounds(100, 100, 983, 604);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getProgressBar());
		contentPane.add(getLblNewLabel());
		contentPane.add(getBtnNewButton_1());
		contentPane.add(getButton());
		contentPane.add(getBtnNewButton());
		contentPane.add(getPanel());
		contentPane.add(getButton_1());
		contentPane.add(getLblNewLabel_2());
		setVisible(true);
	}

	//과목 난이도 라벨
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("과목_난이도");
			lblNewLabel.setFont(new Font("굴림", Font.BOLD, 17));
			lblNewLabel.setBounds(754, 17, 209, 39);
		}
		return lblNewLabel;
	}

	// 종료를 누르면 로그인 창으로 복귀함.
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("종료");
			btnNewButton.setFont(new Font("HY수평선M", Font.BOLD, 19));
			btnNewButton.setBounds(787, 503, 180, 56);
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (e.getSource() == btnNewButton) {
						MainGUI mg = new MainGUI();
						mg.setVisible(true);
						setVisible(false);
					}
				}
			});
		}
		return btnNewButton;
	}
    
	//프로그레스바를 나타냄
	private JProgressBar getProgressBar() {
		if (progressBar == null) {
			progressBar = new JProgressBar();
			progressBar.setForeground(new Color(34, 139, 34));
			progressBar.setBounds(36, 23, 268, 33);
			progressBar.setIndeterminate(false);
			progressBar.setMinimum(0);
			if(select == 3){
				progressBar.setMaximum(14);
			}
			else {
				progressBar.setMaximum(45);
			}
			progressBar.setStringPainted(true);
		}
		return progressBar;
	}
    
	//이전을 누르면 전 문제로 돌아감.
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("이전");
			btnNewButton_1.setFont(new Font("HY수평선M", Font.BOLD, 19));
			btnNewButton_1.setBounds(36, 503, 132, 56);
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//초급
					if(e.getSource() == getBtnNewButton_1())
					if(select == 1){
						if(selectImg < 2 ){
							return;
						}
						else{
							selectImg--;
							selectSound--;
						byte[] img = cm.img(selectImg);
						sound(selectSound);
						Image image = Toolkit.getDefaultToolkit().createImage(img);
						Image resizedImage = image.getScaledInstance(lblNewLabel_1.getWidth(), lblNewLabel_1.getHeight(), Image.SCALE_SMOOTH);
						ImageIcon icon = new ImageIcon(resizedImage);
						lblNewLabel_1.setIcon(icon);
						progressNext1--;
						getProgressBar().setValue(progressNext1);
						}
					}
					//중급
					if(select == 2){
						if(selectImg < 48 ){
							return;
						}
						else{
							selectImg--;
							selectSound--;
						byte[] img = cm.img(selectImg);
						sound(selectSound);
						Image image = Toolkit.getDefaultToolkit().createImage(img);
						Image resizedImage = image.getScaledInstance(lblNewLabel_1.getWidth(), lblNewLabel_1.getHeight(), Image.SCALE_SMOOTH);
						ImageIcon icon = new ImageIcon(resizedImage);
						lblNewLabel_1.setIcon(icon);
						progressNext2--;
						getProgressBar().setValue(progressNext2);
						}
					}
					//고급
					if(select == 3){
						if(selectImg < 94 ){
							return;
						}
						else{
							selectImg--;
							selectSound--;
							sound(selectSound);
						byte[] img = cm.img(selectImg);
						Image image = Toolkit.getDefaultToolkit().createImage(img);
						Image resizedImage = image.getScaledInstance(lblNewLabel_1.getWidth(), lblNewLabel_1.getHeight(), Image.SCALE_SMOOTH);
						ImageIcon icon = new ImageIcon(resizedImage);
						lblNewLabel_1.setIcon(icon);
						progressNext3--;
						getProgressBar().setValue(progressNext3);
						}
					}
					
				}
			});
		}
		return btnNewButton_1;
	}
    
	//다음을 누르면 다음 문제로 돌아감.
	private JButton getButton() {
		if (button == null) {
			button = new JButton("다음");
			button.setFont(new Font("HY수평선M", Font.BOLD, 19));
			button.setBounds(182, 503, 132, 56);
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(arg0.getSource() == getButton()){
					
						//초급
						if(select == 1){
							if(selectImg > 45){
								return;
							}
							else{
								selectImg++;
								selectSound++;
								sound(selectSound);
								byte[] img = cm.img(selectImg);
								Image image = Toolkit.getDefaultToolkit().createImage(img);
								Image resizedImage = image.getScaledInstance(lblNewLabel_1.getWidth(), lblNewLabel_1.getHeight(), Image.SCALE_SMOOTH);
								ImageIcon icon = new ImageIcon(resizedImage);
								lblNewLabel_1.setIcon(icon);
								progressNext1++;
								getProgressBar().setValue(progressNext1);
							}
						}
						
					    //중급 	
						if(select == 2){
							if(selectImg > 91){
								return;
							}
							else{
								selectImg++;
								selectSound++;
								sound(selectSound);
								byte[] img = cm.img(selectImg);
								Image image = Toolkit.getDefaultToolkit().createImage(img);
								Image resizedImage = image.getScaledInstance(lblNewLabel_1.getWidth(), lblNewLabel_1.getHeight(), Image.SCALE_SMOOTH);
								ImageIcon icon = new ImageIcon(resizedImage);
								lblNewLabel_1.setIcon(icon);
								progressNext2++;
								getProgressBar().setValue(progressNext2);
							}
						}
						
						//고급
						if(select == 3){
							if(selectImg > 106){
								return;
							}
							else{
								selectImg++;
								selectSound++;
								sound(selectSound);
								byte[] img = cm.img(selectImg);
								Image image = Toolkit.getDefaultToolkit().createImage(img);
								Image resizedImage = image.getScaledInstance(lblNewLabel_1.getWidth(), lblNewLabel_1.getHeight(), Image.SCALE_SMOOTH);
								ImageIcon icon = new ImageIcon(resizedImage);
								lblNewLabel_1.setIcon(icon);
								progressNext3++;
								getProgressBar().setValue(progressNext3);
							}
						}
					}
				}
			});
		}
		return button;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			panel.setBounds(33, 68, 934, 423);
			panel.setLayout(null);
			panel.add(getLblNewLabel_1());
		}
		return panel;
	}
	
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("");
			lblNewLabel_1.setBounds(14, 12, 906, 399);
			if (select == 1) {
				sound(selectSound);
			}
			else if(select == 2){
				selectImg = 47;
				sound(selectSound);
			}
			else if(select == 3){
				selectImg = 93;
				sound(selectSound);
			}
			byte[] img = cm.img(selectImg);
			Image image = Toolkit.getDefaultToolkit().createImage(img);
			Image resizedImage = image.getScaledInstance(lblNewLabel_1.getWidth(), lblNewLabel_1.getHeight(), Image.SCALE_SMOOTH);
			ImageIcon icon = new ImageIcon(resizedImage);
			lblNewLabel_1.setIcon(icon);
		}
		return lblNewLabel_1;
	}
	
	//다시듣기 버튼을 누르면 음악이 다시 재생됨
	private JButton getButton_1() {
		if (button_1 == null) {
			button_1 = new JButton("다시 듣기");
			button_1.setFont(new Font("HY수평선M", Font.BOLD, 19));
			button_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					sound(selectSound);
				}
			});
			button_1.setBounds(328, 503, 132, 56);
		}
		return button_1;
	}
	
	private void sound(int selectSound){
		
		byte[] sound =cm.sound(selectSound);
		AudioData ad = new AudioData(sound);
		AudioDataStream ads = new AudioDataStream(ad);
		AudioStream as = null;
		try {
			as = new AudioStream(ads);
		} catch (IOException e) {
			e.printStackTrace();
		}
		AudioPlayer.player.start(as);
	}
	
	//배경이미지
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("New label");
			lblNewLabel_2.setIcon(image1);
			lblNewLabel_2.setBounds(0, 0, 979, 573);
		}
		return lblNewLabel_2;
	}
}
