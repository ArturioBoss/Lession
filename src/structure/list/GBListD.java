package structure.list;

public interface GBListD extends GBIterableD{
//    void add(int key, String val);
    void add(String val);
    boolean remove(String val);
    int size();
    String get(int index);

}
