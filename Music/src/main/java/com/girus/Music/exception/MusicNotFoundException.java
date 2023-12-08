package com.girus.Music.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MusicNotFoundException extends RuntimeException{
   private String message;
}
