package life.majiang.community.advice;

import life.majiang.community.exception.CustomizeExceprion;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class CustomizeExceptionHandler {
    @ExceptionHandler()
    ModelAndView handler(HttpServletRequest request, Throwable ex, Model model){
        if (ex instanceof CustomizeExceprion){
            model.addAttribute("message",ex.getMessage());
        }else {
            model.addAttribute("message","服务已经冒烟了，请稍后试试");
        }
        return new ModelAndView("error");
    }

}
