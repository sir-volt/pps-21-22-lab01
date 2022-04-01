package lab01.tdd;

import java.util.Optional;

public class EvenStrategy implements SelectStrategy{

    private final CircularList elements;

    public EvenStrategy(CircularList elements){
        this.elements = elements;
    }


    @Override
    public boolean apply(int element) {
        return getEvenNext() == element;
    }

    private int getEvenNext() {
        while(true){
            int currentEl = elements.next().get();
            if(currentEl % 2 == 0){
                return currentEl;
            }
        }
    }
}
