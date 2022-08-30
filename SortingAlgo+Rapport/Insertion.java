class Insertion extends Sorter {

    void InsertionSort(int A[]) {
        int n = A.length;
        for (int i = 1; i < n; i++) {
            int j = i;
            while (j > 0 && A[j - 1] > A[j]) {
                int x = A[j - 1];
                int y = A[j];
                A[j] = x;
                A[j - 1] = y;
                j--;
                swapped();
                compared();
            }
        }
    }

    @Override
    void sort() {

        InsertionSort(A);

    }

    String algorithmName() {
        return "insertion";
    }
}
