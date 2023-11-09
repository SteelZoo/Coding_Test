package baekjoon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static HashSet<Character> chSet = new HashSet<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int count = Integer.parseInt(st.nextToken());
		int answer = 0;
		
		for (int i = 0; i < count; i++) {
			chSet.clear();
			
			boolean isG = true;
			char[] string = br.readLine().toCharArray();
			for (int j = 0; j < string.length-1; j++) {
				if (string[j] != string[j+1] && chSet.contains(string[j+1])) {
					isG = false;
					break;
				}
				chSet.add(string[j]);
			}
			
			if (isG) {
				answer++;
			}
		}
		
		bw.write(Integer.toString(answer));
		bw.flush();
		bw.close();
	}
		
}