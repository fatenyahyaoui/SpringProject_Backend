package com.marketplace.tn.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponentsBuilder;

import com.marketplace.tn.model.Message;
import com.marketplace.tn.service.IMessageService;

@Controller
	
@CrossOrigin(origins = {"http://localhost:4200"})
public class MessageController {
	@Autowired
	private IMessageService messageService;
	@GetMapping("message")
	public ResponseEntity<Message> getMessageById(@RequestParam("id") String id) {
		Message message = messageService.getMessageById(Integer.parseInt(id));
		return new ResponseEntity<Message>(message, HttpStatus.OK);
	}
	@GetMapping("all-messages")
	public ResponseEntity<List<Message>> getAllMessages() {
		List<Message> list = messageService.getAllMessages();
		return new ResponseEntity<List<Message>>(list, HttpStatus.OK);
	}
	@PostMapping("message")
	public ResponseEntity<Void> createMessage(@RequestBody Message message, UriComponentsBuilder builder) {
	    
	    boolean flag = messageService.createMessage(message);
        if (flag == false) {
        	return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/message?id={id}").buildAndExpand(message.getMessageId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	
	}
	
	@DeleteMapping("message")
	public ResponseEntity<Void> deleteMessage(@RequestParam("id") String id) {
		messageService.deleteMessage(Integer.parseInt(id));
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}	
	
}