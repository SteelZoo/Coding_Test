import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	public static Map<Integer, ArrayList<Integer>> peopleMap;
	public static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());

		// each case
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			int peopleCount = Integer.parseInt(st.nextToken());
			int knowCount = Integer.parseInt(st.nextToken());

			peopleMap = new HashMap<>();
			visited = new boolean[peopleCount + 1];

			// init data
			for (int i = 0; i < knowCount; i++) {
				st = new StringTokenizer(br.readLine());

				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());

				if (peopleMap.get(start) == null) {
					peopleMap.put(start, new ArrayList<>());
				}
				peopleMap.get(start).add(end);
				if (peopleMap.get(end) == null) {
					peopleMap.put(end, new ArrayList<>());
				}
				peopleMap.get(end).add(start);
			}

			int answer = getMuri();

			bw.write("#" + test_case + " " + answer + "\n");
		} // each case
		bw.flush();
		bw.close();
	}

	public static int getMuri() {
		int result = 0;
		
		for (int index = 1; index < visited.length; index++) {
			if (visited[index] == false) {
				checkOneMuri(index);
				result++;
			}
		}

		return result;
	}

	public static void checkOneMuri(int start) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(start);
		visited[start] = true;

		while (!q.isEmpty()) {
			int poll = q.poll();

			if (peopleMap.get(poll) != null) {
				for (Integer integer : peopleMap.get(poll)) {
					if (visited[integer] == false) {
						visited[integer] = true;
						q.add(integer);
					}
				}
			}
		}
	}
}
