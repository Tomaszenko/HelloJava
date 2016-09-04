import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by tomko_2 on 2016-08-25.
 */
public class FixedSizeList<T> extends ArrayList<T> {

    private int maxSize;

    public boolean add(T o) {

        if(getCurrentSize()>=maxSize) {
            return false;
        } else {
            super.add(o);
            return true;
        }
    }

    public FixedSizeList(List<T> l) {
        super(l);
        maxSize=l.size();
    }

    public FixedSizeList(int size) {
        super(size);
        maxSize=size;
    }

    public int getCurrentSize() {
        return super.size();
    }
}
