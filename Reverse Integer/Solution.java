class Solution {
    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int carry = x % 10;
            x /= 10;

            if ((rev > Integer.MAX_VALUE / 10) || (rev < Integer.MIN_VALUE / 10)
                    || (rev == Integer.MAX_VALUE / 10 && carry > 7) || (rev == Integer.MIN_VALUE / 10 && carry < -8)) {

                return 0;
            }

            rev = rev * 10 + carry;
        }

        return rev;
    }
}