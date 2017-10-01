package trees.MergeBSTTree;


import trees.TreeNode;

public class MergeBST<K extends Comparable<K>, V> {

  public String traverse(TreeNode<K, V> tree1, TreeNode<K, V> tree2) {
    StringBuilder sb = new StringBuilder();
    traverse(tree1, tree2, sb);

    return sb.toString();
  }

  private void traverse(TreeNode<K, V> tree1, TreeNode<K, V> tree2, StringBuilder sb) {

    if (tree1 != null && tree2 != null) {

      //traverse Left Tree
      if (tree1.left != null && tree2.left != null) {
        if (tree1.key.compareTo(tree2.key) < 0) {
          traverse(tree1, tree2.left, sb);
        } else {
          traverse(tree1.left, tree2, sb);
        }
      } else if (tree1.left != null) {
        traverse(tree1.left, tree2, sb);
      } else if (tree2.left != null) {
        traverse(tree1, tree2.left, sb);
      }

      //print value
      if ( tree1.key.compareTo(tree2.key) < 0) {
        sb.append(tree1.value.toString() + " ");

        tree1 = tree1.right;
      } else {
        sb.append(tree2.value.toString() + " ");
        tree2 = tree2.right;
      }
      traverse(tree1, tree2, sb);

    } else if (tree1 != null) {
      traverseSingleTree(tree1, sb);
    } else if (tree2 != null) {
      traverseSingleTree(tree2, sb);
    }

  }

  private void traverseSingleTree(TreeNode<K, V> tree, StringBuilder sb) {
    if (tree.left != null) {
      traverseSingleTree(tree.left, sb);
    }

    sb.append(tree.value + " ");
    if (tree.right != null) {
      traverseSingleTree(tree.right, sb);
    }

  }
}
