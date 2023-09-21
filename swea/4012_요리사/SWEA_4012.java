package swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SWEA_4012 {
	public static int[][] recipe;
	public static boolean[] choose;
	public static int answer;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		
		//case
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			
			int jeryoCount = Integer.parseInt(st.nextToken());
			
			recipe = new int[jeryoCount][jeryoCount];
			choose = new boolean[jeryoCount];
			answer = Integer.MAX_VALUE;
			
			for (int i = 0; i < jeryoCount; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < jeryoCount; j++) {
					recipe[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			chooseHalf(0, 0, 0);
			
			bw.write("#" + test_case + " " + answer + "\n");
		}//case
		bw.flush();
		bw.close();
		
	}
	
	public static void chooseHalf(int depth, int trueCount, int falseCount) {
		if (depth == choose.length) {
			if (trueCount == falseCount) {
				//logic
//				System.err.println(Arrays.toString(choose));
				int temp = getDiffSynergy();
				answer = (answer > temp)? temp : answer;
				
				return;
			}else {
				return;
			}
		}
		
		choose[depth] = true;
		chooseHalf(depth+1, trueCount+1, falseCount);
		choose[depth] = false;
		chooseHalf(depth+1, trueCount, falseCount+1);
	}
	
	public static int getDiffSynergy() {
		int result = 0;
		int[] countArray = new int[choose.length];
		
		for (int i = 0; i < countArray.length; i++) {
			for (int j = 0; j < countArray.length; j++) {
				if (choose[i] == choose[j]) {
					countArray[i] += recipe[i][j];
				}
			}
		}
		
		for (int i = 0; i < countArray.length; i++) {
			if (choose[i] == true) {
				result += countArray[i];
			}
			else if (choose[i] == false) {
				result -= countArray[i];
			}
		}
		
		return Math.abs(result) ;
	}
}
