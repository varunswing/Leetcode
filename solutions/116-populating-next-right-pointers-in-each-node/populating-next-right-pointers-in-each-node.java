/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root == null){
            return null;
        }
        join(root.left, root.right);
        return root;        
    }

    public void join(Node p, Node q){
        if(p==null){
            return;
        }
        p.next = q;
        join(p.left, p.right);
        join(p.right, q.left);
        join(q.left, q.right);
    }
}