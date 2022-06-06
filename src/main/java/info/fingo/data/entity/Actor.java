package info.fingo.data.entity;

import org.springframework.data.annotation.PersistenceConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Actor {

    @Id
    @GeneratedValue
    private final Long actorId;

    @Column(name = "first_name")
    private final String firstName;

    @Column
    private final String lastName;

    @Column
    private final LocalDateTime lastUpdate;


    protected Actor() {
        this(null, null, null, null);
    }

    @PersistenceConstructor
    public Actor(Long actorId, String firstName, String lastName, LocalDateTime lastUpdate) {
        this.actorId = actorId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.lastUpdate = lastUpdate;
    }

    public long getActorId() {
        return actorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

}
