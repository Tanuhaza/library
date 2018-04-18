package ua.kiyv.training.library.controller;




import ua.kiyv.training.library.controller.command.LogoutCommand;
import ua.kiyv.training.library.controller.command.UnsupportedPathCommand;
import ua.kiyv.training.library.controller.command.admin.AdminHomeCommand;
import ua.kiyv.training.library.controller.command.admin.ManageCommand;
import ua.kiyv.training.library.controller.command.admin.StatisticsCommand;
import ua.kiyv.training.library.controller.command.login.LoginCommand;
import ua.kiyv.training.library.controller.command.login.LoginSubmitCommand;
import ua.kiyv.training.library.controller.command.login.RegisterSubmitCommand;

import java.util.HashMap;
import java.util.Map;

import static ua.kiyv.training.library.utils.constants.PagesPath.*;


/**
 * This class is implementation of CommandHolder. It defines command for every supported request uri.
 *
 */
class CommandHolder {

    static final String DELIMITER = ":";
    private static final String GET = "GET" + DELIMITER;
    private static final String POST = "POST" + DELIMITER;
    public static final String NUMBER_BETWEEN_SLASHES_PATTERN = "/\\d+(?=/|$)";

    private final Command unsupportedPathCommand = new UnsupportedPathCommand();

    private final String deployPath;

    /**
     * Holder for GET commands
     */
    private Map<String, Command> commands = new HashMap<>();

    CommandHolder(String deployPath) {
        this.deployPath = deployPath;
        init();
    }

    private void init() {

//        commands.put(GET + deployPath + HOME_PATH, new HomeCommand());
        commands.put(GET + deployPath + LOGIN_PATH, new LoginCommand());
        commands.put(GET + deployPath + LOGOUT_PATH, new LogoutCommand());

        commands.put(GET + deployPath + STATISTICS_PATH, new StatisticsCommand());
        commands.put(GET + deployPath + MANAGE_PATH, new ManageCommand());
//
          commands.put(GET + deployPath + ADMIN_PATH, new AdminHomeCommand());

//
        commands.put(POST + deployPath + LOGIN_PATH, new LoginSubmitCommand());
        commands.put(POST + deployPath + REGISTER_PATH, new RegisterSubmitCommand());

    }

    /**
     * @param commandKey Key of the command, mapped to certain uri and request method
     * @return Command instance, mapped to certain uri and request method
     */
    Command findCommand(String commandKey) {
        String convertedKey = removeAllNumbersFromUrl(commandKey);
        System.out.println(convertedKey);
        return commands.getOrDefault(convertedKey, unsupportedPathCommand);
    }

    /**
     * this method replaces all digits between slashes to "id"
     * this is necessary because search algorithm doesn't support regular expressions
     * @param url
     * @return converted url
     */
    private String removeAllNumbersFromUrl(String url){
        return url.replaceAll(NUMBER_BETWEEN_SLASHES_PATTERN, "/id");
    }

}
