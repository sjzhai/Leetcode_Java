/*
35. Search Insert Position

Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You must write an algorithm with O(log n) runtime complexity.

--------------------------------------------------------------------------------------------
Example 1:
Input: nums = [1,3,5,6], target = 5
Output: 2

Example 2:
Input: nums = [1,3,5,6], target = 2
Output: 1

Example 3:
Input: nums = [1,3,5,6], target = 7
Output: 4


Constraints:

1 <= nums.length <= 104
-104 <= nums[i] <= 104
nums contains distinct values sorted in ascending order.
-104 <= target <= 104

--------------------------------------------------------------------------------------------

*/

class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        if(right == 0){
            if(target > nums[0])
                return nums.length;
            return 0;
        }
        while(left < right){
            int mid = left + ((right - left) / 2);
            int val = nums[mid];

            if(target == val){
                return mid;
            }
            else if(target < val){
                //Find out left value whether bigger than target value
                int leftLen = mid-1;
                if(leftLen >= 0){
                    int leftVal = nums[leftLen];
                    if(target == leftVal){
                        return mid - 1;
                    }else if(target > leftVal){
                        return mid;
                    }
                }
                right = mid - 1;
            }
            else if(target > val){
                //Find out right value whether smaller than target value
                int rightVal = nums[mid+1];
                if(target == rightVal){
                    return mid + 1;
                }else if(target < rightVal){
                    return mid + 1;
                }
                left = mid + 1;
            }
        }
        if(target <= nums[0])
            return 0;
        return nums.length;
    }
}