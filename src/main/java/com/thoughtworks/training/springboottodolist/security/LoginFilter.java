package com.thoughtworks.training.springboottodolist.security;

import com.google.common.collect.ImmutableList;
import com.google.common.net.HttpHeaders;
import com.thoughtworks.training.springboottodolist.model.User;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import sun.plugin.liveconnect.SecurityContextHelper;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class LoginFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String header = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (header != null) {
            if (header.equals("hehe")) {
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
                return;
            }

            User user = new User(3L, "hong", "adg");
            SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(user, "", ImmutableList.of()));
        }
        filterChain.doFilter(request, response);

    }
}
