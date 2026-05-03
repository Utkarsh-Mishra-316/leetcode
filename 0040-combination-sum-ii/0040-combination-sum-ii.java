class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
         List<List<Integer>> ans=new ArrayList<>();
         Arrays.sort(candidates);
         cs(0,target,candidates,ans,new ArrayList<>());
          return ans;

    }
   static void cs(int index, int target,int []arr,List<List<Integer>> ans, List<Integer>ds){
    if(target==0){
        ans.add(new ArrayList<>(ds));
        return;
    }
    for(int i=index;i<arr.length;i++){
        if(i>index && arr[i]==arr[i-1]) continue;
        if(arr[i]>target) break;
        ds.add(arr[i]);
        cs(i+1,target-arr[i],arr,ans,ds);
         ds.remove(ds.size()-1);
    }
   
   } 
}