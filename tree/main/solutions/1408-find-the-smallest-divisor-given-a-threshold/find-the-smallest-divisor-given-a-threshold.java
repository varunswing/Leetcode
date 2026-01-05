class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int l = 1;
        int h = 0;

        for(int n: nums){
            h = Math.max(h, n);
        }

        int ans = h;

        while(l <= h){
            int m = l + (h-l)/2;

            int sum = 0;

            for(int n : nums){
                sum += (n + m - 1) / m;
            }

            if(sum <= threshold){
                ans = m;
                h = m-1;
            }else{
                l = m+1;
            }
        }

        return ans;
    }
}