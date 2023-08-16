package swea;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Solution {
	static int[] array1;
	static int[] array2;
	static Stack<Integer> stack = new Stack<>();
	
	public static void main(String args[]) throws Exception {
		 System.setIn(new FileInputStream("src/swea/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		for (int test_case = 1; test_case <= 10; test_case++) {
			array1 = new int[100];
			array2 = new int[100];
			int answer = 0;
			//init nodes
			st = new StringTokenizer(br.readLine());
			st.nextToken();
			int road = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < road; i++) {
				//set one road
				int index = Integer.parseInt(st.nextToken());
				int arr = Integer.parseInt(st.nextToken());
				if (array1[index] == 0) {
					array1[index] = arr;
				} else {
					array2[index] = arr;
				}
			}
			//push initial value to stack
			if (array1[0] != 0) {
				stack.push(array1[0]);
			}
			if (array2[0] != 0) {
				stack.push(array2[0]);
			}
			//find logic
			int next;
			while (!stack.isEmpty()) {
				next = stack.pop();
				if (next == 99) {
					answer = 1;
					break;
				}
				if (array1[next] != 0) {
					if (array1[next] == 99) {
						answer = 1;
						break;
					}
					stack.push(array1[next]);
				}
				if (array2[next] != 0) {
					if (array2[next] == 99) {
						answer = 1;
						break;
					}
					stack.push(array2[next]);
				}
			}
			stack.clear();
			bw.write("#" + test_case + " " + answer + "\n");
		}
		bw.flush();
		bw.close();
	}
}