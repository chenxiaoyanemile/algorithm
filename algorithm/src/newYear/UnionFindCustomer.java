package newYear;

import java.util.Arrays;

// ���鼯ģ��
public class UnionFindCustomer {
    int[] parent;
    int[] size;
    int n;
    // ��ǰ��ͨ������Ŀ
    int setCount;

    public UnionFindCustomer(int n) {
        this.n = n;
        this.setCount = n;
        this.parent = new int[n];
        this.size = new int[n];
        Arrays.fill(size, 1);
        for (int i = 0; i < n; ++i) {
            parent[i] = i;
        }
    }
    
    public int findset(int x) {
        return parent[x] == x ? x : (parent[x] = findset(parent[x]));
    }
    
    public boolean unite(int x, int y) {
        x = findset(x);
        y = findset(y);
        if (x == y) {
            return false;
        }
        if (size[x] < size[y]) {
            int temp = x;
            x = y;
            y = temp;
        }
        parent[y] = x;
        size[x] += size[y];
        --setCount;
        return true;
    }
    
    public boolean connected(int x, int y) {
        x = findset(x);
        y = findset(y);
        return x == y;
    }


}
