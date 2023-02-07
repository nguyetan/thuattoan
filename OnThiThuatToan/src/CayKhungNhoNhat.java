import java.util.Arrays;


public class CayKhungNhoNhat {
    public static int find(int[] parent, int i) {
        if (parent[i] == -1) {
            return i;
        }
        return find(parent, parent[i]);
    }
    public static void union(int[] parent, int x, int y) {
        int xset = find(parent, x);
        int yset = find(parent, y);
        parent[xset] = yset;
    }
    public static void kruskalsMST(int[][] graph) {
        int n = graph.length;
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = -1;
        }
        int e = 0;
        int i = 0;
        while (e < n - 1) {
            int min = Integer.MAX_VALUE;
            int a = -1, b = -1;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (find(parent, j) != find(parent, k) && graph[j][k] < min) {
                        min = graph[j][k];
                        a = j;
                        b = k;
                    }
                }
            }
            union(parent, a, b);
            System.out.println("Edge " + ++e + ": (" + a + ", " + b + ") cost: " + min);
        }
    }
    public static void main(String[] args)
    {
        int graph[][] = new int[][] { { 0, 3, 0, 0, 0, 0, 0, 7, 0 },
                { 3, 0, 7, 0, 0, 0, 0, 10, 4 },
                { 0, 7, 0, 6, 0, 2, 0, 0, 1 },
                { 0, 0, 6, 0, 8, 13, 0, 0, 3 },
                { 0, 0, 0, 8, 0, 9, 0, 0, 0 },
                { 0, 0, 2, 13, 9, 0, 4, 0, 5 },
                { 0, 0, 0, 0, 0, 4, 0, 2, 5 },
                { 7, 10, 0, 0, 0, 0, 2, 0, 6 },
                { 0, 4, 1, 3, 0, 5, 5, 6, 0 } };
        for (int i = 0; i < graph.length; i++)
        {
            for (int j = 0; j < graph.length; j++)
            {
                if (graph[i][j] == 0) {
                    graph[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        kruskalsMST((graph));
    }
}
