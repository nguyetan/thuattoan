import java.util.Arrays;
class DijkstraNganNhat {
    int[][] adjMatrix;
    int numOfvertices;
    DijkstraNganNhat(int[][] mat, int v)
    {
        this.adjMatrix = mat;
        this.numOfvertices = v;
    }
    void addEdge(int src, int dest, int edgeWeight)
    {
        adjMatrix[src][dest] = edgeWeight;
        adjMatrix[dest][src] = edgeWeight;
    }
    public static int getClosestVertex(int[] distance, boolean[] visited)
    {
        int min = Integer.MAX_VALUE;
        int minIdx = -1;
        for(int i=0; i<distance.length; i++)
        {
            if(distance[i] < min)
                if(visited[i] == false)
                {
                    min = distance[i];
                    minIdx = i;
                }
        }
        return minIdx;
    }
    public static int[] dijkstrasShortestPath(DijkstraNganNhat g, int src)
    {
        int[] distance = new int[g.numOfvertices];
        boolean[] visited = new boolean[g.numOfvertices];

        for(int i=0; i<g.numOfvertices; i++)
        {
            distance[i] = Integer.MAX_VALUE;
            visited[i] = false;
        }
        distance[src] = 0;
        for(int i=0; i<g.numOfvertices; i++)
        {
            int closestVertex = getClosestVertex(distance, visited);
            if(closestVertex == Integer.MAX_VALUE)
                return distance;
            visited[closestVertex] = true;
            for(int j=0; j<g.numOfvertices; j++)
            {
                if(visited[j] == false)
                {
                    if(g.adjMatrix[closestVertex][j] != 0)
                    {
                        int d = distance[closestVertex] + g.adjMatrix[closestVertex][j];
                        if(d < distance[j])
                            distance[j] = d;
                    }
                }
            }
        }
        return distance;
    }
    public static void main(String[] args)
    {
        int numOfVertices = 6;
        int[][] adjMat = new int[6][6];
        DijkstraNganNhat graph = new DijkstraNganNhat(adjMat, numOfVertices);
        graph.addEdge(0, 4, 21);
        graph.addEdge(0, 3, 18);
        graph.addEdge(2, 1, 7);
        graph.addEdge(1, 4, 6);
        graph.addEdge(4, 5, 10);
        graph.addEdge(4, 3, 11);
        graph.addEdge(5, 3, 7);
        int[] dist = dijkstrasShortestPath(graph, 0);
        System.out.print(Arrays.toString(dist));
    }
}

