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
