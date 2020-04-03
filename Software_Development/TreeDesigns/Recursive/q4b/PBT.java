package q4b;


interface PBT<N> {


  static <X> PBT<X> create(X value){
    return new PBTHead<>(value);
  }

  Integer edgesToRoot(N value);

  void add(N value);

  void remove(N value);

}
