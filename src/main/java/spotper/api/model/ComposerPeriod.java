package spotper.api.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "Composer_Period")
public class ComposerPeriod{
    @EmbeddedId
    private ComposerPeriodId id;

    @MapsId("composerId")
    @ManyToOne
    @JoinColumn(name = "composer_id", referencedColumnName = "id", updatable = false, nullable = false)
    private Composer composer;

    @MapsId("periodId")
    @ManyToOne
    @JoinColumn(name = "period_id", referencedColumnName = "id", updatable = false, nullable = false)
    private MusicalPeriod musicalPeriod;

    public ComposerPeriod(){

    }

    public ComposerPeriod(ComposerPeriodId id, Composer composer, MusicalPeriod musicalPeriod) {
        this.id = id;
        this.composer = composer;
        this.musicalPeriod = musicalPeriod;
    }

    public ComposerPeriodId getId() {
        return id;
    }

    public void setId(ComposerPeriodId id) {
        this.id = id;
    }

    public Composer getComposer() {
        return composer;
    }

    public void setComposer(Composer composer) {
        this.composer = composer;
    }

    public MusicalPeriod getMusicalPeriod() {
        return musicalPeriod;
    }

    public void setMusicalPeriod(MusicalPeriod musicalPeriod) {
        this.musicalPeriod = musicalPeriod;
    }
}

@Embeddable
class ComposerPeriodId implements Serializable {
    private long composerId;
    private long periodId;

    ComposerPeriodId(){

    }

    public ComposerPeriodId(long composerId, long periodId) {
        this.composerId = composerId;
        this.periodId = periodId;
    }

    public long getComposerId() {
        return composerId;
    }

    public void setComposerId(long composerId) {
        this.composerId = composerId;
    }

    public long getPeriodId() {
        return periodId;
    }

    public void setPeriodId(long periodId) {
        this.periodId = periodId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComposerPeriodId that = (ComposerPeriodId) o;
        return composerId == that.composerId &&
                periodId == that.periodId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(composerId, periodId);
    }
}
