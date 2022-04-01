package lab01.tdd;

public class EqualStrategy implements SelectStrategy{

    private final CircularList circularList;
    private int checkedElements;

    public EqualStrategy(CircularList circularList){
        this.circularList = circularList;
    }

    @Override
    public boolean apply(int element) {
        while(checkedElements != circularList.size()){
            if(listContainsEl(element) == true){
                return true;
            }
            checkedElements++;
        }
        return false;
    }

    private boolean listContainsEl(int element) {
        return circularList.next().get() == element;
    }
}
