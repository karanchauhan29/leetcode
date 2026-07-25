class Solution {
    record Pair(int a, int b) {}
    public long maxScore(int[] a, int[] b, int k) {
        int n = a.length;
        Pair[] pairs = new Pair[n];
        for (int i = 0; i < n; ++i) pairs[i] = new Pair(a[i], b[i]);
        Arrays.sort(pairs, (x, y) -> y.b - x.b);
        Queue<Integer> q = new PriorityQueue<>(k+1);
        long res = 0, sum = 0;

        int i = 0;
        for (; i < k; i++) {
            int x = pairs[i].a;
            sum += x;
            q.add(x);
        }
        res = Math.max(res, sum * pairs[i-1].b);

        for (; i < n; i++) {
            q.add(pairs[i].a);
            sum += pairs[i].a;
            sum -= q.poll();
            res = Math.max(res, sum * pairs[i].b);
        }
        return res;
    }
}