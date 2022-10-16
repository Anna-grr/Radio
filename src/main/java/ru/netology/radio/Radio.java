package ru.netology.radio;

public class Radio {
    public int currentStation;
    public int stationsNumber = 10;
    public int currentVolume;
    public int minVolume = 0;

    public int maxVolume = 100;


    public Radio () {

    }

    public Radio (int stationsNumber) {
        this.stationsNumber = stationsNumber;
    }

    public int getCurrentStation() {
        return currentStation;
    }

    public void setCurrentStation(int newCurrentStation) {
        if (newCurrentStation < 0) {
            return;
        }
        if (newCurrentStation > stationsNumber - 1) {
            return;
        }
        currentStation = newCurrentStation;

    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    public void setCurrentVolume(int newCurrentVolume) {
        if (newCurrentVolume < minVolume) {
            return;
        }
        if (newCurrentVolume > maxVolume) {
            return;
        }
        currentVolume = newCurrentVolume;
    }

    public void next() {
        if (currentStation < stationsNumber - 1) {
            currentStation++;
        } else {
            currentStation = 0;
        }
    }

    public void prev() {
        if (currentStation > 0) {
            currentStation--;
        } else {
            currentStation = stationsNumber - 1;
        }
    }

    public void increaseVolume() {
        if (currentVolume < maxVolume) {
            currentVolume++;
        }
    }

    public void decreaseVolume() {
        if (currentVolume > minVolume) {
            currentVolume--;
        }
    }
}