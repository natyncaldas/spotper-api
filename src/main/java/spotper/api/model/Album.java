package spotper.api.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Album")
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "album_description")
    private String albumDescription;
    @ManyToOne(cascade = CascadeType.MERGE, optional = true)
    @JoinColumn(name = "label_id", referencedColumnName = "id", updatable = false, nullable = false)
    private Label label;
    @Column(name = "purchase_price")
    private Float purchasePrice;
    @Column(name = "purchase_date")
    private Date purchaseDate;
    @Column(name = "purchase_type")
    private String purchaseType;
    @Column(name = "recording_date")
    private Date recordingDate;
    @Column(name = "album_name", nullable = false)
    private String albumName;
    @Column(name = "album_cover")
    private String albumCover;

    @OneToMany(targetEntity=Track.class, mappedBy="album", fetch = FetchType.LAZY, cascade=CascadeType.MERGE)
    private List<Track> tracks = new ArrayList<>();

    public Album() {

    }

    public Album(String albumDescription, Label label, Float purchasePrice, Date purchaseDate, String purchaseType, Date recordingDate, String albumName, String albumCover) {
        this.albumDescription = albumDescription;
        this.label = label;
        this.purchasePrice = purchasePrice;
        this.purchaseDate = purchaseDate;
        this.purchaseType = purchaseType;
        this.recordingDate = recordingDate;
        this.albumName = albumName;
        this.albumCover = albumCover;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAlbumDescription() {
        return albumDescription;
    }

    public void setAlbumDescription(String albumDescription) {
        this.albumDescription = albumDescription;
    }

    public Label getLabel() {
        return label;
    }

    public void setLabel(Label label) {
        this.label = label;
    }

    public Float getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(Float purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public String getPurchaseType() {
        return purchaseType;
    }

    public void setPurchaseType(String purchaseType) {
        this.purchaseType = purchaseType;
    }

    public Date getRecordingDate() {
        return recordingDate;
    }

    public void setRecordingDate(Date recordingDate) {
        this.recordingDate = recordingDate;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getAlbumCover() {
        return albumCover;
    }

    public void setAlbumCover(String albumCover) {
        this.albumCover = albumCover;
    }
}