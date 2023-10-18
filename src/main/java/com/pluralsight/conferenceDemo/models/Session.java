package com.pluralsight.conferenceDemo.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity(name="sessions")
/*
 * To avoid below error, the @JsonIgnoreProperties annotation is being used, it
 * specifies to use a serializer to fetch the data, to handle lazy loading/eager 
 * loading.
 * com.fasterxml.jackson.databind.exc.InvalidDefinitionException: \ No
 * serializer found for class
 * org.hibernate.proxy.pojo.bytebuddy.ByteBuddyInterceptor and no properties
 * discovered to create BeanSerializer (to avoid exception, disable
 * SerializationFeature.FAIL_ON_EMPTY_BEANS) (through reference chain:
 * com.pluralsight.conferenceDemo.models.
 * Session$HibernateProxy$MliwRp9K["hibernateLazyInitializer"])
 */
@JsonIgnoreProperties({"hibernateLazyInitiater","handler"})
public class Session {

    /* JPA auto-binds if the names of the variables are same as column names, hence
     * reducing need for annotation. The ID annotation is for primary key, while the
     * generated annotation specifies how the PK gets populated.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long session_id;
    private String session_name;
    private String session_description;
    private Integer session_length;
    
    
    /* The annotations define how the relationship is between the tables. */
    @ManyToMany
    @JoinTable(
            name="session_speakers",
            joinColumns=@JoinColumn(name="session_id"),//PK
            inverseJoinColumns=@JoinColumn(name="Speaker_id")//FK
            )
    private List<Speaker> speakers;
    
    public List<Speaker> getSpeakers() {
        return speakers;
    }

    public void setSpeakers(List<Speaker> speakers) {
        this.speakers = speakers;
    }

    public Long getSession_id() {
        return session_id;
    }

    public void setSession_id(Long session_id) {
        this.session_id = session_id;
    }

    public String getSession_name() {
        return session_name;
    }

    public void setSession_name(String session_name) {
        this.session_name = session_name;
    }

    public String getSession_description() {
        return session_description;
    }

    public void setSession_description(String session_description) {
        this.session_description = session_description;
    }

    public Integer getSession_length() {
        return session_length;
    }

    public void setSession_length(Integer session_length) {
        this.session_length = session_length;
    }

    public Session() {

           
   };
}
