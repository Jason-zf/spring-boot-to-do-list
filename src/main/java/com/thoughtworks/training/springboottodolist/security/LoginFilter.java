package com.thoughtworks.training.springboottodolist.security;

import com.google.common.collect.ImmutableList;
import com.google.common.net.HttpHeaders;
import com.thoughtworks.training.springboottodolist.model.User;
import com.thoughtworks.training.springboottodolist.service.TokenService;
import com.thoughtworks.training.springboottodolist.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class LoginFilter extends OncePerRequestFilter {
    @Autowired
    private TokenService tokenService;
    @Autowired
    private UserService userService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (token != null) {
            Long userId = tokenService.parseToken(token);
            if (userId == null) {
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
                return;
            }

            User user = userService.findById(userId);
            SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(user, "", ImmutableList.of()));
        }
        filterChain.doFilter(request, response);

    }
}
