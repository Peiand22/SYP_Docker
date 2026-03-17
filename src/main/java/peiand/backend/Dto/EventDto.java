package peiand.backend.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import peiand.backend.Pojo.Rating;

import java.time.LocalDate;
import java.util.List;
@Data
@AllArgsConstructor
public class EventDto {
    private String title;
    private String location;
    private LocalDate eventDate;
    private String imageUrl;
    private List<RatingDto> ratings;
    private List<String> artists;
}
