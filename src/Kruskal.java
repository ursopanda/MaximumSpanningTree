import java.io.*;
import java.util.*;

public class Kruskal
{
    private final int MAX_NODES = 99;
    private HashSet nodes[];               // Array of connected components
    private TreeSet allEdges;              // Priority queue of Edge objects
    private Vector allNewEdges;            // Edges in Minimal-Spanning Tree
    int newWeightSum, weightSum, k, newK = 0;

    public static void main(String args[]) throws FileNotFoundException {
        Kruskal k = new Kruskal();
        k.readData();
        k.performKruskal();
        k.printFinalEdges();
    }

    Kruskal() {
        // Konstruktor
        nodes = new HashSet[MAX_NODES];      // Create array for components
        allEdges = new TreeSet(new Edge());  // Create empty priority queue
        allNewEdges = new Vector(MAX_NODES); // Create vector for MST edges
    }

    // Scanner class object for reading data from file using .nextInt() method
    private void readData() throws FileNotFoundException {
            Scanner scanner = new Scanner(new File("main.in"));
            int from, to, cost = 0;
            int n = scanner.nextInt();

        while (scanner.hasNextInt()) {
                from = scanner.nextInt();
                to = scanner.nextInt();
                cost = scanner.nextInt() * (-1);
                weightSum += cost;
                k++;
                allEdges.add(new Edge(from, to, cost));

                if (nodes[from] == null)
                {
                    // Create set of connect components [singleton] for this node
                    nodes[from] = new HashSet(2*MAX_NODES);
                    nodes[from].add(new Integer(from));
                }
                if (nodes[to] == null) {
                    // Create set of connect components [singleton] for this node
                    nodes[to] = new HashSet(2*MAX_NODES);
                    nodes[to].add(new Integer(to));
                }
            }
    }

    private void performKruskal()
    {
        int size = allEdges.size();
        for (int i=0; i<size; i++) {
//            Edge curEdge = (Edge) allEdges.last();
            Edge curEdge = (Edge) allEdges.first();
            if (allEdges.remove(curEdge)) {
                // successful removal from priority queue: allEdges

                if (nodesAreInDifferentSets(curEdge.from, curEdge.to)) {
                    // System.out.println("Nodes are in different sets ...");
                    HashSet src, dst;
                    int dstHashSetIndex;

                    if (nodes[curEdge.from].size() > nodes[curEdge.to].size()) {
                        // have to transfer all nodes including curEdge.to
                        src = nodes[curEdge.to];
                        dst = nodes[dstHashSetIndex = curEdge.from];
                    } else {
                        // have to transfer all nodes including curEdge.from
                        src = nodes[curEdge.from];
                        dst = nodes[dstHashSetIndex = curEdge.to];
                    }

                    Object srcArray[] = src.toArray();
                    int transferSize = srcArray.length;
                    for (int j=0; j<transferSize; j++) {
                        // move each node from set: src into set: dst
                        // and update appropriate index in array: nodes
                        if (src.remove(srcArray[j])) {
                            dst.add(srcArray[j]);
                            nodes[((Integer) srcArray[j]).intValue()] = nodes[dstHashSetIndex];
                        } else {
                            // This is a serious problem
                            System.out.println("Something wrong: set union");
                            System.exit(1);
                        }
                    }

                    allNewEdges.add(curEdge);
                    // add new edge to MST edge vector
                } else {
//                    System.out.println(nodes[curEdge.from] + " " + nodes[curEdge.to]);
                }

            } else {
                // This is a serious problem
                System.out.println("TreeSet should have contained this element!!");
                System.exit(1);
            }
        }
    }

    private boolean nodesAreInDifferentSets(int a, int b) {
        // returns true if graph nodes (a,b) are in different
        // connected components, ie the set for 'a' is different
        // from that for 'b'
        return(!nodes[a].equals(nodes[b]));
    }

    private void printFinalEdges() {
        while (!allNewEdges.isEmpty()) {
            // for each edge in Vector of MST edges
            Edge e = (Edge) allNewEdges.firstElement();
            System.out.println("(" + e.from + ", " + e.to +
                    ") " + e.cost * (-1));
            newK++;
            newWeightSum += (e.cost * (-1));
            allNewEdges.remove(e);
        }
        System.out.println("Dobumu skaits, kuros jāizvieto medus " + (k - newK) + " \n" +
                "Dobumu grūtības pakāpju summa : " + ((weightSum * (-1)) - newWeightSum));
    }

    class Edge implements Comparator
    {
        // Inner class for representing edge+end-points
        public int from, to, cost;
        public Edge() {
            // Default constructor for TreeSet creation
        }
        public Edge(int f, int t, int c) {
            // Inner class constructor
            from = f; to = t; cost = c;
        }
        public int compare(Object o1, Object o2)
        {
            // Used for comparisions during add/remove operations
            int cost1 = ((Edge) o1).cost;
            int cost2 = ((Edge) o2).cost;
            int from1 = ((Edge) o1).from;
            int from2 = ((Edge) o2).from;
            int to1   = ((Edge) o1).to;
            int to2   = ((Edge) o2).to;

            if (cost1 < cost2)
                return(-1);
            else if (cost1 == cost2 && from1 == from2 && to1 == to2)
                return(0);
            else if (cost1 == cost2)
                return(-1);
            else if (cost1 > cost2)
                return(1);
            else
                return(0);
        }
        public boolean equals(Object obj)
        {
            // Used for comparisions during add/remove operations
            Edge e = (Edge) obj;
            return (cost == e.cost && from == e.from && to == e.to);
        }
    }

}