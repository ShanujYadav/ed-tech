// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.web.servlet.config.annotation.CorsRegistry;
// import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// @Configuration
// public class WebConfig {

//     @Bean
//     public WebMvcConfigurer corsConfigurer() {
//         return new WebMvcConfigurer() {
//             @Override
//             public void addCorsMappings(CorsRegistry registry) {
//                 registry.addMapping("/**") // Apply to all endpoints
//                         .allowedOrigins("*") // Allow all origins
//                         .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Allow these HTTP methods
//                         .allowedHeaders("*") // Allow all headers
//                         .allowCredentials(false) // Set to true only if you need cookies/auth headers
//                         .maxAge(3600); // Cache preflight response for 1 hour
//             }
//         };
//     }
// }
