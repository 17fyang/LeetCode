package weekMatch.double_week.d48;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author: ÎÚÑ»×ø·É»úÙï
 * @date: 2021/3/20 22:23
 * @Description:
 */
public class Q02 {
    private int timeToLive;
    private Map<String, Integer> map;

    public static void main(String[] args) {

    }

    public Q02(int timeToLive) {
        this.timeToLive = timeToLive;
        map = new HashMap<>();
    }

    public void generate(String tokenId, int currentTime) {
        map.put(tokenId, currentTime + timeToLive);
    }

    public void renew(String tokenId, int currentTime) {
        Integer left = map.get(tokenId);
        if (left == null || left <= currentTime) return;
        map.put(tokenId, currentTime + timeToLive);
    }

    public int countUnexpiredTokens(int currentTime) {
        int result = 0;
        Iterator<Map.Entry<String, Integer>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Integer> entry = it.next();
            if (entry.getValue() > currentTime) {
                result++;
            } else {
                it.remove();
            }
        }
        return result;
    }
}

class MyToken {
    String token;
    int leftTime;

    public MyToken(String token, int leftTime) {
        this.token = token;
        this.leftTime = leftTime;
    }
}
