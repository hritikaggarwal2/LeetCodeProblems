class Solution {
    private double helper(double x, long n) {
        if (n == 0) {
            return 1.0;
        } else if (n == 1) {
            return x;
        }

        double half = helper(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }

    public double myPow(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }

        return helper(x, N);
    }
}