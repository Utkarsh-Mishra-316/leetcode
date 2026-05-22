class Solution {
    public boolean isValidSerialization(String preorder) {
        int slot=1;
  String [] nodes=preorder.split(",");
  for(String node: nodes){
    slot--;
    if(slot<0){return false;}
    if(!node.equals("#"))
    {
        slot+=2;
    }

  }
  return slot==0;
    }
}