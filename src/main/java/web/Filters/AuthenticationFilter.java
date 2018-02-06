package web.Filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
/**
 * Created by sadok on 06/02/2018.
 */


@WebFilter(
        filterName = "authentication",
        urlPatterns = {"/","/home","/logout"}
)
public class AuthenticationFilter implements Filter {


    private static final Set<String> ALLOWED_PATHS = Collections.unmodifiableSet(new HashSet<>(Arrays.asList("/jsp/login.jsp","/login")));

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        System.out.println("here filter");
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession(false);
        if(ALLOWED_PATHS.contains(request.getRequestURI())){
            // do nothing
            filterChain.doFilter(request,response);
            return;
        }
        if(session == null || session.getAttribute("userName") == null){
            response.sendRedirect("/login");
        }else{
            filterChain.doFilter(request,response);
        }
    }

    @Override
    public void destroy() {

    }
}
