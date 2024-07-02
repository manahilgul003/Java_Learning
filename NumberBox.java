
public class NumberBox<T extends Number> {
    private T number;

    public void setNumber(T number) {
        this.number = number;
    }

    public T getNumber() {
        return number;
    }

    public double doubleValue() {
        return number.doubleValue();
    }
}

// Using the bounded type parameter
public class Main {
    public static void main(String[] args) {
        NumberBox<Integer> intBox = new NumberBox<>();
        intBox.setNumber(10);
        System.out.println("Double Value: " + intBox.doubleValue());

        NumberBox<Double> doubleBox = new NumberBox<>();
        doubleBox.setNumber(10.5);
        System.out.println("Double Value: " + doubleBox.doubleValue());
    }
}

