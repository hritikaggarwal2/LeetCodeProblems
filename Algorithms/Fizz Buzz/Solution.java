class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> retList = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            StringBuilder sb = new StringBuilder();
            if (i % 3 == 0) {
                sb.append("Fizz");
            }

            if (i % 5 == 0) {
                sb.append("Buzz");
            }

            if (sb.length() == 0) {
                sb.append(i);
            }

            retList.add(sb.toString());
        }

        return retList;
    }
}