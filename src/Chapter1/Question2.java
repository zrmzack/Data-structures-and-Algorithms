package Chapter1;


class Riddle {
    public static final String[] WORDS = {"this", "two", "fat", "that"};
    public static final char[][] CONST = {{'t', 'h', 'i', 's'}, {'w', 'a', 't', 's'}, {'o', 'a', 'h', 'g'}, {'f', 'g', 'd', 't'}};

    public static void main(String[] args) {
        findWords(CONST, WORDS);
    }

    public static void findWords(char[][] arr, String[] words) {
//        记录首字母，不重复
        StringBuilder initials = new StringBuilder();
        for (String word : words) {
            String initial = word.substring(0, 1);
            if (!initials.toString().contains(initial)) {
                initials.append(initial);
            }
        }
//        遍历每个元素是否是首字母
        for (int x = 0; x < arr.length; x++) {
            for (int y = 0; y < arr[x].length; y++) {
                if (initials.toString().contains(String.valueOf(arr[x][y]))) {
                    for (int p = 1; p <= 8; p++) {
                        String tem = "";
                        int xEnd = x, yEnd = y;
                        while (xyAva(arr, xEnd, yEnd)) {
                            tem += arr[xEnd][yEnd];
                            printWord(tem, x, y, xEnd, yEnd);
                            if (p == 1) {
                                xEnd--;
                            }
                            if (p == 2) {
                                xEnd++;
                            }
                            if (p == 3) {
                                yEnd++;
                            }
                            if (p == 4) {
                                yEnd--;
                            }
                            if (p == 5) {
                                xEnd--;
                                yEnd++;
                            }
                            if (p == 6) {
                                xEnd++;
                                yEnd--;
                            }
                            if (p == 7) {
                                xEnd++;
                                yEnd++;
                            }
                            if (p == 8) {
                                xEnd--;
                                yEnd--;
                            }
                        }
                    }
                }
            }
        }
    }

    public static boolean xyAva(char[][] arr, int x, int y) {
        if (0 <= x && x < arr.length) {
            return 0 <= y && y < arr[x].length;
        }
        return false;
    }

    /**
     *     判断是否是给定的单词并打印
     */
    public static void printWord(String word, int x, int y, int xEnd, int yEnd) {
        for (String s : WORDS) {
            if (word.equals(s)) {
                System.out.println("单词："+ s + "\t向量:" + "(" + (x + 1) + "," + (y + 1) + ")->(" + (xEnd + 1) + "," + (yEnd + 1) + ")");
            }
        }
    }
}