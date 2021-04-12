package spotper.api.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "Composer")
public class Composer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "composer_name", nullable = false)
    private String composerName;
    @Column(name = "birth_date", nullable = true)
    private Date birthDate;
    @Column(name = "death_date", nullable = true)
    private Date deathDate;
    @Column(name = "city", nullable = true)
    private String city;
    @Column(name = "country", nullable = true)
    private String country;
    @OneToMany(mappedBy = "composer")
    Set<ComposerPeriod> composerPeriods;
    @OneToMany(mappedBy = "composer")
    Set<ComposerTrack> composerTracks;

    public Composer(){

    }

    public Composer(String composerName, Date birthDate, Date deathDate, String city, String country) {
        this.composerName = composerName;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.city = city;
        this.country = country;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getComposerName() {
        return composerName;
    }

    public void setComposerName(String composerName) {
        this.composerName = composerName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Date getDeathDate() {
        return deathDate;
    }

    public void setDeathDate(Date deathDate) {
        this.deathDate = deathDate;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}