import lab01.tdd.*;

public class StrategyFactoryImpl implements StrategyFactory {
    @Override
    public SelectStrategy getEvenStrategy(CircularList circularList) {
        return new EvenStrategy(circularList);
    }

    @Override
    public SelectStrategy getMultipleOfStrategy(CircularList circularList) {
        return new MultipleOfStrategy(circularList);
    }

    @Override
    public SelectStrategy getEqualStrategy(CircularList circularList) {
        return new EqualStrategy(circularList);
    }
}
