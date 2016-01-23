import java.util.ArrayList;
import java.util.List;

/**
 * Created by Emil on 21/01/16.
 */
public class Node {
    public int id;
    boolean in_tree;

    List<Edge> edges = new ArrayList<Edge>();

    public Node(int id) {
        this.id = id;
        this.in_tree = false;
    }

    void addEdge(Edge edge) {
        edges.add(edge);
    }
}
