package ua.kiyv.training.library.controller.validate;


import org.apache.log4j.Logger;
import ua.kiyv.training.library.model.Book;
import ua.kiyv.training.library.model.dto.BookData;
import ua.kiyv.training.library.model.dto.RegisterData;
import ua.kiyv.training.library.utils.constants.Attributes;
import ua.kiyv.training.library.utils.constants.MessageKeys;

import static java.util.regex.Pattern.matches;


public class BookValidator implements Validator<BookData> {
    private static final String REGEX_TITLE = "[A-ZА-ЯЇІЄЁ]{1}[a-zA-Zа-яА-ЯїЇіІєЄёЁ\\s]{1,100}";
    private static final String REGEX_DESCRIPTION = "[A-ZА-ЯЇІЄЁ]{1}[a-zA-Zа-яА-ЯїЇіІєЄёЁ\\d\\s,.!?;:()]{1,500}";
    private static final String REGEX_QUANTITY = "[1-9]{1}[\\d]{0,2}";
    private static final String REGEX_YEAR = "[1,2]{1}[\\d]{3}";
    private static final Logger LOGGER = Logger.getLogger(BookValidator.class);


    @Override
    public Errors validate(BookData bookData) {
        Errors results = new Errors();

        if (isNull(bookData.getTitle()) || hasScript(bookData.getTitle()) || !matches(REGEX_TITLE, bookData.getTitle())) {
            results.addError(Attributes.TITLE, MessageKeys.WRONG_TITLE);
        }

        if (isNull(bookData.getDescription()) || hasScript(bookData.getDescription()) || !matches(REGEX_DESCRIPTION, bookData.getDescription())) {
            results.addError(Attributes.DESCRIPTION, MessageKeys.WRONG_DESCRIPION);
        }

        if (isNull(bookData.getYear()) || hasScript(bookData.getYear()) || !matches(REGEX_YEAR, bookData.getYear())) {
            results.addError(Attributes.YEAR, MessageKeys.WRONG_YEAR);
        }

        if (isNull(bookData.getQuantity()) || hasScript(bookData.getQuantity()) || !matches(REGEX_QUANTITY, bookData.getQuantity())) {
            results.addError(Attributes.QUANTITY, MessageKeys.WRONG_QUANTITY);
        }

        if ((isNull(bookData.getFirstAuthorName())) || hasScript(bookData.getFirstAuthorName()) || !matches(REGEX_TITLE, bookData.getFirstAuthorName())) {
            results.addError(Attributes.FIRST_ATHOR_NAME, MessageKeys.WRONG_FIRST_AUTHOR_NAME);
        }

        if (isNull(bookData.getFirstAuthorSurname()) || hasScript(bookData.getFirstAuthorSurname()) || !matches(REGEX_TITLE, bookData.getFirstAuthorSurname())) {
            results.addError(Attributes.FIRST_ATHOR_SURNAME, MessageKeys.WRONG_FIRST_AUTHOR_SURNAME);
        }
        return results;
    }
}