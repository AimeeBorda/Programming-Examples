package trees;


public class TreeNode<Key extends Comparable<Key>, Value> {

  public Value value;
  public Key key;
  public TreeNode<Key, Value> left;
  public TreeNode<Key, Value> right;

  public TreeNode(Key key, Value value) {
    this(key, value, null, null);
  }

  public TreeNode(Key key, Value value, TreeNode left, TreeNode right) {
    this.key = key;
    this.value = value;
    this.left = left;
    this.right = right;
  }

  public TreeNode(TreeNode left, Key key, Value value, TreeNode right) {
    this.key = key;
    this.value = value;
    this.left = left;
    this.right = right;
  }
}
