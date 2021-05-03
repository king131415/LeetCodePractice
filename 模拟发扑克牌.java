package javaSePrictice;

import java.util.*;

class Card{
    public String suit;
    public String rank;

    public Card(String suit, String rank) {
        this.suit = suit;
        this.rank = rank;
    }

    @Override
    public String toString() {

        return "("+this.suit +this.rank + ")";
    }
}

public class 模拟发扑克牌 {
    //使用数组把四种花色的准备好
    public static final String[] suits={"♥","♠","♣","♦"};

    private  static List<Card>buyPoker(){
        ArrayList<Card> poker= new ArrayList<>();
        for(int i=0;i<4;i++){   //循环处理四种花色
            for(int j=2;j<=10;j++){   //内层循环处理每种花色的13张牌
                poker.add(new Card(suits[i],""+j));
            }
            poker.add(new Card(suits[i],"j"));
            poker.add(new Card(suits[i],"Q"));
            poker.add(new Card(suits[i],"K"));
            poker.add(new Card(suits[i],"A"));
        }
        poker.add(new Card("","big Joker"));
        poker.add(new Card("","small Joker"));
        return poker;
    }

    private static void Shuffle(List<Card> poker){
        Random random=new Random();
        for(int i=poker.size()-1;i>0;i--){
            int pos=random.nextInt(i);
            swap(poker,i,pos);
        }
    }

    private static void swap(List<Card> poker, int i, int j) {
        Card tmp=poker.get(i);
        poker.set(i,poker.get(j));
        poker.set(j,tmp);
    }

    public static void main(String[] args) {
        List<Card> poker=buyPoker();
//        Collections.shuffle(poker);  //集合类自己的打乱顺序
        Shuffle(poker); //我们自己写的打乱顺序的代码
        List<List<Card>> players=new ArrayList<>();
        players.add(new ArrayList<>());
        players.add(new ArrayList<>());
        players.add(new ArrayList<>());
        for(int i=0;i<5;i++){
            for(int j=0;j<3;j++){
                Card top=poker.remove(0);
                List<Card> player=players.get(j);
                player.add(top);
            }
        }
        for(int i=0;i<players.size();i++){
            List<Card> player=players.get(i);
            System.out.println("玩家"+(i+1)+"手牌是:"+player);
        }
    }
}
