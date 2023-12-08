package com.girus.Music.service;

import com.girus.Music.dao.MusicDao;
import com.girus.Music.entity.Music;
import com.girus.Music.exception.MusicNotFoundException;
import com.girus.Music.util.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicService {

    @Autowired
    private MusicDao dao;

    public ResponseEntity<ResponseStructure<Music>> saveMusic(Music music){
        ResponseStructure<Music> structure=new ResponseStructure<>();
        structure.setData(dao.saveMusic(music));
        structure.setStatus(HttpStatus.CREATED.value());
        structure.setMessage("song saved succesfully");
        return  new ResponseEntity<ResponseStructure<Music>>(structure,HttpStatus.CREATED);
    }

    public ResponseEntity<ResponseStructure<Music>> getMusicById(int id){
        Music db=dao.getMusicByID(id);
        if(db!=null){
            ResponseStructure<Music> structure=new ResponseStructure<>();
            structure.setMessage("song fetched succesfully");
            structure.setData(db);
            structure.setStatus(HttpStatus.FOUND.value());

            return new ResponseEntity<ResponseStructure<Music>>(structure,HttpStatus.FOUND);
        }
        else{
                throw new MusicNotFoundException("song not found");
        }
    }

    public ResponseEntity<ResponseStructure<Music>> deleteMusic(int id){
        Music db=dao.getMusicByID(id);
        if(db!=null){
            ResponseStructure<Music> structure=new ResponseStructure<>();
            structure.setStatus(HttpStatus.FOUND.value());
            structure.setData(dao.deleteMusic(id));
            structure.setMessage("song deleted succesfully");

            return new ResponseEntity<ResponseStructure<Music>>(structure,HttpStatus.FOUND);
        }
        else{
            throw new MusicNotFoundException("song not found");
        }
    }

    public ResponseEntity<ResponseStructure<List<Music>>> getAllMusic() {
        List<Music> db = dao.getAllMusic();
        if (!db.isEmpty()&& db!=null) {
            ResponseStructure<List<Music>> structure = new ResponseStructure<>();
            structure.setData(db);
            structure.setStatus(HttpStatus.FOUND.value());
            structure.setMessage("songs fetched successfully");

            return new ResponseEntity<ResponseStructure<List<Music>>>(structure, HttpStatus.FOUND);
        } else {
            throw new MusicNotFoundException("songs not found");
        }
    }

    public ResponseEntity<ResponseStructure<Music>> updateMusic(Music music){
        Music db=dao.getMusicByID(music.getId());
        if(db!=null){
            ResponseStructure<Music> structure=new ResponseStructure<>();
            structure.setMessage("song updated successfully");
            structure.setData(dao.updateMusic(music));
            structure.setStatus(HttpStatus.FOUND.value());

            return new ResponseEntity<ResponseStructure<Music>>(structure,HttpStatus.FOUND);
        }else{
            throw new MusicNotFoundException("song not found");
        }

    }

    public ResponseEntity<ResponseStructure<List<Music>>> findByMusicTitle(String musicTitle) {
        List<Music> music = dao.findByMusicTitle(musicTitle);
        if (!music.isEmpty() && music != null) {
            ResponseStructure<List<Music>> structure = new ResponseStructure<>();
            structure.setStatus(HttpStatus.FOUND.value());
            structure.setData(music);
            structure.setMessage("songs fetched successfully");

            return new ResponseEntity<ResponseStructure<List<Music>>>(structure, HttpStatus.FOUND);
        } else {
            throw new MusicNotFoundException("song not found");
        }


    }


}
