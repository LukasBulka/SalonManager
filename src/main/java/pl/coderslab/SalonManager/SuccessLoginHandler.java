package pl.coderslab.SalonManager;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

@Component
public class SuccessLoginHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
        if (roles.contains("ROLE_ADMIN")) {
            response.sendRedirect("/dashboardDispatcher/admin");
        } else if (roles.contains("ROLE_EMPLOYEE")) {
            response.sendRedirect("/dashboardDispatcher/employee");
        } else if (roles.contains("ROLE_USER")) {
            response.sendRedirect("/dashboardDispatcher/user");
        }
    }
}