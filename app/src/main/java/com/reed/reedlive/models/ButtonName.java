package com.reed.reedlive.models;

/**
 * Created by thinkreed on 2017/4/4.
 */

public class ButtonName {
    private String jumpName;
    private String playerName;

    public ButtonName(String jumpName, String playerName) {
        this.jumpName = jumpName;
        this.playerName = playerName;
    }

    public String getPlayerName() {

        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getJumpName() {

        return jumpName;
    }

    public void setJumpName(String jumpName) {
        this.jumpName = jumpName;
    }
}
