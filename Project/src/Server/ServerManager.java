package Server;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import VO.Human;
import VO.Dictionary;
import VO.Game;
import VO.Grade;
import connection.ConnectionManager;

public class ServerManager implements Serializable{

	private static final long serialVersionUID = 1L;
	private Connection conn = null;
	private PreparedStatement pstmt1 = null;
	private PreparedStatement pstmt2 = null;
	private PreparedStatement pstmt3 = null;
	
	public Human login(Human h){
		conn = ConnectionManager.getConnection();
		String query1 = "Select id, password from HUMAN";
		String id = "";
		String password = "";
		try {
			pstmt1 = conn.prepareStatement(query1);
			ResultSet rs = pstmt1.executeQuery();
			while(rs.next()){
				if(h.getId().equals(rs.getString(1)) && h.getPassWord().equals(rs.getString(2)))
				{
					id = rs.getString(1);
					password = rs.getString(2);
					if(rs != null)rs.close();
					if(pstmt1 != null)pstmt1.close();
					break;
				}
			}
			if(id.equals("") || password.equals(""))return null;
			Human h1 = new Human(id, password, "", "", "");
			return h1;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	//회원정보를 데이터베이스에 저장
	public int insert(Human h){
		String query = "Insert into HUMAN values(? , ?, ?, ?, ?)";
		conn = ConnectionManager.getConnection();
		try {
			pstmt1 = conn.prepareStatement(query);
			pstmt1.setString(1, h.getId());
			pstmt1.setString(2, h.getPassWord());
			pstmt1.setString(3, h.getName());
			pstmt1.setInt(4, Integer.parseInt(h.getAge()));
			pstmt1.setInt(5, Integer.parseInt(h.getGender()));
			int i = pstmt1.executeUpdate();
			if(pstmt1 != null) pstmt1.close();
			if(conn != null) conn.close();
			return i;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	//회원정보를 수정
	public int update(Human h){
		String query2 = "Update HUMAN set password = ?, name = ?, age = ? where id = ?";
		conn = ConnectionManager.getConnection();
		try {
			pstmt2 = conn.prepareStatement(query2);
			pstmt2.setString(1, h.getPassWord());
			pstmt2.setString(2, h.getName());
			pstmt2.setString(3, h.getAge());
			pstmt2.setString(4, h.getId());
			int i = pstmt2.executeUpdate();
			if(pstmt2 != null)pstmt2.close();
			if(conn != null)conn.close();
			return i;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	//시험 문제 출제
	public ArrayList<Dictionary> test(int x){
		ArrayList<Dictionary> dic = new ArrayList<>();
		int seq;
		String mean;
		String word;
		String query = null;
			switch (x) {
			case 1:
				query = "SELECT * FROM BEGINNER";
				break;
			case 2:
				query = "SELECT * FROM INTERMEDIATE";
				break;
			case 3:
				query = "SELECT * FROM ADVANCED";
				break;
			}
		conn = ConnectionManager.getConnection();
		try {
			pstmt1 = conn.prepareStatement(query);
			ResultSet rs = pstmt1.executeQuery();
			while(rs.next()){
				seq = rs.getInt(1);
				mean = rs.getString(2);
				word = rs.getString(3);
				Dictionary dic1 = new Dictionary(seq, mean, word);
				dic.add(dic1);
			}
			rs.close();
			pstmt1.close();
			conn.close();	
		}catch (SQLException e) {
		}
		return dic;
	}
	
	//평가 기록 저장
	public int result(Grade g){
		String query2 = "Insert into grade Values (?, sysdate, ?, ?)";
		conn = ConnectionManager.getConnection();
			try {
				pstmt2 = conn.prepareStatement(query2);
				pstmt2.setString(1, g.getId());
				pstmt2.setInt(2, g.getScore());
				pstmt2.setString(3, g.getLevel());
				int i = pstmt2.executeUpdate();
				if(pstmt2 != null)pstmt2.close();
				if(conn != null)conn.close();
				return i;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return 0;
	}
	
	//기록 출력 시
	public ArrayList<Grade> record(){
		Grade g = null;
		ArrayList<Grade> gList = new ArrayList<>();
		String query = "select * from GRADE ORDER BY HIREDATE";
		conn = ConnectionManager.getConnection();
			try {
				pstmt1 = conn.prepareStatement(query);
				ResultSet rs = pstmt1.executeQuery();
				while(rs.next()){
					String id = rs.getString(1);
					String date = rs.getString(2);
					int score = rs.getInt(3);
					String level = rs.getString(4);
					g = new Grade(id, date, score, level);
					gList.add(g);
				}
					if(rs != null)rs.close();
					if(pstmt1 != null)pstmt1.close();
					if(conn != null)conn.close();
					return gList;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
	}
	
	//게임 기록 출력 시
	public ArrayList<Game> gameRecord(){
		Game g = null;
		ArrayList<Game> gList = new ArrayList<>();
		String query = "select * from RESULT ORDER BY HIREDATE";
		conn = ConnectionManager.getConnection();
			try {
				pstmt1 = conn.prepareStatement(query);
				ResultSet rs = pstmt1.executeQuery();
				while(rs.next()){
					String id = rs.getString(1);
					String date = rs.getString(2);
					int score = rs.getInt(3);
					double time = rs.getDouble(4);
					String level = rs.getString(5);
					g = new Game(id, date, score, time, level);
					gList.add(g);
				}
					if(rs != null)rs.close();
					if(pstmt1 != null)pstmt1.close();
					if(conn != null)conn.close();
					return gList;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
	}
	
	//탈퇴 
	public int delete(String id){
		String query1 = "delete from HUMAN where ID = ?";
		conn = ConnectionManager.getConnection();
		try {
			pstmt2 = conn.prepareStatement(query1);
			pstmt2.setString(1, id);
			int i = pstmt2.executeUpdate();
			if (pstmt2 != null)pstmt2.close();
			if (conn != null)conn.close();
			return i;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	//이미지 변경시켜주기
	public byte[] img(int x){
		byte[] bytes = null;
		conn = ConnectionManager.getConnection();
		String query = "SELECT * FROM IMAGESOUND WHERE seq = ?";
		try {
			pstmt1 = conn.prepareStatement(query);
			pstmt1.setInt(1, x);
			ResultSet rs = pstmt1.executeQuery();
			while (rs.next()) {
				// 바이너리 데이터를 저장하고 있는 컬럼으로부터 데이터를 가져온다
			bytes = rs.getBytes(2);
		} 
			rs.close();
			pstmt1.close();
			conn.close();
		}
			
			catch (SQLException e) {
			e.printStackTrace();
		}
		return bytes;
		}
	//사운드
	public byte[] sound(int x){
		byte[] bytes = null;
		conn = ConnectionManager.getConnection();
		String query = "SELECT * FROM IMAGESOUND WHERE seq = ?";
		try {
			pstmt1 = conn.prepareStatement(query);
			pstmt1.setInt(1, x);
			ResultSet rs = pstmt1.executeQuery();
			while (rs.next()) {
				// 바이너리 데이터를 저장하고 있는 컬럼으로부터 데이터를 가져온다
			bytes = rs.getBytes(3);
		} 
			rs.close();
			pstmt1.close();
			conn.close();
		}
			
			catch (SQLException e) {
			e.printStackTrace();
		}
		return bytes;
		}
	
	public int game(Game g){
		String query2 = "Insert into RESULT values(?, sysdate, ?, ?, ?)";
		conn = ConnectionManager.getConnection();
		try {
			pstmt2 = conn.prepareStatement(query2);
			pstmt2.setString(1, g.getId());
			pstmt2.setInt(2, g.getScore());
			pstmt2.setDouble(3, g.getTime());
			pstmt2.setString(4, g.getLevel());
			int i = pstmt2.executeUpdate();
			if(pstmt2 != null)pstmt2.close();
			if(conn != null)conn.close();
			return i;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	public Vector<String> words (int x){
		Vector<String> words = new Vector<>();
		String query1 = "SELECT * FROM BEGINNER";
		String query2 = "SELECT * FROM INTERMEDIATE";
		String query3 = "SELECT * FROM ADVANCED";
		conn = ConnectionManager.getConnection();
		if (x == 1) {
			try {
				pstmt1 = conn.prepareStatement(query1);
				ResultSet rs = pstmt1.executeQuery();
				while(rs.next()){
					words.add(rs.getString(3));
				}
				if(rs != null)rs.close();
				if(pstmt1 != null)pstmt1.close();
				if(conn != null)conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(x == 2){
			try {
				pstmt2 = conn.prepareStatement(query2);
				ResultSet rs = pstmt2.executeQuery();
				while(rs.next()){
					words.add(rs.getString(3));
				}
				if(rs != null)rs.close();
				if(pstmt2 != null)pstmt2.close();
				if(conn != null)conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		if(x == 3){
			try {
				pstmt3 = conn.prepareStatement(query3);
				ResultSet rs = pstmt3.executeQuery();
				while(rs.next()){
					words.add(rs.getString(3));
				}
				if(rs != null)rs.close();
				if(pstmt3 != null)pstmt3.close();
				if(conn != null)conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return words;
	}
	}


