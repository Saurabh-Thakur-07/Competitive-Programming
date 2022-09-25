class Solution {
    class custom
    {
        String name;
        int height;
        public custom(String n,int h)
        {
            this.name=n;this.height=h;
        }
    }
     class cmp implements Comparator<custom>{
    public int compare(custom a , custom b)
    {
        if(a.height < b.height)
        {
            return 1;
        }
        else if(a.height > b.height)
        {
            return -1;
        }
        else
        {
            return 0;
        }
    }
}
    public String[] sortPeople(String[] names, int[] heights) {
        PriorityQueue<custom> pq = new PriorityQueue<>(new cmp());
        for(int i=0;i<heights.length;i++)
        {
            pq.add(new custom(names[i],heights[i]));
        }
        String[] ans = new String[heights.length];
        int k=0;
        while(!pq.isEmpty())
        {
            ans[k++]=pq.remove().name;
        }
        return ans;
    }
}
