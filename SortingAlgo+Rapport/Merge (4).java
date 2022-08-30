import java.util.Arrays;

class Merge extends Sorter {

    int[] Merging(int A1[], int A2[], int A[]) {
        int i = 0;
        int j = 0;
        while (i < A1.length && j < A2.length) {
            if (A1[i] < A2[j]) {
                A[i + j] = A1[i];
                i++;
                compared();
                swapped();
            } else {
                A[i + j] = A2[j];
                j++;
                swapped();
            }
        }
        while (i < A1.length) {
            A[i + j] = A1[i];
            i++;
            swapped();
        }
        while (j < A2.length) {
            A[i + j] = A2[j];
            j++;
            swapped();
        }
        return A;
    }

    int[] MergeSort(int A[]) {
        if (A.length <= 1) {
            return A;
        }
        int i = A.length / 2;
        int[] copy1 = Arrays.copyOfRange(A, 0, i);
        int[] copy2 = Arrays.copyOfRange(A, i, A.length);
        int[] A1 = MergeSort(copy1);
        int[] A2 = MergeSort(copy2);

        return Merging(A1, A2, A);
    }

    void Merg(int A[]) {
        MergeSort(A);
    }

    @Override
    void sort() {
        Merg(A);
    }

    String algorithmName() {
        return "merge";
    }

}
