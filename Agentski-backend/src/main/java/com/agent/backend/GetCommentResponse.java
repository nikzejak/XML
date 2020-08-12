package com.agent.backend;

import com.agent.backend.model.Ad;
import com.agent.backend.model.Comment;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = "", propOrder = {
        "comment"
})
@XmlRootElement(name = "getCommentResponse", namespace = "http://ftn.uns.ac.rs.tim13")

public class GetCommentResponse {

    @XmlElement(namespace = "http://ftn.uns.ac.rs.tim13")
    protected Comment comment;

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }
}
