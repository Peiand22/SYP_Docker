package peiand.backend.Pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import peiand.backend.Dto.ArtistDto;
import peiand.backend.Dto.EventDto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity  //is a database table
@AllArgsConstructor
@NoArgsConstructor
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long eventId;

    private String title;
    private String location;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate eventDate;
    private String imageUrl;

    @OneToMany( mappedBy = "event", //
            cascade= {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JsonManagedReference

    private List<Rating> ratings;



    private List<String> artists;


    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "event_artist",
            joinColumns = @JoinColumn(name = "event_id"),
            inverseJoinColumns = @JoinColumn(name = "artist_id")
    )
    private List<Artist> fullartists;


    public EventDto toDto (){
        EventDto dto  = new EventDto(this.title,this.location,this.eventDate,this.imageUrl,this.ratings.stream().map(s-> s.toDto()).toList(),this.artists);
        return dto;
    }
}
