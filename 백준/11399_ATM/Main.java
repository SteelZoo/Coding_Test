package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] waitArray;
	static int[] totalWaitArray;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int length = Integer.parseInt(br.readLine());
		waitArray = new int[length];
		totalWaitArray = new int[length];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < length; i++) {
			waitArray[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(waitArray);

		for (int i = 0; i < length; i++) {
			if (i==0) {
				totalWaitArray[i] = waitArray[i];
			} else {
				totalWaitArray[i] = totalWaitArray[i-1] + waitArray[i];
			}
		}
		
		int answer = 0;
		for (int time : totalWaitArray) {
			answer+=time;
		}
		
		bw.write(Integer.toString(answer));
		bw.flush();
		bw.close();
	}
}

/**
 * 
 * 1 2 3 3 4 
 * 
 * 1 3 6 9 13
 * 
 * 1 4 10 19 32
 * 
 */