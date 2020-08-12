package service.rentingService.dtos;

import service.rentingService.model.Car;
import service.rentingService.model.Comment;

public class AddCommentDTO {
    private Comment comment;
    private Car car;
    private int rate;

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }
}
