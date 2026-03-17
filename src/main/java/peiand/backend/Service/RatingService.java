package peiand.backend.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peiand.backend.Database.EventRepository;
import peiand.backend.Database.RatingRepository;
import peiand.backend.Pojo.Rating;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RatingService {

    private final RatingRepository ratingRepository;

    private final EventRepository eventRepository;

    public List<Rating> getRatings(long id) {
        List<Rating> ratings = ratingRepository.findAll().stream().filter(s-> s.getEvent().getEventId()==id).toList();
        return ratings;
    }

    public Rating postNewRating(Rating rating, long eventId) {
        Rating help = rating;
        help.setEvent(eventRepository.findById(eventId).get());
        Rating r = ratingRepository.save(help);
        return r;
    }
}
