class Solution {
    public double soupServings(int N) {
        return soupServings(N, N);
    }

    private double soupServings(int A, int B) {
        if (A <= 0 && B <= 0) {
            return 0.5;
        } else if (A <= 0) {
            return 1;
        } else if (B <= 0) {
            return 0;
        }

        return 0.25 * soupServings(A - 100, B) + 0.25 * soupServings(A - 75, B - 25)
                + 0.25 * soupServings(A - 50, B - 50) + 0.25 * soupServings(A - 25, B - 75);
    }
}