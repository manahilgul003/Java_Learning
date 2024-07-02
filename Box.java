public class Box<T> {
    private T content;

    public void setContent(T content) {
        this.content = content;
    }

    public T getContent() {
        return content;
    }
}

// Using the generic class
public class Main {
    public static void main(String[] args) {
        Box<Integer> intBox = new Box<>();
        intBox.setContent(123);
        System.out.println("Integer Value: " + intBox.getContent());

        Box<String> strBox = new Box<>();
        strBox.setContent("Hello Generics");
        System.out.println("String Value: " + strBox.getContent());
    }
}
