package trees.AVL;


import trees.TreeNode;

import java.util.Stack;

public class AVL<Key extends  Comparable<Key>, Val> {

    TreeNode<Key, Val> root;

    public void insert(Key key, Val value){
       root = insert(root,key, value);
    }

    private TreeNode insert(TreeNode node, Key key, Val value){

        if(node == null){
            return new TreeNode(key, value);
        }else if(node.key.compareTo(key) < 0){
            node.right = insert(node.right,key,value);
        } else if(node.key.compareTo(key) > 0){
            node.left = insert(node.left,key,value);
        } else if(node.key.compareTo(key) == 0){
            node.value = value;
        }

        return balance(node);
    }

    private int height(TreeNode node){
        if(node == null){
            return 0;
        }else{
            return 1 + Math.max(height(node.left),height(node.right));
        }
    }

    private TreeNode balance(TreeNode node){
        if(node == null)
            return null;
        int rightHeight =height(node.right);
        int leftHeight = height(node.left);

        //balancing
        if(rightHeight - leftHeight < -1){
            //left heavy
            if(height(node.left.left) < height(node.left.right)){
                //right heavy
                node.left = rightRotation(node.left);
            }
            node = leftRotation(node);

        }else if(rightHeight - leftHeight > 1){
            //right heavy

            if(height(node.right.right) < height(node.right.left)){
                //left heavy
                node.right = leftRotation(node.right);
            }
            node = rightRotation(node);

        }

        return node;

    }

    private TreeNode rightRotation(TreeNode node) {
        TreeNode  newRoot = node.right;
        TreeNode newRootLeft = newRoot.left;

        newRoot.left = node;
        node.right = newRootLeft;

        return newRoot;
    }


    private TreeNode leftRotation(TreeNode node){
        TreeNode  newRoot = node.left;
        TreeNode newRootRight = newRoot.right;

        newRoot.right = node;
        node.left = newRootRight;

        return newRoot;
    }

    public void delete(Key key){
        root = delete(root, key);
    }

    private TreeNode delete(TreeNode node, Key key) {
        if(node == null)
            return null;
        else if(node.key.compareTo(key) < 0) {
            node.right = delete(node.right, key);
        }else if(node.key.compareTo(key) > 0) {
            node.left = delete(node.left, key);
        }else if(node.key.compareTo(key) == 0){
            if(height(node.right) > height(node.left)){
                node =  findLeft(node.right);
            }else
                node = findRight(node.left);

        }
        return balance(node);
    }


    private TreeNode findLeft(TreeNode current){
        if(current == null){
            return null;
        }else{
            TreeNode left = findLeft(current.left);
            if(current.left != null && left.key.compareTo(current.left.key) == 0) {
                current.left = null;
            }
            return left;// getTreeNode(current, left);
        }

    }

    private TreeNode findRight(TreeNode current){
        if(current == null){
            return null;
        }else{
            TreeNode right = findRight(current.right);
            if(current.right != null && right.key.compareTo(current.right.key) == 0) {
                current.right = null;
            }
            return right;//getTreeNode(current, right);
        }

    }

//    private TreeNode getTreeNode(TreeNode current, TreeNode temp) {
//        if(temp == null){
//            return balance(current);
//        }else if(current.left != null && temp.key.compareTo(current.left.key) == 0) {
//            current.left = null;
//        }else if(current.right != null && temp.key.compareTo(current.right.key) == 0) {
//            current.right = null;
//        }
//
//        return balance(temp);
//    }

    public Val search(Key key){
        TreeNode<Key, Val> node = root;
        while(node != null){
            if(node.key.compareTo(key) < 0)
                node = node.right;
            else if(node.key.compareTo(key) >0)
                node = node.left;
            else if(node.key.compareTo(key) == 0)
                return node.value;
        }

        return null;
    }

    public String traversal() {
        TreeNode current = root;
        StringBuffer res = new StringBuffer();
        Stack<TreeNode> stack = new Stack<>();

        while(!stack.empty() || current != null){

            while(current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            res.append(","+current.value);

            current = current.right;
        }


        return res.substring(1).toString();

    }
}
