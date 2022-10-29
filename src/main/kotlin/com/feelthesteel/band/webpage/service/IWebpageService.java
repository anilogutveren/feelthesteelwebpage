package com.feelthesteel.band.webpage.service;

import javax.servlet.http.HttpServletRequest;
import org.springframework.core.io.Resource;

public interface IWebpageService {
    Resource getPage(HttpServletRequest request);
    Resource getUserPage();
}