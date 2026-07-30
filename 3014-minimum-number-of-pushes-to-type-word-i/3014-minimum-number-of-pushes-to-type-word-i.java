class Solution {
    public int minimumPushes(String word) {
        int arr[]=new int [26];

        for( char ch:word.toCharArray()){
            arr[ch-'a']++;
        }
        int ans=0;
        Arrays.sort(arr);
        for(int i=25;i>=0;i--){
            int cost=(25-i)/8+1;
            
            ans+=arr[i]*(cost);
        }
        return ans;
    }
}