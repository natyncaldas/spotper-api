package spotper.api.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "Track_Playlist")
public class TrackPlaylist{
    @EmbeddedId
    private TrackPlaylistId id;

    @MapsId("trackId")
    @ManyToOne
    @JoinColumn(name = "track_id", referencedColumnName = "id", updatable = false, nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Track track;

    @MapsId("playlistId")
    @ManyToOne
    @JoinColumn(name = "playlist_id", referencedColumnName = "id", updatable = false, nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Playlist playlist;

    public TrackPlaylist(){

    }

    public TrackPlaylist(TrackPlaylistId id, Track track, Playlist playlist) {
        this.id = id;
        this.track = track;
        this.playlist = playlist;
    }

    public TrackPlaylistId getId() {
        return id;
    }

    public void setId(TrackPlaylistId id) {
        this.id = id;
    }

    public Track getTrack() {
        return track;
    }

    public void setTrack(Track track) {
        this.track = track;
    }

    public Playlist getPlaylist() {
        return playlist;
    }

    public void setPlaylist(Playlist playlist) {
        this.playlist = playlist;
    }
}

@Embeddable
class TrackPlaylistId implements Serializable {
    private long trackId;
    private long playlistId;

    TrackPlaylistId(){

    }

    public TrackPlaylistId(long trackId, long playlistId) {
        this.trackId = trackId;
        this.playlistId = playlistId;
    }

    public long getTrackId() {
        return trackId;
    }

    public void setTrackId(long trackId) {
        this.trackId = trackId;
    }

    public long getPlaylistId() {
        return playlistId;
    }

    public void setPlaylistId(long playlistId) {
        this.playlistId = playlistId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TrackPlaylistId that = (TrackPlaylistId) o;
        return trackId == that.trackId &&
                playlistId == that.playlistId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(trackId, playlistId);
    }
}
