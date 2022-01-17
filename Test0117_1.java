

public class Test0117_1 {
    public static void main(String[] args) {
//        将数组分成和相等的三个部分
        /**
         *
         * 输入：[0,2,1,-6,6,-7,9,1,2,0,1]
         *         输出：true
         *         解释：0 + 2 + 1 = -6 + 6 - 7 + 9 + 1 = 2 + 0 + 1
         */
        int[] arr={0,2,1,-6,6,7,9,-1,2,0,1};
        boolean result= canThreePartsEqualSum(arr);
        System.out.println(result);
    }
    public static boolean canThreePartsEqualSum(int[] arr) {
            if(arr==null){
                return false;
            }
            int sum=0;
            for(int i:arr){
                sum+=i;  //统计求和！
            }
            if(sum%3!=0){
                return false;
            }
             int tempResulrt=0;
             int pos=0;
            for(int i:arr){
                tempResulrt+=i;
                if(tempResulrt==sum%3){ //直接阶段性的找看是否有
                    pos++;
                    tempResulrt=0;
                }
            }
            return pos>=3;

    }
}
