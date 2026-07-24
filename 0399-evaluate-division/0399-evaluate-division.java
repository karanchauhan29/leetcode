class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        UF uf = new UF();

        for (int i = 0; i < equations.size(); i++) {
            List<String> eq = equations.get(i);
            String v1 = eq.get(0);
            String v2 = eq.get(1);
            double value = values[i];

            uf.union(v1, v2, value);
        }

        double[] result = new double[queries.size()];
        int i = 0;
        for (List<String> query : queries) {
            String v1 = query.get(0);
            String v2 = query.get(1);
            result[i++] = uf.getResult(v1, v2);
        }

        return result;
    }

    class UF {
        Map<String, Record> parent = new HashMap<>();

        public void union(String v1, String v2, double value) {
            // System.out.println("----" + "Enter union: " + v1 + ", " + v2 + "----");
            add(v1);
            add(v2);

            Record root1 = find(v1);
            Record root2 = find(v2);
            // System.out.println(v1 + "'s root: <" + root1.base + ", " + root1.multiple + ">");
            // System.out.println(v2 + "'s root: <" + root2.base + ", " + root2.multiple + ">");

            if (root1.base.equals(root2.base))
                return;
            parent.put(root1.base, new Record(root2.base, root2.multiple * value / root1.multiple));
            // Record rootRoot1 = parent.get(root1.base);
            // System.out.println("Connect v1 root to v2 root, v1 root: "+ root1.base + "'s new parent: <" + rootRoot1.base + ", " + rootRoot1.multiple + ">");
        }

        private void add(String v) {
            if (!parent.containsKey(v)) {
                parent.put(v, new Record(v, 1.0));
                // System.out.println("Put " + v + ": <" + v + ", 1.0>");
            }
        }

        public Record find(String v) {
            // System.out.println("----" + "Enter find: " + v + "----");
            Record p = parent.get(v);

            if (!p.base.equals(v)) {
                Record pp = find(p.base);
                parent.put(v, new Record(pp.base, pp.multiple * p.multiple));
            }

            return parent.get(v);
        }

        public double getResult(String v1, String v2) {
            if (!isConnected(v1, v2))
                return -1.0;

            return parent.get(v1).multiple / parent.get(v2).multiple;
        }

        private boolean isConnected(String v1, String v2) {
            if (!parent.containsKey(v1) || !parent.containsKey(v2))
                return false;

            return find(v1).base.equals(find(v2).base);
        }
    }

    class Record {
        String base;
        double multiple;

        public Record(String base, double multiple) {
            this.base = base;
            this.multiple = multiple;
        }
    }
}