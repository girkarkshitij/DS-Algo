import java.util.ArrayList;

public class Main{
    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 3);
        graph.addEdge(1, 4);
        graph.addEdge(1, 2);
        graph.addEdge(2, 4);
        graph.dfs(0);          // 0 1 4 2 3
    }
}

class Graph{
    int V;
    ArrayList<Integer>[] adj;

    Graph(int V){
        this.V = V;
        adj = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }
    }

    public void addEdge(int u, int v){
        adj[u].add(v);
    }

    public void dfs(int v){
        boolean[] visited = new boolean[V];
        dfsutil(v, visited);
    }

    public void dfsutil(int v,boolean[] visited){
        visited[v] = true;
        .out.print(v + " ");

        for (int temp : adj[v]) {
            if (!visited[temp])
                dfsutil(temp, visited);
        }
    }
}
