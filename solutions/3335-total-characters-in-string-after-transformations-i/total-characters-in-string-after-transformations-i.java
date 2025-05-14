class Solution {
    private final int M = 1_000_000_007;
    public int lengthAfterTransformations(String s, int t) {
        
        int[] mp = new int[26];

        for(Character c : s.toCharArray()){
            mp[c-'a']++;
        }

        for(int j=0; j<t; j++){

            int[] temp = new int[26];
            for(int i=0; i<26; i++){
                char ch = (char)(i+'a');
                int freq = mp[i];

                if(ch != 'z'){
                    temp[(ch + 1) - 'a'] = temp[(ch + 1) - 'a'] + freq;
                }else{
                    temp['a'-'a'] = (temp['a' - 'a'] + freq) % M;
                    temp['b'-'a'] = (temp['b' - 'a'] + freq) % M;
                }
            }

            mp = temp;
        }

        int ans = 0;

        for(int i=0; i<26; i++){
            ans = (ans + mp[i]) % M;
        }

        return ans;
    }
}