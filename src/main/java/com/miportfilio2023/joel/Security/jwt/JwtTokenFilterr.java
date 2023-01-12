/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.miportfilio2023.joel.Security.jwt;

import com.miportfilio2023.joel.Security.Service.UserDetailsImpl;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 *
 * @author Joel Miguel Serrudo
 */
public class JwtTokenFilterr extends OncePerRequestFilter{
    private final static Logger logger = LoggerFactory.getLogger(JwtTokenFilterr.class);
    
    @Autowired
    JwtProvider jwtProvider;
    @Autowired
    UserDetailsImpl userDetailsServImpl;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try{
            String token = getToken(request);
            if (token!=null && jwtProvider.validateToken(token)){
                String nombreUsuario = jwtProvider.getNombreUsuarioFromToken(token);
                UserDetails userDetails=userDetailsServImpl.loadUserByUsername(nombreUsuario);
                UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(auth);
                
            }
        }catch (Exception e){
                    logger.error("Hubo falla en el metodo dofilterinternal");
                    }
        filterChain.doFilter(request, response);
    }
    
    private String getToken(HttpServletRequest request){
        String header = request.getHeader("Authorization");
        if (header!=null && header.startsWith("Bearer"))
            return header.replace("Bearer","");
        return null;
    }
}
