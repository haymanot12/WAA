package servlets;

import org.springframework.boot.web.servlet.server.Session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Vector;

@WebServlet("/calc")
public class CalculatorServlet extends HttpServlet {
    HtmlUtils hu = new HtmlUtils();
    Vector av = new Vector();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //show calculator page
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>SIMPLE CALCULATOR<br><br><br></head>");
        out.println("<body>");
        out.println("<form method = 'post' action = 'calc'>");
        out.println("enter the first number:<br>");
        out.println("<input type = 'text' name='number1'><br><br>");
        out.println("enter the second number:<br>");
        out.println("<input type = 'text' name='number2'><br><br>");
        out.println("enter the operation:<br><br>");
        out.println("<input type ='radio' name = 'op' value = '+'>add<br>");
        out.println("<input type = 'radio' name = 'op' value = '-'>sub<br>");
        out.println("<input type = 'radio' name = 'op' value = '*'>mul<br>");
        out.println("<input type = 'radio' name = 'op' value = '/'>div<br><br>");
        out.println("<input type = 'submit' name = 'result' value = 'submit'><br>");
        out.println("</body>");
        out.println("</html>");
        out.flush();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //show result page
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        if (session.isNew()) {
            session.setAttribute("table", hu);

        } else {
            hu = (HtmlUtils) session.getAttribute("table");
        }
        out.println("<html>");
        out.println("<head>SIMPLE CALCULATOR<br><br><br></head>");
        out.println("<body>");
        out.println("<form method = 'post' action = 'calc'>");
        out.println("enter the first number:<br>");
        out.println("<input type = 'text' name='number1'><br><br>");
        out.println("enter the second number:<br>");
        out.println("<input type = 'text' name='number2'><br><br>");
        out.println("enter the operation:<br><br>");
        out.println("<input type ='radio' name = 'op' value = '+'>add<br>");
        out.println("<input type = 'radio' name = 'op' value = '-'>sub<br>");
        out.println("<input type = 'radio' name = 'op' value = '*'>mul<br>");
        out.println("<input type = 'radio' name = 'op' value = '/'>div<br><br>");
        out.println("<input type = 'submit' name = 'result' value = 'submit'><br><br>");
        out.println("</body>");
        out.println("</html>");
        int num1 = Integer.parseInt(request.getParameter("number1"));
        int num2 = Integer.parseInt(request.getParameter("number2"));

        if (request.getParameter("op").equals("+")) {
            out.println("The result of " + num1 + " + " + num2 + " = " + (num1 + num2));
            out.print(hu.createHtmlHeader("Print Table"));
            out.print(hu.getTableHead("left", 1));
            out.print(hu.getTH("center", "First"));
            out.print(hu.getTH("center", "Operation"));
            out.print(hu.getTH("center", "Second"));
            out.print(hu.getTH("center", "Result"));

            av.addElement(num1);
            av.addElement(request.getParameter("op"));
            av.addElement(num2);
            av.addElement(num1 + num2);
            out.print(hu.getTableContents("center", av, 4));
            out.print(hu.getHtmlFooter());
        } else if (request.getParameter("op").equals("-")){
            out.println("The result of " + num1 + " - " + num2 + " = " + (num1 - num2));
            //out.println("The result of " + num1 + " + " + num2 + " = " + (num1 + num2));
            out.print(hu.createHtmlHeader("Print Table"));
            out.print(hu.getTableHead("left", 1));
            out.print(hu.getTH("center", "First"));
            out.print(hu.getTH("center", "Operation"));
            out.print(hu.getTH("center", "Second"));
            out.print(hu.getTH("center", "Result"));

            av.addElement(num1);
            av.addElement(request.getParameter("op"));
            av.addElement(num2);
            av.addElement(num1 - num2);
            out.print(hu.getTableContents("center", av, 4));
            out.print(hu.getHtmlFooter());
    }
        else if (request.getParameter("op").equals("*")) {
            out.println("The result of " + num1 + " * " + num2 + " = " + (num1 * num2));

            out.print(hu.createHtmlHeader("Print Table"));
            out.print(hu.getTableHead("left", 1));
            out.print(hu.getTH("center", "First"));
            out.print(hu.getTH("center", "Operation"));
            out.print(hu.getTH("center", "Second"));
            out.print(hu.getTH("center", "Result"));

            av.addElement(num1);
            av.addElement(request.getParameter("op"));
            av.addElement(num2);
            av.addElement(num1 * num2);
            out.print(hu.getTableContents("center", av, 4));
            out.print(hu.getHtmlFooter());

        } else if (request.getParameter("op").equals("/")) {
            out.println("The result of " + num1 + " / " + num2 + " = " + (float)num1 / num2);
            out.print(hu.createHtmlHeader("Print Table"));
            out.print(hu.getTableHead("left", 1));
            out.print(hu.getTH("center", "First"));
            out.print(hu.getTH("center", "Operation"));
            out.print(hu.getTH("center", "Second"));
            out.print(hu.getTH("center", "Result"));

            av.addElement(num1);
            av.addElement(request.getParameter("op"));
            av.addElement(num2);
            av.addElement((float)num1 / num2);
            out.print(hu.getTableContents("center", av, 4));
            out.print(hu.getHtmlFooter());

        }

        out.flush();
    }
    class HtmlUtils {

        public String createHtmlHeader(String title) {

            String htmlHeader = null;
            htmlHeader = "<HTML><HEAD><TITLE> " + title + " </TITLE></HEAD><BODY>";
            return htmlHeader;
        }

        public String getHtmlFooter() {

            String htmlFooter = "</BODY></HTML>";
            return htmlFooter;
        }

        public String getHead(int level, String heading) {
            return "<H" + level + "> " + heading + "</H" + level + ">";
        }

        public String getTableHead(String align, int border) {

            String tableHeader = null;
            tableHeader = "<TABLE align=" + align + " border=" + border + ">";
            return tableHeader;

        }

        public String getTR(String align) {
            String TRCell = null;
            TRCell = "<TR align=" + align + ">";
            return TRCell;
        }

        public String getTR() {
            String TRCell = null;
            TRCell = "<TR>";
            return TRCell;
        }

        public String getTD(String align, String value) {
            String TDCell = null;
            TDCell = "<TD align=" + align + "> " + value + " </TD>";
            return TDCell;
        }

        public String getTD() {
            String TDCell = null;
            TDCell = "<TD>";
            return TDCell;
        }
        public String getTH(String align, String value) {
            String THCell = null;
            THCell = "<TH align=" + align + "> " + value + " </TH>";
            return THCell;
        }

        public String getTableContents(String align, Vector values,
                                       int elementCounter) throws IOException {

            StringWriter Cells = new StringWriter();
            String contents = new String();
            int vsize = values.size();

            Cells.write("<TR>");

            for (int i = 0; i < vsize; i++) {
                String value = values.elementAt(i).toString();

                if (i != 0) {
                    if (i >= elementCounter) {

                        if (i % elementCounter == 0) {
                            Cells.write("</TR>\n\n<TR>");
                        }
                    }
                }

                Cells.write("<TD align=" + align + "> " + value + " </TD> \n");
            }

            Cells.write("</TR>");

            contents = Cells.toString();
            Cells.flush();
            Cells.close();

            return contents;
        }

        public String getClosedTR() {
            String TRCell = null;
            TRCell = "</TR>";
            return TRCell;
        }

        public String getClosedTD() {
            String TDCell = null;
            TDCell = "</TD>";
            return TDCell;
        }

        public String getBR(int lines) {

            StringWriter lineBR = new StringWriter();
            String lineBRs = new String();

            for (int i = 0; i <= lines; i++) {
                lineBR.write("<BR>\n");
            }
            lineBRs = lineBR.toString();

            return lineBRs;
        }

        public String getLI(String item) {

            String li = new String("<LI>");
            li += item;
            return li;

        }

    }

}
