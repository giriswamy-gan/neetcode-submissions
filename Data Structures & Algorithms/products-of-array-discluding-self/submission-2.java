class Solution {
    public int[] productExceptSelf(int[] nums) {
        int product = 1;
        int zeroCount = 0;
        boolean zeroFlag = false;
        boolean singleZeroFlag = false;
        for(int i = 0; i<nums.length; ++i) {
            if(nums[i] == 0) {
                zeroCount++;
            }
            if(zeroCount > 1) {
                zeroFlag = true;
                System.out.println("zero flag: true");
                break;
            }
            if(zeroCount > 0) {
                singleZeroFlag = true;
            }
            if(nums[i] != 0) {
                product = product * nums[i];
            }
        }
        System.out.println(zeroCount);
        int[] res = new int[nums.length];
        for(int i = 0; i<nums.length; ++i) {
            if(zeroFlag) {
                res[i] = 0;
                continue;
            }
            if(singleZeroFlag) {
                if(nums[i] == 0) {
                    res[i] = product;
                } else {
                    res[i] = 0;
                }
                continue;
            }
            if(nums[i] == 0) {
                res[i] = product;
            } else {
                res[i] = product / nums[i];
            }
        }
        return res;
    }
}  
