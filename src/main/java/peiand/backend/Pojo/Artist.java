package peiand.backend.Pojo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import peiand.backend.Dto.ArtistDto;

import java.util.List;

@Data
@Entity  //is a database table
@AllArgsConstructor
@NoArgsConstructor
public class Artist {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long artistId;
    private String firstName;
    private String lastName;
    private String description;
    private String imageUrl;



    @ManyToMany(mappedBy = "fullartists")
    @JsonBackReference
    private List<Event> events;
/*
    @Transient
    private String fullname = getFirstName() + " " + getLastName();



 */
    @Transient
    public String getFullName() {
        return (firstName != null ? firstName : "") + " " + (lastName != null ? lastName : "");
    }

    public ArtistDto toDto (){
        peiand.backend.Dto.ArtistDto artistDto = new ArtistDto(this.firstName,this.lastName,this.description,this.imageUrl);
        return artistDto;
    }


}
