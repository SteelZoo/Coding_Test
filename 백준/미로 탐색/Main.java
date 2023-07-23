package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static int n,m;
	public static int[][] map;
	public static int[][] distanceMap;
	public static int distance;
	public static LinkedList<Node> queue;
	public static int[] nArray = {1,0,-1,0};
	public static int[] mArray = {0,1,0,-1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];

		for (int i = 0; i < n; i++) {
			char[] string = br.readLine().toCharArray();
			for (int j = 0; j < string.length; j++) {
				int number = Character.getNumericValue(string[j]);
				if (number >= 0) {
					map[i][j] = number;
				}
			}
		}
		// input
		br.close();
		int result = trackingBybfs(n, m, map);

		// code

		bw.write(Integer.toString(result));
		bw.flush();
	}

	static int trackingBybfs(int n, int m, int[][] map) {
		int result = -1;
		distanceMap = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				distanceMap[i][j] = 0;
			}
		}

		queue = new LinkedList<Node>();
		queue.add(new Node(0, 0));
		distanceMap[0][0] = 1;

		Node node;
		while (!queue.isEmpty()) {
			node = queue.removeFirst();

			for (int i = 0; i < 4; i++) {
				if (0 <= node.n + nArray[i] 
						&& node.n + nArray[i] < n 
						&& 0 <= node.m + mArray[i] 
						&& node.m + mArray[i] < m) {
					if (map[node.n + nArray[i]][node.m + mArray[i] ] == 1 
							&& distanceMap[node.n + nArray[i]][node.m + mArray[i] ] == 0) {
						queue.add(new Node(node.n+nArray[i],node.m+mArray[i]));
						distanceMap[node.n+nArray[i]][node.m+mArray[i]] = distanceMap[node.n][node.m] + 1;
					}
				}
			}
			
		}

		result = distanceMap[n - 1][m - 1];

		return result;
	}

}

class Node {
	int n;
	int m;

	public Node(int n, int m) {
		this.n = n;
		this.m = m;
	}
}
