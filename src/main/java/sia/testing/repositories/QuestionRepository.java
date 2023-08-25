package sia.testing.repositories;


import org.springframework.data.repository.CrudRepository;
import sia.testing.models.Question;

public interface QuestionRepository extends CrudRepository<Question, Long> {
}
