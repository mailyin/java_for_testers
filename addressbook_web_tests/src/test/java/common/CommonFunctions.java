package common;

import java.util.Random;

public class CommonFunctions {

    public static String randomString(int l) {
        var rnd = new Random();
        var result = "";
        for (int i = 0; i < l; i++) {
            result = result + (char) ('a' + rnd.nextInt(26));
        }
        return result;
    }
}
