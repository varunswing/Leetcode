
func subsetXORSum(nums []int) int {
    // m of All Subset of XOR == sum of OR of all individual element left shift (<<) by n-1
    ans := 0
    for _, a := range nums{
        ans |= a
    }

    return ans << (len(nums)-1)
}