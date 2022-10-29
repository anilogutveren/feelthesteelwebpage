package com.feelthesteel.band.webpage.service.impl;

import com.feelthesteel.band.webpage.dto.PageCall;
import com.feelthesteel.band.webpage.event.PageCalledEvent;
import com.feelthesteel.band.webpage.repository.PageCalledRepository;
import com.feelthesteel.band.webpage.service.IWebpageService;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

@Service
public class WebpageServiceImpl implements IWebpageService {

    @Value("classpath:/static/main.html")
    private Resource mainPage;

    @Value("classpath:/user")
    private Resource userPage;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @Autowired
    private PageCalledRepository pageCalledRepository;

    @Override
    @Transactional
    public Resource getPage(HttpServletRequest request) {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        PageCall pageCall = new PageCall();
        pageCall.setDate(new Date());
        pageCall.setEventType(PageCall.EventType.PAGE_CALLED.getValue());
        pageCall.setHttpSessionId(request.getSession().getId());
        pageCall.setCookie(request.getHeader("Cookie"));
        pageCall.setUri(request.getRequestURI());
        pageCall.setMethod(request.getMethod());
        pageCall.setRemoteAddr(request.getRemoteAddr());


        applicationEventPublisher.publishEvent(new PageCalledEvent(pageCall));

        pageCalledRepository.save(pageCall);
        return mainPage;
    }

    @Override
    public Resource getUserPage() {
        return userPage;
    }
}