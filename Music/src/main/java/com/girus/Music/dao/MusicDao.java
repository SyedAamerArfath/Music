package com.girus.Music.dao;

import com.girus.Music.entity.Music;
import com.girus.Music.repository.MusicRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MusicDao {
    @Autowired
    private MusicRepo repo;

    public Music saveMusic(Music music){
        return repo.save(music);
    }

    public Music getMusicByID(int id){
        if(repo.findById(id).isPresent()){
          return   repo.findById(id).get();
        }
        else{
            return null;
        }
    }

    public Music deleteMusic(int id){
        if(repo.findById(id).isPresent()){
           Music music= repo.findById(id).get();
            repo.delete(music);
            return  music;
        }
        else{
            return null;
        }
    }

    public List<Music> getAllMusic(){
        return repo.findAll();
    }

    public Music updateMusic(Music music) {
        if (repo.findById(music.getId()).isPresent()) {
            Music db = repo.findById(music.getId()).get();

            if (music.getBanner() == null) {
                music.setBanner(db.getBanner());
            }
            if (music.getArtist() == null) {
                music.setArtist(db.getArtist());
            }
            if (music.getLyrics() == null) {
                music.setLyrics(db.getLyrics());
            }
            if (music.getAlbumName() == null) {
                music.setAlbumName(db.getAlbumName());
            }
            if (music.getMusicTitle() == null) {
                music.setMusicTitle(db.getMusicTitle());
            }
            repo.save(music);
            return music;
        }else {
            return null;
        }
    }

    public List<Music> findByMusicTitle(String musicTitle){
        return repo.findByMusicTitle(musicTitle);
    }
}
