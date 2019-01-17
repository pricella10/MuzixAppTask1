package com.stackroute.Controller;

import com.stackroute.Service.TrackService;
import com.stackroute.domain.Track;
import com.stackroute.exception.TrackAlreadltExistsException;
import com.stackroute.exception.TrackNotFoundException;
import com.stackroute.exception.UpdateNotPosssibleException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1")
public class TrackController {
    TrackService trackService;

    public TrackController(TrackService trackService) {
        this.trackService = trackService;
    }


    @PostMapping("track")
    public ResponseEntity<?> saveUser(@RequestBody Track track)

    {
        ResponseEntity responseEntity;
        try {
            trackService.saveTrack(track);
            responseEntity = new ResponseEntity<String>("successfully created", HttpStatus.CREATED);
        }
        catch(TrackAlreadltExistsException e)
        {
            responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @GetMapping("track")
    public ResponseEntity<?> getAllTracks()
    {
        return new ResponseEntity<List<Track>>(trackService.getAllTracks(),HttpStatus.OK);
    }

    @PutMapping("track")
    public ResponseEntity<?> UpdateTrack(@RequestBody Track track)

    {
        ResponseEntity responseEntity;
        try {
            trackService.UpdateTrack( track);
            responseEntity = new ResponseEntity<String>("successfully created", HttpStatus.CREATED);
        }
        catch(UpdateNotPosssibleException e)
        {
            responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }
    @DeleteMapping("track/{id}")
    public ResponseEntity<?> deleteTrack(@PathVariable("id") int id)
    {
        ResponseEntity responseEntity;
        try
        {
            trackService.deleteTrack(id);
            responseEntity = new ResponseEntity<String>("deleted successfully",HttpStatus.OK);
        } catch (TrackNotFoundException e) {
            responseEntity=new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
        }


        return responseEntity;
    }


}
