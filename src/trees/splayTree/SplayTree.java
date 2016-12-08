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
        TreeNode[] nodes =split(k);
        root = new TreeNode(k, v,nodes[0],nodes[1]);
    }

    private TreeNode splay(Key k,  TreeNode gp, TreeNode parent, TreeNode node){
        if(node !=null){
            if(node.key.compareTo(k) < 0) {
                gp = splay(k, parent,node, node.right);
                return splayOperation(gp, node, node.right);
            }else if(node.key.compareTo(k) > 0) {
                gp = splay(k, parent,node, node.left);
                return splayOperation(gp, node, node.left);
            } else {
                return splayOperation(gp, parent, node);
            }
        }

        return null;
    }

    private TreeNode splayOperation(TreeNode gp, TreeNode parent, TreeNode node) {
        //7 cases (3 mirroring cases for left and right) & node is already root
        if(parent == null)
            return node;
        else if(parent.left.key.compareTo(node.key) == 0){
            //3 cases
            if(gp == null){

            }else if(gp.left.key.compareTo(parent.key) == 0){

            }else { //if(gp.right.key.compareTo(parent.key) == 0)

            }
        }else { //if(parent.right.key.compareTo(node.key) == 0)
            //3 cases
            if(gp == null){

            }else if(gp.right.key.compareTo(parent.key) == 0){

            }else { //if(gp.left.key.compareTo(parent.key) == 0)
            }
        }

        return null;
    }


    public void splay(Key k){
        root = splay(k,null, null, root);
    }

    private TreeNode find(Key k) {
        return find(k, root);
    }

    private TreeNode find(Key k, TreeNode node) {
        while(!isEmpty(node)){
            if(node.key.compareTo(k) < 0)
                node = node.right;
            else if(node.key.compareTo(k) > 0)
                node = node.left;
            else //if(node.key.compareTo(k) == 0)
                return node;
        }

        return null;
    }

    public void delete(Key k){
        splay(k);
        if(!isEmpty(root)) {
            root = join(root.left, root.right);
        }
    }

    private TreeNode join(TreeNode left, TreeNode right) {
        left = splay(max(left).key,null,null,left);
        if(!isEmpty())
            left.right = right;
        return left;
    }

    private TreeNode<Key,Val> max(TreeNode node){
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
