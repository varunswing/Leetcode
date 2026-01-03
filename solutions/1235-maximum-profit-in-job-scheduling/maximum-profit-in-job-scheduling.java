class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        
        int n = startTime.length;

        int[][] dp = new int[n][3];

        for(int i=0; i<n; i++){
            dp[i][0] = startTime[i];
            dp[i][1] = endTime[i];
            dp[i][2] = profit[i];
        }

        Arrays.sort(dp, (a, b) -> a[1] - b[1]);

        TreeMap<Integer, Integer> res = new TreeMap();

        res.put(0, 0);

        for(int i=0; i<n; i++){
            int s= dp[i][0];
            int e = dp[i][1];
            int p = dp[i][2];

            int prev = res.floorEntry(s).getValue();

            int cur = prev + p;

            if(cur > res.lastEntry().getValue()){
                res.put(e, cur);
            }
        }

        return res.lastEntry().getValue();
    }
}
