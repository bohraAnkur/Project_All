package q4;

public interface PBT<N> {

  public static <X> PBT<X> create(X value){
    return new PBTHead<>(value);
  }

  public Integer edgesToRoot(N value);

  public void add(N value);

  public void remove(N value);

}
