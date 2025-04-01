package fi.haagahelia.courseproject.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Album title is mandatory")
    private String title;

    @NotNull
    @Min(value=1, message = "Please enter a valid year")
    private int releaseYear;

    @DecimalMin(value="0.0", message = "Rating should not be less than 0")
    @DecimalMax(value="5.0", message = "Rating should not be greater than 5")
    private double rating;

    @ManyToOne
    @JoinColumn(name = "artistId")
    private Artist artist;

    public Album() {}

    public Album(String title, Artist artist, int releaseYear, double rating) {
        super();
        this.title = title;
        this.artist = artist;
        this.releaseYear = releaseYear;
        this.rating = rating;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Album [id=" + id + ", title=" + title + ", artist=" + artist + ", releaseYear=" + releaseYear
                + ", rating=" + rating + "]";
    }
    
}


