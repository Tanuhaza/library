package ua.kiyv.training.library.controller.validate;


import org.apache.log4j.Logger;
import ua.kiyv.training.library.model.Book;
import ua.kiyv.training.library.model.dto.BookData;
import ua.kiyv.training.library.model.dto.RegisterData;
import ua.kiyv.training.library.utils.constants.Attributes;
import ua.kiyv.training.library.utils.constants.MessageKeys;

import java.util.regex.Pattern;

public class BookValidator implements Validator<BookData> {
    private static final String REGEX_TITLE = "[A-Z]{1}[a-z]{1,100}";
    private static final String REGEX_DESCRIPTION = "[A-Z]{1}[A-Za-z0-9]{1,500}";
    private static final String REGEX_QUANTITY = "[1-9]{1}[0-9]{0,2}";
    private static final String REGEX_YEAR = "[1,2]{1}[0-9]{3}";
    private static final Logger logger = Logger.getLogger(BookValidator.class);


    @Override
    public Errors validate(BookData bookData) {
        System.out.println("IN BOOK VALIDATE");
        Errors results = new Errors();
        if (!Pattern.matches(REGEX_TITLE, bookData.getTitle())) {
            results.addError(Attributes.TITLE, MessageKeys.WRONG_TITLE);
            System.out.println("TITLE");
        }
        if (!Pattern.matches(REGEX_DESCRIPTION, bookData.getDescription())) {
            results.addError(Attributes.DESCRIPTION, MessageKeys.WRONG_DESCRIPION
            );
            System.out.println("DESC");
        }

        if (!Pattern.matches(REGEX_YEAR, bookData.getYear())) {
            results.addError(Attributes.YEAR, MessageKeys.WRONG_YEAR);
            System.out.println("Year");
        }
        if (!Pattern.matches(REGEX_QUANTITY, bookData.getQuantity())) {
            results.addError(Attributes.QUANTITY, MessageKeys.WRONG_QUANTITY);
            System.out.println("quantity");
        }
        if (!Pattern.matches(REGEX_TITLE, bookData.getFirstAuthorName())) {
            results.addError(Attributes.FIRST_ATHOR_NAME, MessageKeys.WRONG_FIRST_AUTHOR_NAME);
            logger.info("Athor name");
        }
        if (!Pattern.matches(REGEX_TITLE, bookData.getFirstAuthorSurname())) {
            results.addError(Attributes.FIRST_ATHOR_SURNAME, MessageKeys.WRONG_FIRST_AUTHOR_SURNAME);
            logger.info("Athor surname");
        }
        return results;
    }
}