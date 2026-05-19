class Solution {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int count =0;
        int getindex=0;
        if(ruleKey.equals("type")){
            getindex=0;
        }
        else if(ruleKey.equals("color")){
            getindex=1;
        }
        else if(ruleKey.equals("name")){
            getindex=2;
        }
        for(List<String> item :items){
            if(item.get(getindex).equals(ruleValue)){
                count++;
            }
           
        }
         return count;
    }
}