import java.util.Arrays;
public class Test0211_2 {
    public static void main(String[] args) {
        int[] arr1={1,2,3,4,5};
        int[] arr2={9,6,8,7,10};
        arr1=jion(arr1,arr2);
       System.out.println(Arrays.toString(arr1));
    }
    public static int[] jion(int[] arr1, int[] arr2) {
        int a=arr1.length;
        int b=arr2.length;
        int[] arr=Arrays.copyOf(arr1,a+b);
        for(int k=0;k<arr2.length;k++){
            for(int n=0;n<arr.length;n++){
                if(arr[n]==0){
                    arr[n]=arr2[k];
                    break;
                }
            }
        }
        for(int i=0;i<arr.length-1;i++){
            for(int j=0;j<arr.length-1-i;j++){
                int temp=0;
                if(arr[j]>arr[j+1]){
                    temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
        return arr;
    }
}
