package com.majorProject.HonestExam.Model;
import lombok.Data;

import java.io.Serializable;


@Data
public class AnswerSheetKey implements Serializable {
    private long userId;
    private long testId;
    private  long questionId;


    public AnswerSheetKey(){}
    public   AnswerSheetKey(long userId,long testId,long questionId){
        this.userId=userId;
        this.testId=testId;
        this.questionId=questionId;


    }
}

