class Solution {
    public List<String> commonChars(String[] words) {
        List<String> list=new ArrayList<>();
        Map<Character,Integer> map=new HashMap<>();
        for(char ch: words[0].toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        for(int i=1;i<words.length;i++){
            Map<Character,Integer> ans=new HashMap<>();
            for(char ch: words[i].toCharArray()){
                ans.put(ch,ans.getOrDefault(ch,0)+1);
            
        }
        for(char ch:map.keySet()){
            int ind=ans.getOrDefault(ch,0);
            map.put(ch,Math.min(map.get(ch),ind));

        }}
        for(char ch:map.keySet()){
   int cnt=map.get(ch);
   while(cnt>0){
    list.add(String.valueOf(ch));
    cnt--;
   }
        }
        return list;
    }
}