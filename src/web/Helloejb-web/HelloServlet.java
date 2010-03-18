// HelloServlet.java
//

package hello;

import javax.servlet.http.*;
import javax.servlet.*;
import javax.ejb.*;
import javax.naming.*;
import java.io.IOException;

public class HelloServlet extends HttpServlet
{
    HelloLocalHome helloHome;
    HelloLocal hello;

    public void init() throws ServletException
    {
        try {
            Context context = new InitialContext();
            helloHome = (HelloLocalHome)context.lookup
                ("java:comp/env/HelloBean");

            // create local object
            hello = (HelloLocal)helloHome.create();

        } catch (NamingException e) {
            throw new ServletException("Error looking up home", e);
        } catch (CreateException e) {
            throw new ServletException("Error creating local hello bean", e);
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        response.setContentType("text/html");
        ServletOutputStream out = response.getOutputStream();
        try {
            out.println("<html>\n");
            out.println("<body>\n");
            out.println(hello.sayHello("Rubbish McInty"));
            out.println("</body>\n");
            out.println("</html>\n");
        } catch (EJBException e) {
            out.println("EJBException error: " + e.getMessage() );
        } catch (IOException e) {
            out.println("IOException error: " + e.getMessage() );
        } finally {
            out.close();
        }
    }

}
