package com.iofit.creational.builder;

import java.util.OptionalDouble;

public class Song {

    private Melody melody;
    private Harmony harmony;
    private Rhythym rhythym;
    private Song() {}

    public String play() {
        System.out.println("Playing the song!");
        return "wowowowowowo";
    }

    public static class SongBuilder {

        private static SongBuilder instance;
        private Song song = new Song();


        private SongBuilder() {}

        public static SongBuilder getInstance() {
            synchronized (SongBuilder.class) {
                if(instance == null) {
                    instance = new SongBuilder();
                }
            }
            return instance;
        }

        public SongBuilder addMelody(Melody melody) {
            song.melody = melody;
            return this;
        }

        public SongBuilder addHarmony(Harmony harmony){
            song.harmony = harmony;
            return this;
        }

        public SongBuilder addRhythym(Rhythym rhythym){
            song.rhythym = rhythym;
            return this;
        }

        public Song build() {
            return song;
        }
    }
}

