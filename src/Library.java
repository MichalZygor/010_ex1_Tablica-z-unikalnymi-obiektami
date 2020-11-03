import java.util.Objects;
import java.util.Scanner;

public class Library {
    private String name;
    private int rating;
    private boolean isCool;

    public static void createLibrary(Library[] libraries) {
        int i = 0;
        while (i < libraries.length) {
            Library library = Library.scanDataFromUser();
            if (Library.isUnique(libraries, library)) {
                libraries[i] = library;
                i++;
            } else {
                System.out.println("Podałeś duplikat!");
            }
        }
    }

    private static Library scanDataFromUser() {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Podaj tytuł książki: ");
        library.name = scanner.nextLine();
        System.out.print("Wprowadź ocenę w skali 1-10: ");
        library.rating = scanner.nextInt();
        System.out.print("Czy książka jest interesująca? false/true: ");
        library.isCool = scanner.nextBoolean();
        return library;
    }

    public static void showArray(Library[] libraries) {
        System.out.println("Obiekty zapisane w tablicy:");
        for (Library library :
                libraries) {
            System.out.println(library);
        }
    }


    @Override
    public String toString() {
        return "Library{" +
                "name='" + name + '\'' +
                ", rating=" + rating +
                ", isCool=" + isCool +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Library)) return false;
        Library library = (Library) o;
        return rating == library.rating &&
                isCool == library.isCool &&
                Objects.equals(name, library.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, rating, isCool);
    }

    private static boolean isUnique(Library[] libraries, Library library) {
        for (int i = 0; i < libraries.length; i++) {
            if (libraries[i] != null && libraries[i].equals(library)) return false;
        }
        return true;
    }
}
