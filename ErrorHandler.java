package mastermind;

public class ErrorHandler {
    private int errorType;
    private String errorMessage;

    public void chkYesNoError(String yesno) {
        setErrMsg(0, "");

        try {
            if (yesno.length() != 1) {
                throw new Exception();
            }

            Choose.valueOf(yesno.toUpperCase());
        } catch (Exception err) {
            setErrMsg(1, "Please input y or n !");
        }
    }

    public void chkPegsColour(String guess, BaseData baseData) {
        setErrMsg(0, "");

        char maxGuessValue = Integer.toString(baseData.getMaxColourValue()).charAt(0);
        char minGuessValue = Integer.toString(baseData.getMinColourValue()).charAt(0);

        for (int i = 0; i < guess.length(); i++) {
            if (guess.charAt(i) < minGuessValue || guess.charAt(i) > maxGuessValue) {
                String msg = "Use digit " + "'" + minGuessValue + "'" + " to " + "'" + maxGuessValue + "'"
                        + " to represent Colour!!!";

                setErrMsg(2, msg);
                break;
            }
        }
    }

    public void chkPegsNumber(String guess, BaseData baseData) {
        setErrMsg(0, "");

        if (guess.length() != baseData.getMaxColourNum()) {
            String num = NumericAlp.of(baseData.getMaxColourNum()).getNumerAlp();
            String msg = "Only " + num + " pegs are allowed!!!";
            setErrMsg(2, msg);
        }
    }

    public boolean getError() {
        return errorType != 0;
    }

    public void setErrMsg(int type, String msg) {
        errorType = type;
        errorMessage = msg;
    }

    public String getErrMsg() {
        return errorMessage;
    }
}