import java.util.Comparator;

public class VertexComparator implements Comparator<Vertex>{

    @Override
    public int compare(Vertex node, Vertex node2) {
        if(node.getDistance() < node2.getDistance())
            return 1;
        else if(node.getDistance() > node2.getDistance())
            return -1;
        return 0;
    }
    
}
