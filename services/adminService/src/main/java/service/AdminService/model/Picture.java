package service.AdminService.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Picture {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String picture;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Ad ad;

    @Column
    private boolean isDeleted;

    public Picture() {
    }
}
