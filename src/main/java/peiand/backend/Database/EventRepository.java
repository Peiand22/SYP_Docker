package peiand.backend.Database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import peiand.backend.Pojo.Artist;
import peiand.backend.Pojo.Event;

import java.awt.print.Pageable;
import java.util.Collection;
import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

    List<Event> findByFullartistsArtistId(long artistId);
    Event getReferenceById(Long aLong);

}
