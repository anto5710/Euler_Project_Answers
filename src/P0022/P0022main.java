package P0022;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
/**
 * "XXXX" = s.substring(1, s.length()-1)
 * "CCCC"
 * "CCCC"
 * "CCCC"
 * 
 * list를 정렬하는 법을 API에서 찾아야 합니다.
 * 
 * @author anto5710
 *
 */

public class P0022main {
	static String [] tokens = {"", "A", "B", "C", "D", "Z"};
	// tokens[idx];
	
	static ArrayList<String>names = new ArrayList<>();
	static HashMap<String, Integer>score= new HashMap<>();
	long Total = 0;
	static File file ;
	
	public static void main(String[] args) {
		put_Map();
		try {
			getNames();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Alphabetically_Sort(names);
		System.out.println(names.toString());
		System.out.println(names.size());
		System.out.println(getScores());
	}
	private static void put_Map() {
		score.put("A", 1);
		score.put("B", 2);
		score.put("C", 3);
		score.put("D", 4);
		score.put("E", 5);
		score.put("F", 6);
		score.put("G", 7);
		score.put("H", 8);
		score.put("I", 9);
		score.put("J", 10);
		score.put("K", 11);
		score.put("L", 12);
		score.put("M", 13);
		score.put("N", 14);
		score.put("O", 15);
		score.put("P", 16);
		score.put("Q", 17);
		score.put("R", 18);
		score.put("S", 19);
		score.put("T", 20);
		score.put("U", 21);
		score.put("V", 22);
		score.put("W", 23);
		score.put("X", 24);
		score.put("Y", 25);
		score.put("Z", 26);	
	}
	private static long getScores() {
		long total = 0;
		for(int index = 0; index <names.size() ; index++){
			String name = names.get(index);
			int score =getScore(name);
			total +=score*(index+1);
		}
		return total;
	}
	private static int getScore(String name) {
		int totalScore = 0;
		for(int index = 0; index < name.length() ; index++){
			String string = name.charAt(index)+"";
			string.toUpperCase();
			int Score =score.get(string);
			totalScore+=Score;
		}
		return totalScore;
	}
	public static List<String>Alphabetically_Sort( List<String>list){
		 java.util.Collections.sort(list);
		return  list;
	}
	private static void getNames() throws FileNotFoundException {
//		file = new File("names.txt");
		InputStream in = P0022main.class.getResourceAsStream("names.txt");
		
//		System.out.println("file: " + file.getAbsolutePath());
		Scanner scanner = new Scanner( in );
		scanner.useDelimiter(",");
		
		while ( scanner.hasNext()) {
			String name = scanner.next(); 
			name = name.substring(1, name.length()-1);
			names.add(name);
		}
		scanner.close();
	}

}
