package sia.testing.models;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "answer_id")
    private long answerId;

    @Column(name = "answer_text")
    private String answerText;

    @Column(name = "right_answer")
    private boolean isRightAnswer;

    @ManyToOne
    private Question question;
}
