package ru.testhub.portal;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleService
{
    @RequestMapping("/hello")
    public String hello()
    {
        return "Hello Spring!";
    }
}
