package com.jfcc.link.repositories;

import com.jfcc.link.dto.LinkDTO;
import com.jfcc.link.exceptionHandlers.NotValidIdException;
import com.jfcc.link.exceptionHandlers.NotValidUrlException;
import com.jfcc.link.urlutils.UrlValidator;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Repository
public class LinksRepositoryImpl implements LinksRepository {

    private int count = 0;
    private List<LinkDTO> repo = new ArrayList<>();


    @Override
    public LinkDTO getLinkById(int linkId) throws NotValidIdException {

        for (LinkDTO link : repo) {
            if (link.getLinkID().equals(linkId)) {
                return link;
            }
        }
        throw new NotValidIdException(Integer.toString(linkId));
    }

    @Override
    public int addToRepository(LinkDTO link) throws NotValidUrlException {
        if (UrlValidator.validateUrl(link.getUrl())) {
            count++;
            link.setLinkID(count);
            link.setRedirectCount(0);
            repo.add(link);
            return count;
        }
        throw new NotValidUrlException(link.getUrl());
    }

    @Override
    public boolean invalidateLink(LinkDTO link) {
        if(!link.isValid())
            return false;
        else{
            link.setValid(false);
            return true;
        }

    }

}
