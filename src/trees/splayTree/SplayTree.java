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
        root = new TreeNode(k, v, nodes[0],nodes[1]);
    }

    private TreeNode splay(Key k, TreeNode gp, TreeNode parent, TreeNode node) {
        if (node != null) {

            if (node.key.compareTo(k) < 0) {
                node.right = splay(k, parent, node, node.right);
                return splayOperation(gp,parent,node);
            } else if (node.key.compareTo(k) > 0) {
                node.left = splay(k, parent, node, node.left);
                return splayOperation(gp,parent,node);
            }

        }
        return gp;

    }



    private TreeNode rotateRight(TreeNode node) {
        TreeNode x = node.left;
        node.left = x.right;
        x.right = node;
        return x;
    }

    private TreeNode rotateLeft(TreeNode node) {
        TreeNode x = node.right;
        node.right = x.left;
        x.left = node;
        return x;
    }

    private TreeNode splayOperation(TreeNode gp, TreeNode parent, TreeNode node) {
        //7 cases (3 mirroring cases for left and right) & node is already root
        if(parent == null)
            return node;
        else if(parent.left.key.compareTo(node.key) == 0){
            //3 cases
            if(gp == null){
                TreeNode temp = node.right;
                node.right = parent;
                parent.left = temp;

                return node;
            }else if(gp.left.key.compareTo(parent.key) == 0){
                TreeNode temp = node.right;
                node.right = parent;
                parent.left = temp;

                temp = parent.right;
                parent.right = gp;
                gp.left = temp;
            }else { //if(gp.right.key.compareTo(parent.key) == 0)
                TreeNode temp1 = node.left;
                node.left = parent;
                parent.right = temp1;

                temp1 = node.right;
                node.right = gp;
                gp.left = temp1;
            }
        }else { //if(parent.right.key.compareTo(node.key) == 0)
            //3 cases
            if(gp == null){
                TreeNode temp = node.left;
                node.left = parent;
                parent.right = temp;

                return node;
            }else if(gp.right.key.compareTo(parent.key) == 0){
                TreeNode temp = node.left;
                node.left = parent;
                parent.right = temp;
                temp = parent.left;
                parent.left = gp;
                gp.right = temp;
            }else { //if(gp.left.key.compareTo(parent.key) == 0)
                TreeNode temp1 = node.right;
                node.right = parent;
                parent.left = temp1;

                temp1 = node.left;
                node.left = gp;
                gp.right = temp1;
            }
        }

        return node;
    }

    public void splay(Key k){
        root = splay(k, null, null, root);
    }

    public Val find(Key k) {

        splay(k);
        if(!isEmpty() && root.key == k)
            return (Val) root.value;
        else
            return null;
    }

   public void delete(Key k){
        splay(k);

       if(!isEmpty(root)) {
           root = join(root.left, root.right);
        }
    }

    private TreeNode join(TreeNode left, TreeNode right) {
        left = splay((Key) max(left).key, null,null,left);
        if(!isEmpty())
            left.right = right;
        return left;
    }

    private TreeNode max(TreeNode node){
        while(node != null && node.right != null){
            node = node.right;
        }

        return node;
    }

    public TreeNode[] split(Key k){
        splay(k);
        if(!isEmpty()) {
            return new TreeNode[]{new TreeNode(root.key, root.value, root.left, null), root.right};
        } else
            return new TreeNode[]{null,null};
    }

    public Key getRoot(){
        return isEmpty() ? null : (Key) root.key;
    }

    @Override
    public String toString(){
        return toString(root).trim();
    }

    private String toString(TreeNode node) {
        if(node != null)
            return toString(node.left) +"(" +node.key+", "+node.value +") "+toString(node.right);
        else
            return "";
    }
}
