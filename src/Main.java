import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
                ArrayList<String> colors = new ArrayList<>(Arrays.asList("sex","Black","Black","White", "Green", "Red"));
                boolean contains = colors.contains("Black");
                System.out.println(contains);

                int index = colors.indexOf("Black");
                System.out.println(index);

                System.out.println(colors.get(1));
                index = colors.indexOf("Red");
                System.out.println(index);
            }

}