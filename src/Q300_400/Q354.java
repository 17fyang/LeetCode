package Q300_400;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: ÎÚÑ»×ø·É»úÙï
 * @date: 2021/3/4 12:01
 * @Description:
 */
public class Q354 {

    public int maxEnvelopes(int[][] envelopes) {
        Letter[] letters = new Letter[envelopes.length];
        for (int i = 0; i < letters.length; i++) letters[i] = new Letter(envelopes[i][0], envelopes[i][1]);

        Arrays.sort(letters, (l1, l2) -> l1.height == l2.height ? l1.width - l2.width : l1.height - l2.height);

        int[] dp = new int[letters.length];
        int maxLen = 0;
        for (int i = 0; i < letters.length; i++) {
            int maxCount = 0;

            for (int j = 0; j < i; j++) {
                if (!isSmall(letters[j], letters[i])) continue;
                maxCount = Math.max(maxCount, dp[j]);
            }
            dp[i] = maxCount + 1;
            maxLen = Math.max(dp[i], maxLen);

        }

        return maxLen;
    }

    private boolean isSmall(Letter l1, Letter l2) {
        return l1.height < l2.height && l1.width < l2.width;
    }


}

class Letter {
    int height;
    int width;
    List<Letter> smaller = new LinkedList<>();

    public Letter(int width, int height) {
        this.height = height;
        this.width = width;
    }
}
