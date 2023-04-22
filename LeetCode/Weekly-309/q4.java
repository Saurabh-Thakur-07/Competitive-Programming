class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings,(a,b)->a[0]-b[0]);
        int[]  count=new int[n];
        PriorityQueue<long[]> roomsBusy = new PriorityQueue<long[]>((a,b)->{
            long t1=a[1], t2=b[1];
            return t1==t2?(int)(a[0]-b[0]):(int)(t1-t2);
        });
        PriorityQueue<long[]> roomsAvailable = new PriorityQueue<>((a,b)->(int)(a[0]-b[0]));
        for(int i=0;i<n&&i<meetings.length;i++) roomsAvailable.add(new long[] {i,0});
        for(int i=0;i<meetings.length;i++) {
            int meetingStart=meetings[i][0];
            int meetingEnd=meetings[i][1];
            while(!roomsBusy.isEmpty()&&(roomsAvailable.isEmpty()||roomsBusy.peek()[1]<=meetingStart)) {
                roomsAvailable.add(roomsBusy.remove());
            }
            long[] nextRoom = roomsAvailable.remove();
            count[(int)nextRoom[0]]++;
            nextRoom[1]=Math.max(meetingEnd,meetingEnd-meetingStart+nextRoom[1]);
            roomsBusy.add(nextRoom);
        }
        int max=0;
        for(int i=1;i<count.length;i++) if(count[i]>count[max]) max=i;
        return max;
    }
}
