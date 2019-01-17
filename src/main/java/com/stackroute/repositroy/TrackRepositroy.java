package com.stackroute.repositroy;

import com.stackroute.domain.Track;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrackRepositroy extends JpaRepository<Track,Integer> {
}
