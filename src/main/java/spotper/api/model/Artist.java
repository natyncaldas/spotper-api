package spotper.api.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Artist")
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "artist_name", nullable = false)
    private String artistName;
    @Column(name = "artist_type")
    private String artistType;

    @OneToMany(mappedBy = "artist")
    Set<TrackArtist> trackArtists;

    public Artist() {
    }

    public Artist(String artistName, String artistType) {
        this.artistName = artistName;
        this.artistType = artistType;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getArtistType() {
        return artistType;
    }

    public void setArtistType(String artistType) {
        this.artistType = artistType;
    }
}
