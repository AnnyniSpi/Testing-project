package sia.testing.repositories;

import org.springframework.data.repository.CrudRepository;
import sia.testing.models.Answer;

public interface AnswersRepository  extends CrudRepository<Answer, Long> {
}
