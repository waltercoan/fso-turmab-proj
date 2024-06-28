package br.univille.projapifso2024b.security;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JWTRequestFilter extends OncePerRequestFilter{
    @Autowired
    private JWTUtil serviceJWT;
    @Autowired
    private UserDetailsService serviceUser;

    
    @Override
    protected void doFilterInternal(HttpServletRequest request, 
                                    HttpServletResponse response, 
                                    FilterChain filterChain)
            throws ServletException, IOException {
        
        var authHeader = request.getHeader("Authorization");
        String username = null;
        String token = null;

        if(authHeader != null &&
            authHeader.startsWith("Bearer ")){
            token = authHeader.substring(7);
            username = serviceJWT.extractUserName(token);
        }

        if(username != null &&
            SecurityContextHolder.getContext().getAuthentication() == null){
            var userDetail = serviceUser.loadUserByUsername(username);
            if(serviceJWT.validateToken(token, userDetail)){
                UsernamePasswordAuthenticationToken ut = 
                    new UsernamePasswordAuthenticationToken(username, null, userDetail.getAuthorities());
                
                ut.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(ut);
            }
        }
        
        filterChain.doFilter(request, response);
    }
}