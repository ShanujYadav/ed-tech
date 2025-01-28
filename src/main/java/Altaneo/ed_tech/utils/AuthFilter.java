// package Altaneo.ed_tech.utils;

// import java.io.IOException;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.stereotype.Component;
// import org.springframework.web.filter.OncePerRequestFilter;

// import jakarta.servlet.FilterChain;
// import jakarta.servlet.ServletException;
// import jakarta.servlet.http.HttpFilter;
// import jakarta.servlet.http.HttpServletRequest;
// import jakarta.servlet.http.HttpServletResponse;

// @Component
// public class AuthFilter extends HttpFilter {
//     // public class AuthFilter extends OncePerRequestFilter {
//     @Value("${spring.pid}")
//     private String pid;

//     // private static final String SECRET_KEY = "your-jwt-secret-key";
//     // private static final String pid = "ALTA";
//     @Override

//     protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
//             throws IOException, ServletException {

//         // protected void doFilterInternal(HttpServletRequest request,
//         // HttpServletResponse response, FilterChain chain)
//         // throws ServletException, IOException {

//         String path = request.getRequestURI();
//         System.out.println("Request filter-----" + pid);

//         String userAgent = request.getHeader("userAgent");
//         String jwtToken = request.getHeader("Authorization");

//         if (userAgent == null || !userAgent.equals(pid)) {
//             sendErrorResponse(response, HttpServletResponse.SC_UNAUTHORIZED, "Invalid or missing userAgent! ");
//             return;
//         }

//         if (path.startsWith("/api/v1/auth/")) {
//             if (jwtToken == null || !validateJwtToken(jwtToken)) {
//                 sendErrorResponse(response, HttpServletResponse.SC_UNAUTHORIZED, "Invalid or missing JWT Token");
//                 return;
//             }
//         }
//         chain.doFilter(request, response);
//     }

//     private boolean validateJwtToken(String token) {
//         try {
//             if (token.startsWith("Bearer ")) {
//                 token = token.substring(7); // Remove 'Bearer ' prefix
//             }
//             return true;
//             // Claims claims = Jwts.parser()
//             // .setSigningKey(SECRET_KEY)
//             // .parseClaimsJws(token)
//             // .getBody();
//             // return claims != null;
//             // } catch (SignatureException| IllegalArgumentException e) {
//         } catch (Exception e) {
//             return false;
//         }
//     }

//     private void sendErrorResponse(HttpServletResponse response, int status, String message) throws IOException {
//         response.setStatus(status);
//         response.setContentType("application/json");
//         response.getWriter()
//                 .write("{\"status\":" + status + ", \"error\":\"Unauthorized\", \"message\":\"" + message + "\"}");
//     }
// }
