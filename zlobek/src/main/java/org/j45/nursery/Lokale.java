package org.j45.nursery;

import java.util.Locale;
import static org.j45.nursery.Locales.en_US;

/**
 * Created by SG0224606 on 3/18/2016.
 */
public class Lokale {
    public static void main(String[] args) {
        Locale l = new Locale("en", "US");
        System.out.println("tag:" + l.toLanguageTag());
        System.out.println("tag:" + l.toString());

        Locale l2 = new Locale("xx", "XX");
        System.out.println("tag:" + l2.toLanguageTag());
        System.out.println("tag:" + l2.toString());

        System.out.println("l3: " + en_US);

    }

}