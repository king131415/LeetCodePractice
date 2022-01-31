import java.util.Arrays;

public class Test0131_2 {
    public static void main(String[] args) {
        int[] arr={13,2,5,7,1,99};
        ChangeShuffer(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void ChangeShuffer(int[] arr) {
        for(int i=0;i<arr.length;i++){
            for(int j=i;j<arr.length;j++){
                if(arr[i]>arr[j]){
                    int tmp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=tmp;
                }
            }
        }
    }
}
