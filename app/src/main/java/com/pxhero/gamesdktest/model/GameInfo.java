package com.pxhero.gamesdktest.model;

/**
 * Created by pengxianheng on 2016/10/28.
 */
public class GameInfo {
    private int imageResourceId;
    private String gameName;
    private String gameType;
    private String gameDescription;
    private String gameActivityDes; //活动描述
    private int gameId;

    public GameInfo(int imageResourceId, String gameName, String gameType, String gameDescription, int gameId) {
        this.imageResourceId = imageResourceId;
        this.gameName = gameName;
        this.gameType = gameType;
        this.gameDescription = gameDescription;
        this.gameId = gameId;
    }

    public String getGameActivityDes() {
        return gameActivityDes;
    }

    public void setGameActivityDes(String gameActivityDes) {
        this.gameActivityDes = gameActivityDes;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public void setImageResourceId(int imageResourceId) {
        this.imageResourceId = imageResourceId;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public String getGameType() {
        return gameType;
    }

    public void setGameType(String gameType) {
        this.gameType = gameType;
    }

    public String getGameDescription() {
        return gameDescription;
    }

    public void setGameDescription(String gameDescription) {
        this.gameDescription = gameDescription;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }
}
