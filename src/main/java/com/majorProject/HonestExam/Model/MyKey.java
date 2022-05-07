package com.majorProject.HonestExam.Model;
import lombok.Data;

import java.io.Serializable;


@Data
public class MyKey implements Serializable {

        private long userId;
    private long testId;
public MyKey(){}
       public   MyKey(long userId,long testId){

             this.userId=userId;
           this.testId=testId;
         }
    }

