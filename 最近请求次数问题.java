package javaSePrictice;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 写一个 RecentCounter 类来计算特定时间范围内最近的请求。
 * 请你实现 RecentCounter 类：
 * RecentCounter() 初始化计数器，请求数为 0 。
 * int ping(int t) 在时间 t 添加一个新请求，其中 t 表示以毫秒为单位的某个时间，并返回过去 3000 毫秒内发生的所有请求数（包括新请求）。确切地说，返回在 [t-3000, t] 内发生的请求数。
 * 保证 每次对 ping 的调用都使用比之前更大的 t 值。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-recent-calls
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */


class RecentCounter {
    Queue<Integer> q; //创建一个队列

    public RecentCounter() {
        q=new LinkedList<>(); //初始化队列实例
    }

    public int ping(int t) {
       q.add(t); //将输入的时间加入队列
       while (q.peek()<t-3000){ //每次需要将t-3000之前的时间出队列
           q.poll();
       }
       return q.size(); //最后返回队列的大小
    }
}

public class 最近请求次数问题 {
    public static void main(String[] args) {
        RecentCounter recentCounter=new RecentCounter();
        int result= recentCounter.ping(1);
        System.out.print(result+" ");
        result=recentCounter.ping(100);
        System.out.print(result+" ");
        result=recentCounter.ping(3001);
        System.out.print(result+" ");
        result= recentCounter.ping(3002);
        System.out.print(result+" ");

    }
}
