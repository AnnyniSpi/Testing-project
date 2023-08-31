package sia.testing.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import sia.testing.models.Question;

public interface QuestionRepository extends JpaRepository<Question, Long> {

    Question findByQuestionText(String questionText);
}
