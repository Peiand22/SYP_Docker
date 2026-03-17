package peiand.backend.Dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import peiand.backend.Pojo.Event;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
public class RatingDto {
    private int stars;
    private String comment;
    private LocalDateTime createdAt;
}
