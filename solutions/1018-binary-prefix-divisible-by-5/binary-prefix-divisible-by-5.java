class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> result = new ArrayList<>();
        int current = 0;

        for (int bit : nums) {
            current = (current * 2 + bit) % 5;
            result.add(current == 0);
        }

        return result;
    }
}
