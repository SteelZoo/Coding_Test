package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.channels.NonWritableChannelException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;
import java.util.StringTokenizer;

class Main {
	static boolean[] numCount;
	static int n;
	static int m;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		sb = new StringBuilder();
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		numCount = new boolean[n];
		
		nKWAm(0, new ArrayList<Integer>());
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
	}
	
	public static void nKWAm(int depth, ArrayList<Integer> selected) {
		if (selected.size() == m) {
			for (Integer integer : selected) {
				sb.append(integer+1 + " ");
			}
			sb.append("\n");
			return;
		} else if (depth == n && selected.size() != m) {
			return;
		}
		for (int i = 0; i < numCount.length; i++) {
			if(numCount[i] == false) {
				numCount[i] = true;
				int flag = selected.size();
				selected.add(i);
				nKWAm(depth+1, selected);
				numCount[i] = false;
				selected.remove(flag);
			}
		}
	}
}
