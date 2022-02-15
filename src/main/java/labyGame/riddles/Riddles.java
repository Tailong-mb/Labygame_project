package labyGame.riddles;

public enum Riddles {

    Riddle_One("What has to be broken before you can use it?", "an egg"),
    Riddle_Two("I’m tall when I’m young, and I’m short when I’m old. What am I?", "a candle"),
    Riddle_Three("What is full of holes but still holds water?", "a sponge"),
    Riddle_Four("What is always in front of you but can’t be seen?", "the Future"),
    Riddle_Five("What can you break, even if you never pick it up or touch it?", "a promise"),
    Riddle_Six("You walk into a room that contains a match, a kerosene lamp, a candle and a fireplace. What would you light first?", "the match"),
    Riddle_Seven("What can’t talk but will reply when spoken to?", "an echo"),
    Riddle_Eight("The more of this there is, the less you see. What is it?", "Darkness"),
    Riddle_Nine("I follow you all the time and copy your every move, but you can’t touch me or catch me. What am I?", "your shadow"),
    Riddle_Ten("What gets bigger when more is taken away?", "a hole"),
    Riddle_Eleven("Where does today come before yesterday?", "the dictionary"),
    Riddle_Twelve("If you’ve got me, you want to share me; if you share me, you haven’t kept me. What am I?", "a secret");

    final String Rid;
    final String Ans;
    String answer;

    Riddles(String Rid, String Ans) {
        this.Rid = Rid;
        this.Ans = Ans;
    }

    public String getRid() {
        return Rid;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public boolean AnsRid() {
        for (Riddles Ans : Riddles.values()) {
            if (Ans.Rid.equalsIgnoreCase(answer))
                return true;
            else
                return false;
        }
        return false;
    }

    public String getAns(){
        return Ans;
    }

}