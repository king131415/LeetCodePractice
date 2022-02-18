public class Test0218_1 {
    public static void main(String[] args) {
        //给定一个整数数组，判断是否存在重复元素。如果任何值在数组中出现至少两次，函数返回 true。如果数组中
//每个元素都不相同，则返回 false。
        int[] arr={1,2,3,4,6,4,2};
        boolean result=find(arr);
        System.out.println(result);
    }
    public static boolean find(int[] arr) {
        int count = 0;  //定义一个计数器
        for (int i = 0; i < arr.length - 1; i++) {  //循环遍历
            for (int j = 0; j < arr.length - 1-i;j++) {
                if (arr[i] == arr[j+ 1+i]) {
                    count++;
                }
            }
        }
        if(count>=1){ //若count的值大于等于1，说明数组中存在重复的数
            return true;
        }
        return false;
    }
}
