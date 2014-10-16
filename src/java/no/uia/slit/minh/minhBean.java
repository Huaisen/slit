/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.uia.slit.minh;

import java.io.Serializable;
import java.util.ArrayList;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
@WebServlet("/minhBean")
public class minhBean extends HttpServlet {
 
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
         
String feedback = request.getParameter("feedback");
System.out.println("Feed back is: " + feedback);
         
    }
 
}   
