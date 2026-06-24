class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
    return false;
}
int [] sch=new int[128];
int []tch=new int[128];
for(int i=0;i<s.length();i++){
    char ss=s.charAt(i);
    char tt=t.charAt(i);
    if(sch[ss]!=tch[tt]){
        return false;
    }
    sch[ss]=i+1;
    tch[tt]=i+1;
}
return true;
//          HashMap<Character ,Character> maps=new HashMap<>();
//                  HashMap<Character ,Character> mapt=new HashMap<>();
//                  for(int i=0;i<s.length();i++){
//                     char sch=s.charAt(i);
//                     char tch=t.charAt(i);
//                     if(maps.containsKey(sch) && maps.get(sch)!=tch){
//                         return false;
//                     }
//                     if(mapt.containsKey(tch) && mapt.get(tch)!=sch){
//                         return false;
//                     }
//                     maps.put(sch,tch);
//                     mapt.put(tch,sch);
//                  }
//  return true;
    }
}