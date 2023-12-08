package com.girus.Music.repository;

import com.girus.Music.entity.Music;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MusicRepo extends JpaRepository<Music,Integer> {

//@Query("SELECT a FROM Music a WHERE UPPER(a.musicTitle) LIKE UPPER(?1 || '%')")
//@Query("SELECT a FROM Music a WHERE UPPER(a.musicTitle) LIKE UPPER(?1 || '%')")
//@Query(value = "SELECT * FROM Music WHERE UPPER(music_title) LIKE UPPER(?1 || '%')", nativeQuery = true)
@Query("select a from Music a where a.MusicTitle ILIKE ?1")
    public List<Music> findByMusicTitle(String musicTitle);

}
