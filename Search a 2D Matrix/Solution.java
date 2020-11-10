class Solution {
    private int getElem(int[][] matrix, int m, int index) {
        int i = index / m; // n = 3
        int j = index % m; // m = 4

        return matrix[i][j];
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }

        int n = matrix.length;
        int m = matrix[0].length;

        int start = 0;
        int end = m * n - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            int curr = getElem(matrix, m, mid);

            if (curr == target) {
                return true;
            }

            if (curr < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return false;

    }
}