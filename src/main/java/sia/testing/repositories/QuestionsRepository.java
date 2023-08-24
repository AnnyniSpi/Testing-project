package sia.testing.repositories;


import org.springframework.data.repository.CrudRepository;
import sia.testing.models.Question;

public interface QuestionsRepository  extends CrudRepository<Question, Long> {
}
