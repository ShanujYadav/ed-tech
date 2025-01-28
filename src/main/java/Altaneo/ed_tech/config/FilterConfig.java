// package Altaneo.ed_tech.config;

// import org.springframework.boot.web.servlet.FilterRegistrationBean;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;

// import Altaneo.ed_tech.utils.AuthFilter;

// @Configuration
// public class FilterConfig {

//     @Bean
//     public FilterRegistrationBean<AuthFilter> filterRegistrationBean() {
//         FilterRegistrationBean<AuthFilter> registrationBean = new FilterRegistrationBean<>();
//         AuthFilter authValidationFilter = new AuthFilter();
//         registrationBean.setFilter(authValidationFilter);
//         registrationBean.addUrlPatterns("/api/v1/*");
//         registrationBean.setOrder(1);
//         return registrationBean;
//     }
// }
