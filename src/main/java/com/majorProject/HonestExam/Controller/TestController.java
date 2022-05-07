package com.majorProject.HonestExam.Controller;

import com.majorProject.HonestExam.Model.Question;
import com.majorProject.HonestExam.Model.Test;
import com.majorProject.HonestExam.Service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;


@CrossOrigin(origins="http://localhost:3000")
@RestController
public class TestController {
    @Autowired
    TestService testService;

    @PostMapping("test")
    public long createTest(@RequestBody Test test)
    {
        return testService.createTest(test);
    }

    @GetMapping("test/info/{testId}")
    public HashMap testInfo(@PathVariable long testId){
        return testService.testInfo(testId);

    }

    @GetMapping("getQuestions/{testId}")
    public List<Question> getQuestions(@PathVariable long testId){
        return testService.sendQuestions(testId);

    }





}
