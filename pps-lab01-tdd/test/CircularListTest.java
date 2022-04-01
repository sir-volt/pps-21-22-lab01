import lab01.tdd.*;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {

    private CircularList circularList;
    private StrategyFactory strategyFactory;


    @BeforeEach
    public void beforeEach(){

        circularList = new CircularListImpl();
        strategyFactory = new StrategyFactoryImpl();

    }

    @Test
    public void testSize(){
        assertNotEquals(5,circularList.size());
        circularList.add(4);
        circularList.add(67);
        circularList.add(15);
        assertEquals(3, circularList.size());
    }

    @Test
    public void testIsEmpty(){
        assertTrue(circularList.isEmpty());
        circularList.add(89);
        circularList.add(354);
        assertFalse(circularList.isEmpty());
    }

    @Test
    public void testNext(){
        circularList.add(89);
        circularList.add(354);
        circularList.add(65764);
        circularList.add(-15);
        assertEquals(89,circularList.next().get());
        assertNotEquals(1,circularList.next().get());
        assertNotEquals(6,circularList.next().get());
        assertEquals(-15,circularList.next().get());
        assertEquals(89, circularList.next().get());
    }

    @Test
    public void testPrevious(){
        circularList.add(89);
        circularList.add(354);
        circularList.add(34);
        assertEquals(89,circularList.next().get());
        assertEquals(354,circularList.next().get());
        assertEquals(89,circularList.previous().get());
        assertEquals(34,circularList.previous().get());
    }

    @Test
    public void testReset(){
        circularList.add(89);
        circularList.add(1);
        assertEquals(2,circularList.size());
        circularList.reset();
        assertTrue(circularList.isEmpty());
    }

    @Test
    public void testEvenStrategy(){
        circularList.add(56);
        circularList.add(87);
        circularList.add(50);
        SelectStrategy evenStrategy = strategyFactory.getEvenStrategy(circularList);
        assertTrue(evenStrategy.apply(56));
        assertTrue(evenStrategy.apply(50));
        assertFalse(evenStrategy.apply(87));
        assertFalse(evenStrategy.apply(56));
    }

    @Test
    public void testMultipleOfStrategy(){
        circularList.add(3);
        circularList.add(9);
        circularList.add(10);
        SelectStrategy multipleOfStrategy = strategyFactory.getMultipleOfStrategy(circularList);
        assertTrue(multipleOfStrategy.apply(3));
        assertTrue(multipleOfStrategy.apply(9));
        assertTrue(multipleOfStrategy.apply(2));
        assertFalse(multipleOfStrategy.apply(7));
    }

    @Test
    public void testEqualsStrategy(){
        circularList.add(89);
        circularList.add(354);
        circularList.add(5);
        SelectStrategy equalsStrategy = strategyFactory.getEqualStrategy(circularList);
        assertTrue(equalsStrategy.apply(89));
        assertTrue(equalsStrategy.apply(5));
        assertFalse(equalsStrategy.apply(2));
    }



}
