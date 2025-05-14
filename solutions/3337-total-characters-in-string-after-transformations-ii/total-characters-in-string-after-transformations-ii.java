public class Solution {
    private static final int MOD = 1_000_000_007;
    private static final int SIZE = 26;

    // Matrix multiplication
    private List<List<Integer>> matrixMultiplication(List<List<Integer>> A, List<List<Integer>> B) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < SIZE; i++) {
            List<Integer> row = new ArrayList<>(Collections.nCopies(SIZE, 0));
            result.add(row);
        }

        for (int i = 0; i < SIZE; ++i) {
            for (int j = 0; j < SIZE; ++j) {
                long sum = 0;
                for (int k = 0; k < SIZE; ++k) {
                    sum = (sum + 1L * A.get(i).get(k) * B.get(k).get(j)) % MOD;
                }
                result.get(i).set(j, (int) sum);
            }
        }
        return result;
    }

    // Matrix exponentiation
    private List<List<Integer>> matrixExponentiation(List<List<Integer>> base, int exponent) {
        // Identity matrix
        List<List<Integer>> identity = new ArrayList<>();
        for (int i = 0; i < SIZE; i++) {
            List<Integer> row = new ArrayList<>(Collections.nCopies(SIZE, 0));
            row.set(i, 1);
            identity.add(row);
        }

        if (exponent == 0)
            return identity;

        List<List<Integer>> half = matrixExponentiation(base, exponent / 2);
        List<List<Integer>> result = matrixMultiplication(half, half);

        if (exponent % 2 == 1)
            result = matrixMultiplication(result, base);

        return result;
    }

    public int lengthAfterTransformations(String s, int t, List<Integer> nums) {
        int[] freq = new int[SIZE];
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        // Build transformation matrix T
        List<List<Integer>> T = new ArrayList<>();
        for (int i = 0; i < SIZE; i++) {
            T.add(new ArrayList<>(Collections.nCopies(SIZE, 0)));
        }

        for (int i = 0; i < SIZE; ++i) {
            for (int add = 1; add <= nums.get(i); ++add) {
                int newIndex = (i + add) % SIZE;
                T.get(newIndex).set(i, T.get(newIndex).get(i) + 1);
            }
        }

        // Matrix exponentiation
        List<List<Integer>> result = matrixExponentiation(T, t);

        // Apply transformation to frequency vector
        int[] updatedFreq = new int[SIZE];
        for (int i = 0; i < SIZE; ++i) {
            long value = 0;
            for (int j = 0; j < SIZE; ++j) {
                value = (value + 1L * result.get(i).get(j) * freq[j]) % MOD;
            }
            updatedFreq[i] = (int) value;
        }

        // Compute final length
        int resultLength = 0;
        for (int val : updatedFreq) {
            resultLength = (resultLength + val) % MOD;
        }

        return resultLength;
    }
}