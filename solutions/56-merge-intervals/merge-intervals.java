class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new int[0][];
        }

        // 1. Sort by start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>();
        // Start with the first interval
        int[] current = intervals[0];
        merged.add(current);

        // 2. Iterate and merge
        for (int i = 1; i < intervals.length; i++) {
            int[] next = intervals[i];

            // if overlap: next.start <= current.end
            if (next[0] <= current[1]) {
                // merge by extending the end
                current[1] = Math.max(current[1], next[1]);
            } else {
                // no overlap, move current and add to list
                current = next;
                merged.add(current);
            }
        }

        // 3. Convert list back to array
        return merged.toArray(new int[merged.size()][]);
    }
}
