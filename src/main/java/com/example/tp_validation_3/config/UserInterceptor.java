package com.example.tp_validation_3.config;
import com.example.tp_validation_3.service.IntUserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
@AllArgsConstructor
public class UserInterceptor implements HandlerInterceptor {
    private final IntUserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (request.getSession().getAttribute("email") != null) {
            String email = (String) request.getSession().getAttribute("email");
            request.setAttribute("email",email);
        }
        return true;
    }
}
