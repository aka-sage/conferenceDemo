package com.pluralsight.conferenceDemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pluralsight.conferenceDemo.models.Session;

public interface SessionRepository extends JpaRepository<Session, Long> {

}
