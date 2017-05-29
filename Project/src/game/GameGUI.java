package game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.IOException;
import java.util.Vector;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


import Client.ClientManager;
import GUI.MainGUI;
import VO.Game;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JLabel;


public class GameGUI extends JFrame implements ActionListener, Runnable{

	private static final long serialVersionUID = 1L;
	//창 크기
	private static final int WIDTH = 800;
	private static final int HEIGHT = 800;
	//생명
	private int life = 3;
	//단어 저장
	private Vector<String> words;
	private Vector<Word> viewingwords;
	//쓰레드
	private Thread t;
	private long time;
	//컴포넌트 글자 생성 위치와 글자 색깔
	private DropArea da1;
	//입력 값
	private JTextField t1;
	//점수 값
	private int score = 0;
	private String level = null;
	private ClientManager cm = new ClientManager();
	private int select;
	private JLabel label;
	public GameGUI(int z) throws IOException{
		select = z;
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				MainGUI mg = new MainGUI();
				mg.setVisible(true);
				setVisible(false);
				t.stop();
			}
		});
		switch (select) {
		case 1:
			level = "초급";
		case 2:
			level = "중급";
		case 3:
			level = "고급";
			break;
		}
		words = cm.words(z);
		viewingwords = new Vector<>();
		//JFrame 기본값 설정
		setTitle("산성비");
		//파일 읽기
		da1 = new DropArea();
		da1.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		getContentPane().add(da1, BorderLayout.CENTER);
		t1 = new JTextField(20);
		t1.setFont(new Font("Yu Mincho", Font.PLAIN, 20));
		t1.addActionListener(this);
		getContentPane().add(t1, BorderLayout.SOUTH);

		
		t = new Thread(this);
		//?
		pack();
		setBounds(570, 100, WIDTH, HEIGHT);
		setVisible(true);
		t.start();
	}
	
	class DropArea extends JComponent{
		private static final long serialVersionUID = 1L;

		public void paint(Graphics g){
			//라이프 위치
			Image img = Toolkit.getDefaultToolkit().getImage("Img\\gameImg1.png");
			g.drawImage(img, 0, 0, this);
			String i = "LIFE : ";
			Font font1 = new Font(i, Font.BOLD, 20);
			g.setFont(font1);
			g.drawString(i + life, 10, 30);
			String s = "Score : ";
			Font font2 = new Font(s, Font.BOLD, 20);
			g.setFont(font2);
			g.drawString(s + score, 330, 30);
			for(Word w : viewingwords){
				//글자 색깔?
				g.setColor(Color.BLACK);
				//글자 임의의 장소에 만들기
				Font font3 = new Font(w.str, Font.BOLD, 30);
				g.setFont(font3);
				g.drawString(w.str, w.x, w.y);
			}
		}
	}
	class Word{
		public int x;
		public int y;
		String str;
		
		Word(){
			//떨어뜨려주는 위치값 설정
			if (select == 3){
				x = 600;
			x = (int) Math.abs(((Math.random()* WIDTH) - 200));
			}
			else{
			x = (int) Math.abs(((Math.random()* WIDTH) - 50));
			}
			if(x < 0){
				x = 0;
			}
			y = 0;
			//떨어뜨려주는 단어 설정
			
			str = words.get((int)(Math.random() * words.size()));
		}
	}
	@Override
	//쓰레드
	public void run() {
		double timespeed = 0.03;
		double startspeed = 100.0;
		while(true){
			//속도
			startspeed = startspeed - timespeed;
			try {
				//떨어지는 시간 초기값
				t.sleep((int)startspeed);
			} catch (InterruptedException e) {
				JOptionPane.showMessageDialog(null, "축하합니다. 게임을 끝내셨습니다.", "결과", JOptionPane.INFORMATION_MESSAGE);
				double cheak = time/10.0;
				Game g = new Game("", "", score, cheak, level);
				cm.game(g);
				MainGUI main = new MainGUI();
				main.setVisible(true);
				setVisible(false);
				t.stop();
			}
			//시간 재는 방법
			time++;
			
			//떨어지는 로직
			for(Word w : viewingwords){
				w.y += 10;
			}
			//LIFE가 줄어드는 로직
			if(!viewingwords.isEmpty()){
				if(viewingwords.get(0).y> HEIGHT -50){
					life--;
					viewingwords.remove(0);	
				}
			}
			//게임 종료 로직
			if(life <= 0){
				JOptionPane.showMessageDialog(this, "게임종료(게임시간:" + time/10.0 + "초  점수  : " + score + ")");
				double cheak = time/10.0;
				Game g = new Game("", "", score, cheak, level);
				cm.game(g);
				MainGUI main = new MainGUI();
				main.setVisible(true);
				setVisible(false);
				t.stop();
			}
			int randomWords = (int)(Math.random()*50)+10;
			if(time %  randomWords== 0){
				viewingwords.add(new Word());
			}
			if(startspeed == 10){
				
			}
			repaint();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int index = -1;
		for(Word w : viewingwords){
			if(t1.getText().equals(w.str)){
				index = viewingwords.indexOf(w);
			}
		}
		if(index != -1){
			viewingwords.remove(index);
			score += 100;
			repaint();
		}
		t1.selectAll();
		t1.setText("");
	}
	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("");
		}
		return label;
	}
}
