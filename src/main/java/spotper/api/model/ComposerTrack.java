package spotper.api.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "Composer_Track")
public class ComposerTrack{
    @EmbeddedId
    private ComposerTrackId id;

    @MapsId("composerId")
    @ManyToOne
    @JoinColumn(name = "composer_id", referencedColumnName = "id", updatable = false, nullable = false)
    private Composer composer;

    @MapsId("trackId")
    @ManyToOne
    @JoinColumn(name = "track_id", referencedColumnName = "id", updatable = false, nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Track track;

    public ComposerTrack(){

    }

    public ComposerTrack(ComposerTrackId id, Composer composer, Track track) {
        this.id = id;
        this.composer = composer;
        this.track = track;
    }

    public ComposerTrackId getId() {
        return id;
    }

    public void setId(ComposerTrackId id) {
        this.id = id;
    }

    public Composer getComposer() {
        return composer;
    }

    public void setComposer(Composer composer) {
        this.composer = composer;
    }

    public Track getTrack() {
        return track;
    }

    public void setTrack(Track track) {
        this.track = track;
    }
}

@Embeddable
class ComposerTrackId implements Serializable {
    private long composerId;
    private long trackId;

    ComposerTrackId(){

    }

    public ComposerTrackId(long composerId, long trackId) {
        this.composerId = composerId;
        this.trackId = trackId;
    }

    public long getComposerId() {
        return composerId;
    }

    public void setComposerId(long composerId) {
        this.composerId = composerId;
    }

    public long getTrackId() {
        return trackId;
    }

    public void setTrackId(long trackId) {
        this.trackId = trackId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComposerTrackId that = (ComposerTrackId) o;
        return composerId == that.composerId &&
                trackId == that.trackId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(composerId, trackId);
    }
}
