import java.util.Random;

public class Coin {

    private static  int side;
    private static final int  HEAD = 1;
    private  static final int TAIL = 0;

    public int getSide() {
        return side;
    }

    public void setSide(int side) {
        this.side = side;
    }

    public int flip(){
       int rand =  new Random().nextInt(2);
        if(rand == HEAD){
            setSide(rand);

        }
        else if (rand == TAIL){ setSide(rand);
        }
        return rand;
    }

    public static int AddHeadTail(int head, int tail){
        return head + tail;
    }
}
