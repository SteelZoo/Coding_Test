package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static int[] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int target = Integer.parseInt(br.readLine());
		dp = new int[target + 1];

		getBag();
		
		int answer = (dp[target] == 0)? -1 : dp[target];

		bw.write(Integer.toString(answer));
		bw.flush();
		bw.close();
	}

	private static void getBag() {
		if (dp.length > 3) {
			dp[3] = 1;
		} if (dp.length > 5) {
			dp[5] = 1;
		}

		for (int i = 0; i < dp.length; i++) {
			if (dp[i] > 0) {
				if (i + 3 < dp.length) {
					insert(i + 3, dp[i] + 1);
				}
				if (i + 5 < dp.length) {
					insert(i + 5, dp[i] + 1);
				}
			}
		}
	}

	private static void insert(int index, int value) {
		if (dp[index] < 1) {
			dp[index] = value;
		} else {
			dp[index] = min(dp[index], value);
		}
	}

	private static int min(int a, int b) {
		if (a < b) {
			return a;
		}
		return b;
	}
}
