class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int num: stones){
            pq.offer(num);
        }
        while(pq.size()>1){
            int a=pq.poll();
            int b=pq.poll();
            if(b!=a){            pq.offer(a-b);}

        }
        return pq.isEmpty() ? 0: pq.peek();
//         Arrays.sort(stones);
//  int l=stones.length;
//         for(int i=stones.length-1;i>=1;i--){
//             int n=stones[l-i]-stones[l-i-1];
//             stones[l-i-1]=n;
//             if(i==1){
//                 return n;
//             }
//         }
//         return stones[l-1];
    }
}