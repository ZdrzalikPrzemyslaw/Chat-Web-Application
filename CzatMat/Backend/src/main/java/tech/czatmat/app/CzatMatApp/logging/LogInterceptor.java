package tech.czatmat.app.CzatMatApp.logging;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.DispatcherType;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LogInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) {

        LoggingService loggingService = new LoggingService() {
            @Override
            public void logRequest(HttpServletRequest httpServletRequest, Object body) {
                System.out.println(httpServletRequest);
                System.out.println(body);
            }

            @Override
            public void logResponse(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object body) {

            }
        };

        if (DispatcherType.REQUEST.name().equals(request.getDispatcherType().name())
                && request.getMethod().equals(HttpMethod.GET.name())) {
            loggingService.logRequest(request, null);
        }

        return true;
    }
}