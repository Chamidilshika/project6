public class Car {

    String licensePlate;
    int movesCount;

    Car(String licensePlate){ // constructor method
        this.licensePlate =  licensePlate;
    }

    public void incrementMoves(){
        this.movesCount++;
    }

    @Override
    public  String toString(){
        return "car number : " +licensePlate+"\n";
    }
}
