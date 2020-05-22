package Q0_100;
/*
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 */
public class Q07 {
	public int reverse(int x) {
        int newX=0;
        while(true){
            if(x==0)    break;
            int pop=x%10;
            if (newX> Integer.MAX_VALUE/10 || (newX== Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (newX< Integer.MIN_VALUE/10 || (newX== Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            x=x/10;
            newX=newX*10+pop;  
        }
        return newX;
    }
}
