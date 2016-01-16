
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Zadanie2 extends JFrame implements ActionListener {

    List<Person> ludzie = new ArrayList<Person>();
    private JMenuBar menuBar;
    private JMenu menuFile, menuAbout;
    private JMenuItem itemExit, itemAboutProgram;
    private JLabel lText, lWoj, lMias, lUli, lNrD;
    private JButton bAdd;
    private JTextArea taBook;
    private JTextField tWoj, tMias, tUli, tNrD;
    private String s = "";

    public Zadanie2() {

        setBounds(500, 100, 800, 800);
        setTitle("Zadanie1");
        setLayout(null);
        menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        menuFile = new JMenu("File");
        menuBar.add(menuFile);

        menuAbout = new JMenu("About");
        menuBar.add(menuAbout);

        itemAboutProgram = new JMenuItem("About program");
        menuAbout.add(itemAboutProgram);
        itemAboutProgram.addActionListener(this);

        menuFile.addSeparator();
        itemExit = new JMenuItem("Exit");
        menuFile.add(itemExit);
        itemExit.addActionListener(this);

        tWoj = new JTextField();
        tWoj.setBounds(100, 100, 80, 30);
        add(tWoj);

        tMias = new JTextField();
        tMias.setBounds(200, 100, 90, 30);
        add(tMias);

        tUli = new JTextField();
        tUli.setBounds(300, 100, 90, 30);
        add(tUli);

        tNrD = new JTextField();
        tNrD.setBounds(400, 100, 90, 30);
        add(tNrD);

        lWoj = new JLabel("Wojewodztwo");
        lWoj.setBounds(100, 75, 90, 30);
        add(lWoj);

        lMias = new JLabel("Miasto");
        lMias.setBounds(200, 75, 90, 30);
        add(lMias);

        lUli = new JLabel("Ulica");
        lUli.setBounds(300, 75, 90, 30);
        add(lUli);

        lNrD = new JLabel("Nr domu");
        lNrD.setBounds(400, 75, 90, 30);
        add(lNrD);

        bAdd = new JButton("Dodaj");
        bAdd.setBounds(500, 100, 90, 30);
        add(bAdd);
        bAdd.addActionListener(this);

        taBook = new JTextArea(20, 15);
        taBook.setEditable(false);
        add(taBook);

        JScrollPane scroll = new JScrollPane(taBook);
        scroll.setBounds(150, 300, 400, 300);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        add(scroll);

        lText = new JLabel("Posortowana ksiazka adresowa");
        lText.setBounds(150, 270, 200, 40);
        add(lText);

    }

    private void addPerson() {
        if (!tWoj.getText().equals("") && !tMias.getText().equals("") && !tUli.getText().equals("") && !tNrD.getText().equals("")) {
            ludzie.add(new Person(tWoj.getText(), tMias.getText(), tUli.getText(), tNrD.getText()));
            Collections.sort(ludzie);
            s = "";
            for (Person person : ludzie) {
                s = s + person.getAdres() + "\n";
            }
            taBook.setText(s);
            tWoj.setText("");
            tMias.setText("");
            tUli.setText("");
            tNrD.setText("");
        }

    }

    public static void main(String[] args) {
        Zadanie2 okno = new Zadanie2();
        okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        okno.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == itemExit) {
            dispose();
        } else if (source == itemAboutProgram) {
            JOptionPane.showMessageDialog(this, "Program sortuje ksiazke adresowa\nPaweł Grzmil");
        } else if (source == bAdd) {
            addPerson();
        }
    }

}
