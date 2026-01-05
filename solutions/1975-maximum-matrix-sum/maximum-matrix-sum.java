class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int m = matrix.length;

        long sum = 0;

        int neg = 0;

        int min = Integer.MAX_VALUE;

        for(int i=0; i<m; i++){
            for(int j=0; j<m; j++){
                int v = matrix[i][j];

                if(v < 0){
                    neg++;
                }

                min = Math.min(min, Math.abs(v));

                sum+= Math.abs(v);
            }

            
        }
        if(neg %2 == 0){
            return sum;
        }

        return sum - 2*min;
    }
}