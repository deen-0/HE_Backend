package com.majorProject.HonestExam.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
     private String title;

     @Column(length = 8000)
    private String description;
    private long creater_Id;

   //Updates: duration,


//Current : NO_of_questions,title,,description,


//    @ManyToMany(mappedBy = "testGiven")
//    @JsonIgnore
//    List<User> candidate;


    @OneToMany(mappedBy = "test_id",cascade = CascadeType.REMOVE,fetch=FetchType.LAZY)
    @JsonIgnore
    List<Question> allQuestions;

    @OneToMany(mappedBy = "testId",cascade = CascadeType.REMOVE,fetch=FetchType.LAZY)
    @JsonIgnore
    private List<UserTest> userTestId;

}
