package lab01.tdd;

import lab01.tdd.CircularList;
import lab01.tdd.SelectStrategy;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CircularListImpl implements CircularList {

    private List<Integer> elements =new ArrayList<>();
    private int iterator = -1;

    @Override
    public void add(int element) {
        elements.add(element);
    }

    @Override
    public int size() {
        return elements.size();
    }

    @Override
    public boolean isEmpty() {
        return elements.isEmpty();
    }

    @Override
    public Optional<Integer> next() {
        checkIfNextLoop();
        return getElement();
    }

    @Override
    public Optional<Integer> previous() {
        checkIfPreviousLoop();
        return getElement();
    }


    @Override
    public void reset() {
        elements.clear();
        iterator = 0;
    }


    private Optional<Integer> getElement(){

        return Optional.of(elements.get(iterator));
    }

    private void checkIfPreviousLoop(){
        if(iterator > 0){
            iterator--;
        } else{
            iterator = elements.size()-1;
        }

    }

    private void checkIfNextLoop(){
        if(iterator != size()-1){
            iterator++;
        } else{
            iterator = 0;
        }
    }

    @Override
    public Optional<Integer> next(SelectStrategy strategy) {
        return null;
    }
}
