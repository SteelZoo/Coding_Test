package swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

class Solution {
	static int[][] map = new int[100][100];
	static Stack<Integer> countStack = new Stack<>();
	
	public static void main(String args[]) throws Exception {
//		 System.setIn(new FileInputStream("src/swea/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		/*
		 * 표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
		Scanner sc = new Scanner(System.in);
		int T = 10;

		for (int test_case = 1; test_case <= T; test_case++) {
			int answer = 0;
			
			//init map
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < map.length; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < map.length; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int i = 0; i < map.length; i++) {
				answer += countDistruptOneCol(i);
			}
			
			bw.write("#" + test_case + " " + answer + "\n");
			
		}
		bw.flush();
		bw.close();
	}
	
	public static int countDistruptOneCol(int colNum) {
		int result = 0;
		
		for (int i = 0; i < map[colNum].length; i++) {
			if (map[i][colNum] == 1 && countStack.isEmpty()) {
				countStack.push(1);
			} else if (map[i][colNum] == 2 && !countStack.isEmpty()) {
				countStack.pop();
				result++;
			}
		}
		
		countStack.clear();
		
		return result;
	}
}