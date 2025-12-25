package additoncalculator;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;


@SuppressWarnings("serial")
@WebServlet("/AddServlet")
public class Additioncalc extends HttpServlet {
    
    @Override
    public void service(HttpServletRequest req, HttpServletResponse res) 
            throws ServletException, IOException {
        
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        
        // Get numbers from form
        String n1 = req.getParameter("num1");
        String n2 = req.getParameter("num2");
        
        try {
            // Convert to numbers and calculate
            double a = Double.parseDouble(n1);
            double b = Double.parseDouble(n2);
            double sum = a + b;
            
            // Show result
            out.println("<html><head><style>");
            out.println("body { font-family: Arial; padding: 50px; text-align: center; }");
            out.println(".result { background: #d4edda; padding: 30px; border-radius: 10px; margin: 20px auto; max-width: 400px; }");
            out.println(".numbers { font-size: 24px; color: #155724; }");
            out.println(".answer { font-size: 36px; color: #27ae60; font-weight: bold; margin: 20px 0; }");
            out.println(".btn { background: #3498db; color: white; padding: 10px 20px; text-decoration: none; border-radius: 5px; }");
            out.println("</style></head><body>");
            
            out.println("<div class='result'>");
            out.println("<h2>✅ Calculation Complete!</h2>");
            out.println("<div class='numbers'>" + a + " + " + b + "</div>");
            out.println("<div class='answer'>= " + sum + "</div>");
            out.println("<p>The sum of " + a + " and " + b + " is <strong>" + sum + "</strong></p>");
            out.println("</div>");
            
        } catch (Exception e) {
            out.println("<div style='color:red; background:#f8d7da; padding:20px; border-radius:10px;'>");
            out.println("<h2>❌ Oops! Error</h2>");
            out.println("<p>Please enter valid numbers only!</p>");
            out.println("<a href='calculator.html' style='color:#721c24;'>Try Again</a>");
            out.println("</div>");
        }
        
        out.println("</body></html>");
    }
}