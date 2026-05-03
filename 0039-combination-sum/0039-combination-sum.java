class Solution {
    static void cs(int []candidates,int index,List<Integer> ds,int target, List<List<Integer>> ans){
        if(index==candidates.length){
            if(target==0){
                ans.add(new ArrayList<>(ds));
               
            }
             return;
        }
        if(candidates[index]<=target){
            
            ds.add(candidates[index]);
            cs(candidates,index,ds,target-candidates[index],ans);
            ds.remove(ds.size()-1);
        }
        cs(candidates,index+1,ds,target ,ans);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        int index;
   cs(candidates,0,new ArrayList<>(),target,ans);
   return ans;
    }
}