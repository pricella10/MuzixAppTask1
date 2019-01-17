package com.stackroute.Service;

import com.stackroute.domain.Track;
import com.stackroute.exception.TrackAlreadltExistsException;
import com.stackroute.exception.TrackNotFoundException;
import com.stackroute.exception.UpdateNotPosssibleException;

import java.util.List;

public interface TrackService {
    public Track saveTrack(Track track) throws TrackAlreadltExistsException;
    public List<Track> getAllTracks();
    public boolean deleteTrack(int id) throws TrackNotFoundException;
    public Track UpdateTrack(Track track) throws UpdateNotPosssibleException;
}
