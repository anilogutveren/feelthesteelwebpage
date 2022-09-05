package com.feelthesteel.band.webpage.event.listener;

import com.feelthesteel.band.webpage.event.PageCalledEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class PageCalledEventListener {

    @EventListener
    public void pageCalledEventHandler(PageCalledEvent pageCalledEvent) throws InterruptedException {
        Thread.sleep(1000L);
        System.out.println("PageCalledEventListener-> " + " from IP Address " + pageCalledEvent.getSource().toString());
    }
}