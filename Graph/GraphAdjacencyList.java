import java.util.ArrayList;

public class Main{
    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.printGraph();

//        0: -->1-->4
//        1: -->0-->2-->3-->4
//        2: -->1-->3
//        3: -->1-->2-->4
//        4: -->0-->1-->3
    }
}

class Graph{
    ArrayList<ArrayList<Integer>> adj;
    int V;

    Graph(int numberOfVertices){
        this.V = numberOfVertices;
        adj = new ArrayList<>(V);

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
    }

    public void addEdge(int u, int v){
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    public void printGraph(){
        for (int i = 0; i < adj.size(); i++) {
            System.out.print(i+": " );
            for (int j = 0; j < adj.get(i).size(); j++) {
                System.out.print("-->"+adj.get(i).get(j));
            }
            System.out.println();
        }
    }
}
