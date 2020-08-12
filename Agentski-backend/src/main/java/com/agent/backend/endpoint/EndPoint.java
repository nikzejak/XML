package com.agent.backend.endpoint;

import com.agent.backend.*;
import com.agent.backend.model.Comment;
import com.agent.backend.repository.AdRepo;
import com.agent.backend.repository.CarBrandRepo;
import com.agent.backend.repository.CommentRepo;
import com.agent.backend.repository.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class EndPoint {

    private static final String NAMESPACE_URI = "http://ftn.uns.ac.rs.tim13";

//    @Autowired
//    AdService adService;
//
//    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAdRequest")
//    @ResponsePayload
//    public JAXBElement<String> saveAd(@RequestPayload GetAdRequest request){
//        GetAdResponse response = new GetAdResponse();
//        response.setName("Saved");
//        QName qName = new QName("getAdRequest");
//        adService.saveSoapAd(request);
//
//        JAXBElement jaxbElement = new JAXBElement<GetAdResponse>(qName, GetAdResponse.class, response);
//        return jaxbElement;
//    }

    @Autowired
    private AdRepo adRepo;

    @Autowired
    private CommentRepo commentRepo;

    @Autowired
    private CarBrandRepo carBrandRepo;

    @Autowired
    private MessageRepo messageRepo;

    @Autowired
    public EndPoint(AdRepo adRepo, CommentRepo commentRepo, CarBrandRepo carBrandRepo, MessageRepo messageRepo) {
        this.adRepo = adRepo;
        this.commentRepo = commentRepo;
        this.carBrandRepo = carBrandRepo;
        this.commentRepo = commentRepo;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAdRequest")
    @ResponsePayload
    public GetAdResponse getAd(@RequestPayload GetAdRequest request){
        GetAdResponse response = new GetAdResponse();
        response.setAd(adRepo.findAdById(request.getId()));

        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCommentRequest")
    @ResponsePayload
    public GetCommentResponse getComment(@RequestPayload GetCommentRequest request){
        GetCommentResponse response = new GetCommentResponse();
        response.setComment(commentRepo.findCommentById(request.getId()));

        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCarBrandRequest")
    @ResponsePayload
    public GetCarBrandResponse getCarBrand(@RequestPayload GetCarBrandRequest request){
        GetCarBrandResponse response = new GetCarBrandResponse();
        response.setBrand(carBrandRepo.findCarBrandById(request.getId()));

        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getMessageRequest")
    @ResponsePayload
    public GetMessageResponse getMessage(@RequestPayload GetMessageRequest request){
        GetMessageResponse response = new GetMessageResponse();
        response.setMessage(messageRepo.findMessageById(request.getId()));

        return response;
    }

}
