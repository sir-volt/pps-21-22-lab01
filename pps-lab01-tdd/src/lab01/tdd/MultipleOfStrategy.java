package lab01.tdd;

import lab01.tdd.CircularList;
import lab01.tdd.CircularListImpl;
import lab01.tdd.SelectStrategy;

public class MultipleOfStrategy implements SelectStrategy {

    private final CircularList circularList;
    private int checkedElements = 0;
    private int currentEl = 1;

    public MultipleOfStrategy(CircularList circularList) {
        this.circularList = circularList;
    }

    @Override
    public boolean apply(int element) {
        while(checkedElements != circularList.size()){
            if(checkIfMultiplePresent(element) == true){
                return true;
            }
            checkedElements++;
        }
        return false;
    }

    private boolean checkIfMultiplePresent(int element) {
        return circularList.next().get() % element == 0;
    }
}
