import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Main {
	public static int[] memo;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int target = Integer.parseInt(st.nextToken());
		memo = new int[target+4];

//		int answer = getMinCount(target);

		memo[1] = 0;
		memo[2] = 1;
		memo[3] = 1;

		for (int i = 4; i < memo.length; i++) {
			int d3 = Integer.MAX_VALUE;
			int d2 = Integer.MAX_VALUE;
			int m1 = Integer.MAX_VALUE;
			if(i%3 == 0) {
				d3 = memo[i/3];
			}
			if (i%2 == 0) {
				d2 = memo[i/2];
			}
			m1 = memo[i-1];
			memo[i] = Math.min(Math.min(d3, d2), m1) + 1;
		}

		int answer = memo[target];


		bw.write(Integer.toString(answer));
		bw.flush();
		bw.close();

	}
}
