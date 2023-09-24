package swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/**
 * 
 * @author steelzoo
 * 
 *	등산로 조성에서 깍을 수 있는 조건이 없고 탐색에 대한 조건만 있음.
 *	즉, dfs,bfs탐색에 조건만 넣으면 됨.
 *
 */
public class Walmal_1 {
	public static int[][] dxdy = {{-1,0},{0,1},{1,0},{0,-1}};
	public static int[][] map;
	public static int highestNum = 0;
	public static LinkedList<int[]> highestList;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			int answer = 0;
			
			st = new StringTokenizer(br.readLine());
			int size = Integer.parseInt(st.nextToken())+2;
			
			map = new int[size][size];
			highestList = new LinkedList<>();
			//init data
			for (int i = 0; i < size; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < size; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					//가장 큰 위치 저장
					if (map[i][j] > highestNum) {
						highestNum = map[i][j];
						highestList.clear();
					}
					if (map[i][j] == highestNum) {
						highestList.add(new int[] {i,j});
					}
				}
			}
			
			for (int[] target : highestList) {
				int temp = getLongestWay(target[0], target[1]);
				answer = (answer < temp) ? temp : answer;
			}
			
			bw.write("#" + test_case + " " + answer + "\n");
		}
		bw.flush();
		bw.close();
	}
	
	public static int getLongestWay(int row, int col) {
		int result = 1;
		int[][] visited = new int[map.length][map.length];
		
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {row,col});
		visited[row][col] = 1;
		
		while (!q.isEmpty()) {
			int rep = q.size();
			for (int r = 0; r < rep; r++) {
				int[] poll = q.poll();
				
				for (int i = 0; i < dxdy.length; i++) {
					int dRow = poll[0] + dxdy[i][0];
					int dCol = poll[1] + dxdy[i][1];
					if (0 <= dRow && dRow < visited.length && 0 <= dCol && dCol < visited.length) {
						if (visited[dRow][dCol] == 0 && map[dRow][dCol] < map[poll[0]][poll[1]]) {
							visited[dRow][dCol] = visited[poll[0]][poll[1]] + 1;
							q.add(new int[] {dRow,dCol});
							result = visited[dRow][dCol];
						}
					}
				}
			}
//			result++;
		}
//		System.out.println(result+"");
		return result;
	}
}


/*
테스트케이스 예시

1
5
9 3 2 3 2
6 3 1 7 5
3 4 8 9 9
2 3 7 7 7
7 6 5 5 8
3
1 2 1
2 1 2
1 2 1
5
9 3 2 3 2
6 3 1 7 5
3 4 8 9 9
2 3 7 7 7
7 6 5 5 8
4
8 3 9 5
4 6 8 5
8 1 5 1
4 9 5 5
4
6 6 1 7
3 6 6 1
2 4 2 4
7 1 3 4
5
18 18 1 8 18
17 7 2 7 2
17 8 7 4 3
17 9 6 5 16
18 10 17 13 18
6
12 3 12 10 2 2
13 7 13 3 11 6
2 2 6 5 13 9
1 12 5 4 10 5
11 10 12 8 2 6
13 13 7 4 11 7
7
16 10 14 14 15 14 14
15 7 12 2 6 4 9
10 4 11 4 6 1 1
16 4 1 1 13 9 14
3 12 16 14 8 13 9
3 4 17 15 12 15 1
6 6 13 6 6 17 12
8
2 3 4 5 4 3 2 1
3 4 5 6 5 4 3 2
4 5 6 7 6 5 4 3
5 6 7 8 7 6 5 4
6 7 8 9 8 7 6 5
5 6 7 8 7 6 5 4
4 5 6 7 6 5 4 3
3 4 5 6 5 4 3 2
8
5 20 15 11 1 17 10 14
1 1 11 16 1 14 7 5
17 2 3 4 5 13 19 20
6 18 5 16 6 7 8 5
10 4 5 4 9 2 10 16
2 7 16 5 8 9 10 11
12 19 18 8 7 11 15 12
1 20 18 17 16 15 14 13

-----------------

10
5
9 3 2 3 2
6 3 1 7 5
3 4 8 9 9
2 3 7 7 7
7 6 5 5 8
3
1 2 1
2 1 2
1 2 1
5
9 3 2 3 2
6 3 1 7 5
3 4 8 9 9
2 3 7 7 7
7 6 5 5 8
4
8 3 9 5
4 6 8 5
8 1 5 1
4 9 5 5
4
6 6 1 7
3 6 6 1
2 4 2 4
7 1 3 4
5
18 18 1 8 18
17 7 2 7 2
17 8 7 4 3
17 9 6 5 16
18 10 17 13 18
6
12 3 12 10 2 2
13 7 13 3 11 6
2 2 6 5 13 9
1 12 5 4 10 5
11 10 12 8 2 6
13 13 7 4 11 7
7
16 10 14 14 15 14 14
15 7 12 2 6 4 9
10 4 11 4 6 1 1
16 4 1 1 13 9 14
3 12 16 14 8 13 9
3 4 17 15 12 15 1
6 6 13 6 6 17 12
8
2 3 4 5 4 3 2 1
3 4 5 6 5 4 3 2
4 5 6 7 6 5 4 3
5 6 7 8 7 6 5 4
6 7 8 9 8 7 6 5
5 6 7 8 7 6 5 4
4 5 6 7 6 5 4 3
3 4 5 6 5 4 3 2
8
5 20 15 11 1 17 10 14
1 1 11 16 1 14 7 5
17 2 3 4 5 13 19 20
6 18 5 16 6 7 8 5
10 4 5 4 9 2 10 16
2 7 16 5 8 9 10 11
12 19 18 8 7 11 15 12
1 20 18 17 16 15 14 13

#1 5
#2 2
#3 5
#4 4
#5 3
#6 10
#7 4
#8 5
#9 9
#10 14

*/