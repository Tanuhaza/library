package ua.kiyv.training.library.controller.validate;


import org.apache.log4j.Logger;
import ua.kiyv.training.library.model.dto.RegisterData;
import ua.kiyv.training.library.utils.constants.Attributes;
import ua.kiyv.training.library.utils.constants.LoggerMessages;
import ua.kiyv.training.library.utils.constants.MessageKeys;

import java.util.regex.Pattern;

public class UserValidator implements Validator<RegisterData> {
    private static final String REGEX_NAME="[A-Z]{1}[a-z]{1,}";
    private static final String REGEX_PASSWORD = "[A-Za-z0-9]{4,200}";
    private static final String REGEX_EMAIL = "^([a-z0-9_-]+\\.)*[a-z0-9_\\-]+@[a-z0-9_-]+(\\.[a-z0-9_\\-]+)*\\.[a-z]{2,6}$";
    private static  final String REGEX_PHONE="^(\\\\+380|0)([0-9]{9})$";
    private static final Logger logger = Logger.getLogger(UserValidator.class);

    @Override
    public Errors validate(RegisterData data) {
        Errors results = new Errors();
        if(!Pattern.matches(REGEX_NAME, data.getFirstName())){
            results.addError(Attributes.USER_NAME, MessageKeys.WRONG_USER_NAME);
        }
        if(!Pattern.matches(REGEX_NAME, data.getLastName())){
            results.addError(Attributes.USER_SURNAME, MessageKeys.WRONG_USER_SURNAME);
        }
        if(!Pattern.matches(REGEX_EMAIL, data.getEmail())){
            results.addError(Attributes.USER_EMAIL, MessageKeys.WRONG_USER_EMAIL);
        }
        if(!Pattern.matches(REGEX_PASSWORD, data.getPassword())){
            results.addError(Attributes.USER_PASSWORD, MessageKeys.WRONG_USER_PASSWORD);
        }
        if(!Pattern.matches(REGEX_PHONE, data.getPhone())){
            results.addError(Attributes.USER_CELLPHONE, MessageKeys.WRONG_USER_CELLPHONE);
        }

        return results;
    }
}