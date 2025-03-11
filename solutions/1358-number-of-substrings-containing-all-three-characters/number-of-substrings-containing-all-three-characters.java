class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();

        int[] c = new int[26];
        c['a' - 'a']++;
        c['b' - 'a']++;
        c['c' - 'a']++;

        int req = 3;

        int ans = 0;


        for(int i = 0, j=0; j<n; j++){
            if(--c[s.charAt(j) - 'a'] >= 0){
                req--;
            }
            if(req == 0){
                ans += n-j;
            }
            while(req == 0){
                if(++c[s.charAt(i++) - 'a'] > 0){
                    req++;
                }else{
                    ans+=n-j;
                }
            }
        }

        return ans;
    }
}