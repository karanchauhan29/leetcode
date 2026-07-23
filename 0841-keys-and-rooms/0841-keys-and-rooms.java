class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        visited[0]=true;
        q.offer(0);
        int count = 1;
        while(!q.isEmpty()){
            int room = q.poll();
            for( int keys : rooms.get(room) ){
                if(!visited[keys]){
                    visited[keys]=true;
                    q.offer(keys);
                    count++;
                }
            }
        }
        return count == n;
        
    }
}