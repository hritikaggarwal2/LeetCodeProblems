class Solution {
    public int compareVersion(String version1, String version2) {
        char[] v1 = version1.toCharArray();
        char[] v2 = version2.toCharArray();

        int len1 = v1.length;
        int len2 = v2.length;

        int i = 0;
        int j = 0;

        while (i < len1 || j < len2) {
            int num1 = 0;
            int num2 = 0;

            while (i < len1 && v1[i] != '.') {
                num1 = num1 * 10 + (v1[i] - '0');
                i++;
            }

            while (j < len2 && v2[j] != '.') {
                num2 = num2 * 10 + (v2[j] - '0');
                j++;
            }

            if (num1 < num2) {
                return -1;
            }
            if (num1 > num2) {
                return 1;
            }

            i++;
            j++;
        }

        return 0;
    }
}