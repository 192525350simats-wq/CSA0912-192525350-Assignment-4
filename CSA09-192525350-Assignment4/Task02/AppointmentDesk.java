import javax.swing.*; import java.awt.*; import java.util.*;
public class AppointmentDesk extends JFrame {
 private final JTextField patient=new JTextField(12); private final JComboBox<String> dept=new JComboBox<>(new String[]{"Cardiology","Orthopaedics","Dermatology"});
 private final JComboBox<String> doctor=new JComboBox<>(), slot=new JComboBox<>(new String[]{"09:00","10:30","12:00","14:00"});
 private final JLabel status=new JLabel("Ready"); private boolean booking=false;
 private final Map<String, java.util.List<String>> doctors=Map.of("Cardiology",java.util.List.of("Dr. Anand","Dr. Meera"),"Orthopaedics",java.util.List.of("Dr. Kumar","Dr. Sana"),"Dermatology",java.util.List.of("Dr. Isha","Dr. Raj"));
 public AppointmentDesk(){super("Hospital Outpatient Appointment Desk"); setLayout(new BorderLayout(8,8)); JPanel form=new JPanel(new GridLayout(4,2,6,6));
 form.add(new JLabel("Patient ID"));form.add(patient);form.add(new JLabel("Department"));form.add(dept);form.add(new JLabel("Doctor"));form.add(doctor);form.add(new JLabel("Time slot"));form.add(slot);
 JButton book=new JButton("Book appointment"); JPanel south=new JPanel(new FlowLayout());south.add(book);south.add(status);add(form,BorderLayout.CENTER);add(south,BorderLayout.SOUTH);
 dept.addActionListener(e->refreshDoctors());book.addActionListener(e->book());addWindowListener(new java.awt.event.WindowAdapter(){public void windowClosing(java.awt.event.WindowEvent e){if(booking){int x=JOptionPane.showConfirmDialog(AppointmentDesk.this,"Booking is in progress. Close anyway?","Confirm close",JOptionPane.YES_NO_OPTION);if(x!=JOptionPane.YES_OPTION)setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);else setDefaultCloseOperation(DISPOSE_ON_CLOSE);}else setDefaultCloseOperation(DISPOSE_ON_CLOSE);}});
 refreshDoctors();setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);setSize(500,260);setLocationRelativeTo(null); }
 private void refreshDoctors(){doctor.removeAllItems();for(String d:doctors.getOrDefault((String)dept.getSelectedItem(),java.util.List.of()))doctor.addItem(d);}
 private void book(){String id=patient.getText().trim();if(!id.matches("[A-Za-z0-9-]{3,20}")){status.setText("Enter a valid patient ID.");return;}if(doctor.getSelectedItem()==null||slot.getSelectedItem()==null){status.setText("Choose a doctor and slot.");return;}booking=true;status.setText("Booking confirmed for "+id+" – "+doctor.getSelectedItem()+" at "+slot.getSelectedItem());booking=false;}
 public static void main(String[] a){SwingUtilities.invokeLater(()->new AppointmentDesk().setVisible(true));}
}
