package spotper.api.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "LabelPhone")
public class LabelPhone {
    @EmbeddedId
    private LabelPhonetId id;

    @Column(name = "phone_type", nullable = true)
    private String phoneType;

    @MapsId("labelId")
    @ManyToOne()
    @JoinColumn(name="label_id", referencedColumnName = "id", updatable = false, nullable = false)
    private Label label;

    public LabelPhone() {

    }

    public LabelPhone(LabelPhonetId id, String phoneType, Label label) {
        this.id = id;
        this.phoneType = phoneType;
        this.label = label;
    }

    public LabelPhonetId getId() {
        return id;
    }

    public void setId(LabelPhonetId id) {
        this.id = id;
    }

    public long getPhoneNumber() {
        return id.getPhoneNumber();
    }

    public void setPhoneNumber(long phoneNumber) {
        this.id.setPhoneNumber(phoneNumber);
    }

    public long getLabelId() {
        return id.getLabelId();
    }

    public void setLabelId(long labelId) {
        this.id.setLabelId(labelId);
    }

    public String getPhoneType() {
        return phoneType;
    }

    public void setPhoneType(String phoneType) {
        this.phoneType = phoneType;
    }

    public Label getLabel() {
        return label;
    }

    public void setLabel(Label label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return "LabelPhone [id=" + id.getPhoneNumber() + ", phoneType=" + phoneType + ", label_id=" + label.getId()
                + "]";
    }
}
@Embeddable
class LabelPhonetId implements Serializable{
    @Column(name = "phone_number")
    private long phoneNumber;

    private long labelId;

    public LabelPhonetId(){

    }

    public LabelPhonetId(long phoneNumber, long labelId) {
        this.phoneNumber = phoneNumber;
        this.labelId = labelId;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public long getLabelId() {
        return labelId;
    }

    public void setLabelId(long labelId) {
        this.labelId = labelId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LabelPhonetId that = (LabelPhonetId) o;
        return phoneNumber == that.phoneNumber &&
                labelId == that.labelId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(phoneNumber, labelId);
    }
}