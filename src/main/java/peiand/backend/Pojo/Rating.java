package peiand.backend.Pojo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import peiand.backend.Dto.EventDto;
import peiand.backend.Dto.RatingDto;

import java.time.LocalDateTime;

@Data
@Entity  //is a database table
@AllArgsConstructor
@NoArgsConstructor
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ratingId;
    private int stars;
    private String comment;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    //2025-10-13T09:00:00
    private LocalDateTime createdAt;

    @ManyToOne
    @JsonBackReference
    private Event event;

    public RatingDto toDto (){
        RatingDto dto  = new RatingDto(this.stars,this.comment,this.createdAt);
        return dto;
    }
}
