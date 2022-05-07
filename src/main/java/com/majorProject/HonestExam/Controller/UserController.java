package com.majorProject.HonestExam.Controller;

import com.majorProject.HonestExam.Model.Question;
import com.majorProject.HonestExam.Model.User;
import com.majorProject.HonestExam.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins="http://localhost:3000/")
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("user")
    public boolean createUser(@RequestBody User user)
    {
        try{
            userService.createUser(user);
            return true;
        }catch (Exception e){
            return  false;
        }

    }

    @GetMapping("user/validatekey/{testId}")
    public  int validateTestKey(@PathVariable long testId){

        return userService.validateTestKey(testId);
    }

    @GetMapping("validemail/{email}")
    public boolean validEmail(@PathVariable String email){

        return userService.validEmail(email);
    }

    @GetMapping("validuser/{email}/{password}")
    public boolean validUser(@PathVariable String email,@PathVariable String password){
        User user=userService.validUser(email,password);
        if(user==null)
        return false;
        else return true;
    }
    @GetMapping("getuser/{email}/{password}")
    public User getUser(@PathVariable String email,@PathVariable String password){
        return userService.validUser(email,password);

    }

}
