package com.stackroute.Service;

import com.stackroute.domain.Track;
import com.stackroute.exception.TrackAlreadltExistsException;
import com.stackroute.exception.TrackNotFoundException;
import com.stackroute.exception.UpdateNotPosssibleException;
import com.stackroute.repositroy.TrackRepositroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrackServiceimpl implements TrackService {

    TrackRepositroy trackRepositroy;

    @Autowired
    public TrackServiceimpl(TrackRepositroy trackRepositroy) {
        this.trackRepositroy = trackRepositroy;
    }

    @Override
    public Track saveTrack(Track track) throws TrackAlreadltExistsException {
        if(trackRepositroy.existsById(track.getId()))
        {
            throw new TrackAlreadltExistsException("TRACK ALREADY EXISTS");
        }
        Track savedTrack = trackRepositroy.save(track);
        if (savedTrack == null)
        {
            throw new TrackAlreadltExistsException("TRACK ALREADY EXISTS");
        }
        return savedTrack;
    }

    @Override
    public List<Track> getAllTracks() {
        return trackRepositroy.findAll();
    }


    @Override

    public boolean deleteTrack(int id) throws TrackNotFoundException {
        //return null;
        boolean status=false;
        if(trackRepositroy.existsById(id))
        {
            trackRepositroy.deleteById(id);
            status=true;
            return status;
        }
        else
        {

            throw new TrackNotFoundException("Track not found");
        }


    }
    @Override
    public Track UpdateTrack(Track track)  throws UpdateNotPosssibleException {
////        if(trackRepositroy.existsById(track.getId()))
////        {
////            throw new TrackAlreadltExistsException("TRACK ALREADY EXISTS");
////        }
//        Track savedTrack = trackRepositroy.save(track);
////        if (savedTrack == null)
////        {
////            throw new TrackAlreadltExistsException("TRACK ALREADY EXISTS");
////        }
//        return savedTrack;
        if(trackRepositroy.existsById(track.getId()))
        {

            Track updateTrack=trackRepositroy.save(track);
            return updateTrack;


        }

        else {

            throw new UpdateNotPosssibleException("ID doesnt exist");
        }
    }


}
