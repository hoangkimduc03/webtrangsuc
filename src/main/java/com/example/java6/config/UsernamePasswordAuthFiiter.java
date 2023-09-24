//package com.example.java6.config;
//
//import com.example.java6.Dto.CredentialsDto;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import java.io.IOException;
//
//public class UsernamePasswordAuthFiiter extends OncePerRequestFilter {
//
//    private static final ObjectMapper MAPPER = new ObjectMapper();
//
//    private final AbstractUserDetailsAuthenticationProvider provider;
//
//    public UsernamePasswordAuthFiiter(AbstractUserDetailsAuthenticationProvider provider) {
//        this.provider = provider;
//    }
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request,
//                                    HttpServletResponse response,
//                                    FilterChain filterChain) throws ServletException, IOException {
//        if ("/v1/signIn".equals(request.getServletPath())
//        && HttpMethod.POST.matches(request.getMethod()));
//         MAPPER.readValue(request.getInputStream(), CredentialsDto.class);
//         try {
//             SecurityContextHolder.getContext().setAuthentication(
//                     provider.vali
//             );
//        }
//    }
//}
