package org.j45.nursery;

import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

public class Collectionz {

    public static void main(String[] args) {
        List<String> l1 = new ArrayList<>();
        l1.add("ania");
        l1.add("basia");
        l1.add("celina");

        List<String> l2 = new ArrayList<>();
        l2.add("ania");
        l2.add("basia");
        l2.add("celina");

        boolean equals = CollectionUtils.isEqualCollection(l1, l2);

    }

}
