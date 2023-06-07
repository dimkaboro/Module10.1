import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class PhoneValidator {
    private static final String ABSOlUTE_PATH = "C:\\Users\\dmitr\\IdeaProjects\\Homework10.1\\file.txt";

    public void validPhoneNumbers() {
        File file = new File(ABSOlUTE_PATH);
        checkFileExists(file);

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (isValidPhoneNumber(line)) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    private static void checkFileExists(File file) {
        if (!file.exists()) {
            file.getParentFile().mkdirs();
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    private boolean isValidPhoneNumber(String phoneNumber) {
        String check = phoneNumber;
        if (check.length() == 12 && check.charAt(3) == '-' && check.charAt(7) == '-') {
            return true;
        } else if (check.length() == 14 && check.charAt(0) == '(' && check.charAt(4) == ')' && check.charAt(9) == '-' && check.charAt(5) == ' ') {
            return true;
        } else {
            return false;
        }
    }
}

