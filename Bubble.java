class Bubble extends Sorter {

    void BubbleSort(int A[]) {
        int n = A.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (A[j] > A[j + 1]) {
                    int x = A[j];
                    int y = A[j + 1];
                    A[j] = y;
                    A[j + 1] = x;
                    swapped();
                    compared();
                }
            }
        }
    }

    @Override
    void sort() {
        BubbleSort(A);
    }

    String algorithmName() {
        return "bubble";
    }
}
