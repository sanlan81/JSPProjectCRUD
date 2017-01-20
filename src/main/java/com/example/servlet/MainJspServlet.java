package com.example.servlet;

import com.example.dao.UserDAO;
import org.springframework.context.ApplicationContext;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("")
public class MainJspServlet extends HttpServlet {
    private UserDAO userDAO;
    @Override
    public void init(ServletConfig config) throws ServletException {

        super.init(config);

        ApplicationContext ac = (ApplicationContext) config.getServletContext().getAttribute("applicationContext");
        this.userDAO = (UserDAO)ac.getBean("UserDAO");
        userDAO.createTable();
    }

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("users",userDAO.listUsers());
        getServletContext().getRequestDispatcher("/pages/index.jsp").forward(req, resp);
    }
}
