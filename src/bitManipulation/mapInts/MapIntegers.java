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
        int len = 16;
        int mask = 1 << len;
        num = absValue(num);
        while(num != 0 && (num & (num-1)) > 0){
            if((num & (mask-1)) > 0) {
                len /= 2;
                num = num & (mask - 1);
                mask = (mask >> len);
            } else {
                len /= 2;
                mask = (mask << len);
            }
        }


        return num;
    }

    public int reverseBit(int num){
        int res = 0;
        for(int i = 0 ; i < 32; i++){
            res = (res << 1) | (num & 1);
            num = num >>> 1;
        }

        return res;
    }
    public int reverseBitRec(int num) {
        return reverseBitRec(num,0,31);
    }
    private int reverseBitRec(int num, int s, int e){
        if(e - s < 1){
            return num;
        }else{
            int mid = (e + s)/2;
            int len = ((e-s) /2) + 1;
            int mask = (-1 >>> (32 - len)) << s;
            int num1 = reverseBitRec(num & mask, s, mid) << (len);
            int num2= reverseBitRec(num & (mask << len), mid+1,e) >>> (len);
            //O(1) as the size is at most 32
            return num2 | num1;
        }
    }

    public int add(int num1, int num2){
        int carry = ((num1 & num2) << 1);
        return (num1 ^ num2) ^carry ;
    }

}
