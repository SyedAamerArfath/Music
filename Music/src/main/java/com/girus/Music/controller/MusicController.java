package com.girus.Music.controller;

import com.girus.Music.entity.Music;
import com.girus.Music.service.MusicService;
import com.girus.Music.util.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MusicController {

    @Autowired
    private MusicService service;

    @PostMapping("/music")
    public ResponseEntity<ResponseStructure<Music>> saveMusic(@RequestBody Music music){
        return service.saveMusic(music);
    }
    @GetMapping("/music")
    public ResponseEntity<ResponseStructure<Music>> getMusicByID(@RequestParam int id){
        return service.getMusicById(id);
    }
    @GetMapping("music/all")
    public ResponseEntity<ResponseStructure<List<Music>>> getAllMusic(){
        return service.getAllMusic();
    }

    @PutMapping("/music")
    public ResponseEntity<ResponseStructure<Music>> updateMusic(@RequestBody Music music){
        return  service.updateMusic(music);
    }
    @DeleteMapping("/music")
    public ResponseEntity<ResponseStructure<Music>> deleteMusic(@RequestParam int id){
        return service.deleteMusic(id);
    }
    @GetMapping("/title")
    public ResponseEntity<ResponseStructure<List<Music>>> findByMusicTitle(@RequestParam String musicTitle){
        String pattern =  musicTitle + "%";

//        String pattern="%"+musicTiltle+"%";
        return service.findByMusicTitle(pattern);
    }
}
