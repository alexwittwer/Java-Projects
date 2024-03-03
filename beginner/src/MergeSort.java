public class MergeSort {
    public static void main(String[] args) {
        int[] array = {12, 11, 13, 5, 6, 7};
        System.out.println("Given Array");
        printArray(array);
        mergeSort(array);
        System.out.println("\nSorted array");
        printArray(array);
    }

    static void printArray(int[] array) {
        for (int element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    static void mergeSort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        int n = array.length;
        int mid = n / 2;
        int[] left = new int[mid];
        int[] right = new int[n - mid];
        System.arraycopy(array, 0, left, 0, mid);
        System.arraycopy(array, mid, right, 0, n - mid);
        mergeSort(left);
        mergeSort(right);
        merge(array, left, right);
    }

    static void merge(int[] array, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                array[k++] = left[i++];
            } else {
                array[k++] = right[j++];
            }
        }
        while (i < left.length) {
            array[k++] = left[i++];
        }
        while (j < right.length) {
            array[k++] = right[j++];
        }
    }
}
