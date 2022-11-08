class Solution {
    class two
    {
        int win,loss;
        public two(){}
        public two(int win,int loss)
        {
            this.win=win;this.loss=loss;
        }
    }
    public List<List<Integer>> findWinners(int[][] matches) {
        HashMap<Integer,two> map = new HashMap<>();
        for(int[] val : matches)
        {
            int winner = val[0],loser=val[1];
            if(map.containsKey(winner)==true)
            {
                two a = map.get(winner);
                a.win += 1;
                map.put(winner,a);
            }
            else
            {
                two a = new two();
                a.loss=0;
                a.win = 1;
                map.put(winner,a);
            }
            if(map.containsKey(loser)==true)
            {
                two a = map.get(loser);
                a.loss += 1;
                map.put(loser,a);
            }
            else
            {
                two a = new two();
                a.win=0;
                a.loss = 1;
                map.put(loser,a);
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> win = new ArrayList<>();
        List<Integer> los = new ArrayList<>();
        for(Map.Entry<Integer,two> hm : map.entrySet())
        {
            int key = hm.getKey();
            two a = hm.getValue();
            if(a.win >0 && a.loss == 0)
                win.add(key);
            if(a.loss == 1)
                los.add(key);
        }
        Collections.sort(win);
        Collections.sort(los);
        ans.add(win);
        ans.add(los);
        return ans;
    }
}
