/*
977. Squares of a Sorted Array

Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.

--------------------------------------------------------------------------------------------
Example 1:
Input: nums = [-4,-1,0,3,10]
Output: [0,1,9,16,100]
Explanation: After squaring, the array becomes [16,1,0,9,100].
After sorting, it becomes [0,1,9,16,100].

Example 2:
Input: nums = [-7,-3,2,3,11]
Output: [4,9,9,49,121]

Constraints:

1 <= nums.length <= 104
-104 <= nums[i] <= 104
nums is sorted in non-decreasing order.

--------------------------------------------------------------------------------------------

*/

class Solution {
    public int[] sortedSquares(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int len = nums.length - 1;
        int[] new_nums = new int[nums.length];
        while(left <= right){
            if(nums[left] * nums[left] <= nums[right] * nums[right]){
                new_nums[len] = nums[right] * nums[right];
                len--;
                right--;
            }else{
                new_nums[len] = nums[left] * nums[left];
                len--;
                left++;
            }
        }
        return new_nums;
    }
}