package threads;

import java.util.concurrent.TimeUnit;

public class Runner {

  public static void main(String[] args) {
    try {
      Parking parking = new Parking();
      System.out.println(parking.parkingState());

      new Thread(new CarThread()).start();
      TimeUnit.SECONDS.sleep(1);
      new Thread(new Parking()).start();

    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new AssertionError(e);
    }
  }
}
