package info.fingo.data.api;

import info.fingo.data.ActorRepository;
import info.fingo.data.entity.Actor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("actor")
public class ActorController {

    private final ActorRepository actorRepository;

    public ActorController(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    @GetMapping
    public Iterable<Actor> getAll() {
        return actorRepository.findAll();
    }

    @PostMapping
    public Actor updateActor(@RequestParam Long id) {
        Actor update = actorRepository.findById(id)
                .map(
                        actor ->
                                new Actor(actor.getActorId(), actor.getFirstName(), actor.getLastName(), LocalDateTime.now())

                )
                .orElseThrow(() -> new RuntimeException(String.format("Actor with id: %d not found", id)));
        actorRepository.save(update);
        return update;
    }

    @PostMapping("updateMultiple")
    public List<Actor> updateActors(@RequestParam Long id) {
        Actor update = actorRepository.findById(id)
                .map(
                        actor ->
                                new Actor(actor.getActorId(), actor.getFirstName(), actor.getLastName(), LocalDateTime.now())

                )
                .orElseThrow(() -> new RuntimeException(String.format("Actor with id: %d not found", id)));
        actorRepository.save(update);

        List<Actor> result = new LinkedList<>();
        result.add(update);
        update = actorRepository.findById(id+1)
                .map(
                        actor ->
                                new Actor(actor.getActorId(), actor.getFirstName(), actor.getLastName(), LocalDateTime.now())

                )
                .orElseThrow(() -> new RuntimeException(String.format("Actor with id: %d not found", id)));
        actorRepository.save(update);
        result.add(update);
        return result;
    }
}
