public class JavasCurse {

    private static class Coffee {}

    private static class Cup<T> {
        public Cup(T anything) {}
    }

    public static void main(String[] args) {
        Cup<Coffee> cupOfCoffee = new Cup<>(new Coffee());
        // val cupOfCoffee = Cup(Coffee())
    }

}
