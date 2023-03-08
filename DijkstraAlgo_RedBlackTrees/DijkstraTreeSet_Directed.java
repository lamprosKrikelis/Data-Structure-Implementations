// Simple Undirected Graph . Works !!!


import javafx.util.Pair;
// import java.lang.management.MemoryManagerMXBean;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.TreeSet;
 // import java.util.Scanner;


// Shortest Path Dijkstra algorithm ... 

public class DijkstraTreeSet3
{
    static class path {
        int src ;
        int dest;
        int weight;

        public path(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }
    static class PairComparator implements Comparator<Pair<Integer, Integer>>{

        @Override
        public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
            //sort using distance values
            int key1 = o1.getKey();
            int key2 = o2.getKey();
            return key1-key2;
        }
    }

      
    static class Graph {
        int vertices; 
        LinkedList<path>[] adjacencylist;

        Graph(int vertices) {
            this.vertices = vertices;
            adjacencylist = new LinkedList[vertices];
            //initialize adjacency lists for all the vertices
            for (int i = 0; i <vertices ; i++) {
                adjacencylist[i] = new LinkedList<>();

            }

        }


        public void addEdge(int src, int dest, int weight) {
            path path = new path(src, dest, weight);
            adjacencylist[src].addFirst(path);

            path = new path(dest, src, weight);
            adjacencylist[dest].addFirst(path);             //for undirected graph
        }

        public void dijkstra_GetMinDistances(int sourceVertex){

            boolean[]  inSPT = new boolean[vertices];
            //distance used to store the distance of vertex from a source
            int [] distance = new int[vertices];

            //Initialize all the distances to infinity
            for (int i = 0; i <vertices ; i++) {
                distance[i] = Integer.MAX_VALUE;
            }
            //Initialize priority queue
            //override the comparator to do the sorting based keys
            TreeSet treeSet = new TreeSet<>(new PairComparator());
            //create the pair for for the first index, 0 distance 0 index
            distance[0] = 0;
            Pair<Integer, Integer> p0 = new Pair<>(distance[0],0);
            //add it to tree set
            treeSet.add(p0);

            //while priority queue is not empty
            while(!treeSet.isEmpty()){
                //extract the min
                Pair<Integer, Integer> extractedPair = (Pair<Integer, Integer>) treeSet.pollFirst();

                //extracted vertex
                int extractedVertex = extractedPair.getValue();
                if(inSPT[extractedVertex]==false) {
                    inSPT[extractedVertex] = true;

                    //iterate through all the adjacent vertices and update the keys
                    LinkedList<path> list = adjacencylist[extractedVertex];
                    for (int i = 0; i < list.size(); i++) {
                        path path = list.get(i);
                        int dest = path.dest;
                        //only if edge destination is not present 
                        if (inSPT[dest] == false) {
                            //check if distance needs an update or not
                            //means check total weight from source to vertex_V is less than
                            //the current distance value, if yes then update the distance
                            int newKey =  distance[extractedVertex] + path.weight ;
                            int currentKey = distance[dest];
                            if(currentKey>newKey){
                                Pair<Integer, Integer> p = new Pair<>(newKey, dest);
                                treeSet.add(p);
                                distance[dest] = newKey;
                            }
                        }
                    }
                }
            }
            //print Shortest Path Tree
            printDijkstra(distance, sourceVertex);                  
        }


        public void printDijkstra(int[] distance, int sourceVertex){
            for (int i = 0; i <vertices ; i++) {
                System.out.println("Source Vertex: " + sourceVertex + " to vertex " +   + i +
                        " distance: " + distance[i]);
            }
        }
    
        public static void main(String[] args) {
            int vertices = 6;
            Graph graph = new Graph(vertices);
            graph.addEdge(0, 1, 4);
            graph.addEdge(0, 2, 3);
            graph.addEdge(1, 2, 1);
            graph.addEdge(1, 3, 2);
            graph.addEdge(2, 3, 4);
            graph.addEdge(3, 4, 2);
            graph.addEdge(4, 5, 6);
            graph.dijkstra_GetMinDistances(0);
        }

    }
}
