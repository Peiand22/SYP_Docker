package peiand.backend.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import peiand.backend.Database.ArtistRepository;
import peiand.backend.Database.EventRepository;
import peiand.backend.Database.RatingRepository;
import peiand.backend.Dto.ArtistDto;
import peiand.backend.Dto.EventDto;
import peiand.backend.Dto.RatingDto;
import peiand.backend.Pojo.Artist;
import peiand.backend.Pojo.Event;
import peiand.backend.Pojo.Rating;
import peiand.backend.Service.EventService;
import peiand.backend.Service.RatingService;

import org.springframework.data.domain.Pageable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class Public {

    private final ArtistRepository artistRepository;
    private final EventRepository eventRepository;
    private final EventService eventService;
    private final RatingRepository ratingRepository;
    private final RatingService ratingService;


    @GetMapping("/artists")
    public ResponseEntity<List<ArtistDto>> getArtists() {
        return ResponseEntity.ok(artistRepository.findAll().stream().map(s-> s.toDto()).toList());
    }


    @GetMapping("/events")
    public ResponseEntity<List<EventDto>> getEvents(Pageable pageable) {

        return ResponseEntity.ok(eventRepository.findAll(pageable).stream().map(s-> s.toDto()).toList());
    }

    @GetMapping("/artists/{id}")
    public ResponseEntity<ArtistDto> getArtistsByName(@PathVariable Long id) {
        return ResponseEntity.ok(artistRepository.getReferenceById(id).toDto());
    }

    @GetMapping("/events/{id}")
    public ResponseEntity<EventDto> getEventByName(@PathVariable Long id) {
        return ResponseEntity.ok(eventRepository.getReferenceById(id).toDto());
    }

    @GetMapping("/ratings/event/{eventId}")
    public ResponseEntity<List<RatingDto>> getRatingEventId(@PathVariable Long eventId) {
        return ResponseEntity.ok(ratingService.getRatings(eventId).stream().map(s->s.toDto()).toList());
    }

    @GetMapping("/events/artist/{artistId}")
    public List<EventDto> getEventsByArtist(@PathVariable long artistId) {
        return eventRepository.findByFullartistsArtistId(artistId).stream().map(s->s.toDto()).toList();
    }

    @PostMapping("/ratings/{eventId}")
    public ResponseEntity<RatingDto> postRating(@PathVariable Long eventId, @RequestBody Rating rating) {
        return ResponseEntity.ok(ratingService.postNewRating(rating, eventId).toDto());
    }







}
