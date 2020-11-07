class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();

        if (matrix.length == 0) {
            return ans;
        }

        int n = matrix.length - 1;
        int m = matrix[0].length - 1;

        int i = 0;
        int j = 0;

        while (i <= n && j <= m) {
            // traverse col
            for (int a = j; a <= m; a++) {
                ans.add(matrix[i][a]);
            }

            // traverse row
            for (int a = i + 1; a <= n; a++) {
                ans.add(matrix[a][m]);
            }

            if (i < n && j < m) {
                // traverse col
                for (int a = m - 1; a >= j; a--) {
                    ans.add(matrix[n][a]);
                }

                // traverse row
                for (int a = n - 1; a > i; a--) {
                    ans.add(matrix[a][j]);
                }
            }

            i++;
            n--;
            j++;
            m--;
        }

        return ans;
    }
}