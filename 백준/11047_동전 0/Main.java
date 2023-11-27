package baekjoon;

import java.io.*;
import java.util.*;

//11047_동전 0
public class Main {
		static int[] coinArray;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 동전 종류, 목표 금액
		int coinArrayCount = Integer.parseInt(st.nextToken());
		int target = Integer.parseInt(st.nextToken());
		coinArray = new int[coinArrayCount];
		
		for(int i = 0; i < coinArrayCount;i++) {
			st = new StringTokenizer(br.readLine());
			
			coinArray[i] = Integer.parseInt(st.nextToken());
		}
		
		
		int answer = 0;
		for(int i = coinArray.length - 1; i >= 0; i--) {
			while((target - coinArray[i]) >= 0){
				target -= coinArray[i];
				answer++;
			}
			if(target == 0) break;
		}
		
		bw.write(Integer.toString(answer));
		bw.flush();
		bw.close();	
	}
}
