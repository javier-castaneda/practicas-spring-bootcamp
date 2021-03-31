package com.jfcc.link.repositories;

import com.jfcc.link.dto.LinkDTO;
import com.jfcc.link.exceptionHandlers.NotValidIdException;
import com.jfcc.link.exceptionHandlers.NotValidUrlException;

public interface LinksRepository {

    public LinkDTO getLinkById(int linkId) throws NotValidIdException;
    public int addToRepository(LinkDTO link) throws NotValidUrlException;
    public boolean invalidateLink(LinkDTO link);
}
