/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.54
 * Generated at: 2021-12-09 19:59:32 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class about_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("     <!--Link to Bootstrap's CSS-->\r\n");
      out.write("     <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css\">\r\n");
      out.write("    <link href=\"css/about.css\" rel=\"stylesheet\" />\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("    <title>Document</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("    <div class=\"contenedro\">\r\n");
      out.write("        <header>\r\n");
      out.write("            <div class=\"CABECERA\"> \r\n");
      out.write("                    \r\n");
      out.write("                <div class=\"imagen\">\r\n");
      out.write("                    <img src=\"img/logo.PNG\">\r\n");
      out.write("                </div> \r\n");
      out.write("            <nav>\r\n");
      out.write("               <a href=\"index.jsp\">Inicio</a>\r\n");
      out.write("                <a href=\"productos.jsp\">Producto</a>\r\n");
      out.write("                <a href=\"about.jsp\">Quienes somos</a>\r\n");
      out.write("                <a href=\"#\">Contacto</a>\r\n");
      out.write("            </nav>\r\n");
      out.write("            </div>\r\n");
      out.write("        </header>\r\n");
      out.write("    \r\n");
      out.write("        <section>\r\n");
      out.write("            <div class=\"art1\">\r\n");
      out.write("                <img src=\"img/naturaleza.jpg\" alt=\"\">\r\n");
      out.write("                <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Ipsa, unde enim quae soluta nisi, cumque quo cupiditate accusantium ab tempora quas? \r\n");
      out.write("                    Provident blanditiis quisquam non enim error aut dolore nemo!Loremloremip</p>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"art2\">\r\n");
      out.write("                <img src=\"img/olivo.jpg\" alt=\"\">\r\n");
      out.write("                <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Ipsa, unde enim quae soluta nisi, cumque quo cupiditate accusantium ab tempora quas? \r\n");
      out.write("                    Provident blanditiis quisquam non enim error aut dolore nemo!Loremloremip</p>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"art3\">\r\n");
      out.write("                <img src=\"img/vaca.jpg\" alt=\"\">\r\n");
      out.write("                <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Ipsa, unde enim quae soluta nisi, cumque quo cupiditate accusantium ab tempora quas? \r\n");
      out.write("                    Provident blanditiis quisquam non enim error aut dolore nemo!Loremloremip</p>\r\n");
      out.write("            </div>\r\n");
      out.write("            \r\n");
      out.write("        </section>\r\n");
      out.write("        \r\n");
      out.write("  	</div>\r\n");
      out.write("    <div class=\"container steps\">\r\n");
      out.write("        <div class=\"container py-5\" id=\"featured-3\">\r\n");
      out.write("          <h2 class=\"pb-2\">Beneficios de elegirnos frente al resto</h2>\r\n");
      out.write("          <div class=\"row g-5 py-0\">\r\n");
      out.write("            <div class=\"feature col-md-3\">\r\n");
      out.write("                <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"16\" height=\"16\" fill=\"currentColor\" class=\"bi bi-emoji-heart-eyes\" viewBox=\"0 0 16 16\">\r\n");
      out.write("                    <path d=\"M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z\"/>\r\n");
      out.write("                    <path d=\"M11.315 10.014a.5.5 0 0 1 .548.736A4.498 4.498 0 0 1 7.965 13a4.498 4.498 0 0 1-3.898-2.25.5.5 0 0 1 .548-.736h.005l.017.005.067.015.252.055c.215.046.515.108.857.169.693.124 1.522.242 2.152.242.63 0 1.46-.118 2.152-.242a26.58 26.58 0 0 0 1.109-.224l.067-.015.017-.004.005-.002zM4.756 4.566c.763-1.424 4.02-.12.952 3.434-4.496-1.596-2.35-4.298-.952-3.434zm6.488 0c1.398-.864 3.544 1.838-.952 3.434-3.067-3.554.19-4.858.952-3.434z\"/>\r\n");
      out.write("                  </svg>\r\n");
      out.write("              <hr>\r\n");
      out.write("              <h3>1. Disfrute</h3>\r\n");
      out.write("              <p>Disfrute de una experiencia unica.</p>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"feature col-md-3\">\r\n");
      out.write("                <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"16\" height=\"16\" fill=\"currentColor\" class=\"bi bi-people\" viewBox=\"0 0 16 16\">\r\n");
      out.write("                    <path d=\"M15 14s1 0 1-1-1-4-5-4-5 3-5 4 1 1 1 1h8zm-7.978-1A.261.261 0 0 1 7 12.996c.001-.264.167-1.03.76-1.72C8.312 10.629 9.282 10 11 10c1.717 0 2.687.63 3.24 1.276.593.69.758 1.457.76 1.72l-.008.002a.274.274 0 0 1-.014.002H7.022zM11 7a2 2 0 1 0 0-4 2 2 0 0 0 0 4zm3-2a3 3 0 1 1-6 0 3 3 0 0 1 6 0zM6.936 9.28a5.88 5.88 0 0 0-1.23-.247A7.35 7.35 0 0 0 5 9c-4 0-5 3-5 4 0 .667.333 1 1 1h4.216A2.238 2.238 0 0 1 5 13c0-1.01.377-2.042 1.09-2.904.243-.294.526-.569.846-.816zM4.92 10A5.493 5.493 0 0 0 4 13H1c0-.26.164-1.03.76-1.724.545-.636 1.492-1.256 3.16-1.275zM1.5 5.5a3 3 0 1 1 6 0 3 3 0 0 1-6 0zm3-2a2 2 0 1 0 0 4 2 2 0 0 0 0-4z\"/>\r\n");
      out.write("                  </svg>\r\n");
      out.write("              <hr>\r\n");
      out.write("              <h3>2. Comparta</h3>\r\n");
      out.write("              <p>Comparta nuestros productos con sus familiares.</p>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"feature col-md-3\">\r\n");
      out.write("                <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"16\" height=\"16\" fill=\"currentColor\" class=\"bi bi-telephone-forward-fill\" viewBox=\"0 0 16 16\">\r\n");
      out.write("                    <path fill-rule=\"evenodd\" d=\"M1.885.511a1.745 1.745 0 0 1 2.61.163L6.29 2.98c.329.423.445.974.315 1.494l-.547 2.19a.678.678 0 0 0 .178.643l2.457 2.457a.678.678 0 0 0 .644.178l2.189-.547a1.745 1.745 0 0 1 1.494.315l2.306 1.794c.829.645.905 1.87.163 2.611l-1.034 1.034c-.74.74-1.846 1.065-2.877.702a18.634 18.634 0 0 1-7.01-4.42 18.634 18.634 0 0 1-4.42-7.009c-.362-1.03-.037-2.137.703-2.877L1.885.511zm10.761.135a.5.5 0 0 1 .708 0l2.5 2.5a.5.5 0 0 1 0 .708l-2.5 2.5a.5.5 0 0 1-.708-.708L14.293 4H9.5a.5.5 0 0 1 0-1h4.793l-1.647-1.646a.5.5 0 0 1 0-.708z\"/>\r\n");
      out.write("                  </svg>\r\n");
      out.write("              <hr>\r\n");
      out.write("              <h3>3. Llamenos</h3>\r\n");
      out.write("              <p>Estamos disponibles 24/7 para cualquier pedido o cualquier inconvenencia.</p>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"feature col-md-3\">\r\n");
      out.write("                <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"16\" height=\"16\" fill=\"currentColor\" class=\"bi bi-envelope-open\" viewBox=\"0 0 16 16\">\r\n");
      out.write("                    <path fill-rule=\"evenodd\" d=\"M8.47 1.318a1 1 0 0 0-.94 0l-6 3.2A1 1 0 0 0 1 5.4v.817l5.75 3.45L8 8.917l1.25.75L15 6.217V5.4a1 1 0 0 0-.53-.882l-6-3.2ZM15 7.383l-4.778 2.867L15 13.117V7.383Zm-.035 6.88L8 10.082l-6.965 4.18A1 1 0 0 0 2 15h12a1 1 0 0 0 .965-.738ZM1 13.116l4.778-2.867L1 7.383v5.734ZM7.059.435a2 2 0 0 1 1.882 0l6 3.2A2 2 0 0 1 16 5.4V14a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2V5.4a2 2 0 0 1 1.059-1.765l6-3.2Z\"/>\r\n");
      out.write("                  </svg>\r\n");
      out.write("              <hr>\r\n");
      out.write("              <h3>4. Contacte</h3>\r\n");
      out.write("              <p>Envienos un correo en cualquier momento.</p>\r\n");
      out.write("            </div>\r\n");
      out.write("          </div>\r\n");
      out.write("        </div>\r\n");
      out.write("      </div>\r\n");
      out.write("    \r\n");
      out.write("      <!-- FOOTER -->\r\n");
      out.write("      <hr class=\"featurette-divider\">\r\n");
      out.write("      <footer class=\"container\">\r\n");
      out.write("        <p class=\"float-end\"><a href=\"#\">Inicio de pagina <i class=\"fas fa-chevron-up\"></i></a></p>\r\n");
      out.write("        <p>&copy; 2021 SanTierno SL. </p>\r\n");
      out.write("      </footer>\r\n");
      out.write("    \r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}