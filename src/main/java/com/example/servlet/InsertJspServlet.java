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

@WebServlet("/insert")
public class InsertJspServlet extends HttpServlet {
    private UserDAO userDAO;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        ApplicationContext ac = (ApplicationContext) config.getServletContext().getAttribute("applicationContext");
        this.userDAO = (UserDAO) ac.getBean("UserDAO");
    }

    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/pages/insert.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
       userDAO.create(req.getParameter("first_name"), req.getParameter("last_name"));
            resp.sendRedirect("/");
    }
}
