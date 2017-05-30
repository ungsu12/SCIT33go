package Server;



import java.io.ByteArrayOutputStream;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import Dictionary.Advanced;
import Dictionary.Beginner;
import Dictionary.Intermediate;
import VO.Dictionary;
import connection.ConnectionManager;
//서버
public class Server {
	private ServerSocket serverSocket;
	private Socket socketServer;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	/*private ObjectInputStream imgOis;
	private ObjectOutputStream imgOos;*/
	private List<Dictionary> bList;
	private List<Dictionary> aList;
	private List<Dictionary> iList;
	private Beginner b = new Beginner();
	private Advanced a = new Advanced();
	private Intermediate i = new Intermediate();
	private Connection conn;
	private PreparedStatement pstmt;
	private String query1 = "DROP TABLE BEGINNER";
	private String query2 = "DROP TABLE ADVANCED";
	private String query3 = "DROP TABLE INTERMEDIATE";
	private String query4 = "DROP TABLE IMAGESOUND";
	private String query5 = "DROP SEQUENCE beginner_seq";
	private String query6 = "DROP SEQUENCE intermediate_seq";
	private String query7 = "DROP SEQUENCE advanced_seq";
	private String query8 = "DROP SEQUENCE imagesound_seq";
	private String query9 = "CREATE table BEGINNER(SEQ number primary key, MEAN varchar2(60), WORD varchar2(10))";
	private String query10 = "CREATE SEQUENCE beginner_seq";
	private String query11= "CREATE table INTERMEDIATE(SEQ number primary key, MEAN varchar2(60), WORD varchar2(10))";
	private String query12 = "CREATE SEQUENCE intermediate_seq";
	private String query13 = "CREATE table ADVANCED(SEQ number primary key, MEAN varchar2(100), WORD varchar2(20))";
	private String query14 = "CREATE SEQUENCE advanced_seq";
	private String query15 = "CREATE table IMAGESOUND(SEQ number primary key, IMAGE blob, SOUND blob)";
	private String query16 = "CREATE SEQUENCE imagesound_seq";
	private String query17 = "INSERT INTO BEGINNER VALUES(beginner_seq.NEXTVAL, ?, ?)";
	private String query18 = "INSERT INTO ADVANCED VALUES(Advanced_seq.NEXTVAL, ?, ?)";
	private String query19 = "INSERT INTO INTERMEDIATE VALUES(intermediate_seq.NEXTVAL, ?, ?)";
	private String query20 = "INSERT INTO IMAGESOUND VALUES(imagesound_seq.NEXTVAL, ?, ?)";
	
	public Server() {
		this.dataSave();
		try {
			
			System.out.println("서버 생성중");
			serverSocket = new ServerSocket(10000);
			System.out.println("서버 생성완료");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		while(true){
			System.out.println("서버 대기중...");
			try {
				socketServer = serverSocket.accept();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				oos = new ObjectOutputStream(socketServer.getOutputStream());
				ois = new ObjectInputStream(socketServer.getInputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
				
			Thread tr = new Thread(new ServerThread(oos, ois));
			tr.start();
		}
	}
	public static void main(String[] args) {
		new Server();
	}
	//이미지 바이너리코드로 만듬
	public void dataSave(){
		ArrayList<byte[]> imgbufIndex = new ArrayList<>();
		byte[] imgbuf = null;
		for (int j = 1; j < 108; j++) {
			File file = new File("../Project/Img/img" + j + ".PNG");
			FileInputStream in;
			try {
				in = new FileInputStream(file);
				ByteArrayOutputStream bout = new ByteArrayOutputStream();
				byte[] by = new byte[(int)file.length()];
				int len = 0;
				while( (len=in.read(by)) != -1)
					bout.write(by, 0, len);
				imgbuf = bout.toByteArray();
				bout.close();
				imgbufIndex.add(imgbuf);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		//사운드 바이너리코드로 만듬
		ArrayList<byte[]> soundbufIndex = new ArrayList<>();
		byte[] soundbuf = null;
		for (int j = 1; j < 63; j++) {
			File file = new File("../Project/Sound/sound" + j + ".wav");
			FileInputStream in;
			try {
				in = new FileInputStream(file);
				ByteArrayOutputStream bout = new ByteArrayOutputStream();
				byte[] by = new byte[(int)file.length()];
				int len = 0;
				while( (len=in.read(by)) != -1)
					bout.write(by, 0, len);
				soundbuf = bout.toByteArray();
				bout.close();
				soundbufIndex.add(soundbuf);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		
		bList = b.result();
		aList = a.result();
		iList = i.result();



		
		conn = ConnectionManager.getConnection();
		try {
			pstmt = conn.prepareStatement(query1);
			pstmt.executeUpdate();
			if(pstmt != null)pstmt.close();
			pstmt = conn.prepareStatement(query2);
			pstmt.executeUpdate();
			if(pstmt != null)pstmt.close();
			pstmt = conn.prepareStatement(query3);
			pstmt.executeUpdate();
			if(pstmt != null)pstmt.close();
			pstmt = conn.prepareStatement(query4);
			pstmt.executeUpdate();
			if(pstmt != null)pstmt.close();
			pstmt = conn.prepareStatement(query5);
			pstmt.executeUpdate();
			if(pstmt != null)pstmt.close();
			pstmt = conn.prepareStatement(query6);
			pstmt.executeUpdate();
			if(pstmt != null)pstmt.close();
			pstmt = conn.prepareStatement(query7);
			pstmt.executeUpdate();
			if(pstmt != null)pstmt.close();
			pstmt = conn.prepareStatement(query8);
			pstmt.executeUpdate();
			if(pstmt != null)pstmt.close();
			pstmt = conn.prepareStatement(query9);
			pstmt.executeUpdate();
			if(pstmt != null)pstmt.close();
			pstmt = conn.prepareStatement(query10);
			pstmt.executeUpdate();
			if(pstmt != null)pstmt.close();
			pstmt = conn.prepareStatement(query11);
			pstmt.executeUpdate();
			if(pstmt != null)pstmt.close();
			pstmt = conn.prepareStatement(query12);
			pstmt.executeUpdate();
			if(pstmt != null)pstmt.close();
			pstmt = conn.prepareStatement(query13);
			pstmt.executeUpdate();
			if(pstmt != null)pstmt.close();
			pstmt = conn.prepareStatement(query14);
			pstmt.executeUpdate();
			if(pstmt != null)pstmt.close();
			pstmt = conn.prepareStatement(query15);
			pstmt.executeUpdate();
			if(pstmt != null)pstmt.close();
			pstmt = conn.prepareStatement(query16);
			pstmt.executeUpdate();
			if(pstmt != null)pstmt.close();
			for (int i = 0; i < bList.size(); i++) {
				pstmt = conn.prepareStatement(query17);
				pstmt.setString(1, bList.get(i).getMean());
				pstmt.setString(2, bList.get(i).getWord());
				pstmt.executeUpdate();
				if(pstmt != null)pstmt.close();
			}
			for (int i = 0; i < aList.size(); i++) {
				pstmt = conn.prepareStatement(query18);
				pstmt.setString(1, aList.get(i).getMean());
				pstmt.setString(2, aList.get(i).getWord());
				pstmt.executeUpdate();
				if(pstmt != null)pstmt.close();
			}
			for (int i = 0; i < iList.size(); i++) {
				pstmt = conn.prepareStatement(query19);
				pstmt.setString(1, iList.get(i).getMean());
				pstmt.setString(2, iList.get(i).getWord());
				pstmt.executeUpdate();
				if(pstmt != null)pstmt.close();
			}
			for (int i = 0; i < 107; i++) {
				pstmt = conn.prepareStatement(query20);
				pstmt.setBytes(1, imgbufIndex.get(i));
				if(i < 62){
				pstmt.setBytes(2, soundbufIndex.get(i));
				}
				else{
					pstmt.setString(2, null);
				}
				pstmt.executeUpdate();
				if(pstmt != null)pstmt.close();
			}
			if(conn != null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
