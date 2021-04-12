package spotper.api.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Musical_Period")
public class MusicalPeriod {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "period_description", nullable = false)
    private String periodDescription;
    @Column(name = "duration", nullable = true)
    private String duration;
    @OneToMany(mappedBy = "musicalPeriod")
    Set<ComposerPeriod> composerPeriods;

    public MusicalPeriod() {

    }

    public MusicalPeriod(String periodDescription, String duration) {
        this.periodDescription = periodDescription;
        this.duration = duration;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPeriodDescription() {
        return periodDescription;
    }

    public void setPeriodDescription(String periodDescription) {
        this.periodDescription = periodDescription;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
}