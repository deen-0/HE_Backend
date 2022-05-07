package com.majorProject.HonestExam.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String email;
    private String password;
//    @ManyToMany
//    @JoinTable(
//            name = "user_test",
//            joinColumns = @JoinColumn(name = "user_id"),
//            inverseJoinColumns = @JoinColumn(name = "test_id"))
//    @JsonIgnore
//    List<Test> testGiven;
    //List<Test> testCreated;
    @OneToMany(mappedBy = "userId",cascade = CascadeType.ALL,fetch=FetchType.LAZY)
    @JsonIgnore

    private List<UserTest> userTestId;



}
