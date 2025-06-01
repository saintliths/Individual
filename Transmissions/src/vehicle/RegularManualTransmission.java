package vehicle;

/**
 * This class represents regular manual transmission for a vehicle.
 */
public class RegularManualTransmission implements ManualTransmission {
  private final String status;
  private final int speed;
  private final Gear gear;
  private final int l1;
  private final int h1;
  private final int l2;
  private final int h2;
  private final int l3;
  private final int h3;
  private final int l4;
  private final int h4;
  private final int l5;
  private final int h5;


  /**
   * Constructs a RegularManualTransmission object.
   *
   * @param l1 the low bound for gear 1
   * @param h1 the high bound for gear 1
   * @param l2 the low bound for gear 2
   * @param h2 the high bound for gear 2
   * @param l3 the low bound for gear 3
   * @param h3 the high bound for gear 3
   * @param l4 the low bound for gear 4
   * @param h4 the high bound for gear 4
   * @param l5 the low bound for gear 5
   * @param h5 the high bound for gear 5
   */
  public RegularManualTransmission(int l1, int h1, int l2, int h2, int l3,
                                   int h3, int l4, int h4, int l5, int h5)
          throws IllegalArgumentException {
    this.status = "OK: everything is OK.";
    this.speed = 0;
    this.gear = Gear.GEAR1;
    if (l1 == 0 && l1 < h1 && l1 < l2) {
      this.l1 = l1;
      this.h1 = h1;
    } else {
      throw new IllegalArgumentException();
    }
    if (l2 < h2 && l2 < l3 && l2 <= h1) {
      this.l2 = l2;
      this.h2 = h2;
    } else {
      throw new IllegalArgumentException();
    }
    if (l3 < h3 && l3 < l4 && l3 <= h2 && l3 > h1) {
      this.l3 = l3;
      this.h3 = h3;
    } else {
      throw new IllegalArgumentException();
    }
    if (l4 < h4 && l4 < l5 && l4 <= h3 && l4 > h2) {
      this.l4 = l4;
      this.h4 = h4;
    } else {
      throw new IllegalArgumentException();
    }
    if (l5 <= h5 && l5 <= h4 && l5 > h3) {
      this.l5 = l5;
      this.h5 = h5;
    } else {
      throw new IllegalArgumentException();
    }

  }

  /**
   * Private constructor that constructs a new RegularManualTransmission object.
   *
   * @param status the current status of the object
   * @param speed  the current speed of the object
   * @param gear   the current gear of the object
   * @param l1     the low bound for gear 1
   * @param h1     the high bound for gear 1
   * @param l2     the low bound for gear 2
   * @param h2     the high bound for gear 2
   * @param l3     the low bound for gear 3
   * @param h3     the high bound for gear 3
   * @param l4     the low bound for gear 4
   * @param h4     the high bound for gear 4
   * @param l5     the low bound for gear 5
   * @param h5     the high bound for gear 5
   */
  private RegularManualTransmission(String status, int speed, Gear gear,
                                    int l1, int h1, int l2, int h2, int l3,
                                    int h3, int l4, int h4, int l5, int h5) {
    this.status = status;
    this.speed = speed;
    this.gear = gear;
    this.l1 = l1;
    this.h1 = h1;
    this.l2 = l2;
    this.h2 = h2;
    this.l3 = l3;
    this.h3 = h3;
    this.l4 = l4;
    this.h4 = h4;
    this.l5 = l5;
    this.h5 = h5;
  }

  /**
   * This enum class represents a gear.
   */
  enum Gear {
    GEAR1(1),
    GEAR2(2),
    GEAR3(3),
    GEAR4(4),
    GEAR5(5);

    private final int gearNum;

    /**
     * Constructs a Gear object.
     *
     * @param gearNum the number of the gear
     */
    Gear(int gearNum) {
      this.gearNum = gearNum;
    }
  }

  /**
   * Returns the status of this transmission as a string.
   *
   * @return a string representing the status
   */
  public String getStatus() {
    return this.status;
  }

  /**
   * Get the current speed of the vehicle as a whole number.
   *
   * @return an integer greater than zero representing the speed
   */
  public int getSpeed() {
    return this.speed;
  }

  /**
   * Get the current gear of the vehicle as a whole number.
   *
   * @return an integer greater than zero representing the gear
   */
  public int getGear() {
    return this.gear.gearNum;
  }


  /**
   * Increase the speed by a fixed amount without changing the gear.
   * If the speed cannot be increased, then it should return
   * an object with the same speed as before.
   *
   * @return a new Transmission object with the updated speed
   */
  public ManualTransmission increaseSpeed() {
    int newSpeed = this.speed;
    String newStatus = this.status;

    switch (this.gear) {
      case GEAR1:
        if (this.speed + 1 > h1) {
          newStatus = "Cannot increase speed, increase gear first.";
        } else if (this.speed + 1 <= h1 && this.speed + 1 >= l2) {
          newSpeed += 1;
          newStatus = "OK: you may increase the gear.";
        } else {
          newSpeed += 1;
          newStatus = "OK: everything is OK.";
        }
        break;
      case GEAR2:
        if (this.speed + 1 > this.h2) {
          newStatus = "Cannot increase speed, increase gear first.";
        } else if (this.speed + 1 <= this.h2 && this.speed + 1 >= this.l3) {
          newSpeed += 1;
          newStatus = "OK: you may increase the gear.";
        } else {
          newSpeed += 1;
          newStatus = "OK: everything is OK.";
        }
        break;
      case GEAR3:
        if (this.speed + 1 > this.h3) {
          newStatus = "Cannot increase speed, increase gear first.";
        } else if (this.speed + 1 <= this.h3 && this.speed + 1 >= this.l4) {
          newSpeed += 1;
          newStatus = "OK: you may increase the gear.";
        } else {
          newSpeed += 1;
          newStatus = "OK: everything is OK.";
        }
        break;
      case GEAR4:
        if (this.speed + 1 > this.h4) {
          newStatus = "Cannot increase speed, increase gear first.";
        } else if (this.speed + 1 <= this.h4 && this.speed + 1 >= this.l5) {
          newSpeed += 1;
          newStatus = "OK: you may increase the gear.";
        } else {
          newSpeed += 1;
          newStatus = "OK: everything is OK.";
        }
        break;
      case GEAR5:
        if (this.speed + 1 > this.h5) {
          newStatus = "Cannot increase speed. Reached maximum speed.";
        } else if (this.speed + 1 <= this.h5) {
          newSpeed += 1;
          newStatus = "OK: everything is OK.";
        }
        break;
      default:
        // the method doesn't run if it's not one of the five gears
    }

    return new RegularManualTransmission(newStatus, newSpeed, this.gear,
            l1, h1, l2, h2, l3, h3, l4, h4, l5, h5);
  }

  /**
   * Decrease the speed by a fixed amount without changing the gear.
   * If the speed cannot be decreased, then it should return
   * an object with the same speed as before.
   *
   * @return a new Transmission object with the updated speed
   */
  public ManualTransmission decreaseSpeed() {
    int newSpeed = this.speed;
    String newStatus = this.status;

    switch (this.gear) {
      case GEAR1:
        if (this.speed - 1 < this.l1) {
          newStatus = "Cannot decrease speed. Reached minimum speed.";
        } else if (this.speed - 1 >= this.l1) {
          newSpeed -= 1;
          newStatus = "OK: everything is OK.";
        }
        break;
      case GEAR2:
        if (this.speed - 1 < l2) {
          newStatus = "Cannot decrease speed, decrease gear first.";
        } else if (this.speed - 1 >= l2 && this.speed - 1 <= h1) {
          newSpeed -= 1;
          newStatus = "OK: you may decrease the gear.";
        } else {
          newSpeed -= 1;
          newStatus = "OK: everything is OK.";
        }
        break;
      case GEAR3:
        if (this.speed - 1 < this.l3) {
          newStatus = "Cannot decrease speed, decrease gear first.";
        } else if (this.speed - 1 >= this.l3 && this.speed - 1 <= this.h2) {
          newSpeed -= 1;
          newStatus = "OK: you may decrease the gear.";
        } else {
          newSpeed -= 1;
          newStatus = "OK: everything is OK.";
        }
        break;
      case GEAR4:
        if (this.speed - 1 < this.l4) {
          newStatus = "Cannot decrease speed, decrease gear first.";
        } else if (this.speed - 1 >= this.l4 && this.speed - 1 <= this.h3) {
          newSpeed -= 1;
          newStatus = "OK: you may decrease the gear.";
        } else {
          newSpeed -= 1;
          newStatus = "OK: everything is OK.";
        }
        break;
      case GEAR5:
        if (this.speed - 1 < this.l5) {
          newStatus = "Cannot decrease speed, decrease gear first.";
        } else if (this.speed - 1 >= this.l5 && this.speed - 1 <= this.h4) {
          newSpeed -= 1;
          newStatus = "OK: you may decrease the gear.";
        } else {
          newSpeed -= 1;
          newStatus = "OK: everything is OK.";
        }
        break;
      default:
        // the method doesn't run if it's not one of the five gears
    }

    return new RegularManualTransmission(newStatus, newSpeed, this.gear,
            l1, h1, l2, h2, l3, h3, l4, h4, l5, h5);
  }

  /**
   * Increase the gear by one without changing the speed.
   * If the gear cannot be increased, then it should return
   * an object with the same gear as before.
   *
   * @return a new Transmission object with the updated gear
   */
  public ManualTransmission increaseGear() {
    Gear newGear = this.gear;
    String newStatus = this.status;

    switch (this.gear) {
      case GEAR1:
        if (this.speed < this.l2) {
          newStatus = "Cannot increase gear, increase speed first.";
        } else {
          newGear = Gear.GEAR2;
          newStatus = "OK: everything is OK.";
        }
        break;
      case GEAR2:
        if (this.speed < this.l3) {
          newStatus = "Cannot increase gear, increase speed first.";
        } else {
          newGear = Gear.GEAR3;
          newStatus = "OK: everything is OK.";
        }
        break;
      case GEAR3:
        if (this.speed < this.l4) {
          newStatus = "Cannot increase gear, increase speed first.";
        } else {
          newGear = Gear.GEAR4;
          newStatus = "OK: everything is OK.";
        }
        break;
      case GEAR4:
        if (this.speed < this.l5) {
          newStatus = "Cannot increase gear, increase speed first.";
        } else {
          newGear = Gear.GEAR5;
          newStatus = "OK: everything is OK.";
        }
        break;
      case GEAR5:
        newStatus = "Cannot increase gear. Reached maximum gear.";
        break;
      default:
        // the method doesn't run if it's not one of the five gears
    }

    return new RegularManualTransmission(newStatus, this.speed, newGear,
            l1, h1, l2, h2, l3, h3, l4, h4, l5, h5);
  }

  /**
   * Decrease the gear by one without changing the speed.
   * If the gear cannot be decreased, then it should return
   * an object with the same gear as before.
   *
   * @return a new Transmission object with the updated gear
   */
  public ManualTransmission decreaseGear() {
    Gear newGear = this.gear;
    String newStatus = this.status;

    switch (this.gear) {
      case GEAR1:
        newStatus = "Cannot decrease gear. Reached minimum gear.";
        break;
      case GEAR2:
        if (this.speed > this.h1) {
          newStatus = "Cannot decrease gear, decrease speed first.";
        } else {
          newGear = Gear.GEAR1;
          newStatus = "OK: everything is OK.";
        }
        break;
      case GEAR3:
        if (this.speed > this.h2) {
          newStatus = "Cannot decrease gear, decrease speed first.";
        } else {
          newGear = Gear.GEAR2;
          newStatus = "OK: everything is OK.";
        }
        break;
      case GEAR4:
        if (this.speed > this.h3) {
          newStatus = "Cannot decrease gear, decrease speed first.";
        } else {
          newGear = Gear.GEAR3;
          newStatus = "OK: everything is OK.";
        }
        break;
      case GEAR5:
        if (this.speed > this.h4) {
          newStatus = "Cannot decrease gear, decrease speed first.";
        } else {
          newGear = Gear.GEAR4;
          newStatus = "OK: everything is OK.";
        }
        break;
      default:
        // the method doesn't run if it's not one of the five gears
    }
    return new RegularManualTransmission(newStatus, this.speed, newGear,
            l1, h1, l2, h2, l3, h3, l4, h4, l5, h5);
  }
}
