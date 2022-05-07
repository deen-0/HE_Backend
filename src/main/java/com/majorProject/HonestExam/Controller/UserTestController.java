package com.majorProject.HonestExam.Controller;

import com.majorProject.HonestExam.Model.Question;
import com.majorProject.HonestExam.Service.UserTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
@CrossOrigin(origins="http://localhost:3000/")
@RestController
public class UserTestController {

    @Autowired
    private UserTestService userTestService;

    @GetMapping("user/giveTest/{userId}/{testId}")
    public int giveTest(@PathVariable long userId, @PathVariable long testId)
    {
        return userTestService.giveTest(userId,testId);

    }

    @GetMapping("result/{userId}/{testId}")
    public int result(@PathVariable long userId, @PathVariable long testId){
        return userTestService.result(userId,testId);

    }




    @GetMapping("test/report/{testId}")
    public List<HashMap> report(@PathVariable long testId){
        return userTestService.report(testId);

    }


}
