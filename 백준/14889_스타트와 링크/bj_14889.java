package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class bj_14889 {
	static int[][] powerMap;
	static int answer = Integer.MAX_VALUE;
	static LinkedList<Integer> trueTeam = new LinkedList<>();
	static LinkedList<Integer> falseTeam = new LinkedList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int size = Integer.parseInt(br.readLine());

		powerMap = new int[size][size];
		for (int i = 0; i < size; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < size; j++) {
				powerMap[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		checkRec(0);

		bw.write(Integer.toString(answer));
		bw.flush();
		bw.close();

	}

	public static void checkRec(int depth) {
		if (depth >= powerMap.length) {
			if (trueTeam.size() == falseTeam.size()) {
				int tempGap = Math.abs(checkTeamPower(false) - checkTeamPower(true));
				if (answer > tempGap)
					answer = tempGap;
			}
			return;
		}

		// true 팀 넣기
		trueTeam.add(depth);
		checkRec(depth + 1);
		trueTeam.removeLast();

		// false 팀 넣기
		falseTeam.add(depth);
		checkRec(depth + 1);
		falseTeam.removeLast();

		return;
	}

	public static int checkTeamPower(boolean flag) {
		int result = 0;
		if (flag) {
			for (int i = 0; i < trueTeam.size() - 1; i++) {
				for (int j = i + 1; j < trueTeam.size(); j++) {
					int a = trueTeam.get(i);
					int b = trueTeam.get(j);
					result += powerMap[a][b];
					result += powerMap[b][a];
				}
			}
		} else {
			for (int i = 0; i < falseTeam.size() - 1; i++) {
				for (int j = i + 1; j < falseTeam.size(); j++) {
					int a = falseTeam.get(i);
					int b = falseTeam.get(j);
					result += powerMap[a][b];
					result += powerMap[b][a];
				}
			}
		}
		return result;
	}

}
