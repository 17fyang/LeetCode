package Q700_800;

public class Q777 {
    public static void main(String[] args) {
        System.out.println(new Q777().canTransform("XLXRRXXRXX",
                "LXXXXXXRRR"));
    }

    public boolean canTransform(String start, String end) {
        if (start.length() != end.length() || start.length() == 0) {
            return false;
        }
        int xCount = 0;
        int rCount = 0;
        for (char c : start.toCharArray()) {
            xCount += (c == 'X' ? 1 : 0);
            rCount += (c == 'R' ? 1 : 0);
        }

        for (char c : end.toCharArray()) {
            xCount -= (c == 'X' ? 1 : 0);
            rCount -= (c == 'R' ? 1 : 0);
        }

        if (xCount != 0 || rCount != 0) {
            return false;
        }

        char[] startArr = start.toCharArray();
        char[] endArr = end.toCharArray();

        return check(startArr, endArr);

    }

    public boolean check(char[] startArr, char[] endArr) {
        int length = startArr.length;

        for (int i = 0; i < length; i++) {
            if (startArr[i] == 'L' && endArr[i] == 'X') {
                return false;
            }
            if (startArr[i] != 'X' && endArr[i] != 'X' && startArr[i] != endArr[i]) {
                return false;
            }
            if (startArr[i] == 'X' && endArr[i] == 'L') {
                int start = i;
                while (i + 1 < length && startArr[i + 1] == 'X') i++;

                if (i + 1 >= length) {
                    return false;
                }
                if (startArr[i + 1] != 'L') {
                    return false;
                }

                startArr[start] = 'L';
                startArr[i + 1] = 'X';
                i=start;
            }
        }

        for (int i = length - 1; i >= 0; i--) {
            if (startArr[i] == 'R' && endArr[i] == 'X') {
                return false;
            }
            if (startArr[i] != 'X' && endArr[i] != 'X' && startArr[i] != endArr[i]) {
                return false;
            }

            if (startArr[i] == 'X' && endArr[i] == 'R') {
                int start = i;
                while (i > 0 && startArr[i - 1] == 'X') i--;
                if (i <= 0) {
                    return false;
                }
                if (startArr[i - 1] != 'R') {
                    return false;
                }

                startArr[i - 1] = 'X';
                startArr[start] = 'R';
                i=start;
            }
        }
        return true;
    }

    public boolean checkFront(char[] startArr, char[] endArr) {
        int length = startArr.length;
        for (int i = 0; i < length; i++) {
            if (startArr[i] == endArr[i]) {
                continue;
            }

            if (startArr[i] == 'X' && endArr[i] == 'R') {
                return false;
            }
            if (startArr[i] == 'L' && endArr[i] == 'X') {
                return false;
            }
            if (startArr[i] != 'X' && endArr[i] != 'X') {
                return false;
            }

            if (startArr[i] == 'R' && endArr[i] == 'X') {
                if (i + 1 >= length) {
                    return false;
                }
                if (startArr[i + 1] != 'X') {
                    return false;
                }

                startArr[i] = 'X';
                startArr[i + 1] = 'R';
            }
            if (startArr[i] == 'X' && endArr[i] == 'L') {
                if (i + 1 >= length) {
                    return false;
                }
                if (startArr[i + 1] != 'L') {
                    return false;
                }

                startArr[i] = 'L';
                startArr[i + 1] = 'X';
            }
        }
        return true;
    }

    public boolean checkTail(char[] startArr, char[] endArr) {
        int length = startArr.length;
        for (int i = length - 1; i >= 0; i--) {
            if (startArr[i] == endArr[i]) {
                continue;
            }

            if (startArr[i] == 'R' && endArr[i] == 'X') {
                return false;
            }
            if (startArr[i] == 'X' && endArr[i] == 'L') {
                return false;
            }
            if (startArr[i] != 'X' && endArr[i] != 'X') {
                return false;
            }

            if (startArr[i] == 'X' && endArr[i] == 'R') {
                if (i <= 0) {
                    return false;
                }
                if (startArr[i - 1] != 'R') {
                    return false;
                }

                startArr[i - 1] = 'X';
                startArr[i] = 'R';
            }
            if (startArr[i] == 'L' && endArr[i] == 'X') {
                if (i <= 0) {
                    return false;
                }
                if (startArr[i - 1] != 'X') {
                    return false;
                }

                startArr[i - 1] = 'L';
                startArr[i] = 'X';
            }
        }
        return true;
    }
}
