package ru.netology.radio;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class RadioTest {
    Radio radio = new Radio();


    @Test
    public void shouldSetStation() {

        radio.setCurrentStation(5);

        assertEquals(5, radio.getCurrentStation());
    }

    @Test
    public void shouldSetNextStation() {

        radio.setCurrentStation(5);

        radio.next();

        assertEquals(6, radio.getCurrentStation());
    }

    @Test
    public void shouldSetPrevStation() {

        radio.setCurrentStation(5);

        radio.prev();

        assertEquals(4, radio.getCurrentStation());
    }

    @Test
    public void shouldNotSetNextAbove9() {

        radio.setCurrentStation(9);

        radio.next();

        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    public void shouldNotSetPrevBelow0() {

        radio.setCurrentStation(0);

        radio.prev();

        assertEquals(9, radio.getCurrentStation());
    }

    @Test
    public void shouldNotSetStationAbove9() {

        int currentStation = radio.getCurrentStation();

        radio.setCurrentStation(10);

        assertEquals(currentStation, radio.getCurrentStation());
    }


    @Test
    public void shouldNotSetStationBelow0() {

        int currentStation = radio.getCurrentStation();

        radio.setCurrentStation(-1);

        assertEquals(currentStation, radio.getCurrentStation());
    }

    @Test
    public void shouldSetNextStationWhenBoundary() {

        radio.setCurrentStation(8);

        radio.next();

        assertEquals(9, radio.getCurrentStation());
    }

    @Test
    public void shouldSetPrevStationWhenBoundary() {

        radio.setCurrentStation(1);

        radio.prev();

        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    public void shouldIncreaseVolume() {

        radio.setCurrentVolume(0);

        radio.increaseVolume();

        assertEquals(1, radio.getCurrentVolume());
    }

    @Test
    public void shouldDecreaseVolume() {

        radio.setCurrentVolume(100);

        radio.decreaseVolume();

        assertEquals(99, radio.getCurrentVolume());
    }

    @Test
    public void shouldIncreaseVolumeWhenBoundary() {

        radio.setCurrentVolume(99);

        radio.increaseVolume();

        assertEquals(100, radio.getCurrentVolume());
    }

    @Test
    public void shouldDecreaseVolumeWhenBoundary() {

        radio.setCurrentVolume(1);

        radio.decreaseVolume();

        assertEquals(0, radio.getCurrentVolume());
    }

    @Test
    public void shouldNotIncreaseVolumeWhenMax() {

        radio.setCurrentVolume(0);

        radio.decreaseVolume();

        assertEquals(0, radio.getCurrentVolume());
    }

    @Test
    public void shouldNotDecreaseVolumeWhenMin() {

        radio.setCurrentVolume(100);

        radio.increaseVolume();

        assertEquals(100, radio.getCurrentVolume());
    }

    @Test
    public void shouldNotSetVolumeBelowMin() {

        int currentVolume = radio.getCurrentVolume();

        radio.setCurrentVolume(-1);

        assertEquals(currentVolume, radio.getCurrentVolume());
    }

    @Test
    public void shouldNotSetVolumeAboveMax() {

        int currentVolume = radio.getCurrentVolume();

        radio.setCurrentVolume(101);

        assertEquals(currentVolume, radio.getCurrentVolume());
    }

    @Test
    public void shouldSetStationWhenCustomNumberOfStations() {
        Radio radio = new Radio(48);

        radio.setCurrentStation(24);

        assertEquals(24, radio.getCurrentStation());
    }

    @Test
    public void shouldSetTo0AfterMaxStation() {
        Radio radio = new Radio(48);

        radio.setCurrentStation(47);

        radio.next();

        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    public void shouldSetToMaxBefore0Station() {
        Radio radio = new Radio(48);

        radio.setCurrentStation(0);

        radio.prev();

        assertEquals(47, radio.getCurrentStation());
    }

    @Test
    public void shouldNotSetStationAboveMax() {
        Radio radio = new Radio(48);

        int currentStation = radio.getCurrentStation();

        radio.setCurrentStation(48);

        assertEquals(currentStation, radio.getCurrentStation());
    }

    @Test
    public void shouldSetNextStationWhenBoundaryCustom() {
        Radio radio = new Radio(48);

        radio.setCurrentStation(46);

        radio.next();

        assertEquals(47, radio.getCurrentStation());
    }
}