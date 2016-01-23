/**
 * Created by Emil on 21/01/16.
 */
public class Edge {
    public int sakums, beigas, dobums;

    public Edge() {
        this.sakums = 0;
        this.beigas = 0;
        this.dobums = 0;
    }

    public Edge(int sakums, int beigas, int dobums) {
        this.sakums = sakums;
        this.dobums = dobums;
        this.beigas = beigas;
    }

    boolean comparator(Edge i, Edge j) {
        return i.dobums > j.dobums;
    }
}

