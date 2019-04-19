package Sapper;

public enum Difficulty {
    EASY(50),
    MEDIUM(30),
    HARD(20),
    INSANE(15),
    HARDCORE(10),
    NIGHTMARE(8),
    GODLIKE(5);
    int i;
    Difficulty(int i){
        this.i = i;
    }

    public int getI() {
        return i;
    }
}
