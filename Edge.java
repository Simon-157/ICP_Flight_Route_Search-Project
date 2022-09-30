public class Edge {
    
public Route e;
    
public double weight;

public Edge(Route e) {
    this(e, 0.0);
}

public Edge(Route e, double weight) {
    if (e == null) {
        throw new NullPointerException("Argument must not be null");
    }
    
    if (weight < 0) {
        throw new IllegalArgumentException("negative weight");
    }
    
    this.e = e;
    this.weight = weight;
}

public String toString() {
    return "(" + this.e + ":" + this.weight + ")";
}
}