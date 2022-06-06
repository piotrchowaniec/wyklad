package info.fingo.data.entity;


import javax.persistence.*;
import java.util.List;

@Entity
public class Film {

    @Id
    @GeneratedValue
    private long filmId;
    private String title;
    private String description;
    private String releaseYear;

    @ManyToOne
    @JoinColumn(name = "language_id", referencedColumnName = "languageId")
    private Language language;
    private long rentalDuration;
    private String rentalRate;
    private long length;
    private String replacementCost;
    private String rating;
    private java.sql.Timestamp lastUpdate;
    private String specialFeatures;
    private String fulltext;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "film_actor",
            joinColumns = @JoinColumn(name = "actor_id"),
            inverseJoinColumns = @JoinColumn(name = "film_id"))
    private List<Actor> actors;


    public long getFilmId() {
        return filmId;
    }

    public void setFilmId(long filmId) {
        this.filmId = filmId;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public String getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(String releaseYear) {
        this.releaseYear = releaseYear;
    }


    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public long getRentalDuration() {
        return rentalDuration;
    }

    public void setRentalDuration(long rentalDuration) {
        this.rentalDuration = rentalDuration;
    }


    public String getRentalRate() {
        return rentalRate;
    }

    public void setRentalRate(String rentalRate) {
        this.rentalRate = rentalRate;
    }


    public long getLength() {
        return length;
    }

    public void setLength(long length) {
        this.length = length;
    }


    public String getReplacementCost() {
        return replacementCost;
    }

    public void setReplacementCost(String replacementCost) {
        this.replacementCost = replacementCost;
    }


    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }


    public java.sql.Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(java.sql.Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }


    public String getSpecialFeatures() {
        return specialFeatures;
    }

    public void setSpecialFeatures(String specialFeatures) {
        this.specialFeatures = specialFeatures;
    }


    public String getFulltext() {
        return fulltext;
    }

    public void setFulltext(String fulltext) {
        this.fulltext = fulltext;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }
}
