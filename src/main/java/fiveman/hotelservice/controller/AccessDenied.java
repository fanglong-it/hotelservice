package fiveman.hotelservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/accessDenied")
@Controller
public class AccessDenied {
    @GetMapping("/msg")
    public String deniedMessage() {
        return "Access Denied!";
    }
}
