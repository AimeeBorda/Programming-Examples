package trees.BTree;


public class BNode<Key extends Comparable<Key>> {

    public static final int NUM = 3;
    public Key[] keys = (Key[]) new Comparable[NUM];
    public BNode<Key>[] children;

    public BNode(Key key) {
        keys[0] = key;
    }

    public BNode(Key[] keys){
        System.arraycopy(keys,0, this.keys,0, Math.min(NUM, keys.length));
    }

    public void addChild(BNode c, int index){
        if(children == null)
            children = new BNode[NUM];// (BNode<Key>[]) new Comparable[NUM];

        children[index] =c;
    }
}
