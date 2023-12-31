package com.pluralsight.conferenceDemo.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity(name="speakers")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Speaker {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long speaker_id;
    private String first_name;
    private String last_name;
    private String title;
    private String company;
    private String speaker_bio;
    
//    @Lob //LargeObject annotation
//    @Nullable
////    @Type(Type="org.hibernate.type.BinaryType")
//    private byte[] speaker_photo;
    
    @ManyToMany(mappedBy="speakers")
    @JsonIgnore //to stop Jackson for infinite looping
    private List<Session> session;
    
    public List<Session> getSession() {
        return session;
    }
    public void setSession(List<Session> session) {
        this.session = session;
    }
    public Long getSpeaker_id() {
        return speaker_id;
    }
    public void setSpeaker_id(Long speaker_id) {
        this.speaker_id = speaker_id;
    }
    public String getFirst_name() {
        return first_name;
    }
    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }
    public String getLast_name() {
        return last_name;
    }
    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getCompany() {
        return company;
    }
    public void setCompany(String company) {
        this.company = company;
    }
    public String getSpeaker_bio() {
        return speaker_bio;
    }
    public void setSpeaker_bio(String speaker_bio) {
        this.speaker_bio = speaker_bio;
    }
    
//    public byte[] getSpeaker_photo() {
//        return speaker_photo;
//    }
//    public void setSpeaker_photo(byte[] speaker_photo) {
//        this.speaker_photo = speaker_photo;
//    }
    public Speaker() {
        
    };
}
