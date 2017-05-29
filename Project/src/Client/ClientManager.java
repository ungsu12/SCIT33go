package Client;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Vector;

import VO.Human;
import VO.Dictionary;
import VO.Game;
import VO.Grade;
import impl.Clientimpl;

public class ClientManager implements Clientimpl, Serializable{
	
	private static final long serialVersionUID = 1L;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	private Socket socket;
	
	
	public ClientManager() {
		try {
			socket = new Socket("localhost", 10000);
		} catch (IOException e) {
			e.printStackTrace();
		}
			try {
				ois = new ObjectInputStream(socket.getInputStream());
				oos = new ObjectOutputStream(socket.getOutputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	
	public Object send(Object[] request){
		try {
			oos.writeObject(request);
		} catch (IOException e) {
			e.printStackTrace();
		}
		Object response = null;
		try {
			response = ois.readObject();
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		return response;
	}

	@Override
	public int login(Human h) {
		Object[] request = {"login", h};
		return (int)this.send(request);
	}

	@Override
	public int insert(Human h) {
		Object[] request = {"insert", h};
		return (int)this.send(request);
	}

	@Override
	public int update(Human h) {
		Object[] request = {"update",h};
		return (int)this.send(request);
	}

	@Override
	public int result(Grade g) {
		Object[] request = {"result",g};
		return (int)this.send(request);
	}

	@Override
	public ArrayList<Grade> record() {
		Object[] request = {"record"};
		return (ArrayList<Grade>)this.send(request);
	}

	@Override
	public int delete() {
		Object[] request = {"delete"};
		return (int)this.send(request);
	}

	@Override
	public byte[] img(int x) {
		Object[] request = {"img", x};
		return (byte[])this.send(request);
	}

	@Override
	public ArrayList<Dictionary> test(int x) {
		Object[] request = {"test", x};
		return (ArrayList<Dictionary>)this.send(request);
	}

	@Override
	public byte[] sound(int x) {
		Object[] request = {"sound", x};
		return (byte[])this.send(request);
	}

	@Override
	public int game(Game g) {
		Object[] request = {"game", g};
		return (int)this.send(request);
	}

	@Override
	public Vector<String> words(int x) {
		Object[] request = {"words", x};
		return (Vector<String>)this.send(request);
	}

	@Override
	public ArrayList<Game> gameRecord() {
		Object[] request = {"gameRecord"};
		return (ArrayList<Game>)this.send(request);
	}
}
