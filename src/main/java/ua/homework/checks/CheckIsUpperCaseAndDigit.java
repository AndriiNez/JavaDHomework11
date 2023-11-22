package ua.homework.checks;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckIsUpperCaseAndDigit {
    public boolean isUpperCaseAndDigit(String str) {
        String regex = "^[A-Z0-9]+$";

        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(str);

        return matcher.matches();
    }
}
