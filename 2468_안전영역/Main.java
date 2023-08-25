import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

class Main {
	static int[][] news = {{1,0},{-1,0},{0,1},{0,-1}};
	static int size;
	static int[][] map;
	static int answer = 1;
	static int maxHeight = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// init map
		size = Integer.parseInt(st.nextToken());
		map = new int[size][size];
		for (int i = 0; i < size; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < size; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				maxHeight = (maxHeight < map[i][j]) ? map[i][j] : maxHeight;
			}
		}
		//--init map
		
		
		//loop from 1 to max-1
		for (int rain = 1; rain < maxHeight; rain++) {
			int temp = countAnZone(rain);
			answer = (temp > answer) ? temp : answer;
		}

		bw.write(Integer.toString(answer));
		bw.flush();
		bw.close();
	}
	
	public static int countAnZone(int rain) {
		int result = 0;
		
		boolean[][] visited = new boolean[size][size];
		Stack<int[]> stack = new Stack<>();
		
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (map[i][j] > rain && visited[i][j] == false) {
					stack.push(new int[] {i,j});
					visited[i][j] = true;
					while (!stack.isEmpty()) {
						int[] pop = stack.pop();
						
						for (int k = 0; k < news.length; k++) {
							int nRow = pop[0]+news[k][0];
							int nCol = pop[1]+news[k][1];
							if (0 <= nRow && nRow < size
									&& 0 <= nCol && nCol < size) {
								if (map[nRow][nCol] > rain && visited[nRow][nCol] == false) {
									stack.push(new int[] {nRow,nCol});
									visited[nRow][nCol] = true;
								}
							}
						}
						
					}
					
					
					
					stack.clear();
					result++;
				}
			}
		}
		
		
		return result;
	}

}
