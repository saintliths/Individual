package vehicle;

/**
 * This interface represents a manual transmission for a vehicle.
 */
public interface ManualTransmission {

  /**
   * Returns the status of this transmission as a string.
   *
   * @return a string representing the status
   */
  String getStatus();

  /**
   * Get the current speed of the vehicle as a whole number.
   *
   * @return an integer greater than zero representing the speed
   */
  int getSpeed();

  /**
   * Get the current gear of the vehicle as a whole number.
   *
   * @return an integer greater than zero representing the gear
   */
  int getGear();

  /**
   * Increase the speed by a fixed amount without changing the gear.
   * If the speed cannot be increased, then it should return
   * an object with the same speed as before.
   *
   * @return a new Transmission object with the updated speed
   */
  ManualTransmission increaseSpeed();

  /**
   * Decrease the speed by a fixed amount without changing the gear.
   * If the speed cannot be decreased, then it should return
   * an object with the same speed as before.
   *
   * @return a new Transmission object with the updated speed
   */
  ManualTransmission decreaseSpeed();

  /**
   * Increase the gear by one without changing the speed.
   * If the gear cannot be increased, then it should return
   * an object with the same gear as before.
   *
   * @return a new Transmission object with the updated gear
   */
  ManualTransmission increaseGear();

  /**
   * Decrease the gear by one without changing the speed.
   * If the gear cannot be decreased, then it should return
   * an object with the same gear as before.
   *
   * @return a new Transmission object with the updated gear
   */
  ManualTransmission decreaseGear();

}
