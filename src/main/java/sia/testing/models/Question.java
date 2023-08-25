package sia.testing.models;

import jakarta.persistence.*;
import lombok.*;
import java.util.*;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_id")
    private long questionId;

    @Column(name = "question_text")
    private String questionText;

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
