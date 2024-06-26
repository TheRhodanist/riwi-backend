package giese.std.riwi.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator
{
    private Pattern pattern;
    private Matcher matcher;
    private static final String EMAIL_PATTERN = """
            ^[_A-Za-z0-9-+](.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(.[A-Za-z0-9]+)*(.[A-Za-z]{2,})$
""";
    private boolean isValidEmail(String email) {
        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(email);
        return matcher.matches();
    }
}