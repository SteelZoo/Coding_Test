package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int count = 0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int count = Integer.parseInt(st.nextToken());
		char[] gwalArray;
		
		for (int i = 0; i < count; i++) {
			gwalArray = br.readLine().toCharArray();
			
			if (isVPS(gwalArray)) {
				sb.append("YES\n");
			} else {
				sb.append("NO\n");
			}
		}
		
	

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
	static boolean isVPS(char[] array) {
		count = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == '(') {
				count++;
			} else if (array[i] == ')') {
				if (count == 0) {
					return false;
				}
				count--;
			}
		}
		if (count == 0) {
			return true;
		} else {
			return false;
		}
	}

}
