import javax.swing.*;import java.awt.*;import java.awt.event.*;
public class LambdaConverter extends JFrame {
 private final JTextField amount=new JTextField(10); private final JComboBox<String> target=new JComboBox<>(new String[]{"USD","EUR"}); private final JLabel result=new JLabel(" ");
 private static double rate(String c){return c.equals("USD")?0.012:0.011;}
 public LambdaConverter(){super("Currency Converter – Lambda expression");setLayout(new FlowLayout());JButton convert=new JButton("Convert");add(new JLabel("Amount (INR)"));add(amount);add(target);add(convert);add(result);
 ActionListener handler=e->convert(); convert.addActionListener(handler); amount.addActionListener(handler);
 amount.addActionListener(e->convert());setDefaultCloseOperation(DISPOSE_ON_CLOSE);addWindowListener(new WindowAdapter(){@Override public void windowClosing(WindowEvent e){dispose();}});pack();setLocationRelativeTo(null);}
 private void convert(){try{double n=Double.parseDouble(amount.getText().trim());if(!Double.isFinite(n)||n<0)throw new NumberFormatException();String c=(String)target.getSelectedItem();double v=n*rate(c);result.setText(String.format("%.2f %s",v,c));JOptionPane.showMessageDialog(this,result.getText(),"Conversion result",JOptionPane.INFORMATION_MESSAGE);}catch(NumberFormatException ex){result.setText("Invalid amount");JOptionPane.showMessageDialog(this,"Invalid amount","Input error",JOptionPane.ERROR_MESSAGE);}}
 public static void main(String[] a){SwingUtilities.invokeLater(()->new LambdaConverter().setVisible(true));}
}
