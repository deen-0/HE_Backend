package com.majorProject.HonestExam.Controller;

import com.majorProject.HonestExam.Model.Question;
import com.majorProject.HonestExam.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins="http://localhost:3000")
@RestController

public class QuestionController {

    @Autowired
    QuestionService questionService;

    @PostMapping("/question")
    public boolean createQuestion(@RequestBody Question question)
    {
        questionService.createQuestion(question);
        return true;
    }


}
