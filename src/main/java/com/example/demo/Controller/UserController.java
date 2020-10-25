package com.example.demo.Controller;

import com.example.demo.model.Role;
import com.example.demo.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.core.env.Environment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.persistence.Entity;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import java.security.Principal;
import java.util.List;

//@RestController
//@RequestMapping("/crack")
//@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController extends ResponseEntityExceptionHandler {

    //@Autowired
    //public UserService userService;

    //@Autowired
    //private DiscoveryClient discoveryClient;
/*
    @Autowired
    private Environment env;

    @Value("${spring.application.name}")
    private String serviceId;


    @GetMapping("/service/port")
    public String getPort() {
        return "Service port number : " + env.getProperty("local.server.port");

    }
/*
    @GetMapping("/service/instances")
    public ResponseEntity<?> getInstances() {
        return new ResponseEntity<>(discoveryClient.getInstances(serviceId), HttpStatus.OK);
    }

    @GetMapping("service/services")
    public ResponseEntity<?> getServices() {
        System.out.println("testing");
        return new ResponseEntity<>(discoveryClient.getServices(), HttpStatus.OK);
    }
*/
/*
    @PostMapping("/registration")
    public ResponseEntity<?> saveUser(@RequestBody User user) {
        System.out.println("In registration method");
        if (userService.findByUsername(user.getUsername()) != null) {
            //status code :409
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        //user.setRole(Role.User);
        return new ResponseEntity<>(userService.save(user), HttpStatus.CREATED);
    }

    @GetMapping("/login")
    //public ResponseEntity<?> getUser(HttpServletRequest httpServletRequest)
    public ResponseEntity<?> getUser(Principal principal) {
        System.out.println("In Login Method");
        System.out.println("testing going on ");
        //Principal principal=httpServletRequest.getUserPrincipal();
        if (principal == null || principal.getName() == null) {
            //this means ; logutout will be successfull. login?logout
            return new ResponseEntity<>(HttpStatus.OK);
        }
        //username=principal.getName();
        return ResponseEntity.ok(userService.findByUsername(principal.getName()));
    }

    @PostMapping("/names")
    public ResponseEntity<?> getNamesOfUsers(@RequestBody List<Long> isList) {
        return ResponseEntity.ok(userService.findUsers(isList));
    }

    @GetMapping("/test")
    public ResponseEntity<?> test() {
        return ResponseEntity.ok("It is working...");
    }
}
*/
}
