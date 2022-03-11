package take.servlet;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import take.beans.ColorBean;

@WebServlet(name = "ControllerServlet", urlPatterns = {"/ControllerServlet"})
public class ControllerServlet extends HttpServlet {

 @Override
 protected void doGet(HttpServletRequest request, HttpServletResponse response)
 throws ServletException, IOException {
 doPost(request, response);
 }

 @Override
 protected void doPost(HttpServletRequest request, HttpServletResponse response)
 throws ServletException, IOException {
 ColorBean myBean = new ColorBean();
 myBean.setForegroundColor( request.getParameter("foreColor") );
 myBean.setBackgroundColor( request.getParameter("backColor") );
 myBean.setHasBorder(request.getParameter("hasBorder").equals("yes"));
 request.setAttribute("bean", myBean);

 ArrayList members = new ArrayList();
 members.add("John Lennon");
 members.add("Paul McCartney");
 members.add("Ringo Starr");
 members.add("George Harrison");
 request.setAttribute("members", members);
 Calendar calDate = new GregorianCalendar();
 calDate.set(1965,Calendar.SEPTEMBER,13);
 Date releaseDate = calDate.getTime();
 request.setAttribute("releaseDate", releaseDate);
 
 
 ServletContext ctx = this.getServletContext();
 RequestDispatcher dispatcher =
 ctx.getRequestDispatcher("/yesterday.jsp");
 dispatcher.forward(request, response);
 }
}