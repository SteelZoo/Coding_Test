package bj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class bj_17471 {
	static boolean[] visit;
	static int[] population;
	static int[] party;

	static boolean[][] map;

	static final int TEAM_A = 1;
	static final int TEAM_B = 2;
	
	static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		// 크기 초기화
		st = new StringTokenizer(br.readLine());
		int size = Integer.parseInt(st.nextToken());
		visit = new boolean[size];
		population = new int[size];
		party = new int[size];
		map = new boolean[size][size];
		
		// 인구 배열 초기화
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < size; i++) {
			population[i] = Integer.parseInt(st.nextToken());
		}
		
		// 맵 초기화
		for (int i = 0; i < size; i++) {
			st = new StringTokenizer(br.readLine());
			int visitable = Integer.parseInt(st.nextToken());
			for (int j = 0; j < visitable; j++) {
				int node = Integer.parseInt(st.nextToken());
				map[i][node-1] = true;
			}
		}
		
		
		divRec(0);
		
		if(answer == Integer.MAX_VALUE) answer = -1;
		bw.write(Integer.toString(answer));
		bw.flush();
		bw.close();
	}

	static void divRec(int depth) {
		if (depth >= population.length) {
			if(isDivTwo()) {
				int tempMin = diff();
				if (answer > tempMin) answer = tempMin;
			}
			return;
		}

		party[depth] = TEAM_A;
		divRec(depth + 1);
		party[depth] = TEAM_B;
		divRec(depth + 1);
	}
	
	static boolean isDivTwo() {
		visit = new boolean[visit.length];
		visitCheckBfs(TEAM_A);
		visitCheckBfs(TEAM_B);
		
		return isAllVisit();
	}
	
	static void visitCheckBfs(int team) {
		LinkedList<Integer> q = new LinkedList<Integer>();
		for (int i = 0; i < party.length; i++) {
			if (party[i] == team && !visit[i]) {
				q.add(i);
				visit[i] = true;
				break;
			}
		}
		
		while(!q.isEmpty()) {
			int node = q.poll();
			for (int i = 0; i < map[node].length; i++) {
				if(map[node][i] && party[node] == party[i] && !visit[i] ) {
					q.add(i);
					visit[i] = true;
				}
			}
		}
	}
	
	static boolean isAllVisit() {
		for (int i = 0; i < visit.length; i++) {
			if(!visit[i]) return false; 
		}
		return true;
	}
	
	static int diff() {
		int result = 0;
		
		for (int i = 0; i < party.length; i++) {
			if(party[i] == TEAM_A) result += population[i];
			else result -= population[i];
		}
		
		
		return Math.abs(result);
	}
}
