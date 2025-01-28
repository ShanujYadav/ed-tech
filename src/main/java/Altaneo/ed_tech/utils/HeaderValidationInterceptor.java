package Altaneo.ed_tech.utils;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class HeaderValidationInterceptor implements HandlerInterceptor {
    @Value("${spring.pid}")
    private String pid;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        String path = request.getRequestURI();
        String PID = request.getHeader("PID");

        String userAgent = request.getHeader("User-Agent");
        String jwtToken = request.getHeader("accesToken");

        System.out.println("userAgent---------" + userAgent);

        if (PID == null || !PID.equals(pid)) {
            sendErrorResponse(response, HttpServletResponse.SC_UNAUTHORIZED, "Invalid or missing userAgent! ");
            return false;
        }

        if (path.startsWith("/api/v1/auth/")) {
            if (jwtToken == null || !validateJwtToken(jwtToken)) {
                sendErrorResponse(response, HttpServletResponse.SC_UNAUTHORIZED, "Invalid or missing JWT Token");
                return false;
            }
        }
        return true;
    }


    private boolean validateJwtToken(String token) {
        try {
            if (token.startsWith("Bearer ")) {
                token = token.substring(7); // Remove 'Bearer ' prefix
            }
            return true;
            // Claims claims = Jwts.parser()
            // .setSigningKey(SECRET_KEY)
            // .parseClaimsJws(token)
            // .getBody();
            // return claims != null;
            // } catch (SignatureException| IllegalArgumentException e) {
        } catch (Exception e) {
            return false;
        }
    }

    private void sendErrorResponse(HttpServletResponse response, int status, String message) throws IOException {
        response.setStatus(status);
        response.setContentType("application/json");
        response.getWriter()
                .write("{\"status\":" + status + ", \"error\":\"Unauthorized\", \"message\":\"" + message + "\"}");
    }
}