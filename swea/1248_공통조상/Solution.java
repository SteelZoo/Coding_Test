package swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;

//1245 균형점
public class Solution {
	public static Map<Integer, Integer> childToParent;
	public static Map<Integer, List<Integer>> tree;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/swea/input.txt"));

		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			childToParent = new HashMap<>();
			tree = new HashMap<>();
			
			st = new StringTokenizer(br.readLine());
			int nodeCount = Integer.parseInt(st.nextToken());
			int vertexCount = Integer.parseInt(st.nextToken());
			int target1 = Integer.parseInt(st.nextToken());
			int target2 = Integer.parseInt(st.nextToken());
			
			//init data
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < vertexCount; i++) {
				int parent = Integer.parseInt(st.nextToken());
				int child = Integer.parseInt(st.nextToken());
				
				//childToParent
				childToParent.put(child, parent);
				
				//tree
				if (tree.get(parent) == null) {
					tree.put(parent, new ArrayList<>());
				}
				tree.get(parent).add(child);
			}
			
			int sameParent = getSameParent(target1, target2); 
			int size = getSizeFromNode(sameParent);
			
			bw.write("#" + test_case + " " + sameParent + " " + size + "\n");
		}
		
		bw.flush();
		bw.close();
	}
	
	public static int getSizeFromNode(int node) {
		int result = 0;
		
		Stack<Integer> stack = new Stack<>();
		stack.push(node);
		while (!stack.isEmpty()) {
			int pop = stack.pop();
			result++;
			if (tree.get(pop) != null) {
				for (Integer child : tree.get(pop)) {
					stack.push(child);
				}
			}
		}
		
		
		return result;
	}
	
	public static int getSameParent(int target1, int target2) {
		int result = -1;
		ArrayList<Integer> parents = new ArrayList<>();
		//get target1's all parents
		int nowChild = target1;
		while (childToParent.get(nowChild) != null) {
			parents.add(childToParent.get(nowChild));
			nowChild = childToParent.get(nowChild);
		}
		//get minimum same parent
		nowChild = target2;
		while (!parents.contains(childToParent.get(nowChild))
				&& childToParent.get(nowChild) != null) {
			nowChild = childToParent.get(nowChild);
		}
		result = childToParent.get(nowChild);
		return result;
	}
}
