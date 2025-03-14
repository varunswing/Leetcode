class Solution {
    public int[] anagramMappings(int[] nums1, int[] nums2) {
        Map<Integer, Integer> m = new HashMap<>();

        for(int i=0; i<nums2.length; i++){
            m.put(nums2[i], i);
        }

        for(int i=0; i<nums1.length; i++){
            nums1[i] = m.get(nums1[i]);
        }
        
        return nums1;
    }
}