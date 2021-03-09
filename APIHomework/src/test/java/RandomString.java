import java.util.Random;

public class RandomString {

    public static String generateRandomString(int leftLimit, int rightLimit, int targetStringLength ) {
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        return generatedString;
    }
}
