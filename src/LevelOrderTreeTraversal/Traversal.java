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


    public boolean isBST2(TreeNode root){
        return isBSTMax(root) >= 0;
    }

    private int isBSTMax(TreeNode root){
        if(root == null)
            return 0;
        else {
            int max = isBSTMax(root.left);
            if((max > 0 && root.val >= max) || max == 0){
                max = isBSTMax(root.right);
                if((max > 0 && root.val <= max) || max == 0){
                    return Math.max(max,root.val);
                }
            }

            return -1;
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
