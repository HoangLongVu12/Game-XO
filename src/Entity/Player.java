package Entity;

public class Player {
    public String name;
    public String chosenMark;

    public Player(String name, String chosenMark){
        this.name = name;
        this.chosenMark = chosenMark;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getChosenMark() {
        return chosenMark;
    }

    public void setChosenMark(String chosenMark) {
        this.chosenMark = chosenMark;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", chosenMark='" + chosenMark + '\'' +
                '}';
    }
}
