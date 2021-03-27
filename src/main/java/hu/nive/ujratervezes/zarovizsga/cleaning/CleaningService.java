package hu.nive.ujratervezes.zarovizsga.cleaning;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CleaningService {

    private List<Cleanable> cleanables = new ArrayList<>();

    public List<Cleanable> getCleanables() {
        return new ArrayList<>(cleanables);
    }

    public void add(Cleanable cleanable) {
        cleanables.add(cleanable);
    }

    public int cleanAll() {
        int price = 0;
        for (Cleanable c : cleanables) {
            price += c.clean();
        }
        cleanables.clear();
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

    public int cleanOnlyOfficesWithIterator(){
        int price = 0;
        Iterator<Cleanable> iterator = cleanables.iterator();
        while (iterator.hasNext()){
            Cleanable cleanable = iterator.next();
            if (cleanable.getType() == BuildingType.OFFICE){
                price += cleanable.clean();
                iterator.remove();
            }
        }
        return price;
    }

    public List<Cleanable> findByAddressPart(String address) {
        List<Cleanable> result = new ArrayList<>();
        for (Cleanable c : cleanables) {
            if (c.getAddress().contains(address)) {
                result.add(c);
            }
        }
        return result;
    }

    public String getAddresses() {
        if (cleanables.size() == 0){
            return "";
        }
        StringBuilder temp = new StringBuilder();
        for (Cleanable c : cleanables) {
            temp.append(c.getAddress()).append(", ");
        }
        String s = temp.toString();
        s = s.trim();
        return s.substring(0, s.length() - 1);
    }
}
