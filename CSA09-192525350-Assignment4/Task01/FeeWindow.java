import javax.swing.*; import java.awt.*; import java.math.BigDecimal;

// UI collects data and delegates validation/payment to FeeService.
public class FeeWindow extends JFrame {
    private final JTextField regNo = new JTextField(14), amount = new JTextField(10);
    private final JLabel status = new JLabel("Enter registration number and amount.");
    private final FeeService service = new FeeService();
    public FeeWindow() {
        super("Student Fee Payment"); setLayout(new BorderLayout(8,8));
        JPanel form=new JPanel(new GridLayout(2,2,6,6));
        form.add(new JLabel("Registration number")); form.add(regNo);
        form.add(new JLabel("Amount (INR)")); form.add(amount);
        JPanel actions=new JPanel(new FlowLayout());
        JButton pay=new JButton("Pay"), clear=new JButton("Clear"), receipt=new JButton("Receipt");
        actions.add(pay); actions.add(clear); actions.add(receipt);
        add(form,BorderLayout.NORTH); add(actions,BorderLayout.CENTER); add(status,BorderLayout.SOUTH);
        pay.addActionListener(e -> payFee());
        clear.addActionListener(e -> {regNo.setText(""); amount.setText(""); status.setText("Form cleared.");});
        receipt.addActionListener(e -> status.setText("Receipt: " + service.lastReceipt()));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE); setSize(430,190); setLocationRelativeTo(null);
    }
    private void payFee() {
        try { FeeService.Payment p=service.pay(regNo.getText(),amount.getText()); status.setText("Payment successful. Receipt: "+p.receipt()); }
        catch (IllegalArgumentException ex) { status.setText("Error: "+ex.getMessage()); }
    }
    public static void main(String[] args){ SwingUtilities.invokeLater(()->new FeeWindow().setVisible(true)); }
}
class FeeService {
    private String last="No payment yet";
    static class Payment { final String receipt; Payment(String r){receipt=r;} String receipt(){return receipt;} }
    Payment pay(String reg,String raw) {
        if(reg==null || !reg.trim().matches("[A-Za-z0-9-]{4,20}")) throw new IllegalArgumentException("Enter a valid registration number.");
        final BigDecimal value;
        try { value=new BigDecimal(raw.trim()); } catch(Exception e){throw new IllegalArgumentException("Amount must be numeric.");}
        if(value.signum()<=0) throw new IllegalArgumentException("Amount must be greater than zero.");
        // Demonstration repository: replace with JDBC PreparedStatement in production.
        last="FEE-"+reg.trim()+"-"+System.currentTimeMillis(); return new Payment(last);
    }
    String lastReceipt(){return last;}
}
