package com.jfcc.link.services;

import com.jfcc.link.dto.LinkDTO;
import com.jfcc.link.dto.LinkMetricDTO;
import com.jfcc.link.exceptionHandlers.NotValidIdException;
import com.jfcc.link.exceptionHandlers.NotValidLinkException;
import com.jfcc.link.exceptionHandlers.NotValidUrlException;
import com.jfcc.link.exceptionHandlers.WrongPasswordException;
import com.jfcc.link.repositories.LinksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.view.RedirectView;

@Service
public class LinkTrackerServiceImpl implements LinkTrackerService{

    @Autowired
    private LinksRepository linksRepository;

    @Override
    public int createLink(String url, String password) throws NotValidUrlException {
        LinkDTO link = new LinkDTO(-1, url, 0, password);
        return linksRepository.addToRepository(link);
    }

    @Override
    public RedirectView redirectLink(int linkID, String password) throws NotValidIdException, NotValidLinkException, WrongPasswordException {
        LinkDTO link = linksRepository.getLinkById(linkID);
        if(link.isValid()){
            if(link.getPassword().equals(password)){
                link.setRedirectCount(link.getRedirectCount()+1);
                return new RedirectView(link.getUrl());
            }else{
                throw new WrongPasswordException(Integer.toString(linkID));
            }
        }else{
            throw new NotValidLinkException(Integer.toString(link.getLinkID()));
        }

    }

    @Override
    public LinkMetricDTO metricsLink(int linkID) throws NotValidIdException {
        LinkDTO link = linksRepository.getLinkById(linkID);
        LinkMetricDTO linkMetricDTO = new LinkMetricDTO(link.getRedirectCount(), link.getUrl(), link.isValid());
        return linkMetricDTO;
    }

    @Override
    public boolean invalidateLink(int linkID) throws NotValidIdException {
        return linksRepository.invalidateLink(linksRepository.getLinkById(linkID));
    }

}
