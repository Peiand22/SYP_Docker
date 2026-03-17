package peiand.backend.Database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import peiand.backend.Pojo.Artist;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Long> {
    @Override
    Artist getReferenceById(Long aLong);
}
