package Part_3_Advance_Java.Class_2.Milestone5;

import Part_3_Advance_Java.Class_2.Milestone1.Item;

import java.util.Comparator;

public class ItemQuantityComparator implements Comparator<Item> {
    @Override
    public int compare(Item o1, Item o2) {
        return Integer.compare(o1.getQuantity(), o2.getQuantity());
    }
}
