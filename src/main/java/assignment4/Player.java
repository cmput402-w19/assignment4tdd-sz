package assignment4;

public class Player implements Comparable<Player> {
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

    public void reset(String newPlayerName) {
        playerName = newPlayerName;
        playTime = 0;
    }

    @Override
    public int compareTo(Player comparePlayer) {
        long comparePlayerTime = comparePlayer.getPlayTime();
        long compareResult = playTime - comparePlayerTime;
        if (compareResult > 0) {
            return 1;
        }
        else if (compareResult < 0) {
            return -1;
        }
        else {
            return 0;
        }
    }

    @Override
    public String toString() {
        long playTimeInSec = playTime / 1000;
        return playerName + "\t\t" + "[" + playTimeInSec + "]";
    }
}
