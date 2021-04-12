package spotper.api.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Label")
public class Label {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "label_name", nullable = false)
    private String labelName;
    @Column(name = "address", nullable = true)
    private String address;
    @Column(name = "homepage", nullable = true)
    private String homepage;

    @OneToMany(targetEntity=LabelPhone.class, mappedBy="label", fetch = FetchType.LAZY, cascade=CascadeType.MERGE)
    private List<LabelPhone> labelPhones = new ArrayList<>();

    @OneToMany(targetEntity=Album.class, mappedBy="label", fetch = FetchType.LAZY, cascade=CascadeType.MERGE)
    private List<Album> albums = new ArrayList<>();

    public Label(){

    }

    public Label(String labelName, String address, String homepage) {
        this.labelName = labelName;
        this.address = address;
        this.homepage = homepage;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLabelName() {
        return labelName;
    }

    public void setLabelName(String labelName) {
        this.labelName = labelName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    @Override
    public String toString() {
        return "Label [id=" + id + ", labelName=" + labelName + ", address=" + address + ", homepage=" + homepage
                + "]";
    }

}