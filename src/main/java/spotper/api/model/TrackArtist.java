package spotper.api.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "Track_Artist")
public class TrackArtist{
    @EmbeddedId
    private TrackArtistId id;

    @MapsId("trackId")
    @ManyToOne
    @JoinColumn(name = "track_id", referencedColumnName = "id", updatable = false, nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Track track;

    @MapsId("artistId")
    @ManyToOne
    @JoinColumn(name = "artist_id", referencedColumnName = "id", updatable = false, nullable = false)
    private Artist artist;

    public TrackArtist(){

    }

    public TrackArtist(TrackArtistId id, Track track, Artist artist) {
        this.id = id;
        this.track = track;
        this.artist = artist;
    }

    public TrackArtistId getId() {
        return id;
    }

    public void setId(TrackArtistId id) {
        this.id = id;
    }

    public Track getTrack() {
        return track;
    }

    public void setTrack(Track track) {
        this.track = track;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }
}

@Embeddable
class TrackArtistId implements Serializable {
    private long trackId;
    private long artistId;

    TrackArtistId(){

    }

    public TrackArtistId(long trackId, long artistId) {
        this.trackId = trackId;
        this.artistId = artistId;
    }

    public long getTrackId() {
        return trackId;
    }

    public void setTrackId(long trackId) {
        this.trackId = trackId;
    }

    public long getArtistId() {
        return artistId;
    }

    public void setArtistId(long artistId) {
        this.artistId = artistId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TrackArtistId that = (TrackArtistId) o;
        return trackId == that.trackId &&
                artistId == that.artistId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(trackId, artistId);
    }
}
