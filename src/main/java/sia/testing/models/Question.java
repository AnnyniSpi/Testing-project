package sia.testing.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.*;

@Data
@Entity
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String bodyQuestion;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "question", orphanRemoval = true)
    Set<Answer> answers = new HashSet<>();

    public void addAnswer(Answer answer){
        this.answers.add(answer);
        answer.setQuestion(this);
    }

    public void removeAnswer(Answer answer){
        answer.setQuestion(null);
        this.answers.remove(answer);
    }

    public void removeAnswers(){
        Iterator<Answer> iterator = this.answers.iterator();

        while (iterator.hasNext()){
            Answer answer = iterator.next();

            answer.setQuestion(null);
            iterator.remove();
        }


    }
}
