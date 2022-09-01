package com.feelthesteel.band.webpage.service.impl;

import com.feelthesteel.band.webpage.service.WebpageService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

@Service
public class WebpageServiceImpl implements WebpageService {

    @Value("classpath:/static/main.html")
    private Resource mainPage;

    @Override
    public Resource getPage() {
        return mainPage;
    }
}