package hu.nive.ujratervezes.zarovizsga.words;

public class Words {

    public boolean hasMoreDigits(String s){
        if(s == null || s.isBlank()){
            return false;
        }
        int numCounter = 0;
        char[] chars = s.toCharArray();
        for (char c: chars) {
            if (Character.isDigit(c)){
                numCounter++;
            }
        }
        return numCounter > s.length()-numCounter;
    }
}
