package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\n");
      out.write("    <title>Document</title>\n");
      out.write("    <link href=\"http://fonts.googleapis.com/icon?family=Material+Icons\" rel=\"stylesheet\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.2/css/materialize.min.css\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"resources/css/styles.css\">\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("    <nav class=\"navbar-material default-primary-color\">\n");
      out.write("        <div class=\"nav-wrapper container\">\n");
      out.write("            <a href=\"product.jsp\" class=\"brand-logo left\">Sunshine Andina</a>\n");
      out.write("            <a href=\"#\" data-activates=\"sidebar\" class=\"button-collapse right\"><i class=\"material-icons\">menu</i></a>\n");
      out.write("            <ul class=\"right hide-on-med-and-down\">\n");
      out.write("                <li><a href=\"index.html\">Login</a></li>\n");
      out.write("                <li><a href=\"register.html\">Register</a></li>\n");
      out.write("                <li><a href=\"#\">Logout</a></li>\n");
      out.write("                <li><a href=\"cart.html\">Ver carrito<i class=\"material-icons right\"> shopping_cart</i></a></li>\n");
      out.write("                <li><a href=\"profile.html\">Mi Perfil</a></li>\n");
      out.write("            </ul>\n");
      out.write("            <ul class=\"side-nav dark-primary-color\" id=\"sidebar\">\n");
      out.write("                <li><a href=\"index.html\">Login</a></li>\n");
      out.write("                <li><a href=\"register.html\">Register</a></li>\n");
      out.write("                <li><a href=\"#\">Logout</a></li>\n");
      out.write("                <li><a href=\"cart.html\">Ver carrito<i class=\"material-icons right\">shopping_cart</i></a></li>\n");
      out.write("                <li><a href=\"profile.html\">Mi Perfil</a></li>\n");
      out.write("            </ul>\n");
      out.write("        </div>\n");
      out.write("    </nav>\n");
      out.write("\n");
      out.write("    <div class=\"container\">\n");
      out.write("        <div class=\"row\">\n");
      out.write("            <h2 class=\"center-align\">Ingrese sus datos</h2>\n");
      out.write("\n");
      out.write("            <form action=\"ServletRegistrer\" class=\"col s6 offset-s3 user-form\">\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"input-field inline col s12 m6\">\n");
      out.write("                        <input type=\"text\" id=\"username\" name=\"username\">\n");
      out.write("                        <label for=\"username\">Usuario</label>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"input-field inline col s12 m6\">\n");
      out.write("                        <input type=\"password\" id=\"password\" name=\"password\">\n");
      out.write("                        <label for=\"password\">Contraseña</label>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"input-field inline col s12 m6\">\n");
      out.write("                        <input type=\"text\" id=\"firstname\" name=\"firstname\">\n");
      out.write("                        <label for=\"firstname\">Primer Nombre</label>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"input-field inline col s12 m6\">\n");
      out.write("                        <input type=\"text\" id=\"middlename\" name=\"middlename\">\n");
      out.write("                        <label for=\"middlename\">Segundo Nombre</label>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"input-field inline col s12 m6\">\n");
      out.write("                        <input type=\"text\" id=\"lastname\" name=\"lastname\">\n");
      out.write("                        <label for=\"lastname\">Apellido Paterno</label>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"input-field inline col s12 m6\">\n");
      out.write("                        <input type=\"text\" id=\"lastname2\" name=\"lastname2\">\n");
      out.write("                        <label for=\"lastname2\">Apellido Materno</label>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"input-field inline col s12 m6\">\n");
      out.write("                        <input type=\"text\" id=\"dni\" name=\"dni\">\n");
      out.write("                        <label for=\"dni\">DNI</label>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"input-field inline col s12 m6\">\n");
      out.write("                        <input type=\"text\" id=\"ruc\" name=\"ruc\">\n");
      out.write("                        <label for=\"ruc\">RUC</label>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"input-field col s12\">\n");
      out.write("                        <input type=\"email\" id=\"email\" name=\"email\">\n");
      out.write("                        <label for=\"email\">Email</label>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"input-field inline col s12\">\n");
      out.write("                        <textarea id=\"direccion\" name=\"address\" class=\"materialize-textarea\"></textarea>\n");
      out.write("                        <label for=\"direccion\">Direccion</label>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col s12 center-align\">\n");
      out.write("                        <button class=\"btn waves-effect accent-color\">Registrarse</button>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </form>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <footer class=\"page-footer default-primary-color\">\n");
      out.write("        <div class=\"footer-copyright\">\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <div class=\"right\">&copy; 2017</div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </footer>\n");
      out.write("\n");
      out.write("    <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js\"></script>\n");
      out.write("    <script src=\"https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.2/js/materialize.min.js\"></script>\n");
      out.write("    <script src=\"resources/js/main.js\"></script>\n");
      out.write("</body>\n");
      out.write("\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
