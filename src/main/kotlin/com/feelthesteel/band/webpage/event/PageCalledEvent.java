package com.feelthesteel.band.webpage.event;

import org.springframework.context.ApplicationEvent;

public class PageCalledEvent extends ApplicationEvent {
    public PageCalledEvent(Object source) {
        super(source);
    }
}