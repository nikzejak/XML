package service.AdminService.model;

import javax.persistence.*;

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "commenter_id", nullable = false)
    private User commenter;

    @Column
    private String comment;

    @Column
    private boolean approved = false;

    @ManyToOne
    @JoinColumn(name = "ad_id")
    private Ad ad;

    public Comment() {
    }

    public Comment(User commenter, String comment, boolean approved, Ad ad) {
        this.commenter = commenter;
        this.comment = comment;
        this.approved = approved;
        this.ad = ad;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getCommenter() {
        return commenter;
    }

    public void setCommenter(User commenter) {
        this.commenter = commenter;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }


    public Ad getAd() {
        return ad;
    }

    public void setAd(Ad ad) {
        this.ad = ad;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", commenter=" + commenter +
                ", comment='" + comment + '\'' +
                ", approved=" + approved +
                ", ad=" + ad +
                '}';
    }
}
