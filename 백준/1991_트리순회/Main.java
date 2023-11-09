package baekjoon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	private static Map<Character, ArrayList<Character>> tree = new HashMap<>();
	private static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int count = Integer.parseInt(st.nextToken());
		
		//read input, init date
		for (int i = 0; i < count; i++) {
			st = new StringTokenizer(br.readLine());
			char parent = st.nextToken().charAt(0);
			char left = st.nextToken().charAt(0);
			char right = st.nextToken().charAt(0);
			
			ArrayList<Character> children = new ArrayList<>();
			children.add(left);
			children.add(right);
						
			tree.put(parent, children);
		}
		
		
		preO('A');
		sb.append('\n');
		inO('A');
		sb.append('\n');
		postO('A');
		
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
	
	public static void preO(char parent) {
		char left = tree.get(parent).get(0);
		char right = tree.get(parent).get(1);
		
		sb.append(parent);
		if (left != '.') preO(left);
		if (right != '.') preO(right);
	}
	
	public static void inO(char parent) {
		char left = tree.get(parent).get(0);
		char right = tree.get(parent).get(1);
		
		if (left != '.') inO(left);
		sb.append(parent);
		if (right != '.') inO(right);
	}
	
	public static void postO(char parent) {
		char left = tree.get(parent).get(0);
		char right = tree.get(parent).get(1);
		
		if (left != '.') postO(left);
		if (right != '.') postO(right);
		sb.append(parent);
	}
}
