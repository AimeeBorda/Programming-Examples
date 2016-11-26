package trees;


public class TreeNode<Key extends  Comparable<Key>, Value> {

    public Value value;
    public Key key;
    public TreeNode<Key,Value> left;
    public TreeNode<Key,Value> right;

    public TreeNode(Key key, Value value){
        this.key = key;
        this.value = value;
    }

}
