package peiand.backend.Database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import peiand.backend.Pojo.Rating;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Long> {

}
