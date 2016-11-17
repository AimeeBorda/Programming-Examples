package dynamicProgramming.stripePainter;

/*
 * Karel is a frustrated painter who works by day in an electrical repair shop. Inspired by the
 * color-coded bands on resistors, he is painting a series of long, narrow canvases with bold
 * colored stripes. However, Karel is lazy and wants to minimize the number of brush strokes it
 * takes to paint each canvas.
 * Abbreviating each color to a single uppercase letter, Karel would write the stripe pattern
 * red-green-blue-green-red as "RGBGR" (quotes added for clarity). It would take him three brush
 * strokes to paint this pattern. The first stroke would cover the entire canvas in red (RRRRR).
 * The second stroke would leave a band of red on either side and fill in the rest with green
 * (RGGGR). The final brush stroke would fill in the blue stripe in the center (RGBGR).
 * Given a stripe pattern stripes as a String, calculate the minimum number of brush strokes
 * required to paint that pattern.
 *
 * -	stripes will contain only uppercase letters ('A'-'Z', inclusive).
 * -	stripes will contain between 1 and 50 characters, inclusive.
 */
public class StripePainter {

    public int minStrokes(String pattern){
        char[] stack = new char[26];
        int count = 0;

        for(char c : pattern.toCharArray()){
            if(!findAndPop(stack, c)){
                System.out.print(c);
                count++;
            }
        }

        return count;
    }

    private boolean findAndPop(char[] stack, char c){
        int index = 0;
        while(c != stack[index] && index < stack.length && stack[index] != '\u0000'){
            index++;
        }

        if(index < stack.length && stack[index] == c){
            //found element
            System.arraycopy(stack, index, stack, 0, stack.length - index);

            return true;
        }else {
            //did not find element
            System.arraycopy(stack, 0,stack, 1, stack.length - 1);
            stack[0] = c;

            return false;
        }
    }
}
