package bitManipulation.mapInts;

//http://www.mytechinterviews.com/bit-swaps
//How would you find the number of bit swaps required to convert integer A to integer B?
public class MapIntegers {
    public int mapInt(int a, int b) {
        return countSetNaive(a ^ b);
    }


    public int countSetNaive(int a){
        if(a != 0){
            return (a % 2 == 0 ? 0 : 1) + countSetNaive(a >>> 1);
        }else {
            return 0;
        }
    }

    public boolean isNegative(int a){
        return ((~a) >> 31) == 0;//(a & (1<< 31)) != 0;
    }

    public boolean diffSign(int a, int b){
        return (a^ b) < 0;
    }

    public int absValue(int a){
        int negativeMask = ((a & (1<< 31)) >> 31);
        return (negativeMask & (1 + ~a)) | (~negativeMask & a);
    }

    public int max(int a, int b){
        //true=1231 (615) and false=1237 (618)
        int booleanValue= 1 & (Boolean.hashCode( a<b ) >> 1);
        int mask = 1 + ~(booleanValue);

        return (mask & b) | (~mask & a);
    }

    public boolean isPowerOf2(int a){
        a = Math.abs(a);
        return a != 0 && (a & (a-1)) == 0;
    }

    public int extendNum(int num, int from, int to){
        int pattern = num & (1 << (from - 1)); // check msb is 1
        pattern = pattern << (32 - from); //msb as MSB
        pattern = pattern >> (to - from - 1); // create (to - from) 1s
        pattern = pattern >>> (32 - to ); // move pattern to correct position

        return num | pattern;
    }

    //if cond set mask else clear mask
    public int condClearOrSet(int num, int mask, boolean cond){
        int condition = 1 + ~((Boolean.hashCode(cond) >> 1) & 1);

        return (condition & (num | mask)) | (~condition &(num &~mask));
    }

    public int merge(int num1, int num2, int mask){
       //if 1 in mask bit from n2 otherwise from n1
        return (num1 &~mask) | (num2&mask);
    }

    public int lsb(int num){
return -1;
    }

    public int reverseBit(int num){
        return -1;
    }
}
