package dex.ivanova.lesson5.docs;
import org.junit.jupiter.api.Test;

import static dex.ivanova.lesson5.utils.RandomUtils.getRandomString;
import static dex.ivanova.lesson5.utils.RandomUtils.*;

public class RandomUtilsExample {
    @Test
    void random() {
        System.out.println(getRandomString(10));

        int randomInt = getRandomInt(223333, 100000000);
        System.out.println(randomInt + "");

        String randomPhone = getRandomPhone();
        System.out.println(randomPhone);

        String randomPhoneWithPrefix = getRandomPhone("+7");
        System.out.println(randomPhoneWithPrefix);

        String difficultRandomPhoneWithPrefix = getDifficultRandomPhone("+8");
        System.out.println(difficultRandomPhoneWithPrefix);

        String randomEmail = getRandomEmail();
        System.out.println(randomEmail);
    }
}