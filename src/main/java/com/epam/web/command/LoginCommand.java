package com.epam.web.command;


import com.epam.web.entities.User;
import com.epam.web.exceptions.ServiceException;
import com.epam.web.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

public class LoginCommand implements Command {

    private static final String PARAMETER_USERNAME = "username";
    private static final String PARAMETER_PASSWORD = "password";
   // private static final String ATTRIBUTE_NAME = "name";
  //  private static final String PATH_MAIN_PAGE = "WEB-INF/view/mainPage.jsp";

    private UserService userService;

    public LoginCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        String email = request.getParameter(PARAMETER_USERNAME);
        String password = request.getParameter(PARAMETER_PASSWORD);
        Optional<User> optionalUser = userService.login(email, password);

        optionalUser.ifPresent(user -> request.setAttribute("name", user.getName()));


        return CommandResult.redirect("/controller?command=mainPage");
               // (PATH_MAIN_PAGE) ; //
    }
}
