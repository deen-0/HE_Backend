package com.majorProject.HonestExam.Service;

import com.majorProject.HonestExam.Model.AnswerSheet;
import com.majorProject.HonestExam.Model.AnswerSheetKey;
import com.majorProject.HonestExam.Model.Question;
import com.majorProject.HonestExam.Model.Test;
import com.majorProject.HonestExam.Repository.AnswerSheetRepo;
import com.majorProject.HonestExam.Repository.TestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerSheetService {
        @Autowired
        private AnswerSheetRepo answerSheetRepo;
        @Autowired
        private TestRepo testRepo;
    public void aSGenerated(long userId, long testId) {
        Test test= testRepo.findById(testId).orElse(null);
        List<Question> ansSheetQue=test.getAllQuestions();
        for (int i=0;i<ansSheetQue.size();i++) {

            answerSheetRepo.save(new AnswerSheet(userId,testId,ansSheetQue.get(i).getId(),null));

        }

    }

    public void updateAns(long userId, long testId, long questionId, String userOption) {

    AnswerSheet answerSheet=new AnswerSheet(userId,testId,questionId,userOption);
    answerSheetRepo.save(answerSheet);
    }
}
