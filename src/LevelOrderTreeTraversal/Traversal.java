package LevelOrderTreeTraversal;

import java.util.*;

public class Traversal{
    private void lot(TreeNode node, int[] arr, int index){
        if(node != null){
            arr[index] = node.val;
            lot(node.right,arr,2*index+1);
            lot(node.left,arr,2*(index + 1));
        }
    }

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
