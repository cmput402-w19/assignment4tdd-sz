package assignment4;

public class Player {
    private String playerName;
    private long playTime;

    public Player(String name) {
        playerName = name;
        playTime = 0;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayTime(long playTime) {
        this.playTime = playTime;
    }

    public long getPlayTime() {
        return playTime;
    }
}
