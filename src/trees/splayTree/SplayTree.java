package trees.splayTree;

import trees.TreeNode;


public class SplayTree<Key extends Comparable<Key>,Val> {

    private TreeNode root;

    public boolean isEmpty(){
        return isEmpty(root);
    }

    private boolean isEmpty(TreeNode node) {
        return node == null;
    }

    public void insert(Key k, Val v){
        root = insert(k,v,root);
    }

    private TreeNode insert(Key k, Val v, TreeNode node) {
        return node;
    }

    private TreeNode splay(TreeNode current, TreeNode root){

        return root;
    }

    public void splay(Key k){
        root = splay(find(k),root);
    }

    private TreeNode find(Key k) {
        return find(k, root);
    }

    private TreeNode find(Key k, TreeNode node) {
        if(isEmpty(node))
            return null;
        else if(node.key.compareTo(k) < 0)
            return find(k, node.right);
        else if(node.key.compareTo(k) > 0)
            return find(k, node.left);
        else //if(node.key.compareTo(k) == 0)
            return node;
    }

    public void delete(Key k){
        splay(k);
        if(!isEmpty(root)) {
            root = join(root.left, root.right);
        }
    }

    private TreeNode join(TreeNode left, TreeNode right) {
        left = splay(max(left),left);
        if(!isEmpty())
            left.right = right;
        return left;
    }

    private TreeNode max(TreeNode node){
        while(node.right != null){
            node = node.right;
        }

        return node;
    }

    private TreeNode[] split(Key k){
        splay(k);
        return new TreeNode[]{root.left, root.right};
    }
}
