package hu.nive.ujratervezes.zarovizsga.cleaning;

import java.util.ArrayList;
import java.util.List;

public class CleaningService {

    private List<Cleanable> cleanables = new ArrayList<>();

    public List<Cleanable> getCleanables() {
        return cleanables;
    }

    public void add(Cleanable cleanable) {
        cleanables.add(cleanable);
    }

    public int cleanAll() {
        int price = 0;
        List<Cleanable> toDel = new ArrayList<>();
        for (Cleanable c : cleanables) {
            price += c.clean();
            toDel.add(c);
        }
        cleanables.removeAll(toDel);
        return price;
    }

    public int cleanOnlyOffices() {
        int price = 0;
        List<Cleanable> offices = new ArrayList<>();
        for (Cleanable c : cleanables) {
            if (c instanceof Office) {
                price += c.clean();
                offices.add(c);
            }
        }
        cleanables.removeAll(offices);
        return price;
    }

    public List<Cleanable> findByAddressPart(String address){
        List<Cleanable> result = new ArrayList<>();
        for (Cleanable c : cleanables) {
            if (c.getAddress().contains(address)){
                result.add(c);
            }
        }
        return result;
    }
}
