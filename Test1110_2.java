package javaDailyProctice.Test1110;



import java.util.Arrays;
public class Test1110_2 {
    public static void main(String[] args) {
        int[] arr={5,19,1,6,9,10};
        HeapShuuer(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void HeapShuuer(int[] arr) {
        for(int i=arr.length-1;i>=0;i--){
            ShiftDown(arr,i,arr.length);
        }

        int heapsize=arr.length;
        for(int i=0;i<arr.length;i++){
            int data=arr[0];
            arr[0]=arr[heapsize-1];
            arr[heapsize-1]=data;
            heapsize--;
            ShiftDown(arr,0,heapsize);
        }
    }

    private static void ShiftDown(int[] arr, int i, int size) {
        int parent=i;
        int child=2*parent+1;
        while (child<size){
            if(child+1<size && arr[child]>arr[child+1]){
                child=child+1;
            }
            if(arr[parent]>arr[child]){
                int temp=arr[parent];
                arr[parent]=arr[child];
                arr[child]=temp;
            }else { //这里可以不写，写了其实就是优化的作用
                break;
            }
            parent=child;
            child=parent*2+1;
        }
    }

}
