package com.example.demo;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class WebErrorController implements ErrorController {

//http://localhost:8081/url - 스프링 부트는 오류발생시 자동으로 url을 /error 로 변경하므로
// http://localhost:8081/error 매핑 메소드가 오류처리하도록 유도한다
// 즉 , /error 은 스프링부트서버로 요청시 오류 발생할 때에만 실행한다.	
    @GetMapping("/error")
    public String handleError(HttpServletRequest request) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        
        System.out.println("오류메시지="+request.getAttribute(RequestDispatcher.ERROR_MESSAGE));
        System.out.println("오류파라미터="+request.getAttribute(RequestDispatcher.FORWARD_QUERY_STRING));
        System.out.println("요청파일="+request.getAttribute(RequestDispatcher.FORWARD_REQUEST_URI));
        System.out.println("오류파일="+request.getAttribute(RequestDispatcher.ERROR_REQUEST_URI));
        
        //if(status != null){
            int statusCode = Integer.valueOf(status.toString());
            System.out.println("오류코드="+statusCode);//404, 405등 
            if(statusCode == HttpStatus.NOT_FOUND.value()) {
                return "404";//404.jsp
            } 
            else if(statusCode == 400) {
            	return "400";
            }
            else if(statusCode == 405) {
            	return "405";//405 경우에만 RequestDispatcher.ERROR_MESSAGE값 있다(나머지오류시 공백)
            }
            else {
            	return "500";
            }
        //}
    }

}
