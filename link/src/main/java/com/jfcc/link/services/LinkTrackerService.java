package com.jfcc.link.services;

import com.jfcc.link.dto.LinkDTO;
import com.jfcc.link.dto.LinkMetricDTO;
import com.jfcc.link.exceptionHandlers.NotValidIdException;
import com.jfcc.link.exceptionHandlers.NotValidLinkException;
import com.jfcc.link.exceptionHandlers.NotValidUrlException;
import com.jfcc.link.exceptionHandlers.WrongPasswordException;
import org.springframework.web.servlet.view.RedirectView;

public interface LinkTrackerService {

    public int createLink(String url, String password) throws NotValidUrlException;

    public RedirectView redirectLink(int linkID, String password) throws NotValidIdException, NotValidLinkException, WrongPasswordException;

    public LinkMetricDTO metricsLink(int linkID) throws NotValidIdException;

    public boolean invalidateLink(int linkID) throws NotValidIdException;

}
