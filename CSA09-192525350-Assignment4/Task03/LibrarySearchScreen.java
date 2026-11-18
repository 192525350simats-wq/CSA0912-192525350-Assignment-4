import javax.swing.*; import java.awt.*;
public class LibrarySearchScreen extends JFrame {
 private final JTextField query=new JTextField(22); private final JComboBox<String> category=new JComboBox<>(new String[]{"All","Books","Journals","Theses"});
 private final DefaultListModel<String> model=new DefaultListModel<>(); private final JList<String> results=new JList<>(model); private final JLabel status=new JLabel("Ready");
 public LibrarySearchScreen(){super("Campus Library Search");setLayout(new BorderLayout(8,8));
 JLabel title=new JLabel("Campus Library Catalogue",SwingConstants.CENTER);title.setFont(title.getFont().deriveFont(Font.BOLD,18f));add(title,BorderLayout.NORTH);
 JPanel search=new JPanel(new FlowLayout(FlowLayout.LEFT));search.add(new JLabel("Search"));search.add(query);search.add(category);JButton go=new JButton("Search");search.add(go);
 JPanel centre=new JPanel(new BorderLayout(4,4));centre.add(search,BorderLayout.NORTH);centre.add(new JScrollPane(results),BorderLayout.CENTER);
 JPanel bottom=new JPanel(new FlowLayout());JButton prev=new JButton("Prev"),next=new JButton("Next"),reserve=new JButton("Reserve");bottom.add(prev);bottom.add(next);bottom.add(reserve);bottom.add(status);
 add(centre,BorderLayout.CENTER);add(bottom,BorderLayout.SOUTH);
 go.addActionListener(e->{model.clear();String q=query.getText().trim();if(q.isEmpty()){status.setText("Enter a search term.");return;}model.addElement("Java Programming – Library shelf CS-12");model.addElement("Event-Driven Interfaces – E-Resources");status.setText("2 results for: "+q);});reserve.addActionListener(e->status.setText("Select a result before reserving."));
 setDefaultCloseOperation(DISPOSE_ON_CLOSE);setSize(760,480);setMinimumSize(new Dimension(500,340));setLocationRelativeTo(null); }
 public static void main(String[] a){SwingUtilities.invokeLater(()->new LibrarySearchScreen().setVisible(true));}
}
