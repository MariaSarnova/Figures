package com.epam.task.figures.creating;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PyramidValidator {
    public static final String VALID_ELEMENTS = "(-?(0|([1-9][0-9]*))\\.?[0-9]*\\s){14}(-?(0|([1-9][0-9]*))\\.?[0-9]*)";

    public boolean validate(String line) {
        Pattern validPattern = Pattern.compile(VALID_ELEMENTS);
        Matcher validStringMatcher = validPattern.matcher(line);
        return validStringMatcher.matches();
    }
}
