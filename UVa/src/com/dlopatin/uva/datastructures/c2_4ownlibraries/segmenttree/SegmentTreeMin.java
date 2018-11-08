package com.dlopatin.uva.datastructures.c2_4ownlibraries.segmenttree;

public class SegmentTreeMin {

    public static void main(String[] args) {
        int a[] = new int[]{18, 17, 13, 19, 15, 11, 20};
        SegmentTreeMin st = new SegmentTreeMin(a);
        System.out.printf("RMQ(1, 3) = %d\n", st.rmq(1, 3)); // answer = index 2
        System.out.printf("RMQ(4, 6) = %d\n", st.rmq(4, 6)); // answer = index 5
        System.out.printf("RMQ(3, 4) = %d\n", st.rmq(3, 4)); // answer = index 4
        System.out.printf("RMQ(0, 0) = %d\n", st.rmq(0, 0)); // answer = index 0
        System.out.printf("RMQ(0, 1) = %d\n", st.rmq(0, 1)); // answer = index 1
        System.out.printf("RMQ(0, 6) = %d\n", st.rmq(0, 6)); // answer = index 5

        System.out.printf("              idx    0, 1, 2, 3, 4,  5, 6\n");
        System.out.printf("Now, modify A into {18,17,13,19,15,100,20}\n");
        st.update(5, 100);                  // updateRange A[5] from 11 to 100
        System.out.printf("These values do not change\n");
        System.out.printf("RMQ(1, 3) = %d\n", st.rmq(1, 3));               // 2
        System.out.printf("RMQ(3, 4) = %d\n", st.rmq(3, 4));               // 4
        System.out.printf("RMQ(0, 0) = %d\n", st.rmq(0, 0));               // 0
        System.out.printf("RMQ(0, 1) = %d\n", st.rmq(0, 1));               // 1
        System.out.printf("These values change\n");
        System.out.printf("RMQ(0, 6) = %d\n", st.rmq(0, 6));            // 5->2
        System.out.printf("RMQ(4, 6) = %d\n", st.rmq(4, 6));            // 5->4
        System.out.printf("RMQ(4, 5) = %d\n", st.rmq(4, 5));            // 5->4
    }

    private final int data[];
    private final int st[];

    public SegmentTreeMin(int[] data) {
        this.data = data;
        st = new int[4 * data.length];
        build(1, 0, data.length - 1);
    }

    public int left(int p) {
        return p << 1;
    }

    public int right(int p) {
        return (p << 1) + 1;
    }

    public void build(int p, int l, int r) {
        if (l == r) {
            st[p] = l;
        } else {
            int m = l + (r - l) / 2;
            build(left(p), l, m);
            build(right(p), m + 1, r);
            int p1 = st[left(p)];
            int p2 = st[right(p)];
            st[p] = data[p1] <= data[p2] ? p1 : p2;
        }
    }

    public int rmq(int i, int j) {
        return rmq(1, 0, data.length - 1, i, j);
    }

    public int rmq(int p, int l, int r, int i, int j) {
        if (i > r || j < l) {
            return -1;
        }
        if (l >= i && r <= j) {
            return st[p];
        }
        int m = l + (r - l) / 2;
        int p1 = rmq(left(p), l, m, i, j);
        int p2 = rmq(right(p), m + 1, r, i, j);

        if (p1 == -1) {
            return p2;
        }
        if (p2 == -1) {
            return p1;
        }
        return data[p1] <= data[p2] ? p1 : p2;
    }

    public int update(int idx, int newVal) {
        return update(1, 0, data.length - 1, idx, newVal);
    }

    public int update(int p, int l, int r, int idx, int newVal) {
        // this updateRange code is still preliminary, i == j
        // must be able to updateRange range in the future!
        int i = idx;
        int j = idx;

        if (j < l || i > r) {
            return st[p];
        }
        if (i == l && j == r) {
            data[idx] = newVal;
            return st[p] = l;
        }
        int m = l + (r - l) / 2;
        int p1 = update(left(p), l, m, idx, newVal);
        int p2 = update(right(p), m + 1, r, idx, newVal);

        return st[p] = data[p1] <= data[p2] ? p1 : p2;
    }

}
