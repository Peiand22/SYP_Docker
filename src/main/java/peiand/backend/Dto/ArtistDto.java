package peiand.backend.Dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import peiand.backend.Pojo.Event;

import java.util.List;
@Data
@AllArgsConstructor
public class ArtistDto {
    private String firstName;
    private String lastName;
    private String description;
    private String imageUrl;



}
