package com.majorProject.HonestExam.Service;

import com.majorProject.HonestExam.Model.Question;
import com.majorProject.HonestExam.Model.Test;
import com.majorProject.HonestExam.Repository.TestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

@Service
public class TestService {

    @Autowired
    TestRepo testRepo;

    public long createTest(Test test)
    {
       return testRepo.save(test).getId();
    }

    public List<Question> sendQuestions( long testId) {
////        User currentUser=userRepo.findById(userId).orElse(null);
        Test currentTest=testRepo.findById(testId).orElse(null);
////        currentUser.getTestGiven().add(currentTest);
//        userRepo.save(currentUser);
////        currentTest.getCandidate().add(currentUser);
//        testRepo.save(currentTest);
//
//        return currentTest.getAllQuestions();
        return currentTest.getAllQuestions();

    }

    public  HashMap testInfo(long testId) {
        Test test=testRepo.findById(testId).orElse(null);
        HashMap<String,String> tosend=new LinkedHashMap<>();
        tosend.put("title",test.getTitle());
        tosend.put("description",test.getDescription());
        tosend.put("noOfQ",""+test.getAllQuestions().size());
        return tosend;

    }
}
