package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class bj_3190 {
	static int mapsize;
	static int[][] map;
	static int[][] dxdy = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
	static int dxdyNum = 0;
	static LinkedList<Rotate> rq = new LinkedList<Rotate>();
	static Deque<int[]> snakePosition = new LinkedList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 맵 초기화
		StringTokenizer st = new StringTokenizer(br.readLine());
		mapsize = Integer.parseInt(st.nextToken()); // 맵 크기
		map = new int[mapsize][mapsize];

		// 사과 배치
		st = new StringTokenizer(br.readLine());
		int countApple = Integer.parseInt(st.nextToken());
		for (int i = 0; i < countApple; i++) {
			st = new StringTokenizer(br.readLine());
			int row = Integer.parseInt(st.nextToken());
			int col = Integer.parseInt(st.nextToken());

			map[row - 1][col - 1] = 1;
		}

		// 회전 초기화
		int rotateCount = Integer.parseInt(br.readLine());
		for (int i = 0; i < rotateCount; i++) {
			st = new StringTokenizer(br.readLine());
			int time = Integer.parseInt(st.nextToken());
			char dir = st.nextToken().charAt(0);
			rq.add(new Rotate(time, dir));
		}

		// 첫 뱀 위치
		map[0][0] = 2;
		snakePosition.add(new int[]{0,0});
		
		//풀이
		int answer = 1;
		int max = mapsize*mapsize;
		for (; answer <= max; answer++) {
			if(!countTime(answer)) break;
		}
		
		bw.write(Integer.toString(answer));
		bw.flush();
		bw.close();
	}

	// 1초
	static boolean countTime(int count) {
		int[] head = snakePosition.getFirst();
		int[] forehead = {head[0]+dxdy[dxdyNum][0],head[1]+dxdy[dxdyNum][1]};
		
		if (!isCanGo(forehead[0], forehead[1])) return false; // 진행 불가 판단
		
		boolean isAdd = false;
		if (map[forehead[0]][forehead[1]] == 1) {
			isAdd = true;
		}
		setSnakePosition(forehead[0], forehead[1], isAdd);
		
		if (!rq.isEmpty()) {
			if(rq.getFirst().time == count) {
				changeDxdy(rq.removeFirst());
			}
		}
		return true;
	}
	
	static boolean isCanGo(int row, int col) {
		if(row >= mapsize || col >= mapsize || row < 0 || col < 0) return false;
		if (map[row][col] == 2) return false;
		return true;
	}

	static void setSnakePosition(int row, int col, boolean isAdd) {
		snakePosition.addFirst(new int[] { row, col });
		map[row][col] = 2;
		if (!isAdd) {
			int[] position = snakePosition.removeLast();
			map[position[0]][position[1]] = 0;
		}
	}
	
	static void changeDxdy(Rotate r) {
		dxdyNum += r.dir;
		if (dxdyNum < 0) {
			dxdyNum = dxdy.length - 1;
		}
		if (dxdyNum >= dxdy.length) {
			dxdyNum = 0;
		}
	}

	static class Rotate {
		int time;
		int dir;

		public Rotate(int time, char dir) {
			this.time = time;
			if (dir == 'L')
				this.dir = -1;
			else
				this.dir = 1;
		}
	}

}
