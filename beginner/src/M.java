public class M {
    public static void main(String[] args) {
        int w = 20;
        // arrow operator
        Drawable d = () -> {
            System.out.println(" Drawing width is   " + w);
        };
        d.draw();
    }
}