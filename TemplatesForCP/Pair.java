import java.util.Objects;

public class Test{
    public static void main(String[] args) {
        Pair<Integer, Integer> pair = Pair.makePair(5,10);
        System.out.println(pair);  //(5, 10)
        Pair<Integer, Integer> pair1 = Pair.makePair(5,10);
        System.out.println(pair1.swap());  //(10, 5)
        System.out.println(pair.equals(pair1));  //true
    }
}

class Pair<U, V> implements Comparable<Pair<U, V>> {
    private final U first;
    private final V second;

    public static <U, V> Pair<U, V> makePair(U first, V second) {
        return new Pair<U, V>(first, second);
    }

    private Pair(U first, V second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Pair pair = (Pair) o;

        return !(!Objects.equals(first, pair.first)) &&
                !(!Objects.equals(second, pair.second));
    }

    @Override
    public int hashCode() {
        int result = first != null ? first.hashCode() : 0;
        result = 31 * result + (second != null ? second.hashCode() : 0);
        return result;
    }

    public Pair<V, U> swap() {
        return makePair(second, first);
    }

    @Override
    public String toString() {
        return "(" + first + "," + second + ")";
    }

    @SuppressWarnings({"unchecked"})
    public int compareTo(Pair<U, V> o) {
        int value = ((Comparable<U>) first).compareTo(o.first);
        if (value != 0) {
            return value;
        }
        return ((Comparable<V>) second).compareTo(o.second);
    }
}
