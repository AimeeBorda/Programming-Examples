package dynamicProgramming.roadsRecognition;

import java.util.LinkedList;

/**
 *
 * A Kingdom consists of several cities, some of which are connected by bidirectional roads. For any two
 * cities A and B, there is exactly one simple path between them (a path is simple if it doesn't contain
 * any city more than once). In terms of graph theory, the roads network in the Kingdom is a tree.
 *
 * Unfortunately, the new King does not like trees, so he wants the road network to be a loop. In other
 * words, each city must be directly connected to exactly 2 other cities, and for any two cities there
 * still must be at least one path between them.
 *
 * You will be given a String[] kingdom, representing the roads in the Kingdom. The i-th character in the
 * j-th element of kingdom is equal to '1' (one) if there is a road between the i-th and the j-th cities,
 * and '0' (zero) otherwise. Given that destroying a road or building a new road takes exactly one day,
 * and knowing that King has only enough workers to perform 1 task per day, return the minimal number of
 * days King needs to change the network to satisfy the new requirements. See examples for further
 * clarification.
 */
public class RoadRecognition {
    public int minDaysCount(String[] kingdom) {
        LinkedList<long[]> test = new LinkedList<>();
        int[][] min = new int[kingdom.length][kingdom.length];

        //remove extra roads
        for(int r = 0 ; r < kingdom.length ; r++){
            for(int r2 = 0; r2 < kingdom.length;r2++){
                min[r][r2] = 0;
            }
        }
        return 0;
    }
}
