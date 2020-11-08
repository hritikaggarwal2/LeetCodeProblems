class Solution {

    private boolean shiftCheck(char[] a, char[] b, int shift) {
        for (int i = 0; i < a.length; i++) {
            int indexB = (i + shift) % a.length;
            if (a[i] != b[indexB]) {
                return false;
            }
        }

        return true;
    }

    public boolean rotateString(String A, String B) {
        if (A.length() != B.length()) {
            return false;
        } else if (A.equalsIgnoreCase(B)) {
            return true;
        }

        Set<Integer> set = new TreeSet<>();

        char[] a = A.toCharArray();
        char[] b = B.toCharArray();

        for (int i = 0; i < b.length; i++) {
            if (b[i] == a[0]) {
                set.add(i);
            }
        }

        for (Integer shift : set) {
            if (shiftCheck(a, b, shift)) {
                return true;
            }
        }

        return false;
    }
}