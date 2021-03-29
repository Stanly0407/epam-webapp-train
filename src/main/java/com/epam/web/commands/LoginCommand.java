package com.epam.web.commands;


import com.epam.web.entities.User;
import com.epam.web.exceptions.ServiceException;
import com.epam.web.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

public class LoginCommand implements Command {
    private static final Logger LOGGER = LogManager.getLogger(LoginCommand.class);

    private static final String PARAMETER_LOGIN = "login";
    private static final String PARAMETER_PASSWORD = "password";

    private final UserService userService;

    public LoginCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {

           LOGGER.debug("execute method start...");
        String login = request.getParameter(PARAMETER_LOGIN);
        String password = request.getParameter(PARAMETER_PASSWORD);


        Optional<User> optionalUser = userService.login(login, password);
        LOGGER.debug(" Optional<User> optionalUser = " + optionalUser);

        optionalUser.ifPresent(user -> request.setAttribute("name", user.getName()));

        String name = request.getParameter("name");

        LOGGER.debug("optionalUser = " + optionalUser);
        //session
        return CommandResult.redirect("/controller?command=mainPage");
    }


}
