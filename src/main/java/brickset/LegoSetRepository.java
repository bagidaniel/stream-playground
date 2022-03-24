package brickset;

import repository.Repository;

import java.util.Comparator;

/**
 * Represents a repository of {@code LegoSet} objects.
 */
public class LegoSetRepository extends Repository<LegoSet> {

    public LegoSetRepository() {
        super(LegoSet.class, "brickset.json");
    }

    /**
     * Visszaadja a legtöbb darabból álló lego set nevét
     * @return the name of the max pieces of LEGO sets
     */
    public String largestLego() {
        return getAll().stream()
                .max(Comparator.comparingInt(LegoSet::getPieces))
                .get().getName();
    }

    /**
     * Visszaadja hogy az adott témábol hány lego set van
     * @param theme
     * @return the number of LEGO sets with the theme specified
     */
    public long countLegoSetsWithTheme(String theme) {
        return getAll().stream()
                .filter(legoSet -> legoSet.getTheme() != null && legoSet.getTheme().contains(theme))
                .count();
    }

    /**
     * Kiírja az első 5 lego settnek a nevét amelyek "L" betűvel kezdődnek
     */
    public void startsWithL() {
        getAll().stream()
                .filter(legoSet -> legoSet.getName().startsWith("L"))
                .map(LegoSet::getName)
                .limit(5)
                .forEach(System.out::println);
    }

    /**
     * Kiírja a azokat a lego setteket amelyeknek a packagingtype-ja bucket
     */
    public void packagingTypeBucket() {
        getAll().stream()
                .filter(legoSet -> legoSet.getPackagingType() == PackagingType.BUCKET)
                .forEach(System.out::println);
    }

    /**
     * Kiírja a azoknak a lego setteknek a nevét sorrendben, amelyeknek a subtheme értéke null
     */
    public void subThemeInOrder() {
        getAll().stream()
                .filter(legoSet -> legoSet.getSubtheme() == null)
                .map(LegoSet::getName)
                .sorted(Comparator.naturalOrder())
                .forEach(System.out::println);
    }

}
