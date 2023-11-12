package baekjoon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Random;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int count = Integer.parseInt(input[0]);
        int[] list = new int[count];

        for (int i = 0; i < count; i++) {
            list[i] = Integer.parseInt(br.readLine());
        }

        quickSort(list, 0, count - 1);

        for (int i = 0; i < count; i++) {
            bw.write(Integer.toString(list[i]) + "\n");
        }
        bw.flush();
        bw.close();
    }

    public static void quickSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }

        Random rand = new Random();
        int pivotIndex = rand.nextInt(end - start + 1) + start;

        swap(arr, pivotIndex, end);

        int pivot = arr[end];
        int left = start;
        int right = end - 1;

        while (left <= right) {
            while (left <= right && arr[left] < pivot) {
                left++;
            }
            while (left <= right && arr[right] > pivot) {
                right--;
            }
            if (left <= right) {
                swap(arr, left, right);
                left++;
                right--;
            }
        }

        swap(arr, left, end);

        quickSort(arr, start, left - 1);
        quickSort(arr, left + 1, end);
    }

    public static void swap(int[] arr, int aIndex, int bIndex) {
        int temp = arr[aIndex];
        arr[aIndex] = arr[bIndex];
        arr[bIndex] = temp;
    }
}
