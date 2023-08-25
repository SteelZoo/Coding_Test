package baekjoon;

import java.awt.event.MouseWheelEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

class Main {
	static int[][] news = {{1,0},{-1,0},{0,1},{0,-1}};
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//init data
		int row = Integer.parseInt(st.nextToken());
		int col = Integer.parseInt(st.nextToken());
		map = new int[row][col];
		for (int i = 0; i < row; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < col; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int year = 0;
		while (getBlock() < 2) {	
			if (isAllNok()) {
				year=0;
				break;
			}
			year++;
			oneYearNok();
		}
		
		bw.write(Integer.toString(year));
		bw.flush();
		bw.close();
	}	

	public static boolean isAllNok() {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j] > 0) {
					return false;
				}
			}
		}
		return true;
	}
	
	public static void oneYearNok() {
		int[][] origin = new int[map.length][map[0].length];
		for (int i = 0; i < origin.length; i++) {
			for (int j = 0; j < origin[i].length; j++) {
				origin[i][j] = map[i][j];
			}
		}
		
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				for (int k = 0; k < news.length; k++) {
					int nRow = i + news[k][0];
					int nCol = j + news[k][1];
					if (0<=nRow && nRow < map.length
							&& 0<= nCol && nCol < map[i].length) {
						if (origin[nRow][nCol] == 0 && map[i][j] > 0) {
							map[i][j]--;
						}
					}
				}
			}
		}
	}
	
	//dfs
	public static int getBlock() {
		int result = 0;
		
		boolean[][] visited = new boolean[map.length][map[0].length];
		Stack<int[]> stack = new Stack<>();
		
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j] > 0 && visited[i][j] == false) {
					stack.push(new int[] {i,j});
					visited[i][j] = true;
					while (!stack.isEmpty()) {
						int[] pop = stack.pop();
						
						
						for (int k = 0; k < news.length; k++) {
							int nRow = pop[0] + news[k][0];
							int nCol = pop[1] + news[k][1];
							if (0<=nRow && nRow < map.length
									&& 0<= nCol && nCol < map[i].length) {
								if (map[nRow][nCol] > 0 && visited[nRow][nCol] == false) {
									stack.push(new int[] {nRow,nCol});
									visited[nRow][nCol] = true;
								}
							}
						}
					}
					
					result++;
					stack.clear();
				}
			}
		}
		
		return result;
	}
	
	
}
