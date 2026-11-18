# Task 2 – Hospital Appointment Desk

Event model: department JComboBox → ActionEvent → ActionListener → refresh doctor list; Book button → ActionEvent → ActionListener → validate and confirm; window close → WindowEvent → WindowAdapter/windowClosing → ask before closing if a booking is in progress.

Containment: JFrame(BorderLayout) → form JPanel(GridLayout 4×2) containing patient JTextField, department/doctor/slot JComboBoxes; bottom JPanel(FlowLayout) contains Book JButton and status JLabel.

Pseudocode: ON department change: clear doctor list; for each doctor in map[department], add item. ON book: validate patient ID; ensure doctor and slot selected; set booking flag; call service; show confirmation/error; clear flag.

Trace: construct → initialize components → register listeners → pack/set size → visible → event dispatch → windowClosing → confirmation → dispose. Applet lifecycle is init/start/paint/stop/destroy; it is not a JFrame lifecycle.

Alternative: DB query on every change costs O(q + r) per change plus network latency; preload map costs O(m) startup and O(1) map lookup plus O(r) to populate r doctors, using O(d+m) memory for d departments and m doctor records.

Run: `javac AppointmentDesk.java && java AppointmentDesk`.
