package com.majorProject.HonestExam.Service;

import com.majorProject.HonestExam.Model.Question;
import com.majorProject.HonestExam.Repository.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {
    @Autowired
    QuestionRepo questionRepo;
    public void createQuestion(Question question) {


        questionRepo.save(question);
    }
}
