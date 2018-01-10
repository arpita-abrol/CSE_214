import java.util.*;
import java.lang.*;
import java.io.*;
 
class ShortestPath
{
    // A utility function to find the vertex with minimum distance value,
    // from the set of vertices not yet included in shortest path tree
    int V;
    int target;
    public ShortestPath( int n, int t ) {
        V = n;
        target = t;
    }
    int minDistance(int dist[], Boolean sptSet[])
    {
        // Initialize min value
        int min = Integer.MAX_VALUE, min_index=-1;
 
        for (int v = 0; v < V; v++)
            if (sptSet[v] == false && dist[v] <= min)
            {
                min = dist[v];
                min_index = v;
            }
 
        return min_index;
    }
 
    // A utility function to print the constructed distance array
    void printSolution(int dist[], int n)
    {
        System.out.println("Vertex\tDistance from Source");
        for (int i = 0; i < V; i++)
            System.out.println(i+"\t"+dist[i]);
    }
 
    // Funtion that implements Dijkstra's single source shortest path
    // algorithm for a graph represented using adjacency matrix
    // representation
    void dijkstra(int graph[][], int src)
    {
        int dist[] = new int[V]; // The output array. dist[i] will hold
                                 // the shortest distance from src to i
 
        // sptSet[i] will true if vertex i is included in shortest
        // path tree or shortest distance from src to i is finalized
        Boolean sptSet[] = new Boolean[V];
 
        // Initialize all distances as INFINITE and stpSet[] as false
        for (int i = 0; i < V; i++)
        {
            dist[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }
 
        // Distance of source vertex from itself is always 0
        dist[src] = 0;
 
        // Find shortest path for all vertices
        for (int count = 0; count < V-1; count++)
        {
            // Pick the minimum distance vertex from the set of vertices
            // not yet processed. u is always equal to src in first
            // iteration.
            int u = target;
 
            // Mark the picked vertex as processed
            sptSet[u] = true;
 
            // Update dist value of the adjacent vertices of the
            // picked vertex.
            for (int v = 0; v < 3; v++)
 
                // Update dist[v] only if is not in sptSet, there is an
                // edge from u to v, and total weight of path from src to
                // v through u is smaller than current value of dist[v]
                if (!sptSet[v] && graph[u][v]!=0 &&
                        dist[u] != Integer.MAX_VALUE &&
                        dist[u]+graph[u][v] < dist[v])
                    dist[v] = dist[u] + graph[u][v];
        }
 
        // print the constructed distance array
        printSolution(dist, V);
    }
 
    // Driver method
    public static void main (String[] args)
    {

        LinkedList<String> lines = new LinkedList<String>();

        File file = new File("in1.txt");
        int numTests = 0;
        int numLines = 0;
        // test to see if file is in folder
        try {
            Scanner input = new Scanner(file);

            while( input.hasNextLine() )
                lines.add(input.nextLine());
            input.close();

        }
        catch(Exception e) {
            System.out.println("File not found. Please add in1.txt");
            //e.printStackTrace();
            return;
        }

        //test to make sure there is a first line + valid test case
        try {
            numTests = Integer.parseInt((String)lines.getFirst());
        }
        catch(Exception e) {
            System.out.println("First line does not contain a number.");
            //e.printStackTrace();
        }

        if( numTests == 0 ) {
            System.out.println("No test cases given");
            return;
        }

        numLines = lines.size();

        /*one iteration of the for loop per test case-- note that i is incremented
          during the loop as well 
        */
        for( int i = 1; i < numLines; i++ ) { 
            int n = Integer.parseInt((((String)lines.get(i)).split(" "))[0]);

            //check for issues with n
            if( n < 1 ) {
                System.out.println("0");
                break;
            }

            i++;
            int source = Integer.parseInt((((String)lines.get(i)).split(" "))[0]);
            int destination = Integer.parseInt((((String)lines.get(i)).split(" "))[1]);

            //create matrix; make matrix into ints for simplicity
            String[][] matrixS = new String[n][n];
            int[][] matrixN = new int[n][n];
            for( int j = 0; j < n; j++ ) {
                i++;
                matrixS[j] = lines.get(i).split(" ");
            }
            for( int j = 0; j < n; j++ ) {
                for( int k = 0; k < n; k ++ ) {
                    matrixN[j][k] = Integer.parseInt(matrixS[j][k]);
                }
            }

            //Algo test = new Algo( n, matrixN, source, destination );

            System.out.println(n + "\t" + source + "\t" + destination);
        

            /* Let us create the example graph discussed above */
            int graph[][] = matrixN;
            ShortestPath t = new ShortestPath(n, destination);
            t.dijkstra(graph, 0);
        }
    }
}