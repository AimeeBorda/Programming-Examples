package levelOrderTreeTraversal;

import java.util.*;

public class Traversal{
    private void lot(TreeNode node, int[] arr, int index){
        if(node != null){
            arr[index] = node.val;
            lot(node.right,arr,2*index+1);
            lot(node.left,arr,2*(index + 1));
        }
    }

    //https://www.careercup.com/question?id=5641503067078656
    //https://www.interviewcake.com/question/python/bst-checker?
    public String[] allRootToLeavePaths(TreeNode root){
        if(root != null ){

            if(root.left != null || root.right != null) {
                String[] left = allRootToLeavePaths(root.left);
                String[] right = allRootToLeavePaths(root.right);

                String[] paths = new String[left.length + right.length];

                for(int i = 0; i < left.length;i++){
                    paths[i] = root.val + left[i];
                }

                for(int i = 0; i < right.length;i++){
                    paths[left.length + i] = root.val + right[i];
                }

                return paths;
            } else{
                //it is a leaf
                return new String[]{String.valueOf(root.val)};
            }
        }


        return new String[0];
     }

    public boolean isSuperBalancedIterative(TreeNode root){

        HashMap<TreeNode, int[]> nodes = new HashMap<>();
        nodes.put(root, new int[]{Integer.MAX_VALUE,Integer.MIN_VALUE});


        boolean stillToProcess = true;
        while(stillToProcess) {
            stillToProcess = false;
            for (Object obj : nodes.keySet().toArray()) {
                TreeNode node = (TreeNode) obj;
                int[] left = new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE};

                if (node.left != null && !nodes.containsKey(node.left)) {
                    nodes.put(node.left, left);
                    stillToProcess = true;
                } else if(node.left !=null){
                    left = nodes.getOrDefault(node.left, left);
                } else{
                    left[0] = 0; left[1] = 0;
                }

                int[] right = new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE};
                if (node.right != null && !nodes.containsKey(node.right)) {
                    nodes.put(node.right, right);
                    stillToProcess = true;
                } else if(node.right != null){
                    right = nodes.getOrDefault(node.right, right);
                } else{
                    right[0] = 0; right[1] = 0;
                }

                if (left[0] < Integer.MAX_VALUE && right[0] < Integer.MAX_VALUE) {
                    int[] temp = nodes.get(node);
                    temp[0] = Math.min(left[0], right[0]) + 1;
                    temp[1] = Math.max(left[1], right[1]) + 1;

                }else {
                    stillToProcess = true;
                }
            }
        }
      return nodes.get(root)[1] -  nodes.get(root)[0] <= 1;
    }

    public String iterativeTraversal(TreeNode root){
        String res = "";

        Stack<TreeNode> nodes = new Stack<>();
        TreeNode current = root;
        while(!nodes.isEmpty() || current != null){

            while(current != null) {
                nodes.push(current);
                current = current.left;
            }

            current = nodes.pop();
            res += current.val;
            current = current.right;

        }
        return res;
    }

    public boolean isSuperBalanced(TreeNode root){
        int[] depths =  new int[]{Integer.MAX_VALUE,Integer.MIN_VALUE};
        depth(root, depths,0);

        return depths[1] - depths[0] <= 1;
    }

    public void depth(TreeNode root, int[] depths, int i){
        if(root != null){

            if(root.left == null && root.right == null) {
                depths[0] = Math.min(depths[0],i);
                depths[1] = Math.max(depths[1], i);
            }else{
                depth(root.left, depths, i + 1);
                depth(root.right, depths, i + 1);
            }

        }
    }

    public boolean isBST2(TreeNode root){
        return isBSTMax(root, 0 , Integer.MAX_VALUE) ;
    }

    private boolean isBSTMax(TreeNode root, int min, int max){
        if(root == null)
            return true;
        else {
            boolean isBST = (root.val > min) && (root.val < max);
            isBST &= isBSTMax(root.left, min, root.val);
            isBST &= isBSTMax(root.right,root.val, max);

            return isBST;
        }

    }

    public boolean isBSTInOrder(TreeNode root){
        ArrayList<Integer> values = new ArrayList<>();
        inOrderTraversal(root,values);

        return isAsc(values);
    }

    public void inOrderTraversal(TreeNode root, ArrayList<Integer> values){
        if(root != null){
            inOrderTraversal(root.left,values);
            values.add(root.val);
            inOrderTraversal(root.right,values);
        }
    }

    public boolean isAsc(ArrayList<Integer> arr){
        for(int i = 0 ; i < arr.size() - 1; i++){
            if(arr.get(i) > arr.get(i+1))
                return false;
        }

        return true;
    }

    public String traversal(TreeNode root){
        int[] arr = new int[2*height(root)+1];
        Arrays.fill(arr,-1);
        lot(root, arr, 0);

        StringBuffer str = new StringBuffer();
        for(int i = arr.length - 1;i>=0;i--){
            if(arr[i] >= 0){
                str.append(arr[i]);
            }
        }


        return str.toString();
    }




    private int height(TreeNode root){
        if(root == null)
            return 0;
        else{
            return 1+ Math.max(height(root.left) ,	height(root.right));
        }
    }


}
