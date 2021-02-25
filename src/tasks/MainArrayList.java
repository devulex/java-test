package tasks;

public class MainArrayList {
    private int size;
    private Object[] elementData;

    public Object add(Object element) {
        if (elementData.length == size) {
            size = size * 3 / 2 + 1;
            Object[] newElementData = new Object[size];
            System.arraycopy(elementData, 0, newElementData, 0, elementData.length);
            elementData = newElementData;
        }
        elementData[elementData.length] = element;
        return element;
    }
}
