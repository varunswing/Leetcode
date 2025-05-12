import java.util.*;

class Solution {
    public int[] findEvenNumbers(int[] digits) {
        Map<Integer, Integer> mp = new HashMap<>();
        for (int digit : digits) {
            mp.put(digit, mp.getOrDefault(digit, 0) + 1);
        }

        List<Integer> res = new ArrayList<>();

        for (int i = 1; i <= 9; i++) {
            if (mp.getOrDefault(i, 0) == 0) continue;
            mp.put(i, mp.get(i) - 1);

            for (int j = 0; j <= 9; j++) {
                if (mp.getOrDefault(j, 0) == 0) continue;
                mp.put(j, mp.get(j) - 1);

                for (int k = 0; k <= 8; k += 2) {
                    if (mp.getOrDefault(k, 0) == 0) continue;
                    mp.put(k, mp.get(k) - 1);
                    
                    res.add(i * 100 + j * 10 + k);

                    mp.put(k, mp.get(k) + 1);
                }

                mp.put(j, mp.get(j) + 1);
            }

            mp.put(i, mp.get(i) + 1);
        }

        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
