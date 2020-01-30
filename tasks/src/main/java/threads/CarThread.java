package threads;

import java.util.concurrent.TimeUnit;

public class CarThread implements Runnable {
  static final int NUMBER_CARS = 20;

  private void carArrivesToParking() throws InterruptedException {
    for (int i = 1; i <= NUMBER_CARS; i++) {
      System.out.println(String.format("Сar №%d has arrived ", i));
      TimeUnit.SECONDS.sleep(2);
    }
  }

  @Override
  public void run() {
    try {
      carArrivesToParking();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
