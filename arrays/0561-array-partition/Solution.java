import java.util.Arrays;

class Solution {
    public int arrayPairSum(int[] nums) { //함수의 매개변수
        Arrays.sort(nums); // 오름차순 정렬

        // 인접한 두 개의 쌍을 더함
        int sum =0;
        
        for(int i = 0; i<nums.length; i +=2){
            sum += nums[i];
        }
        return sum;
    }
}
