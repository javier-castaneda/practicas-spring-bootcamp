package com.jfcc.link.controllers;

import com.jfcc.link.dto.CreationResponseDTO;
import com.jfcc.link.dto.ErrorDTO;
import com.jfcc.link.exceptionHandlers.NotValidIdException;
import com.jfcc.link.exceptionHandlers.NotValidLinkException;
import com.jfcc.link.exceptionHandlers.NotValidUrlException;
import com.jfcc.link.exceptionHandlers.WrongPasswordException;
import com.jfcc.link.services.LinkTrackerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class LinkTrackerController {

    @Autowired
    private LinkTrackerService linkTrackerService;


    @PostMapping("/create")
    public ResponseEntity createLink(@RequestBody String url, @RequestParam(value = "password",defaultValue = "defaultPass") String password) throws NotValidUrlException {
        int id = linkTrackerService.createLink(url, password);
        CreationResponseDTO creatRes = new CreationResponseDTO(id);
        return new ResponseEntity(creatRes, HttpStatus.CREATED);
    }

    @GetMapping("/link/{linkId}")
    public RedirectView redirect(@PathVariable int linkId, @RequestParam(value = "password", defaultValue = "defaultPass") String password) throws NotValidLinkException, NotValidIdException, WrongPasswordException {
        return linkTrackerService.redirectLink(linkId, password);
    }

    @PostMapping("/invalidate/{linkID}")
    public ResponseEntity invalidateLink(@PathVariable int linkID) throws NotValidIdException {
        if (linkTrackerService.invalidateLink(linkID))
            return new ResponseEntity("The link is now invalid", HttpStatus.OK);
        else
            return new ResponseEntity("The link already invalid", HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/metrics/{linkID}")
    public ResponseEntity statisticsLink(@PathVariable int linkID) throws NotValidIdException {
        return new ResponseEntity(linkTrackerService.metricsLink(linkID), HttpStatus.OK);
    }


    @ExceptionHandler(NotValidUrlException.class)
    public ResponseEntity<ErrorDTO> handleNotValidUrlException(NotValidUrlException notValUrl){
        ErrorDTO exception = new ErrorDTO();
        exception.setErrorName("NOT_VALID_URL");
        exception.setErrorDescription("The URL '"+ notValUrl.getMessage() + "' is malformed or has wrong syntax");
        return new ResponseEntity<>(exception, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotValidLinkException.class)
    public ResponseEntity<ErrorDTO> handleNotValidLinkException(NotValidLinkException notValLink){
        ErrorDTO exception = new ErrorDTO();
        exception.setErrorName("NOT_VALID_LINK");
        exception.setErrorDescription("The link of the Id "+ notValLink.getMessage()+" has been invalidated");
        return new ResponseEntity<>(exception, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NotValidIdException.class)
    public ResponseEntity<ErrorDTO> handleNotValidIdException(NotValidIdException notValId){
        ErrorDTO exception = new ErrorDTO();
        exception.setErrorName("NOT_VALID_ID");
        exception.setErrorDescription("The Id "+ notValId.getMessage()+" doesn't exist in DataBase");
        return new ResponseEntity<>(exception, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(WrongPasswordException.class)
    public ResponseEntity<ErrorDTO> handleWrongPasswordException(WrongPasswordException wrngPwd){
        ErrorDTO exception = new ErrorDTO();
        exception.setErrorName("WRONG_PASSWORD");
        exception.setErrorDescription("The password doesn't match to "+ wrngPwd.getMessage()+" link in DataBase");
        return new ResponseEntity<>(exception, HttpStatus.BAD_REQUEST);
    }

}
