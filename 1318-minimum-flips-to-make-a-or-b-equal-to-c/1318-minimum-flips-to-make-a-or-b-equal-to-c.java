class Solution {
    public int minFlips(int a, int b, int c) {
        int ans = 0;
        while (a > 0 || b > 0 || c > 0) {
            int ab = a & 1;
            int bb = b & 1;
            if ((c & 1) == 0) {
                if (ab == 1)
                    ans++;
                if (bb == 1)
                    ans++;
            } else if (ab == 0 && bb == 0)
                ans++;
            a >>= 1;
            b >>= 1;
            c >>= 1;
        }
        return ans;
    }
}