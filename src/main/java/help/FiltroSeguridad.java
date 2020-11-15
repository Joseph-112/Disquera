/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package help;


import controller.LoginSession;
import java.io.IOException;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pojo.User;

/**
 *
 * @author ASUS-PC
 */
public class FiltroSeguridad implements Filter {

    @Inject
    private LoginSession loginSession;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Se crea el filtro");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        //Entro alguna página según configuración         
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        String Url = req.getRequestURL().toString();
        System.out.println("entro al filtro ");
        if (loginSession.getKey() < 0) {
            res.sendRedirect("../login.xhtml");
        } else {
            if (FacesContext.getCurrentInstance() == null) {
                System.out.println("entro al nulo ");
                res.sendRedirect("../login.xhtml");
            } else {
                User usuario = (User) FacesContext.getCurrentInstance().getExternalContext().
                        getSessionMap().get(loginSession.getKey() + "");
                if (usuario != null) {
                    if(Url.contains("admin1") && usuario.getRol().equals("Administrador")) 
                        chain.doFilter(request, response);
                    else if(Url.contains("estudiante1") && usuario.getRol().equals("Estudiante"))
                        chain.doFilter(request, response);
                    else
                        res.sendRedirect("../login.xhtml");
                } else {
                    res.sendRedirect("../login.xhtml");
                }
            }
        }

        
    }

    @Override
    public void destroy() {
        System.out.println("Se destruye el filtro");
    }

}
