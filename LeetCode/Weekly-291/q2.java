class Solution {
    public int minimumCardPickup(int[] cards) {
        HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
        for(int i = 0 ; i < cards.length ; i++){
            ArrayList<Integer> li = map.getOrDefault(cards[i],new ArrayList<Integer>());
            li.add(i);
            map.put(cards[i],li);
        }
        boolean flag = false;
        int min = Integer.MAX_VALUE;
         for (ArrayList<Integer> list : map.values()) {
             if(list.size()>1){
                 flag=true;
                 for(int j = 0 ; j < list.size()-1 ; j++){
                     min=Math.min(min,(list.get(j+1)-list.get(j)+1));
                 }
                 
             }
         }
        if(flag==false){
            return -1;
        }
        else{
            return min;
        }
        
    }
}
