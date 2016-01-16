
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Zadanie1 extends JFrame implements ActionListener {

    private JMenuBar menuBar;
    private JMenu menuFile, menuAbout;
    private JMenuItem itemOpen, itemSave, itemExit, itemAboutProgram;
    private JLabel lText, lChars;
    private JButton bOpen, bSave;
    private JTextArea taText, taChars;
    private String filePath = "";
    private Map<String, Integer> map = new HashMap<String, Integer>();

    public Zadanie1() {
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

        itemOpen = new JMenuItem("Open");
        menuFile.add(itemOpen);
        itemOpen.addActionListener(this);

        itemSave = new JMenuItem("Save as");
        menuFile.add(itemSave);
        itemSave.addActionListener(this);

        menuFile.addSeparator();
        itemExit = new JMenuItem("Exit");
        menuFile.add(itemExit);
        itemExit.addActionListener(this);

        taText = new JTextArea(25, 1);
        taText.setEditable(false);
        add(taText);

        JScrollPane scroll = new JScrollPane(taText);
        scroll.setBounds(75, 100, 350, 350);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        add(scroll);

        taChars = new JTextArea(25, 15);
        taChars.setEditable(false);
        add(taChars);

        JScrollPane scrollChars = new JScrollPane(taChars);
        scrollChars.setBounds(500, 100, 200, 350);
        scrollChars.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        add(scrollChars);

        lText = new JLabel("Pobrany tekst");
        lText.setBounds(75, 70, 200, 40);
        add(lText);

        bOpen = new JButton("Otwórz tekst");
        bOpen.setBounds(175, 470, 150, 50);
        add(bOpen);
        bOpen.addActionListener(this);

        lChars = new JLabel("Częstotliwość znaków");
        lChars.setBounds(500, 70, 200, 40);
        add(lChars);

        bSave = new JButton("Zapisz dane");
        bSave.setBounds(520, 470, 150, 50);
        add(bSave);
        bSave.addActionListener(this);
    }

    public void displayCounts() {
        taChars.setText("Znak  Ilość");
        if (map.get("\n") != null) {
            taChars.setText(taChars.getText() + "\n(enter) - " + map.get("\n").toString());
        }
        if (map.get(" ") != null) {
            taChars.setText(taChars.getText() + "\n(spacja) - " + map.get(" ").toString());

        }
        String s = "";
        for (int i = 33; i < 127; i++) {
            s = Character.toString((char) i);
            if (map.get(s) != null) {
                taChars.setText(taChars.getText() + "\n' " + s + " ' - " + map.get(s));

            }
        }
        map.clear();
    }

    public void count() {
        taChars.setText("");
        String s = taText.getText();
        String symbol;
        for (int i = 0; i < s.length(); i++) {
            symbol = s.substring(i, i + 1);
            if (map.get(symbol) == null) {
                map.put(symbol, 1);
            } else {
                map.put(symbol, map.get(symbol) + 1);
            }
        }
        displayCounts();

    }

    public void saveFile() {
        try {
            FileWriter file = new FileWriter(filePath);
            file.write(taChars.getText());
            file.close();

        } catch (Exception e) {
        }
    }

    public void openFile() {
        taText.setText("");
        try {
            BufferedReader file = new BufferedReader(new FileReader(filePath));
            String line = file.readLine();
            while (line != null) {
                if (taText.getText().equals("")) {
                    taText.setText(taText.getText() + line);
                } else {
                    taText.setText(taText.getText() + "\n" + line);
                }

                line = file.readLine();
            }
            file.close();
        } catch (Exception e) {
        }
        count();
    }

    public void getSavePath() {
        JFileChooser fc = new JFileChooser();
        if (fc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            File plik = fc.getSelectedFile();
            filePath = plik.getPath();
            saveFile();
        }
    }

    public void getOpenPath() {
        JFileChooser fc = new JFileChooser();
        if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            File plik = fc.getSelectedFile();
            filePath = plik.getAbsolutePath();
            openFile();
        }

    }

    public static void main(String[] args) {
        Zadanie1 okno = new Zadanie1();
        okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        okno.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == itemExit) {
            dispose();
        } else if (source == itemAboutProgram) {
            JOptionPane.showMessageDialog(this, "Program sprawdza liczbę znaków\nPaweł Grzmil");
        } else if (source == itemOpen || source == bOpen) {
            getOpenPath();
        } else if (source == itemSave || source == bSave) {
            getSavePath();
        }
    }

}
