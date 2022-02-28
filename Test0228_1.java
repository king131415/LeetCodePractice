import java.util.Arrays;
public class Test0228_1 {
        public static void main(String[] args) {
//        给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。(旋转数组)
            int[] arr={1,2,3,4,5};
            System.out.println("移动前："+ Arrays.toString(arr));
            int[] arr2=yiDong(arr,3);
            System.out.println("移动后："+Arrays.toString(arr2));
        }
        public static int[] yiDong(int[] arr,int i) {
            int numb=arr.length;
            if(i>numb){
                i=i%numb;
            }
            int[] arr1=new int[numb];//创建新素组进行接收
            for(int j=0;j<numb;j++){
                int pos=(j+i)%numb;
                arr1[pos]=arr[j];
            }
            return arr1;
        }
 }
