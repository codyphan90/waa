package edu.mum.controller;

import mum.edu.framework.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CalculatorController {
    @RequestMapping(value = {"/calculator"})
    public String calculateNumber(HttpServletRequest request, HttpServletResponse response) {
        String add1 = request.getParameter("add1").trim() ;
        String add2 = request.getParameter("add2").trim();
        String mult1 = request.getParameter("mult1").trim();
        String mult2 = request.getParameter("mult2").trim();

        String sum = "";
        String product = "";



        // Check for valid inputs....
        try {
            Integer a1 = Integer.parseInt(add1);
            Integer a2 = Integer.parseInt(add2);
            sum = "" + (a1+a2);
        } catch(NumberFormatException e) {
            if (add1.isEmpty()) add1 = "''";
            if (add2.isEmpty()) add2 = "''";
            sum = "''";
        }

        /*
         * Integer.parseInt(str) throws NumberFormatException
         * if the string cannot be converted to an integer.
         */

        try {
            Integer m1 = Integer.parseInt(mult1);
            Integer m2 = Integer.parseInt(mult2);
            product = "" + (m1 * m2);
        } catch(NumberFormatException e) {
            if (mult1.isEmpty()) mult1 = "''";
            if (mult2.isEmpty()) mult2 = "''";
            product = "''";
        }

        HttpSession session = request.getSession();
        session.setAttribute("add1", add1);
        session.setAttribute("add2", add2);
        session.setAttribute("mult1", mult1);
        session.setAttribute("mult2", mult2);
        session.setAttribute("sum", sum);
        session.setAttribute("product", product);
        return "WEB-INF/jsp/calculator.jsp";
    }
}
