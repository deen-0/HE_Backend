package com.majorProject.HonestExam.Model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
@IdClass(MyKey.class)
@Entity
@Data
public class UserTest {

//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private long userTestId;userID+testID

    @Id
    private long userId;

    @Id
    private long testId;

    private int marks=Integer.MIN_VALUE;

    @ManyToOne
    @JoinColumn(name = "userId",referencedColumnName = "id",insertable = false,updatable = false)

    @JsonBackReference
    private User user;

    @ManyToOne
    @JoinColumn(name = "testId",referencedColumnName = "id",insertable = false,updatable = false)
    @JsonBackReference
    private Test test;

    //adding Questions


}
