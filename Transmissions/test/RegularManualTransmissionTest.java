import org.junit.Before;
import org.junit.Test;

import vehicle.ManualTransmission;
import vehicle.RegularManualTransmission;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * This represents a test class for RegularManualTransmission.
 */
public class RegularManualTransmissionTest {
  private ManualTransmission rmt1;

  @Before
  public void setUpTestFixture() {

    rmt1 = new RegularManualTransmission(0, 3, 2, 5, 4, 7,
            6, 9, 8, 11);
  }


  @Test
  public void testValidTransmission() {
    try {
      ManualTransmission validRmt1 = new RegularManualTransmission(0, 10, 8, 13,
              12, 17, 15, 25, 24, 30);
      ManualTransmission validRmt2 = new RegularManualTransmission(0, 30, 20, 50,
              40, 70, 60, 100, 100, 100);
    } catch (IllegalArgumentException e) {
      fail("No IllegalArgumentException should be thrown");
    }
  }

  @Test
  public void testInvalidTransmissions() {
    try {
      ManualTransmission invalidRmt1 = new RegularManualTransmission(0, 3, 4, 7,
              6, 9, 8, 10, 10, 10); // gap in ranges
      fail("IllegalArgumentException expected");
      ManualTransmission invalidRmt2 = new RegularManualTransmission(0, 10, 10,
              20, 5, 30, 30, 40, 40, 50); // non-adjacent overlap
      fail("IllegalArgumentException expected");
      ManualTransmission invalidRmt3 = new RegularManualTransmission(-10, 10, 10, 20,
              20, 30, 30, 40, 40, 50); // negative speed
      fail("IllegalArgumentException expected");
      ManualTransmission invalidRmt4 = new RegularManualTransmission(0, 20, 5, 10,
              10, 30, 30, 40, 40, 50); // gear within gear
      fail("IllegalArgumentException expected");
    } catch (IllegalArgumentException e) {
      // passes
    }
  }


  @Test
  public void testGetStatus() {
    this.setUpTestFixture();
    assertEquals("OK: everything is OK.", rmt1.getStatus());

    ManualTransmission rmt2 = rmt1.increaseSpeed();
    ManualTransmission rmt3 = rmt2.increaseSpeed();

    assertEquals("OK: you may increase the gear.", rmt3.getStatus());

    ManualTransmission rmt4 = rmt3.increaseSpeed();

    assertEquals("OK: you may increase the gear.", rmt4.getStatus());

    ManualTransmission rmt5 = rmt4.increaseSpeed();

    assertEquals("Cannot increase speed, increase gear first.", rmt5.getStatus());

    ManualTransmission rmt6 = rmt5.increaseGear();

    assertEquals("OK: everything is OK.", rmt6.getStatus());

    assertEquals(3, rmt6.getSpeed());

    ManualTransmission rmt7 = rmt6.increaseGear();

    assertEquals("Cannot increase gear, increase speed first.",
            rmt7.getStatus());

    ManualTransmission rmt8 = rmt7.increaseSpeed();

    assertEquals(4, rmt8.getSpeed());

    ManualTransmission rmt9 = rmt8.increaseSpeed();
    ManualTransmission rmt10 = rmt9.increaseGear();

    assertEquals(3, rmt10.getGear());
    assertEquals(5, rmt10.getSpeed());
    assertEquals("OK: everything is OK.",
            rmt10.getStatus());

    ManualTransmission rmt11 = rmt10.increaseSpeed();
    ManualTransmission rmt12 = rmt11.increaseGear();

    assertEquals(4, rmt12.getGear());
    assertEquals(6, rmt12.getSpeed());

    ManualTransmission rmt13 = rmt12.increaseSpeed();
    ManualTransmission rmt14 = rmt13.increaseSpeed();
    ManualTransmission rmt15 = rmt14.increaseGear();

    assertEquals(5, rmt15.getGear());
    assertEquals(8, rmt15.getSpeed());

    ManualTransmission rmt16 = rmt15.increaseSpeed();
    ManualTransmission rmt17 = rmt16.increaseSpeed();
    ManualTransmission rmt18 = rmt17.increaseSpeed();

    assertEquals("OK: everything is OK.",
            rmt18.getStatus());
    assertEquals(11, rmt18.getSpeed());

    ManualTransmission rmt19 = rmt18.increaseSpeed();

    assertEquals("Cannot increase speed. Reached maximum speed.",
            rmt19.getStatus());

    ManualTransmission rmt20 = rmt19.increaseGear();

    assertEquals("Cannot increase gear. Reached maximum gear.",
            rmt20.getStatus());

    ManualTransmission rmt21 = rmt20.decreaseGear();

    assertEquals("Cannot decrease gear, decrease speed first.",
            rmt21.getStatus());
  }


  @Test
  public void testGetSpeed() {
    this.setUpTestFixture();
    assertEquals(0, rmt1.getSpeed());

    ManualTransmission rmt2 = rmt1.increaseSpeed();
    ManualTransmission rmt3 = rmt2.increaseSpeed();
    ManualTransmission rmt4 = rmt3.increaseSpeed();

    assertEquals(3, rmt4.getSpeed());

    ManualTransmission rmt5 = rmt4.increaseSpeed();

    assertEquals(3, rmt5.getSpeed());

    ManualTransmission rmt6 = rmt5.decreaseSpeed();

    assertEquals(2, rmt6.getSpeed());

    ManualTransmission rmt7 = rmt6.increaseGear();
    ManualTransmission rmt8 = rmt7.increaseSpeed();
    ManualTransmission rmt9 = rmt8.increaseSpeed();
    ManualTransmission rmt10 = rmt9.increaseSpeed();

    assertEquals(5, rmt10.getSpeed());
    assertEquals(2, rmt10.getGear());
  }


  @Test
  public void testGetGear() {
    this.setUpTestFixture();
    assertEquals(1, rmt1.getGear());

    ManualTransmission rmt2 = rmt1.increaseSpeed();
    ManualTransmission rmt3 = rmt2.increaseSpeed();

    assertEquals(2, rmt3.getSpeed());
    assertEquals(1, rmt3.getGear());

    ManualTransmission rmt4 = rmt3.increaseSpeed();
    ManualTransmission rmt5 = rmt4.increaseSpeed();

    assertEquals(3, rmt5.getSpeed());
    assertEquals(1, rmt5.getGear());

    ManualTransmission rmt6 = rmt5.increaseGear();

    assertEquals(2, rmt6.getGear());
    assertEquals(3, rmt6.getSpeed());
  }


  @Test
  public void testIncreaseSpeed() {
    this.setUpTestFixture();
    ManualTransmission rmt2 = rmt1.increaseSpeed();

    assertEquals(1, rmt2.getSpeed());

    ManualTransmission rmt3 = rmt2.increaseSpeed();
    ManualTransmission rmt4 = rmt3.increaseSpeed();

    assertEquals(3, rmt4.getSpeed());

    ManualTransmission rmt5 = rmt4.increaseSpeed();

    assertEquals(3, rmt5.getSpeed());
    assertEquals("Cannot increase speed, increase gear first.",
            rmt5.getStatus());

    ManualTransmission rmt6 = rmt5.increaseGear();

    assertEquals(3, rmt6.getSpeed());

    ManualTransmission rmt7 = rmt6.increaseSpeed();

    assertEquals(4, rmt7.getSpeed());
    assertEquals(2, rmt7.getGear());
    assertEquals("OK: you may increase the gear.",
            rmt7.getStatus());
  }

  @Test
  public void testDecreaseSpeed() {
    this.setUpTestFixture();
    ManualTransmission rmt2 = rmt1.decreaseSpeed();

    assertEquals(0, rmt2.getSpeed());
    assertEquals("Cannot decrease speed. Reached minimum speed.", rmt2.getStatus());

    ManualTransmission rmt3 = rmt2.increaseSpeed();
    ManualTransmission rmt4 = rmt3.increaseSpeed();

    assertEquals(2, rmt4.getSpeed());

    ManualTransmission rmt5 = rmt4.decreaseSpeed();

    assertEquals(1, rmt5.getSpeed());
    assertEquals("OK: everything is OK.", rmt1.getStatus());

    ManualTransmission rmt6 = rmt5.increaseSpeed();
    ManualTransmission rmt7 = rmt6.increaseGear();
    ManualTransmission rmt8 = rmt7.increaseSpeed();

    assertEquals(3, rmt8.getSpeed());
    assertEquals(2, rmt8.getGear());

    ManualTransmission rmt9 = rmt8.decreaseSpeed();
    ManualTransmission rmt10 = rmt9.decreaseSpeed();

    assertEquals("Cannot decrease speed, decrease gear first.",
            rmt10.getStatus());
  }

  @Test
  public void testIncreaseGear() {
    this.setUpTestFixture();
    ManualTransmission rmt2 = rmt1.increaseGear();

    assertEquals(1, rmt2.getGear());
    assertEquals(0, rmt2.getSpeed());

    assertEquals("Cannot increase gear, increase speed first.",
            rmt2.getStatus());

    ManualTransmission rmt3 = rmt2.increaseSpeed();
    ManualTransmission rmt4 = rmt3.increaseSpeed();
    ManualTransmission rmt5 = rmt4.increaseGear();

    assertEquals(2, rmt5.getGear());
    assertEquals("OK: everything is OK.",
            rmt5.getStatus());
  }

  @Test
  public void testDecreaseGear() {
    this.setUpTestFixture();
    ManualTransmission rmt2 = rmt1.decreaseGear();

    assertEquals(1, rmt2.getGear());
    assertEquals("Cannot decrease gear. Reached minimum gear.",
            rmt2.getStatus());

    ManualTransmission rmt3 = rmt2.increaseSpeed();
    ManualTransmission rmt4 = rmt3.increaseSpeed();
    ManualTransmission rmt5 = rmt4.increaseGear();
    ManualTransmission rmt6 = rmt5.increaseSpeed();
    ManualTransmission rmt7 = rmt6.increaseSpeed();
    ManualTransmission rmt8 = rmt7.decreaseGear();

    assertEquals(2, rmt8.getGear());
    assertEquals(4, rmt8.getSpeed());
    assertEquals("Cannot decrease gear, decrease speed first.",
            rmt8.getStatus());

    ManualTransmission rmt9 = rmt8.decreaseSpeed();

    assertEquals("OK: you may decrease the gear.", rmt9.getStatus());
    assertEquals(3, rmt9.getSpeed());

    ManualTransmission rmt10 = rmt9.decreaseGear();

    assertEquals(1, rmt10.getGear());
    assertEquals("OK: everything is OK.",
            rmt10.getStatus());
  }
}