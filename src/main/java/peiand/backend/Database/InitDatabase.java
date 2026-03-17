package peiand.backend.Database;

import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import peiand.backend.Pojo.Artist;
import peiand.backend.Pojo.Event;
import peiand.backend.Service.ArtistService;
import tools.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Component
@RequiredArgsConstructor
public class InitDatabase {

    private final EventRepository eventRepository;
    private final ArtistRepository artistRepository;
    private final ArtistService artistService;
    @PostConstruct
    public void init(){

        InputStream inputStreamat = this.getClass().getResourceAsStream("/artist.json");
        InputStream inputStreamev = this.getClass().getResourceAsStream("/events.json");


        com.fasterxml.jackson.databind.ObjectMapper objectMapper = new com.fasterxml.jackson.databind.ObjectMapper().registerModule(new JavaTimeModule());


        try {
            List<Artist> ar = objectMapper.readerForListOf(Artist.class).readValue(inputStreamat);
            artistRepository.saveAll(ar);



            List<Event> ev = objectMapper.readerForListOf(Event.class).readValue(inputStreamev);

            /*
            ev.forEach(event -> {
                List<Artist> artists = artistRepository.findAllById(
                        artistRepository.findAll()
                                .stream()
                                .map(Artist::getArtistId)
                                .toList()
                );
                event.setFullartists(artists);
            });



             */

           ev.forEach(event -> {
                List<Artist> artists = artistService.getArtistByFullName(event.getArtists());
                event.setFullartists(artists);
            });
            eventRepository.saveAll(ev);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
