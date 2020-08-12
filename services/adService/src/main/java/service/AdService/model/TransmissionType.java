package service.AdService.model;

import javax.persistence.*;

@Entity
public class TransmissionType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String serial_number;

    @Column
    private String type;

    public TransmissionType(Long id, String serial_number, String type) {
        this.id = id;
        this.serial_number = serial_number;
        this.type = type;
    }

    public TransmissionType() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSerial_number() {
        return serial_number;
    }

    public void setSerial_number(String serial_number) {
        this.serial_number = serial_number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "TransmissionType{" +
                "id=" + id +
                ", serial_number='" + serial_number + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
