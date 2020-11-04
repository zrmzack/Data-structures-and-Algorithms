package Chapter1;

import java.util.Arrays;

public class Question1 {
    private static int[] bubleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            boolean flag = false;
            for (int j = i; j < array.length; j++) {
                if (array[i] < array[j]) {
                    swap(array, i, j);
                }
                flag = true;
            }
            if (flag == false) {
                return array;
            }
        }
        return array;
    }

    private static int numberK(int arr[], int k) {
        return arr[k - 1];
    }

    private static void swap(int[] array, int x, int y) {
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }

    private static int getK(int[] array, int k) {
        int result = 0;
        int arraycopy[] = Arrays.copyOf(array, k);
        arraycopy = bubleSort(arraycopy);
        for (int x = k; x < array.length; x++) {
            for (int y = 0; y < k; y++) {
                if (arraycopy[y] < array[x]) {
                    swap(arraycopy, x, y);
                }
            }
        }
        result=arraycopy[k-1];
        return result;
    }

    public static void main(String[] args) {
        int numberk[] = {-1, 3, 5, 6, 1, 3, 4, 4};
        System.out.println(Arrays.toString(bubleSort(numberk)));
        System.out.println(getK(numberk,3));
        System.out.println(numberK(bubleSort(numberk), 3));
    }
}
