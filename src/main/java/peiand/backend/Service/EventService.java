package peiand.backend.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peiand.backend.Database.EventRepository;
import peiand.backend.Pojo.Event;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventService {

    private final EventRepository eventRepository;

}
