package HelperClasses;

public class Pair<K, V> {

  public K first;
  public V second;

  public Pair(K _first, V _second) {
    first = _first;
    second = _second;
  }

  public K get_first() {
    return first;
  }

  public V get_second() {
    return second;
  }
}
