package threads;

import java.util.concurrent.TimeUnit;

class Parking implements Runnable {
  private static final int PARKING_SIZE = 15;
  private boolean[] slots = new boolean[PARKING_SIZE];

  private void occupiedSlots() {
    slots[3] = true;
    slots[4] = true;
    slots[9] = true;
  }

  private boolean[] getSlots() {
    occupiedSlots();
    return slots;
  }

  String parkingState() {
    String state = "";
    for (int i = 0; i < PARKING_SIZE; i++) {
      if (getSlots()[i]) {
        state = state.concat("Occupied slot : № " + (i + 1) + "\n");
      }
    }
    if (state.isEmpty()) {
      state = state.concat("All slots are free\n");
    }
    return state;
  }

  private void carMovesToFreeParkingSlot() throws InterruptedException {
    int arrivedCars = 1;
    for (int numberSlot = 0; numberSlot < PARKING_SIZE; numberSlot++) {
      if (!getSlots()[numberSlot]) {
        getSlots()[numberSlot] = true;
        System.out.println(String.format("   Car moves to slot №%d", numberSlot + 1));
        TimeUnit.SECONDS.sleep(2);
        arrivedCars++;
      } else {
        System.out.println(String.format("  --- Slot №%d is reserved", numberSlot + 1));
      }
    }
    System.out.println("\n ALL SLOTS ARE RESERVED \n");

    carLeavesParkingIfNoFreeSlots(arrivedCars);
  }

  private void carLeavesParkingIfNoFreeSlots(int arrivedCars) throws InterruptedException {
    for (int i = arrivedCars; i <= CarThread.NUMBER_CARS; i++) {
      System.out.println(String.format("   Car №%d left parking ", i));
      TimeUnit.SECONDS.sleep(4);
    }
  }

  @Override
  public void run() {
    try {
      carMovesToFreeParkingSlot();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
