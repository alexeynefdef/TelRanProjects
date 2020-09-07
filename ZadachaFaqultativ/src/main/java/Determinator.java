import org.w3c.dom.Node;

public class Determinator {

    public int getHeight(Node root) {
        if (root == null) return 0;
        return 1 + Math.max(getHeight(root.getFirstChild()), getHeight(root.getLastChild()));
    }
}
