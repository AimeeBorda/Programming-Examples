package trees.BTree;


import java.awt.image.BufferedImage;
import java.util.Arrays;

public class BTree<T extends Comparable<T>> {

    BNode root;

    public void insert(T val){
        BNode temp = insert(new BNode(val),root);
        if(temp != null){
            root = temp;
        }
    }

    private  BNode insert(BNode val, BNode node) {

        if(node == null){
            return val;
        } else if(node.children != null) {
            int i = 0;
            while (i < BNode.NUM && node.keys[i] != null && node.keys[i].compareTo(val.keys[0]) < 0) {
                i++;
            }
            i=Math.min(i, BNode.NUM -1);
            BNode separator = insert(val, node.children[i]);
//            if(separator != null)
//                node.children[i] = null;
            return splitBalance(node, separator);

        } else {
            return splitBalance(node, val);

        }

    }

    public void getPixelColorsInCircle( int cx,  int cy,  int radius)
    {
        final BufferedImage img; // Obtained somewhere else in the program via function call.
//        final LinkedList<Integer> ll = new LinkedList<>();
        char[][] temp = new char[4*radius][4*radius];
        for (int r = radius ; r >= 0;r--){
            for(int a = 0; a <= 360 ; a+= 30){
                //X = xcircle + (r * cosine(angle))
                //Y = ycircle + (r * sine(angle))

                int x = (int) (cx + (r * Math.cos(a)));
                int y = (int) (cy + (r * Math.sin(a)));
//                System.out.println(r+" "+a+" "+x+" "+y);
                temp[(int) (cx + (r * Math.cos(a)))][y] = '1';
            }
        }

        for(int i = 0 ; i < temp.length;i++){
            System.out.println(new String(temp[i]));
        }

    }

    private BNode splitBalance(BNode node, BNode val){
        if(val == null){
            return null;
        }else if(node.keys[BNode.NUM -1] == null) {
            put(val, node);
            return null;
        }else{
            T[] keys = (T[]) new Comparable[BNode.NUM + 1];
            System.arraycopy(node.keys, 0, keys, 0, BNode.NUM);

            //find position of new element
            int k = 0;
            while (k < BNode.NUM && val.keys[0].compareTo(keys[k]) > 0) {
                k++;
            }
            //add new value
            System.arraycopy(keys, k, keys, k + 1, BNode.NUM - k);
            keys[k] = (T) val.keys[0];

            //create a new node containing the median as separator
            BNode<T> newNode = new BNode(keys[keys.length / 2]);
            newNode.addChild(new BNode(Arrays.copyOf(keys, keys.length / 2)), 0);
            System.arraycopy(keys, keys.length/2 + 1,keys,0, keys.length/2 -1);

            node.keys = Arrays.copyOf(keys,(keys.length / 2)-1);

            return newNode;
        }
    }

    private void put(BNode val, BNode node){
        int i = 0;
        while(node.keys[i] != null && node.keys[i].compareTo(val.keys[0]) < 0){
            i++;
        }
        System.arraycopy(node.keys, i , node.keys, i +1, BNode.NUM - (i+1) );
        node.keys[i] = val.keys[0];
        if(node.children != null) {
            System.arraycopy(node.children, i , node.children, i +1, BNode.NUM - (i+1) );
        }
    }

    public void delete(T val){

    }

    public String traversal(){
        StringBuffer sb = new StringBuffer();
        traversal(root,sb);

        return sb.length() > 0 ?sb.substring(1).toString() : "";
    }

    private void traversal(BNode node, StringBuffer b) {
        if(node != null){
            for(int i =0; i< BNode.NUM;i++){
                if(node.children != null)
                    traversal(node.children[i],b);
                if(node.keys[i] != null)
                b.append(","+node.keys[i]);
            }
        }
    }
}
