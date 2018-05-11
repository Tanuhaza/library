package ua.kiyv.training.library.controller.validate;

import ua.kiyv.training.library.model.dto.RegisterData;
import ua.kiyv.training.library.utils.constants.Attributes;
import ua.kiyv.training.library.utils.constants.MessageKeys;
import ua.kiyv.training.library.model.dto.LoginData;

import static java.util.regex.Pattern.matches;

public class LoginValidator implements Validator<LoginData> {
    private static final String REGEX_PASSWORD = "[A-Za-z0-9]{4,200}";
    private static final String REGEX_EMAIL = "^([a-z0-9_-]+\\.)*[a-z0-9_\\-]+@[a-z0-9_-]+(\\.[a-z0-9_\\-]+)*\\.[a-z]{2,6}$";


    @Override
    public Errors validate(LoginData data) {
        Errors results = new Errors();

        if ((isNull(data.getEmail()) || hasScript(data.getEmail()) || !matches(REGEX_EMAIL, data.getEmail()))) {
            results.addError(Attributes.USER_EMAIL, MessageKeys.WRONG_USER_EMAIL);
        }
        if ((isNull(data.getPassword()) || hasScript(data.getPassword()) || !matches(REGEX_PASSWORD, data.getPassword()))) {
            results.addError(Attributes.USER_PASSWORD, MessageKeys.WRONG_USER_PASSWORD);
        }

        return results;}
    }



