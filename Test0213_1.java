class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int val) {
        this.val = val;
    }
    public static ListNode creatListNode(){
        ListNode a=new ListNode(1);
        ListNode b=new ListNode(2);
        ListNode c=new ListNode(3);
        ListNode d=new ListNode(4);
        ListNode e=new ListNode(5);
        a.next=b;
        b.next=c;
        c.next=d;
        d.next=e;
        e.next=null;
        return a;
    }
}


public class Test0213_1 {
    public static void main(String[] args) {
       int result= kthToLast(ListNode.creatListNode(),5);
        System.out.println(result);
    }
    public static int kthToLast(ListNode head, int k) {
              if(head==null){
                  throw new ArrayIndexOutOfBoundsException();
              }
              int count=0;
              ListNode newHead=head;
              while (head!=null){
                  head=head.next;
                  count++;
              }
              if(k>count){
                  throw new ArrayIndexOutOfBoundsException("下标非法！！！");
              }
              for(int i=0;i<count-k;i++){
                 newHead=newHead.next;
             }
             return newHead.val;
    }
}
