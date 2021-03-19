package com.epam.web;

import com.epam.web.command.Command;
import com.epam.web.command.CommandFactory;
import com.epam.web.command.CommandResult;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Controller extends HttpServlet {

    private static final String PARAMETER_COMMAND = "command";

    private CommandFactory commandFactory = new CommandFactory();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }


    private void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String commandType = request.getParameter(PARAMETER_COMMAND);
        Command command = commandFactory.create(commandType);
        String page;
        boolean isRedirect = false;
        try{
            CommandResult result = command.execute(request, response);
            page = result.getPage();
            isRedirect = result.isRedirect();
        } catch (Exception e){
            request.setAttribute("errorMessage", e.getMessage());
            page = "/error.jsp";
        }

        if(!isRedirect){
            forward(request, response, page);
        } else {
            redirect(request, response, page);
        }
    }


    public void forward(HttpServletRequest request, HttpServletResponse response, String page) throws ServletException, IOException {
       RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(page);
        requestDispatcher.forward(request, response);
    }

    public void redirect(HttpServletRequest request, HttpServletResponse response, String page) throws IOException {
        response.sendRedirect(request.getContextPath() + page);
    }

}