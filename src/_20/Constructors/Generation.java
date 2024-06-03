package _20.Constructors;

import java.time.LocalDate;

public enum Generation {

    GEN_Z { //CReating a code block in a constant
        {
            System.out.println("-- SPECIAL FOR " + this + " --");
        }
    },
    MILLENNIAL(1981, 2000),
    GEN_X(1965, 1980),
    BABY_BOOMER(1946, 1964),
    SILENT_GENERATION(1927, 1945),
    GREATEST_GENERATION(1901, 1926);

    private final int startYear;
    private final int endYear;


    //Can have more than one constructor

    Generation() {
        this(2001, LocalDate.now().getYear());
    }
    Generation(int startYear, int endYear) { //This constructor is implicitly private (cannot be public or protected)
        this.startYear = startYear;
        this.endYear = endYear;
        System.out.println(this + " " + startYear + " - " + endYear);
    }

    //Can have more than one constructor
}
