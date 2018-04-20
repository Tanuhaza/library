package ua.kiyv.training.library.controller.validate;


import org.apache.log4j.Logger;
import ua.kiyv.training.library.model.Book;
import ua.kiyv.training.library.model.dto.BookData;
import ua.kiyv.training.library.model.dto.RegisterData;
import ua.kiyv.training.library.utils.constants.Attributes;
import ua.kiyv.training.library.utils.constants.MessageKeys;

import java.util.regex.Pattern;

public class BookValidator implements Validator<BookData> {
    private static final String REGEX_NAME="[A-Z]{1}[a-z]{1,}";
    private static final String REGEX_PASSWORD = "[0-9]{4,200}";
    private static final String REGEX_EMAIL = "^([a-z0-9_-]+\\.)*[a-z0-9_\\-]+@[a-z0-9_-]+(\\.[a-z0-9_\\-]+)*\\.[a-z]{2,6}$";
    private static  final String REGEX_PHONE="^(\\\\+380|0)([0-9]{9})$";
    private static final Logger logger = Logger.getLogger(BookValidator.class);

    @Override
    public Errors validate(BookData bookData) {
        Errors results = new Errors();
        if(!Pattern.matches(REGEX_NAME, bookData.getTitle())){
            results.addError(Attributes.USER_NAME, MessageKeys.WRONG_USER_NAME);
            logger.info("NAME");
        }
        if(!Pattern.matches(REGEX_NAME, bookData.getDescription())){
            results.addError(Attributes.USER_SURNAME, MessageKeys.WRONG_USER_SURNAME);
            logger.info("SURNAME");
        }
        if(!Pattern.matches(REGEX_EMAIL, bookData.getPictureId())){
            results.addError(Attributes.USER_EMAIL, MessageKeys.WRONG_USER_EMAIL);
        }
//        if(!Pattern.matches(REGEX_PASSWORD,bookData.getQuantity())){
//            results.addError(Attributes.USER_PASSWORD, MessageKeys.WRONG_USER_PASSWORD);
//        }
//        if(!Pattern.matches(REGEX_PHONE, bookData.getYear())){
//            results.addError(Attributes.USER_CELLPHONE, MessageKeys.WRONG_USER_CELLPHONE);
//            logger.info("PHONE");
//        }
        if(!Pattern.matches(REGEX_PHONE, bookData.getKeywords())){
            results.addError(Attributes.USER_CELLPHONE, MessageKeys.WRONG_USER_CELLPHONE);
            logger.info("PHONE");
        }


        return results;
    }
}