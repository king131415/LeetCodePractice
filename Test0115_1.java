

/**
 * 若一个数组有许多没有实际意义的数据，就可以对数组进行压缩;
 *  以一个棋盘来说明
 */
public class Test0115_1 {
    public static void main(String[] args) {
        //"0"表示空格，"1"表示红方；"2"表示蓝方
        int[][] chess=new int[11][11]; //定义一个11行11列的二维数组
        chess[0][1]=1;
        chess[1][2]=2;
        chess[3][3]=1;
        System.out.println("没有转换成稀疏数组之前:");
        for(int[] i:chess){
            for(int j:i){
                System.out.printf("%d\t",j);
            }
            System.out.println();
        }
        int count=0; //定义一个计数器，用来计算原来数组元素的个数
        for(int[] i:chess){
            for(int j:i){
                if(j!=0){
                    count++;
                }
            }
        }

        int[][] parserArr=new int[count+1][3]; //定义一个稀疏数组
        parserArr[0][0]=11;      //记录元素的行
        parserArr[0][1]=11;     //记录元素的列
        parserArr[0][2]=count; //记录有效元素的个数
        //把原来数组的数据拷贝到稀疏数组中去
        int sum=0;
        for(int i=0;i<11;i++){ //遍历原来的数组，将有实际意义的数据放到稀疏数组中去
            for(int j=0;j<11;j++){
                if(chess[i][j]!=0){
                    sum++;
                    parserArr[sum][0]=i;
                    parserArr[sum][1]=j;
                    parserArr[sum][2]=chess[i][j];
                }
            }
        }
        System.out.println("转成稀疏数组后:");
        for(int[] i:parserArr){
            for(int j:i){
                System.out.printf("%d\t",j);
            }
            System.out.println();
        }
    }
}
