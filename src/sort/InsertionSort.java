package sort;

public class InsertionSort {
    public void sort(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            int index = i;
            while (index > 0 && arr[index - 1] > arr[i]) {
                arr[index] = arr[index - 1];
                index -= 1;
            }
            arr[index] = arr[i];
        }
    }
}
