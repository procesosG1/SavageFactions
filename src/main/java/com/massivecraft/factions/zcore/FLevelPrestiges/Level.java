package com.massivecraft.factions.zcore.FLevelPrestiges;

public enum Level {

    ALPHA(1,"Alpha"),
    BRAVO(2,"Bravo"),
    CHARLIE(3,"Charlie"),
    DELTA(4,"Delta"),
    ECHO(5,"Echo"),
    FOXTROT(6,"Foxtrot"),
    GOLF(7,"Golf"),
    HOTEL(8,"Hotel"),
    INDIA(9,"India"),
    JULIET(10,"Juliet");

    private int level ;
    private String name;

    Level(int level, String name) {
        this.level = level;
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public String getName() {
        return name;
    }

    public static Level getLevelByNumber(int number) {
        for(Level level : Level.values()){
            if(level.getLevel() == number)
                return level;
        }
        return null;
    }

}
