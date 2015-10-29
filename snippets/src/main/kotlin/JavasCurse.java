import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JavasCurse {

    private static class Coffee {}

    private static class Cup<T> {
        public Cup(T anything) {}
    }

    public static void main(String[] args) {
        Cup<Coffee> cupOfCoffee = new Cup<>(new Coffee());
        // val cupOfCoffee = Cup(Coffee())







        List<String> commands = new ArrayList<>();
        commands.add("ls");
        commands.forEach(s -> {
            try {
                Runtime.getRuntime().exec(s);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        // listOf("ls").forEach { Runtime.getRuntime().exec(it) }

    }

}
