package com.faceTest.web.servlet;

import com.faceTest.domain.PageBean;
import com.faceTest.service.PersonService;
import com.faceTest.service.impl.PersonServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/pagingServlet")
public class PagingServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        String currentPage = request.getParameter("currentPage");
        String row = request.getParameter("row");

        Map<String, String[]> parameterMap = request.getParameterMap();

        System.out.println(currentPage);
        System.out.println(row);

        PersonService service = new PersonServiceImpl();
        PageBean pb = service.conditionQueryCount(parameterMap,currentPage,row);
        System.out.println(pb);

        request.setAttribute("paging",pb);
        request.setAttribute("parameterMap",parameterMap);
        request.getRequestDispatcher("/paging.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
