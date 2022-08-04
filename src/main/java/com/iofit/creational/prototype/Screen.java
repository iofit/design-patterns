package com.iofit.creational.prototype;

import java.util.Objects;

public class Screen implements Cloneable {

    private int width = 200;
    private int height = 300;
    private String resolution = "1080p";

    public Screen() {
    }

    public Screen(int width, int height, String resolution) {
        this.width = width;
        this.height = height;
        this.resolution = resolution;
    }

    @Override
    public Screen clone(){
        return new Screen(this.width, this.height, this.resolution);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Screen)) return false;
        Screen screen = (Screen) o;
        return width == screen.width && height == screen.height && Objects.equals(resolution, screen.resolution);
    }

    @Override
    public int hashCode() {
        return Objects.hash(width, height, resolution);
    }
}
