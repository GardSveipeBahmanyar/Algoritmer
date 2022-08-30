class Quick extends Sorter {

    int Partition(int A[], int low, int high) {

        int pivot = A[high];

        int i = (low - 1);

        for (int j = low; j <= high - 1; j++) {

            if (A[j] < pivot) {
                compared();
                i++;
                int x = A[i];
                int y = A[j];
                A[i] = y;
                A[j] = x;
                swapped();

            }
        }
        int x = A[i + 1];
        int y = A[high];
        A[i + 1] = y;
        A[high] = x;
        swapped();
        return (i + 1);
    }

    void QuickSort(int A[], int low, int high) {
        if (low >= high) {
            return;
        }
        int p = Partition(A, low, high);
        QuickSort(A, low, p - 1);
        QuickSort(A, p + 1, high);
    }

    @Override
    void sort() {
        QuickSort(A, 0, A.length - 1);
    }

    String algorithmName() {
        return "quick";
    }
}
