//package com.dodo.sync.config;
//
//import com.dodo.sync.vo.DynamicCookie;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.session.web.http.CookieSerializer;
//
//@Configuration
//public class SpringSessionConfiguration {
//    @Bean
//    public CookieSerializer cookieSerializer() {
//        DynamicCookie serializer = new DynamicCookie();
//        serializer.setCookieName("JSESSIONID");
//        serializer.setDomainName("localhost");
//        serializer.setCookiePath("/");
//        serializer.setCookieMaxAge(3600);
//        serializer.setSameSite("None");  // 设置SameSite属性
//        serializer.setUseHttpOnlyCookie(true);
//        serializer.setUseSecureCookie(true);
//        return serializer;
//
//    }
//}