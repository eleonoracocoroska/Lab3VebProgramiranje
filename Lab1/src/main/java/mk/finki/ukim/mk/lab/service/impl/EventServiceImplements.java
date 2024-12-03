package mk.finki.ukim.mk.lab.service.impl;

import lombok.AllArgsConstructor;
import mk.finki.ukim.mk.lab.model.Event;
import mk.finki.ukim.mk.lab.model.Location;
import mk.finki.ukim.mk.lab.repository.EventRepository;
import mk.finki.ukim.mk.lab.repository.LocationRepository;
import mk.finki.ukim.mk.lab.service.EventService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EventServiceImplements implements EventService {

    private final EventRepository eventRepository;
 private final LocationRepository locationRepository;
    @Override
    public List<Event> listAll() {
        return eventRepository.findAll();
    }


    @Override
    public List<Event> searchEventsByText(String text) {

        return null;
        //return eventRepository.searchEventsByText(text);
    }

    @Override
    public List<Event> searchEventsByRating(Double rating) {
        return null;
        //return eventRepository.searchEventsByRating(rating);
    }

    @Override
    public List<Event> searchEventsByTextAndRating(String text, Double rating) {
        return null;
        //return eventRepository.searchEventsByTextAndRating(text, rating);
    }
    /*@Override
    public List<Event> searchEventsByCategory(String cat) {
        return null;
       // return eventRepository.searchEventsByCategory(cat);

    }
*/
    @Override
    public void saveEvent(String name, String description, double popularityScore, Long locationId) {
     Location location=locationRepository.findById(locationId).get();
     Event event=new Event(name,description,popularityScore,location);
     eventRepository.save(event);
    }

    @Override
    public void editEvent(Long eventId, String name, String description, double popularityScore, Long locationId) {
   Event event=eventRepository.findById(eventId).get();
        Location location=locationRepository.findById(locationId).get();
        event.setName(name);
        event.setDescription(description);
        event.setPopularityScore(popularityScore);
        event.setLocation(location);
        eventRepository.save(event);
    }

    @Override
    public void deleteEvent(Long eventId) {
eventRepository.deleteById(eventId);
    }

    @Override
    public Event findEventById(Long eventId) {

        return eventRepository.findById(eventId).get();
    }

/*
    @Override
    public void saveReview(Long eventId, String comment, Integer grade) {
        Event event=eventRepository.findById(eventId).get();

        event.getReview().setComment(comment);
        event.getReview().setGrade(grade);
    }
*/
@Override
    public List<Event>findAllByLocationId(Long locationId)
{
    return eventRepository.findAllByLocationId(locationId);
}
}

