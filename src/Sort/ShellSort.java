package Sort;

public class ShellSort {
    public void sort(int[] arr) {
        int section = arr.length / 2;
        int j;
        int temp;

        while (section >= 1) {
            for (int i = section; i < arr.length; i++) {
                temp = arr[i];
                j = i - section;
                while (j >= 0 && arr[j] > temp) {
                    arr[j + section] = arr[j];
                    j = j - section;
                }
                arr[j + section] = temp;
            }
            section /= 2;
        }
    }
}
