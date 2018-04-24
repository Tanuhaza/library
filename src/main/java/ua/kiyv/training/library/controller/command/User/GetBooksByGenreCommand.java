package ua.kiyv.training.library.controller.command.User;

import ua.kiyv.training.library.controller.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GetBooksByGenreCommand implements Command {
    public GetBooksByGenreCommand() {
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        return null;
    }
}
