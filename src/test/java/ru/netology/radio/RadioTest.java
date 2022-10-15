package ru.netology.radio;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class RadioTest {

    @Test
    public void shouldSetStation() {
        Radio radio = new Radio();

        radio.setCurrentStation(5);

        assertEquals(5, radio.getCurrentStation());
    }

    @Test
    public void shouldSetNextStation() {
        Radio radio = new Radio();

        radio.setCurrentStation(5);

        radio.next();

        assertEquals(6, radio.getCurrentStation());
    }

    @Test
    public void shouldSetPrevStation() {
        Radio radio = new Radio();

        radio.setCurrentStation(5);

        radio.prev();

        assertEquals(4, radio.getCurrentStation());
    }

    @Test
    public void shouldNotSetNextAbove9() {
        Radio radio = new Radio();

        radio.setCurrentStation(9);

        radio.next();

        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    public void shouldNotSetPrevBelow0() {
        Radio radio = new Radio();

        radio.setCurrentStation(0);

        radio.prev();

        assertEquals(9, radio.getCurrentStation());
    }

    @Test
    public void shouldNotSetStationAbove9() {
        Radio radio = new Radio();

        int currentStation = radio.getCurrentStation();

        radio.setCurrentStation(10);

        assertEquals(currentStation, radio.getCurrentStation());
    }


    @Test
    public void shouldNotSetStationBelow0() {
        Radio radio = new Radio();

        int currentStation = radio.getCurrentStation();

        radio.setCurrentStation(-1);

        assertEquals(currentStation, radio.getCurrentStation());
    }

    @Test
    public void shouldSetNextStationWhenBoundary() {
        Radio radio = new Radio();

        radio.setCurrentStation(8);

        radio.next();

        assertEquals(9, radio.getCurrentStation());
    }

    @Test
    public void shouldSetPrevStationWhenBoundary() {
        Radio radio = new Radio();

        radio.setCurrentStation(1);

        radio.prev();

        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    public void shouldIncreaseVolume() {
        Radio radio = new Radio();

        radio.setCurrentVolume(0);

        radio.increaseVolume();

        assertEquals(1, radio.getCurrentVolume());
    }

    @Test
    public void shouldDecreaseVolume() {
        Radio radio = new Radio();

        radio.setCurrentVolume(10);

        radio.decreaseVolume();

        assertEquals(9, radio.getCurrentVolume());
    }

    @Test
    public void shouldNotSetVolumeBelow0() {
        Radio radio = new Radio();

        int currentVolume =  radio.getCurrentVolume();

        radio.setCurrentVolume(-1);

        assertEquals(currentVolume, radio.getCurrentVolume());
    }

    @Test
    public void shouldNotSetVolumeAbove10() {
        Radio radio = new Radio();

        int currentVolume = radio.getCurrentVolume();
        ;

        radio.setCurrentVolume(11);

        assertEquals(currentVolume, radio.getCurrentVolume());
    }


    @Test
    public void shouldNotIncreaseVolumeAbove10() {
        Radio radio = new Radio();

        radio.setCurrentVolume(10);

        radio.increaseVolume();

        assertEquals(10, radio.getCurrentVolume());
    }

    @Test
    public void shouldNotDecreaseVolumeBelow0() {
        Radio radio = new Radio();

        radio.setCurrentVolume(0);

        radio.decreaseVolume();

        assertEquals(0, radio.getCurrentVolume());
    }

    @Test
    public void shouldIncreaseVolumeWhenBoundary() {
        Radio radio = new Radio();

        radio.setCurrentVolume(9);

        radio.increaseVolume();

        assertEquals(10, radio.getCurrentVolume());
    }

    @Test
    public void shouldDecreaseVolumeWhenBoundary() {
        Radio radio = new Radio();

        radio.setCurrentVolume(1);

        radio.decreaseVolume();

        assertEquals(0, radio.getCurrentVolume());
    }

}