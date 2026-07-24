class Solution {
    int ans = 0;
    public int minReorder(int n, int[][] cons) {
        List<Integer>[] adj = new ArrayList[n];
        List<Integer>[] frm = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
            frm[i] = new ArrayList<>();
        }
        for (int[] con : cons) {
            int u = con[0];
            int v = con[1];
            adj[u].add(v);
            adj[v].add(u);
        }
        for (int[] con : cons) {
            frm[con[0]].add(con[1]);
        }
        dfs(0, adj, frm, new boolean[n]);
        return ans;
    }
    private void dfs(int node, List<Integer>[] adj, List<Integer>[] frm, boolean[] vis) {
        vis[node] = true;
        for (int nei : adj[node]) {
            if (vis[nei]) continue;
            if (frm[node].contains(nei))
                ans++;
            dfs(nei, adj, frm, vis);
        }
    }
}