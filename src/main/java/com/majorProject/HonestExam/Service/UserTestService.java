package com.majorProject.HonestExam.Service;

import com.majorProject.HonestExam.Model.*;
import com.majorProject.HonestExam.Repository.AnswerSheetRepo;
import com.majorProject.HonestExam.Repository.TestRepo;
import com.majorProject.HonestExam.Repository.UserRepo;
import com.majorProject.HonestExam.Repository.UserTestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

@Service
public class UserTestService {

    @Autowired
    private AnswerSheetRepo answerSheetRepo;

    @Autowired
    private UserTestRepo userTestRepo;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private TestRepo testRepo;
    @Autowired
    private AnswerSheetService answerSheetService;

    public int giveTest(long userId, long testId) {

        UserTest userTest= new UserTest();

        User user= userRepo.findById(userId).orElse(null);
//        userTest.setUser(user);
        userTest.setUserId(userId);
//        user.getUserTestId().add(userTest);

        Test test=testRepo.findById(testId).orElse(null);
//        userTest.setTest(test);
        userTest.setTestId(testId);
//        test.getUserTestId().add(userTest);

        UserTest cuserTest=userTestRepo.findById(new MyKey(userId,testId)).orElse(null);
        if(cuserTest!=null)return 1;
        userTestRepo.save(userTest);
        answerSheetService.aSGenerated(userId,testId);
return 0;


    }

    public int result(long userId, long testId) {
        Test test=testRepo.findById(testId).orElse(null);
        List<Question> questionList=test.getAllQuestions();
        int marks=0;
        for(int i=0;i<questionList.size();i++){
            AnswerSheet answerSheet=answerSheetRepo.findById(new AnswerSheetKey(userId,testId,questionList.get(i).getId())).orElse(null);
            if(questionList.get(i).getAnswer().equals(answerSheet.getUserOption()))
                marks++;
        }
        UserTest userTest=userTestRepo.findById(new MyKey(userId,testId)).orElse(null);
        userTest.setMarks(marks);
        userTestRepo.save(userTest);
        return marks;
    }

    public List<HashMap> report(long testId) {

        List<UserTest> userTests=userTestRepo.findByTestId(testId);
       List<HashMap> toSend=new LinkedList<>();
        for(int i=0;i<userTests.size();i++)
        {
            HashMap<String,String> Report = new LinkedHashMap<>();
            Report.put("Name",userTests.get(i).getUser().getFirstName()+" "+userTests.get(i).getUser().getLastName());
            Report.put("Email",userTests.get(i).getUser().getEmail());

//            Test test=testRepo.findById(testId).orElse(null);
//
//
//            UserTest userTest=userTestRepo.findById(new MyKey(userId,testId)).orElse(null);
//
            List<Question> questionList=userTests.get(i).getTest().getAllQuestions();
            int marks=0;
            for(int j=0;j<questionList.size();j++){
                AnswerSheet answerSheet=answerSheetRepo.findById(new AnswerSheetKey(userTests.get(i).getUserId(),testId,questionList.get(j).getId())).orElse(null);
                if(questionList.get(j).getAnswer().equals(answerSheet.getUserOption()))
                    marks++;
            }
            userTests.get(i).setMarks(marks);
           userTestRepo.save(userTests.get(i));



            Report.put("Marks",""+userTests.get(i).getMarks());
            toSend.add(Report);

        }return toSend;
    }
}
