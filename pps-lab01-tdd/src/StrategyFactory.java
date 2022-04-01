import lab01.tdd.CircularList;
import lab01.tdd.SelectStrategy;

public interface StrategyFactory {

    SelectStrategy getEvenStrategy(CircularList circularList);

    SelectStrategy getMultipleOfStrategy(CircularList circularList);

    SelectStrategy getEqualStrategy(CircularList circularList);
}
