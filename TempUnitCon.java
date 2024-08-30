import java.awt.*;
import java.awt.event.*;

public class TempUnitCon extends Frame implements ActionListener {

    private Choice choice;
    private TextField value;
    private TextField celinput;
    private TextField fahinput;
    private TextField kelinput;

    TempUnitCon() {
        setLayout(null);
        setSize(500, 300);
        setVisible(true);

        Label select = new Label("Select which temperature unit needs conversion:");
        select.setBounds(20, 50, 300, 20);
        choice = new Choice();
        choice.setBounds(320, 50, 100, 30);
        choice.add("Celsius");
        choice.add("Fahrenheit");
        choice.add("Kelvin");

        Label input = new Label("Enter the value:");
        input.setBounds(50, 80, 100, 30);
        value = new TextField();
        value.setBounds(150, 85, 100, 20);

        Button convert = new Button("Convert");
        convert.setBounds(150, 120, 70, 30);
        convert.addActionListener(this);

        Label celsius = new Label("Celsius");
        celsius.setBounds(50, 160, 100, 30);
        celinput = new TextField();
        celinput.setBounds(150, 160, 100, 20);
        celinput.setEditable(false);

        Label fahrenheit = new Label("Fahrenheit");
        fahrenheit.setBounds(50, 190, 100, 30);
        fahinput = new TextField();
        fahinput.setBounds(150, 190, 100, 20);
        fahinput.setEditable(false);

        Label kelvin = new Label("Kelvin");
        kelvin.setBounds(50, 220, 100, 30);
        kelinput = new TextField();
        kelinput.setBounds(150, 220, 100, 20);
        kelinput.setEditable(false);

   
        add(select);
        add(choice);
        add(input);
        add(value);
        add(convert);
        add(celsius);
        add(celinput);
        add(fahrenheit);
        add(fahinput);
        add(kelvin);
        add(kelinput);

    
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    
        double inputValue;
        try {
            inputValue = Double.parseDouble(value.getText());
        } catch (NumberFormatException ex) {
      
            celinput.setText("");
            fahinput.setText("");
            kelinput.setText("");
            return;
        }


        String selectedUnit = choice.getSelectedItem();
        double celsius = 0, fahrenheit = 0, kelvin = 0;

        switch (selectedUnit) {
            case "Celsius":
                celsius = inputValue;
                fahrenheit = celsius * 9 / 5 + 32;
                kelvin = celsius + 273.15;
                break;
            case "Fahrenheit":
                fahrenheit = inputValue;
                celsius = (fahrenheit - 32) * 5 / 9;
                kelvin = celsius + 273.15;
                break;
            case "Kelvin":
                kelvin = inputValue;
                celsius = kelvin - 273.15;
                fahrenheit = celsius * 9 / 5 + 32;
                break;
        }

       
        celinput.setText(String.format("%.2f", celsius));
        fahinput.setText(String.format("%.2f", fahrenheit));
        kelinput.setText(String.format("%.2f", kelvin));
    }

    public static void main(String[] args) {
        new TempUnitCon();
    }
}
