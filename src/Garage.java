public class Garage {

    final static int maxSize = 10;
    Queue waitinglist;
    Queue parkinglist;

    public Garage() { //Initialize the constructor for parking garage class
        waitinglist = new Queue();
        parkinglist = new Queue();
    }

    public void arriveCar(String licensePlate){
        Car newcar = new Car(licensePlate);
        if(!parkinglist.isFull()){
            System.out.println(newcar.licensePlate+" " + " Car arrives and parks it in Parking Garage immediately!.");
            parkinglist.enqueue(newcar);
        } else {
            System.out.println(newcar.licensePlate+" " + " Car arrives and waits.Parking Garage is Full!.");
        }
    }

    public void departCar(String licensePlate){
        Car departcar = new Car(licensePlate);
        if (parkinglist.isEmpty()){
            System.out.println("Error!." + licensePlate+" " + " Car is not found in Parking Garage.");
            return;
        }
        if (departcar.equals(parkinglist.peek())){
            Car car = parkinglist.dequeue();
            System.out.println(departcar.licensePlate+" " + " Car departs.It moves:" + departcar.movesCount + "times." );
            shiftCarsSouth();
        } else {
            int movesCount = moveCarsForDeparture(departcar);
            System.out.println(departcar.licensePlate+" " + " Car departs.It moves:" + departcar.movesCount + "times.");
            shiftCarsSouth();
        }
    }

    public int findCarPosition(String licensePlate) {
        if (licensePlate == null || licensePlate.trim().isEmpty()) {
            System.out.println("Invalid license plate input.");
            return -1;
        }

        int size = parkinglist.size();

        for (int i = 0; i < size; i++) {
            Car car = parkinglist.selectItem(i);

            if (car.licensePlate.equalsIgnoreCase(licensePlate)) {
                System.out.println("Car found successfully at position : " + i);
                return i;
            }
        }

        System.out.println("Car not found.");
        return -1;
    }

    private int moveCarsForDeparture(Car departcar) {
        int movesCount = 0;
        Queue tempQueue = new Queue();

        while (!parkinglist.isEmpty()){
            Car car = parkinglist.dequeue();
            if (car.equals(departcar)){
                departcar.incrementMoves();
                movesCount++;
            } else {
                tempQueue.enqueue(car);
                car.incrementMoves();
                movesCount++;
            }
        }
        while (!tempQueue.isEmpty()){
            parkinglist.enqueue(tempQueue.dequeue());
        }
        return movesCount;
    }


    private void shiftCarsSouth() {
        while (!waitinglist.isEmpty() && parkinglist.size() < 10){
            Car car = waitinglist.dequeue();
            System.out.println(car.licensePlate+" " + " Car moves from waiting to parking");
            parkinglist.enqueue(car);
        }
    }

    public void displaycars(){
        parkinglist.display();
    }
}
