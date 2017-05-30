package impl;

import java.util.ArrayList;
import java.util.Vector;

import VO.Human;
import VO.Dictionary;
import VO.Game;
import VO.Grade;

public interface Clientimpl {
	public Human login(Human h);
	public int insert(Human h);
	public int update(Human h);
	public int result(Grade g);
	public ArrayList<Grade> record();
	public ArrayList<Game> gameRecord();
	public int delete(String id);
	public byte[] img(int x);
	public byte[] sound(int x);
	public ArrayList<Dictionary> test(int x);
	public int game(Game g);
	public Vector<String> words(int x);
}
