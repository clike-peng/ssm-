package com.faceTest.web.servlet;

import com.faceTest.service.PersonService;
import com.faceTest.service.impl.PersonServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/removePersonServlet")
public class RemovePersonServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String personId = request.getParameter("personId");
        PersonService service = new PersonServiceImpl();
        service.removePerson(personId);

        response.sendRedirect(request.getContextPath()+"/pagingServlet?currentPage=1&row=5");

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       this.doPost(request,response);
    }
}
