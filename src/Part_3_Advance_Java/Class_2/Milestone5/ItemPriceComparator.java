package Part_3_Advance_Java.Class_2.Milestone5;

import Part_3_Advance_Java.Class_2.Milestone1.Item;

import java.util.Comparator;

public class ItemPriceComparator implements Comparator<Item> {
    @Override
    public int compare(Item o1, Item o2) {
        return Double.compare(o1.getPrice(), o2.getPrice()); // Sorts on the Basis of Price ASC
    }
}
