class Solution {
    public int findCircleNum(int[][] isConnected) {
        List<Integer>[] graph= new ArrayList[isConnected.length];
        for(int i =0;i<isConnected.length ;i++){
            graph[i]= new ArrayList<>();

        }

        for(int i =0;i< graph.length;i++){
            
            for(int j =0;j< isConnected[i].length ;j++){
                if(isConnected[i][j]==1){
                    graph[i].add(j);
                }
            }
        }


        int count = 0;
        boolean vis[]= new boolean[graph.length];

        for(int i =0;i<graph.length ;i++){
            if(!vis[i]){
                count++;
                search(graph,vis,i);
            }
        }

        return count ;    
    }
    
     private void search(List<Integer>[] graph, boolean[] vis, int cur) {
        vis[cur]= true;
        Queue<Integer> que = new LinkedList<>(); 
        que.add(cur);

        while(!que.isEmpty()){
            int me = que.poll();
            List<Integer> l = graph[me];
            for (Integer integer : l) {
                if (!vis[integer]) {
                    vis[integer] = true;
                    que.add(integer);
                }
            }
        }
    }

}