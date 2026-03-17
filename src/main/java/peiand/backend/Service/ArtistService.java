package peiand.backend.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peiand.backend.Database.ArtistRepository;
import peiand.backend.Pojo.Artist;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ArtistService {

    private final ArtistRepository artistRepository;

    public List<Artist> getArtistByFullName(List<String> full_names) {

        List<Artist> found = new ArrayList<Artist>();
        List<Artist> all = artistRepository.findAll();

        full_names.forEach(full_name -> {
            Artist founded = all.stream().filter(s -> s.getFullName().equals(full_name)).findFirst().orElse(null);
            if (founded != null) {
                found.add(founded);
            }
        });

        return found;
    }

}
