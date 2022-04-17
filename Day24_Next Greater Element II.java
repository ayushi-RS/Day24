class Solution {
   public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<Integer>();
        int n = nums.length;
        int[] ans = new int[n];
        int i;
        for (i = n - 1; i >= 0; i -= 1) {
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                ans[i] = nums[stack.peek()];
            } else {
                ans[i] = -1;
            }
            stack.push(i);
        }
        // System.out.println(Arrays.toString(ans));
        for (i = n - 1; i >= 0; i -= 1) {
            boolean flag = false;
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[i]) {
                if (stack.peek() == i) {
                    flag = true;
                    break;
                }
                stack.pop();
            }
            if (flag) break;
            if (!stack.isEmpty()) {
                ans[i] = nums[stack.peek()];
            } else {
                ans[i] = -1;
            }
            stack.push(i);
        }
        // System.out.println(Arrays.toString(ans));
        return ans;
        
    }
}