package bj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class bj_14499 {
	static int rowSize;
	static int colSize;
	static int[][] map;
	static int[] position = new int[2];
	static LinkedList<Integer> command = new LinkedList<Integer>();
	static int[][] dxdy = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };

	static final int EAST = 0;
	static final int WEST = 1;
	static final int NORTH = 2;
	static final int SOUTH = 3;
	static int[] diceSide = new int[4];
	static int diceTop;
	static int diceBot;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());

		rowSize = Integer.parseInt(st.nextToken());
		colSize = Integer.parseInt(st.nextToken());
		map = new int[rowSize][colSize];
		position[0] = Integer.parseInt(st.nextToken());
		position[1] = Integer.parseInt(st.nextToken());

		int commandSize = Integer.parseInt(st.nextToken());

		// 맵 초기화
		for (int i = 0; i < rowSize; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < colSize; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 명령어 초기화
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < commandSize; i++) {
			command.add(Integer.parseInt(st.nextToken()));
		}
		
		// solve
		while(!command.isEmpty()) {
			int dir = command.removeFirst();
			int top = roll(dir);
			if(top >= 0) {
				sb.append(Integer.toString(top)).append("\n");
			}
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}

	static int roll(int dir) {
		// 가능성
		int[] forhead = {position[0] + dxdy[dir-1][0],position[1] + dxdy[dir-1][1]};
		if(!isCanGo(forhead[0], forhead[1])) {
			return -1;
		}
		
		
		// 면 변환
		int tempTop = diceTop;
		switch (dir-1) {
		case EAST:
			diceTop = diceSide[WEST];
			diceSide[WEST] = diceBot;
			diceBot = diceSide[EAST];
			diceSide[EAST] = tempTop;
			break;
		case WEST:
			diceTop = diceSide[EAST];
			diceSide[EAST] = diceBot;
			diceBot = diceSide[WEST];
			diceSide[WEST] = tempTop;
			break;
		case NORTH:
			diceTop = diceSide[SOUTH];
			diceSide[SOUTH] = diceBot;
			diceBot = diceSide[NORTH];
			diceSide[NORTH] = tempTop;
			break;
		case SOUTH:
			diceTop = diceSide[NORTH];
			diceSide[NORTH] = diceBot;
			diceBot = diceSide[SOUTH];
			diceSide[SOUTH] = tempTop;
			break;
		default:
			break;
		}
		
		// 바닥 변환
		position = forhead;
		if(map[position[0]][position[1]] == 0) {
			map[position[0]][position[1]] = diceBot;
		} else {
			diceBot = map[position[0]][position[1]];
			map[position[0]][position[1]] = 0;
		}

		return diceTop;
	}
	
	static boolean isCanGo(int row, int col) {
		if(0 <= row && row < rowSize &&  0 <= col && col < colSize) {
			return true;
		}
		return false;
	}
}