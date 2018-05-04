package ua.kiyv.training.library.utils.constants;

/**
 * This class contains all necessary messages to perform logging
 */
public class LoggerMessages {
    public static final String REQUESTED_UNSUPPORTED_URI = "Requested unsupported URI. Redirecting to home page.";
    public static final String ERROR_PARSING_INPUT_DATE = "Error occured when parsing date...";
    public static final String SUCCESSFULL_USER_INFO_PARSE = "User's info was successfully parsed";
    public static final String SUCCESSFULL_REFILLING = "Card was successfully refilled";
    public static final String SUCCESSFULL_CARD_TRANSFER = "Card transfer was successfully done";
    public static final String SUCCESSFULL_ACCOUNT_TRANSFER = "Account transfer was successfully done";
    public static final String SUCCESSFUL_REGISTER = "Congratulations! You was successfully registered!";

    public static final String PROBLEM_WITH_DB_CONFIG= "Problem wit webProject.DB webProject.config file";
    public static final String CAN_NOT_GET_DB_CONNECTION = "Can not get connection to webProject.DB";
    public static final String CAN_NOT_CLOSE_CONNECTION = "Can not close connection";
    public static final String CAN_NOT_PREPARE_STATEMENT_WITH_AUTO_GENERATED_KEYS = "Can not prepare statement with auto generated keys";
    public static final String CAN_NOT_PREPARE_STATEMENT =  "Can't prepare statement";
    public static final String CAN_NOT_CREATE_STATEMENT = "Can't create statement";
    public static final String CAN_NOT_SET_IN_TRANSACTION = "Can't set is-in-transaction";
    public static final String CAN_NOT_COMMIT_IN_TRANSACTION= "Can't commit: Is not in transaction";
    public static final String CAN_NOT_COMMIT = "Can't commit";
    public static final String CAN_NOT_ROLLBACK = "Can't rollback";
    public static final String CAN_NOT_COMMIT_TRANSACTION_NOT_BEGUN = "Can't commit transaction: it has not been begun";
    public static final String CAN_NOT_ROLLBACK_TRANSACTION_NOT_BEGUN = "Can't rollback transaction: it has not been begun";
    public static final String WRONG_TRANSACTION = "Transaction failed";

    public static final String ERROR_FIND_USER_BY_LOGIN = "Error occurred when finding user by login: ";
    public static final String ERROR_FIND_USER_BY_ID = "Error occurred when finding user by id: ";
    public static final String ERROR_FIND_ALL_USERS = "Error occurred when finding all users";
    public static final String ERROR_CREATE_NEW_USER = "Error occurred when creating new user: ";
    public static final String ERROR_UPDATE_USER = "Error occurred when updating user: ";
    public static final String ERROR_DELETE_USER = "Error occurred when deleting user: ";
    public static final String ERROR_FIND_ROLE = "Error occurred when finding user by role:";



//    public static final String ERROR_FIND_BOOK_BY_ID = "Error occurred when finding book by id: ";
    public static final String ERROR_FIND_ALL_BOOKS = "Error occurred when finding all books";
    public static final String ERROR_CREATE_NEW_BOOK = "Error occurred when creating new book: ";
    public static final String ERROR_CREATE_NEW_BORROWED_BOOK = "Error occurred when creating new borrowed book: ";
    public static final String ERROR_MATCH_NEW_BOOK_AUTHOR = "Error occurred when match book and author";
    public static final String ERROR_UPDATE_BOOK= "Error occurred when updating book: ";
    public static final String ERROR_DELETE_BOOK = "Error occurred when deleting book: ";
    public static final String ERROR_FIND_ALL_BORROWED_BOOKS = "Error occurred when finding all borrowed books";


    public static final String ERROR_FIND_ALL_GENRES = "Error occurred when finding all genres";

    public static final String ERROR_FIND_BOOK_BY_ID = "Error occurred when finding book by id: ";
    public static final String ERROR_FIND_BOOK_BY_GENRE_ID = "Error occurred when finding book by genre id: ";
    public static final String ERROR_FIND_BOOK_BY_TITLE = "Error occurred when finding book by title: ";

    public static final String ERROR_FIND_AUTHOR_BY_ID = "Error occurred when finding author by id: ";
    public static final String ERROR_FIND_AUTHOR_BY_EMAIL = "Error occurred when finding author by email: ";
    public static final String ERROR_FIND_ALL_AUTHOR = "Error occurred when finding all authors";
    public static final String ERROR_SEARCH_BY_AUTHOR = "Error occurred when searching by author";
    public static final String ERROR_SEARCH_BY_TITLE = "Error occurred when searching by title";
    public static final String ERROR_SEARCH_BY_KEYWORDS = "Error occurred when searching by keywords";
    public static final String ERROR_CREATE_NEW_AUTHOR = "Error occurred when creating new author: ";
    public static final String ERROR_UPDATE_AUTHOR= "Error occurred when updating author: ";
    public static final String ERROR_DELETE_AUTHOR = "Error occurred when deleting author: ";

    public static final String UNKNOWN_ERROR_OCCURED = "Unknown error occurred";
    public static final String SERVICE_EXCEPTION_OCCURRED = "exception in business logic";
    public static final String APPLICATION_EXCEPTION_OCCURRED = "application exception occurred";
    public static final String ERROR_USER_ALREADY_EXISTS = "User with such login already exists!";
}