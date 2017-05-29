package Server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.SocketException;
import java.util.ArrayList;

import VO.Human;
import VO.Dictionary;
import VO.Game;
import VO.Grade;

public class serverThread implements Runnable, Serializable{
	private static final long serialVersionUID = 1L;
	private ObjectOutputStream oos;
	private ObjectInputStream ois;
	private Object[] request;
	private Object response;
	private String cmd;
	public serverThread(ObjectOutputStream oos, ObjectInputStream ois) {
		this.oos = oos;
		this.ois = ois;
	}
	//쓰레드
	@Override
	public void run() {
		while(true){
			response = null;
			request = null;
			try {
				request = (Object[])ois.readObject();
			}catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			catch (SocketException e) {
				System.out.println("접속해제");
				System.out.println("접속대기중...");
			}
			catch (IOException e) {
				e.printStackTrace();
			}
			try{
			cmd = (String)request[0];
			}
			catch (NullPointerException e) {
				break;
			}
				ServerManager sm  = new ServerManager();
				
				switch (cmd) {
				case "login":
					response = sm.login((Human)request[1]);
					break;
				case "insert":
					response = sm.insert((Human)request[1]);
					break;
				case "update":
					response = sm.update((Human)request[1]);
					break;
				case "delete":
					response = sm.delete();
					break;
				case "record":
					response = sm.record();
					break;
				case "result":
					response = sm.result((Grade)request[1]);
					break;
				case "img":
					response = sm.img((int)request[1]);
					break;
				case "sound":
					response = sm.sound((int)request[1]);
					break;
				case "test":
					response = sm.test((int)request[1]);
					break;
				case "game":
					response = sm.game((Game)request[1]);
					break;
				case "words":
					response = sm.words((int)request[1]);
					break;
				case "gameRecord":
					response = sm.gameRecord();
				}
				try {
					oos.writeObject(response);
					oos.reset();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}
	
}
