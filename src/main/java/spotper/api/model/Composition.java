package spotper.api.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Composition")
public class Composition {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "composition_description")
    private String compositionDescription;
    @Column(name = "composition_type")
    private String compositionType;

    @OneToMany(targetEntity=Track.class, mappedBy="composition", fetch = FetchType.LAZY, cascade=CascadeType.MERGE)
    private List<Track> tracks = new ArrayList<>();

    public Composition(){

    }

    public Composition(String compositionDescription, String compositionType) {
        this.compositionDescription = compositionDescription;
        this.compositionType = compositionType;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCompositionDescription() {
        return compositionDescription;
    }

    public void setCompositionDescription(String compositionDescription) {
        this.compositionDescription = compositionDescription;
    }

    public String getCompositionType() {
        return compositionType;
    }

    public void setCompositionType(String compositionType) {
        this.compositionType = compositionType;
    }
}