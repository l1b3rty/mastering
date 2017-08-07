package org.glau.tlab.orm.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalControllerExceptionHandler {


    public static class ErrorInfo {
        private final String url;
        private final Throwable ex;

        public ErrorInfo(String url, Throwable e) {

            this.url = url;
            this.ex = e;
        }

        public String getUrl() {
            return url;
        }

        public Throwable getEx() {
            return ex;
        }
    }

  
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorInfo handleBadRequest(HttpServletRequest req, Exception ex) {

        return new ErrorInfo(req.getRequestURL().toString(), ex);
    } 
}