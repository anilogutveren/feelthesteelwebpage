package com.feelthesteel.band.webpage.dto;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Table(name = "event_repo")
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@ToString
public class PageCall implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String eventType;

    @Column
    private Date date;

    @Column
    private String httpSessionId;

    @Column
    private String cookie;

    @Column
    private String uri;

    @Column
    private String method;

    @Column
    private String remoteAddr;


    public enum EventType{
        PAGE_CALLED("Resume Page is called"),
        OTHER("Other event");

        private String value;

        EventType(final String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return this.getValue();
        }
    }
}