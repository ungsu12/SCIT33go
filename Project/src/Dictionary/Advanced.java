package Dictionary;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import VO.Dictionary;

public class Advanced {
	private BufferedReader br;
	private String[] result = new String[1];
	private List<Dictionary> aList = new ArrayList<>();
	public Advanced() {
		String temp = null;
		try {
			br = new BufferedReader(new FileReader("advanced.txt"));
			while(true){
				temp = br.readLine();
				if(temp == null){
					break;
				}
				result = temp.split("#");
				Dictionary d = new Dictionary(result[0], result[1]);
				aList.add(d);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public List<Dictionary> result(){
		return aList;
	}
}
