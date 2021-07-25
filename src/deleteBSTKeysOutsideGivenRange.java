public class deleteBSTKeysOutsideGivenRange {
    public static void main(String[] args) {
        Node n = new Node(6);
        n.left = new Node(-13);
        n.left.right = new Node(-8);
        n.right = new Node(14);
        n.right.left = new Node(13);
        n.right.right = new Node(15);
        n.right.left.left = new Node(7);
        Node out = removekeys(n, -10, 13);
        print(out);
    }

    static Node removekeys(Node root, int l, int r) {
        Node temp = root;
        if (temp.data < l || temp.data > r)
            remove(root, temp);
        if (temp.left != null)
            removekeys(temp.left, l, r);
        temp = root;
        if (temp.right != null)
            removekeys(temp.right, l, r);
        return root;
    }

    static void remove(Node root, Node x) {
        if (x.left == null && x.right == null) {
            x = null;
            return;
        }
        Node temp = x;
        if (temp.right != null) {
            while (temp.right != null) {
                temp = temp.right;
            }
            x.data = temp.data;
            temp = null;
            return;
        }
        if (temp.left != null) {
            temp = temp.left;
            while (temp.right != null) {
                temp = temp.right;
            }
            x.data = temp.data;
            temp = null;
            return;
        }
    }

    static void print(Node n) {
        while (n != null) {
            print(n.left);
            System.out.print(n.data + " ");
            print(n.right);
        }
    }

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }
}
