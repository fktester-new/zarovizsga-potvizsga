package hu.nive.ujratervezes.zarovizsga.cleaning;

import java.util.ArrayList;
import java.util.List;

public class CleaningService {

    private List<Cleanable> cleanables = new ArrayList<>();

    public List<Cleanable> getCleanables() {
        return cleanables;
    }

    public void add(Cleanable cleanable){
        cleanables.add(cleanable);
    }

    public int cleanAll(){
        int price = 0;
        List<Cleanable> toDel = new ArrayList<>();
        for (Cleanable c : cleanables) {
            price += c.clean();
            toDel.add(c);
        }
       cleanables.removeAll(toDel);
        return price;
    }
}
