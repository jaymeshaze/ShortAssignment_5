
package assignment5;

import java.io.*;
import java.util.Enumeration;
import javax.servlet.*;
import javax.servlet.http.*;


public class TestServlet extends HttpServlet{
    
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        
        response.setContentType("text/html;charset=UTF-8");
        
        //initiate ServletContext, create String array for params
        ServletContext context = request.getServletContext();
        Enumeration<String> params = context.getInitParameterNames();
        //create writer for webpage
        PrintWriter out = response.getWriter();
        
        //loop to print out each of the parameters from the xml file
        String str = "";
        while(params.hasMoreElements()){
            str = params.nextElement();
            out.println("<br>" + "Name: " + str + "<br>" +
                    "Value: " + context.getInitParameter(str) + "<br>");
        }
    }
    
    @Override
    public void destroy(){
    }
}
