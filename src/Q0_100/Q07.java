package Q0_100;
/*
 * ����һ�� 32 λ���з�������������Ҫ�����������ÿλ�ϵ����ֽ��з�ת��
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
