package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static int[][] news = {{1,0},{-1,0},{0,1},{0,-1}};
	static int[][] map;
	static boolean[][] visited;
	static ArrayList<Integer> eachSize = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//init data
		int size = Integer.parseInt(st.nextToken());
		visited = new boolean[size][size];
		map = new int[size][size]; 
		for (int i = 0; i < size; i++) {
			char[] oneLine = br.readLine().toCharArray();
			for (int j = 0; j < size; j++) {
				map[i][j] = Character.getNumericValue(oneLine[j]);
			}
		}
		
		//solve
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (visited[i][j] == false && map[i][j] == 1) {
					Stack<int[]> stack = new Stack<>();
					int nowSize = 1;
					stack.push(new int[] {i,j});
					visited[i][j] = true;
					while (!stack.isEmpty()) {
						int[] pop = stack.pop();
						
						for (int k = 0; k < news.length; k++) {
							int nRow = pop[0] + news[k][0];
							int nCol = pop[1] + news[k][1];
							if (0 <= nRow && nRow < size
									&& 0 <= nCol && nCol < size) {
								if (map[nRow][nCol] == 1 && visited[nRow][nCol] == false) {
									stack.push(new int[] {nRow,nCol});
									visited[nRow][nCol] = true;
									nowSize++;
								}
							}
						}
					}
					
					eachSize.add(nowSize);
				}
			}
		}
		
		eachSize.sort((o1,o2)->{
			return o1-o2;
		});
		
		bw.write(eachSize.size() + "\n");
		for (Integer e : eachSize) {
			bw.write(e + "\n");
		}
		bw.flush();
		bw.close();
	}
	
}