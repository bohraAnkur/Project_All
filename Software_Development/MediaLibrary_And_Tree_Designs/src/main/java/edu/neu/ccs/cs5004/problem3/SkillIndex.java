package edu.neu.ccs.cs5004.problem3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * represent a skill index.
 * @param <K> key type
 * @param <V> value type
 */
public class SkillIndex<K, V> {
  private Map<K, ArrayList<V>> map;

  /**
   * constructor for skill index.
   * @param map to be added
   */
  public SkillIndex(Map<K, ArrayList<V>> map) {
    this.map = map;
  }

  /**
   * getter for map.
   * @return map
   */
  public Map<K, ArrayList<V>> getMap() {
    return map;
  }

  /**
   * analyze data to another type of skill index.
   * @return another type of skill index
   */
  public SkillIndex<V, K> analyze() {
    Map<V, ArrayList<K>> dest = new HashMap<>();
    for (Map.Entry entry : map.entrySet()) {
      for (V ele : (ArrayList<V>) entry.getValue()) {
        ArrayList<K> arrayList = new ArrayList<>();

        if (dest.get(ele) != null) {
          arrayList = dest.get(ele);
          arrayList.add((K) entry.getKey());
        } else {
          arrayList.add((K) entry.getKey());
          dest.put(ele, arrayList);
        }
      }
    }

    return new SkillIndex<>(dest);
  }

  @Override
  public String toString() {
    return "SkillIndex{"
        + "map=" + map
        + '}';
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    SkillIndex<?, ?> that = (SkillIndex<?, ?>) obj;
    return Objects.equals(map, that.map);
  }

  @Override
  public int hashCode() {

    return Objects.hash(map);
  }
}


