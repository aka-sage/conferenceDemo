package com.pluralsight.conferenceDemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pluralsight.conferenceDemo.models.Speaker;

public interface SpeakerRepository extends JpaRepository<Speaker, Long>{

}
