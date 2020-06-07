package mastermind;

class BaseData {
    private int maxColourNum; // how many number we can guess
    private int maxColourValue; // default the Max Number we can Guess, such as 1-6/1-7/1-8
    private int minColourValue; // default the Min Number we can Guesss, such as 2-6/3-6/4-6
    private String correctAns; // set correcr Answer
    private int maxGuesstimes; // How many times we can guess
    private int guessTimes;
    private int black; // Stored Black & White
    private int white;

    // Constructor
    BaseData() {
        this.maxColourNum = 4;
        this.maxColourValue = 6;
        this.minColourValue = 1;
        this.correctAns = "";
        this.maxGuesstimes = 10;
        this.guessTimes = 1;
        this.black = 0;
        this.white = 0;
    }

    // Constructor
    BaseData(
        int maxColourNum, int maxColourValue, int minColourValue,
        String correctAns, int maxGuesstimes, int guessTimes,
        int black, int white
    ) {
        this.maxColourNum = maxColourNum;
        this.maxColourValue = maxColourValue;
        this.minColourValue = minColourValue;
        this.correctAns = correctAns;
        this.maxGuesstimes = maxGuesstimes;
        this.guessTimes = guessTimes;
        this.black = black;
        this.white = white;
    }

    public int getMaxColourNum() {
        return maxColourNum;
    }

    public int getMaxColourValue() {
        return maxColourValue;
    }

    public int getMinColourValue() {
        return minColourValue;
    }

    public int getMaxGuesstimes() {
        return maxGuesstimes;
    }

    public void setGuessTimes(int guessTimes) {
        this.guessTimes = guessTimes;
    }

    public int getGuessTimes() {
        return guessTimes;
    }

    public void setBlack(int black) {
        this.black = black;
    }

    public int getBlack() {
        return black;
    }

    public void setWhite(int white) {
        this.white = white;
    }

    public int getWhite() {
        return white;
    }

    public void setCorrectAns(String correctAns) {
        this.correctAns = correctAns;
    }

    public String getCorrectAns() {
        return correctAns;
    }
}