package labyGame.riddles;

public enum Riddles {

    riddleOne("What has to be broken before you can use it?", "an egg"),
    riddleTwo("I’m tall when I’m young, and I’m short when I’m old. What am I?", "a candle"),
    riddleThree("What is full of holes but still holds water?", "a sponge"),
    riddleFour("What is always in front of you but can’t be seen?", "the Future"),
    riddleFive("What can you break, even if you never pick it up or touch it?", "a promise"),
    riddleSix("You walk into a room that contains a match, a kerosene lamp, a candle and a fireplace. What would you light first?", "the match"),
    riddleSeven("What can’t talk but will reply when spoken to?", "an echo"),
    riddleEight("The more of this there is, the less you see. What is it?", "Darkness"),
    riddleNine("I follow you all the time and copy your every move, but you can’t touch me or catch me. What am I?", "your shadow"),
    riddleTen("What gets bigger when more is taken away?", "a hole"),
    riddleEleven("Where does today come before yesterday?", "the dictionary"),
    riddleTwelve("If you’ve got me, you want to share me; if you share me, you haven’t kept me. What am I?", "a secret");

    final String rid;
    final String ans;
    String answer;

    Riddles(String rid, String ans) {
        this.rid = rid;
        this.ans = ans;
    }

    public boolean ansVerification(String answer, Riddles question) {
        return question.getAns().equals(answer);
    }
    
    public String getRid() {
        return rid;
    }

    public String getAns(){
        return ans;
    }

}
