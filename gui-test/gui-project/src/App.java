import javax.swing.*;


public class App {
    public static void main(String[] args) throws Exception {
        JFrame frame = new JFrame("App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setVisible(true);


        JButton button = new JButton();
        button.addActionListener(click -> {
            System.out.println("Button clicked");
        });


        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("File");
        JMenu subMenu = new JMenu("Sub Menu");
        JMenuItem menuItem = new JMenuItem("New");
        JMenuItem menuItem2 = new JMenuItem("Open");
        JMenuItem menuItem3 = new JMenuItem("Save");
        JMenuItem menuItem4 = new JMenuItem("Exit");
        
        menuBar.add(menu);
        menu.add(menuItem);
        menu.add(menuItem2);
        menu.add(menuItem3);
        menu.add(subMenu);
        subMenu.add(menuItem4);
        
        JMenu menu2 = new JMenu("Edit");
        JMenu subMenu2 = new JMenu("Sub Menu");
        JMenuItem menuItem5 = new JMenuItem("Cut");
        JMenuItem menuItem6 = new JMenuItem("Copy");
        JMenuItem menuItem7 = new JMenuItem("Paste");
        JMenuItem menuItem8 = new JMenuItem("Delete");

        menuBar.add(menu2);
        menu2.add(menuItem5);
        menu2.add(menuItem6);
        menu2.add(menuItem7);
        menu2.add(subMenu2);
        subMenu2.add(menuItem8);
        

        frame.setJMenuBar(menuBar);
    }
}
