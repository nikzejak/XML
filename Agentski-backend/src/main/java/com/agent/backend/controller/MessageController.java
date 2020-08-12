package com.agent.backend.controller;

import com.agent.backend.dtos.MessageDTO;
import com.agent.backend.dtos.ReplyDTO;
import com.agent.backend.model.Ad;
import com.agent.backend.model.Message;
import com.agent.backend.model.RentRequest;
import com.agent.backend.model.User;
import com.agent.backend.services.AdService;
import com.agent.backend.services.MessageService;
import com.agent.backend.services.RentRequestService;
import com.agent.backend.services.UserService;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
public class MessageController {

    @Autowired
    private MessageService messageService;

    @Autowired
    private UserService userService;

    @Autowired
    private AdService adService;

    @Autowired
    private RentRequestService rentRequestService;

    @PostMapping(value = "/message/send")
    public void sendMessage(@RequestBody MessageDTO messageDTO){
        Message mess = new Message();
        mess.setText(messageDTO.getText());
        mess.setSubject(messageDTO.getSubject());
        mess.setSender(userService.findUserByEmail(messageDTO.getEmail()));
        RentRequest r= rentRequestService.findById(messageDTO.getId().longValue());
        mess.setReceiver(userService.findUserByEmail(r.getClient().getEmail()));
        LocalDateTime time= LocalDateTime.now();
        DateTime date = DateTime.parse(time.toString());
        mess.setMessageTime(date.toDate());
        messageService.save(mess);
    }

    @PostMapping(value = "/message/reply")
    public void sendMessage(@RequestBody ReplyDTO replyDTO) {
        Message mess= new Message();
        mess.setText(replyDTO.getText());
        mess.setSubject(replyDTO.getSubject());
        mess.setSender(replyDTO.getSender());
        mess.setReceiver(replyDTO.getReceiver());
        LocalDateTime time= LocalDateTime.now();
        DateTime date = DateTime.parse(time.toString());
        mess.setMessageTime(date.toDate());
        messageService.save(mess);

    }



    @GetMapping(value = "/message/getReceivers")
    public ResponseEntity<List<User>> allClientAds(@RequestParam(value = "email", required = true) String email) {

        System.out.println("usao saaaaam");
        List<Message> messages=this.messageService.findAllBySender(this.userService.findUserByEmail(email));
        List<Message> msg = this.messageService.findAllByReceiver(this.userService.findUserByEmail(email));
        User us=this.userService.findUserByEmail(email);
        List<User> users = new ArrayList<User>();
        System.out.println(messages);
        if(messages!=null) {
            for (Message m : messages) {
                int i=0;
                if(m.getSender().equals(us)) {
                    if (users != null) {
                        for (User u : users) {
                            if (m.getReceiver().equals(u)) {
                                i = 1;
                            }
                        }
                    }
                    if (i == 0) {
                        users.add(m.getReceiver());
                    }
                }
            }
        }
        if(msg!=null){
            for(Message m:msg){
                int i=0;
                if(m.getReceiver().equals(us)){
                    if (users != null) {
                        for (User u : users) {
                            if (m.getSender().equals(u)) {
                                i = 1;
                            }
                        }
                    }
                    if (i == 0) {
                        users.add(m.getSender());
                    }
                }
            }
        }
        System.out.println(users);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping(value = "/message/getConversation")
    public ResponseEntity<List<Message>> allClientAds(@RequestParam(value = "email", required = true) String email,
                                                      @RequestParam(value = "email2", required = true) String email2) {
        User us=this.userService.findUserByEmail(email);
        User us2=this.userService.findUserByEmail(email2);
        List<Message> messages=this.messageService.findall();
        List<Message> ms = new ArrayList<>();
        if(messages!=null){
            for(Message m:messages){
                if(m.getSender().equals(us) && m.getReceiver().equals(us2)){
                    ms.add(m);
                }
                if(m.getSender().equals(us2) && m.getReceiver().equals(us)){
                    ms.add(m);
                }
            }
        }
        return new ResponseEntity<>(ms, HttpStatus.OK);
    }


    }
