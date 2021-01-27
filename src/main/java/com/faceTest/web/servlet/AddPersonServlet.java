package com.faceTest.web.servlet;

import com.faceTest.service.PersonService;
import com.faceTest.service.impl.PersonServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/addPersonServlet")
public class AddPersonServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");

        Map<String, String[]> parameterMap = request.getParameterMap();

        PersonService service = new PersonServiceImpl();
        service.addPerson(parameterMap);

        response.sendRedirect(request.getContextPath()+"/pagingServlet?currentPage=1&row=5");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         doPost(request,response);
    }
}
