package Sort;

public class BubbleSort {
    public void sort(int[] arr) {
        int lens = arr.length;

        for (int i = 0; i < lens - 1; i++) {
            for (int j = lens - 1; j > i; j--) {
                if (arr[j - 1] > arr[j]) {
                    int temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}
