package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

class Main {
	static int[][] news = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	static char[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// init data
		int size = Integer.parseInt(st.nextToken());
		map = new char[size][size];
		for (int i = 0; i < size; i++) {
			char[] oneLine = br.readLine().toCharArray();
			map[i] = oneLine;
		}
		
		// solve
		int normal = getBlocks(false);
		int jeokNok = getBlocks(true);
		
		bw.write(normal + " " + jeokNok);
		bw.flush();
		bw.close();
		
	}

	public static int getBlocks(boolean isJeokNok) {
		int count = 0;
		boolean[][] visited = new boolean[map.length][map.length];

		for (int i = 0; i < visited.length; i++) {
			for (int j = 0; j < visited.length; j++) {
				if (visited[i][j] == false) {
					char flag = map[i][j];
					Stack<int[]> stack = new Stack<>();
					stack.push(new int[] {i,j});
					visited[i][j] = true;
					while (!stack.isEmpty()) {
						int[] pop = stack.pop();
						
						for (int k = 0; k < news.length; k++) {
							int nRow = pop[0] + news[k][0];
							int nCol = pop[1] + news[k][1];
							if (0<=nRow && nRow < visited.length
									&& 0<=nCol && nCol < visited.length) {
								if (visited[nRow][nCol] == false && isSame(flag, map[nRow][nCol], isJeokNok)) {
									stack.push(new int[] {nRow,nCol});
									visited[nRow][nCol] = true;
								}
							}

						}
						
					}
					count++;
				}
			}
		}

		return count;
	}
	
	public static boolean isSame(char flag, char target, boolean isJeokNok) {
		if (isJeokNok) {
			if ((flag == 'R' || flag == 'G') && (target == 'R' || target == 'G')) {
				return true;
			} else if (flag == 'B' && target == 'B') {
				return true;
			}
		} else {
			if (flag == target) {
				return true;
			}
		}
		return false;
	}
}
