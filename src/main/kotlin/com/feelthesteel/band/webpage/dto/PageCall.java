package com.feelthesteel.band.webpage.dto;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String eventType;

    @Column
    private Date callDate;

    @Column
    private String httpSessionId;

    @Column
    private String cookie;

    @Column
    private String uri;

    @Column
    private String methodType;

    @Column
    private String remoteAddr;


    public enum EventType{
        PAGE_CALLED("Web Page is called"),
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