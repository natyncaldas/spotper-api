package spotper.api.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "Track")
public class Track {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "track_name", nullable = false)
    private String trackName;

    @Column(name = "track_duration", nullable = false)
    private float trackDuration;

    @Column(name = "track_description")
    private String trackDescription;

    @Column(name = "recording_type", nullable = false)
    private String recordingType;

    @Column(name = "track_number")
    private int trackNumber;

    @Column(name = "play_count", columnDefinition = "int default 0")
    private int playCount;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_played")
    private Date lastPlayed;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "album_id", referencedColumnName = "id", updatable = false, nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Album album;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "composition_id", referencedColumnName = "id", updatable = false, nullable = false)
    private Composition composition;

    @OneToMany(mappedBy = "track")
    Set<ComposerTrack> composerTracks;

    @OneToMany(mappedBy = "track")
    Set<TrackArtist> trackArtists;

    @OneToMany(mappedBy = "track")
    Set<TrackPlaylist> trackPlaylists;

    public Track() {
    }

    public Track(String trackName, float trackDuration, String trackDescription, String recordingType, int trackNumber, int playCount, Date lastPlayed, Album album, Composition composition) {
        this.trackName = trackName;
        this.trackDuration = trackDuration;
        this.trackDescription = trackDescription;
        this.recordingType = recordingType;
        this.trackNumber = trackNumber;
        this.playCount = playCount;
        this.lastPlayed = lastPlayed;
        this.album = album;
        this.composition = composition;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public float getTrackDuration() {
        return trackDuration;
    }

    public void setTrackDuration(float trackDuration) {
        this.trackDuration = trackDuration;
    }

    public String getTrackDescription() {
        return trackDescription;
    }

    public void setTrackDescription(String trackDescription) {
        this.trackDescription = trackDescription;
    }

    public String getRecordingType() {
        return recordingType;
    }

    public void setRecordingType(String recordingType) {
        this.recordingType = recordingType;
    }

    public int getTrackNumber() {
        return trackNumber;
    }

    public void setTrackNumber(int trackNumber) {
        this.trackNumber = trackNumber;
    }

    public int getPlayCount() {
        return playCount;
    }

    public void setPlayCount(int playCount) {
        this.playCount = playCount;
    }

    public Date getLastPlayed() {
        return lastPlayed;
    }

    public void setLastPlayed(Date lastPlayed) {
        this.lastPlayed = lastPlayed;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public Composition getComposition() {
        return composition;
    }

    public void setComposition(Composition composition) {
        this.composition = composition;
    }
}
