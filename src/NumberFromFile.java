public class NumberFromFile {
    private int number;

    public  NumberFromFile(int number){
        this.number = number;
    }
    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return number + "";
    }
}
