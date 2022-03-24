package brickset;

import java.time.Year;
import java.util.Set;

@lombok.Data
public class LegoSet {

    private String number;
    private String name;
    private Year year;
    private String theme;
    private String subtheme;
    private PackagingType packagingType;
    private int pieces;
    private String bricksetURL;
    private Set<String> tags;
    private Dimensions dimensions;

    public static void main(String[] args) {
        var repository = new LegoSetRepository();
        System.out.println("1. Feladat:");
        System.out.println(repository.largestLego());
        System.out.println("---------------------------------------");
        System.out.println("2. Feladat:");
        System.out.println(repository.countLegoSetsWithTheme("Games"));
        System.out.println("---------------------------------------");
        System.out.println("3. Feladat:");
        repository.startsWithL();
        System.out.println("---------------------------------------");
        System.out.println("4. Feladat:");
        repository.packagingTypeBucket();
        System.out.println("---------------------------------------");
        System.out.println("5. Feladat:");
        repository.subThemeInOrder();
    }
}
