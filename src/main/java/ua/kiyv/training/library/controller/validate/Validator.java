package ua.kiyv.training.library.controller.validate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Generic Validator interface which should return  object with errors
 * @param <T>
 */
public interface Validator<T> {
    /**
     * main methods which validates input data
     * @param t
     * @return  object with errors
     */
    Errors validate(T t);
     default boolean hasScript(String line) {
        String scriptRegex = new String("<script");
        Pattern pattern = Pattern.compile(scriptRegex);
        Matcher matcher = pattern.matcher(line);
        return matcher.find();
    }

     default boolean isNull(Object o) {
        return o == null;
    }
}
