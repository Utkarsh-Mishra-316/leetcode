class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> st=new ArrayDeque<>();
        int [] ans=new int[temperatures.length];
        int n=temperatures.length;
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && temperatures[i]>=temperatures[st.peek()]){
                st.pop();
            }
            if(!st.isEmpty()){
                ans[i]=st.peek()-i;
            }
            else{
                ans[i]=0;
            }
            st.push(i);
        }
        return ans;
    }
}