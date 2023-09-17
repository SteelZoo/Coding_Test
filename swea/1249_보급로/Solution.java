import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//1249 보급로
public class Solution {
	public static int[][] map;
	public static int[][] visited;
	public static int[][] news = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());

		// testcase
		for (int test_case = 1; test_case <= T; test_case++) {

			st = new StringTokenizer(br.readLine());
			int size = Integer.parseInt(st.nextToken());
			map = new int[size][size];
			visited = new int[size][size];
			for (int i = 0; i < size; i++) {
				char[] oneLine = br.readLine().toCharArray();
				for (int j = 0; j < size; j++) {
					map[i][j] = Character.getNumericValue(oneLine[j]);
					visited[i][j] = Integer.MAX_VALUE;
				}
			}

			findBestWay();

			bw.write("#" + test_case + " " + visited[size - 1][size - 1] + "\n");
		} // testcase
		bw.flush();
		bw.close();
	}

	public static void findBestWay() {
		Queue<int[]> q = new LinkedList<int[]>();

		q.add(new int[] { 0, 0 });
		visited[0][0] = 0;
		while (!q.isEmpty()) {
			int[] poll = q.poll();
			int visitFlag = visited[poll[0]][poll[1]] + map[poll[0]][poll[1]];

			for (int i = 0; i < news.length; i++) {
				int row = poll[0] + news[i][0];
				int col = poll[1] + news[i][1];
				if (0 <= row && row < map.length && 0 <= col && col < map.length) {
					if (visited[row][col] > visitFlag) {
						q.add(new int[] {row,col});
						visited[row][col] = visitFlag;
					}
				}
			}
		}
	}
}
