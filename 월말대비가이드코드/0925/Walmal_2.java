package swea;

import java.io.IOException;
import java.util.ArrayList;

public class Walmal_2 {
	public static ArrayList<Integer> arrayList;
	public static int[] array;
	public static boolean[] check;
	
	public static void main(String[] args) throws IOException {
		arrayList = new ArrayList<>();
		array = new int[] {
				1,2,3,4
		};
		check = new boolean[array.length];
		checkAllPath(0);
	}
	
	public static void checkAllPath(int depth) {
		if (depth == array.length) {
			System.out.println(arrayList.toString());
			return;
		}
		
		for (int i = 0; i < array.length; i++) {
			if (check[i] == false) {
				int flag = arrayList.size();
				arrayList.add(array[i]);
				check[i] = true;
				checkAllPath(depth+1);
				arrayList.remove(flag);
				check[i] = false;
			}
		}
	}
}


/*
테스트케이스 예시


10
5
0 1 4 4 7 1 8 
4 0 1 1 2 7 8 
1 2 0 4 7 3 10 
8 9 6 0 4 5 10 
2 7 9 3 0 1 3 
10 6 9 8 2 0 2 
6 8 9 2 6 10 0 
8
0 6 6 2 4 9 2 6 6 3 
2 0 10 1 2 6 7 5 4 9 
10 10 0 6 6 1 9 8 8 4 
3 1 8 0 10 5 3 4 10 1 
7 7 1 3 0 1 1 7 2 1 
5 6 1 3 5 0 4 8 1 9 
8 1 9 5 2 2 0 8 7 6 
6 7 6 3 7 8 8 0 5 8 
5 3 8 3 2 10 7 4 0 6 
1 10 8 3 10 2 10 8 3 0 
5
0 10 8 2 1 6 7 
8 0 9 10 9 6 8 
7 2 0 4 2 1 4 
2 5 2 0 8 5 4 
8 1 8 3 0 10 1 
5 5 3 2 9 0 2 
6 3 2 10 9 5 0 
8
0 7 6 7 9 1 6 8 10 5 
7 0 10 10 5 2 5 9 6 5 
5 4 0 8 3 2 7 4 5 3 
2 6 10 0 3 4 2 10 10 9 
4 9 10 10 0 9 6 10 1 4 
10 8 9 10 3 0 9 4 4 9 
3 1 5 10 8 7 0 7 10 8 
7 9 6 2 9 8 8 0 5 5 
9 7 5 9 2 5 8 2 0 2 
10 1 3 2 1 1 1 3 10 0 
6
0 9 1 8 6 3 8 8 
8 0 8 4 1 4 7 10 
2 2 0 3 9 3 9 4 
10 3 1 0 9 5 5 1 
7 1 5 9 0 4 1 1 
7 7 8 9 9 0 2 8 
10 5 6 5 2 2 0 8 
9 3 7 2 2 4 3 0 
5
0 9 6 4 1 1 7 
7 0 8 5 3 10 10 
8 8 0 9 3 8 1 
5 8 7 0 5 2 1 
8 3 9 8 0 9 9 
4 10 5 2 2 0 4 
10 5 6 9 10 6 0 
6
0 3 8 6 7 3 7 2 
5 0 5 1 2 6 1 4 
2 7 0 8 5 7 3 3 
3 2 5 0 8 2 4 8 
2 1 3 2 0 6 7 4 
2 2 3 1 4 0 7 9 
4 3 7 10 5 5 0 1 
9 1 6 3 2 3 5 0 
8
0 2 2 8 6 9 2 4 3 6 
6 0 4 5 2 2 3 8 8 2 
1 2 0 4 9 6 10 4 8 2 
6 1 4 0 8 1 9 5 3 5 
6 5 9 1 0 8 5 4 1 2 
4 10 4 8 8 0 2 10 9 10 
8 5 10 3 2 10 0 6 4 5 
4 2 8 3 8 1 5 0 5 1 
9 1 1 4 10 2 5 7 0 6 
8 2 5 8 7 3 5 4 1 0 
8
0 6 9 6 8 2 7 2 8 7 
8 0 3 5 1 5 5 7 6 4 
6 6 0 1 10 8 2 7 9 4 
2 6 4 0 3 5 10 8 1 1 
7 10 1 9 0 4 10 8 3 10 
10 4 9 6 4 0 5 1 9 2 
2 3 8 7 1 8 0 9 4 5 
5 8 6 7 10 8 4 0 1 5 
4 10 6 2 6 7 8 2 0 10 
10 2 8 8 9 2 5 8 3 0 
6
0 9 6 6 10 9 7 2 
9 0 8 9 1 1 1 9 
10 7 0 1 3 7 5 6 
1 10 7 0 1 9 10 8 
9 3 7 7 0 5 7 8 
5 5 7 3 8 0 8 7 
7 5 9 4 5 10 0 3 
2 7 7 2 10 3 9 0

#1 13
#2 16
#3 15
#4 23
#5 14
#6 17
#7 15
#8 17
#9 19


*/