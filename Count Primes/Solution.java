class Solution {
    public int countPrimes(int n) {
        int count = 0;
        boolean[] notPrime = new boolean[n];

        if (n > 2) {
            count++;
        }

        for (int i = 3; i < n; i += 2) {
            if (!notPrime[i - 1]) {
                count++;
                for (int j = 2 * i; j < n; j += i) {
                    notPrime[j - 1] = true;
                }
            }
        }

        return count;
    }
}