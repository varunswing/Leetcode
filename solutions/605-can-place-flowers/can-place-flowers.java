class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(n==0){
            return true;
        }
        int planted = 0;

        int s = flowerbed.length;

        for(int i=0; i<s; i++){
            if(flowerbed[i] == 1) planted++;
        }

        int tp = planted + n;

        if(tp > Math.ceilDiv(s, 2)){
            return false;
        }

        if(s==1 && tp == 1){
            return true;
        }

        int ans = 0;

        if(flowerbed[0] == 0 && flowerbed[1] == 0){
            ans++;
        }

        if(flowerbed[s-1] == 0 && flowerbed[s-2] == 0){
            ans++;
        }

        for(int i=1; i<s-1; i++){
            if(flowerbed[i-1] == flowerbed[i+1] && flowerbed[i-1] == 0 && flowerbed[i] == 0){
                ans++;
                i++;
            }
        }

        return ans - n >= 0;
    }
}