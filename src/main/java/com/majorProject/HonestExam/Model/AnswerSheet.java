package com.majorProject.HonestExam.Model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
@IdClass(AnswerSheetKey.class)
@Entity
@Data
public class AnswerSheet {

    @Id
    private long userId;

    @Id
    private long testId;

    @Id
    private long questionId;

    private String userOption;

 public  AnswerSheet(){}
    public AnswerSheet(long userId, long testId, long id,String userOption) {

        this.userId=userId;
        this.testId=testId;
        this.questionId=id;
        this.userOption=userOption;
    }

//    @ManyToOne
//    @JoinColumn(name = "userId",referencedColumnName = "id",insertable = false,updatable = false)
//    @JsonBackReference
//    private User user;
//
//    @ManyToOne
//    @JoinColumn(name = "testId",referencedColumnName = "id",insertable = false,updatable = false)
//    @JsonBackReference
//    private Test test;

    //adding Questions

}
