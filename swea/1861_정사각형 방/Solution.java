import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int[][] map;
	static int[][] news = {{1,0},{-1,0},{0,1},{0,-1}};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());
		for (int test_case = 1; test_case <= T; test_case++) {
			int answerNum = 0;
			int answerLength = 0;

			// init data
			st = new StringTokenizer(br.readLine());
			int size = Integer.parseInt(st.nextToken());
			map = new int[size][size];
			for (int i = 0; i < size; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < size; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			//solve
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[i].length; j++) {
					int[] temp = bfs(new int[] {i,j});
					if (temp[1] > answerLength) {
						answerNum = temp[0];
						answerLength = temp[1];
					} else if (temp[1] == answerLength && temp[0] < answerNum) {
						answerNum = temp[0];
					}
				}
			}
			
			bw.write("#" + test_case + " " + answerNum + " " + answerLength + "\n");
		}

		bw.flush();
		bw.close();
	}
	
	public static int[] bfs(int[] rowcol) {
		int startNum = map[rowcol[0]][rowcol[1]];
		int maxLength = 0;
		
		boolean[][] visited = new boolean[map.length][map.length];
		Queue<int[]> q = new LinkedList<int[]>();
		
		q.add(rowcol);
		visited[rowcol[0]][rowcol[1]] = true;
		while (!q.isEmpty()) {
			maxLength++;
			//loop for now size 
			int nowSize = q.size();
			for (int i = 0; i < nowSize; i++) {
				int[] pollRowCol = q.poll();
				
				//4dir
				for (int j = 0; j < news.length; j++) {
					int dRow = pollRowCol[0] + news[j][0];
					int dCol = pollRowCol[1] + news[j][1];
					//check validate
					if (0 <= dRow && dRow < map.length &&
							0 <= dCol && dCol < map.length) {
						//check condition(bigger just one)
						if (map[dRow][dCol] == startNum+maxLength && visited[dRow][dCol] == false) {
							q.add(new int[] {dRow,dCol});
							visited[dRow][dCol] = true;
						}
					}
				}
			}
		}
		
		return new int[] {startNum, maxLength};
	}
}
