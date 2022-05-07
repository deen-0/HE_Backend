package com.majorProject.HonestExam.Controller;


import com.majorProject.HonestExam.Service.AnswerSheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins="http://localhost:3000")
@RestController
public class AnswerSheetController {
   @Autowired

    private AnswerSheetService answerSheetService;
    @GetMapping("/UpdateAns/{userId}/{testId}/{questionId}/{userOption}")
    public String updateAns(@PathVariable long userId,@PathVariable long testId,@PathVariable long questionId,@PathVariable String userOption){
        answerSheetService.updateAns(userId,testId,questionId,userOption);


return "answer Updated";
    }
}
