# Task 6 – Campus Event Registration

Architecture: `CampusEventApp` (Swing UI) → `RegistrationService` (validation and duplicate rule) → `RegistrationDao` (JDBC persistence). Register, filter and refresh database work run in `SwingWorker`, not the Event Dispatch Thread. The table query is limited to 100 rows; extend it with page controls and parameterized LIMIT/OFFSET for full pagination. The database also enforces a UNIQUE(student_id,event_name) constraint to prevent races between duplicate checks and inserts.

**Setup:** Run `mysql -u root -p < sql/schema.sql`. Ensure MySQL Connector/J is on the classpath. Configure `DB_URL`, `DB_USER`, `DB_PASSWORD` environment variables. Compile: `javac CampusEventApp.java`. Run: `java -cp .:mysql-connector-j.jar CampusEventApp` (Windows classpath separator is `;`).

The app uses MySQL JDBC; without a running configured MySQL server and Connector/J, the UI opens but database operations show a connection error.

**100,000-row comparison:** loading all rows uses O(N) memory in the table model and blocks the EDT if done synchronously; paged loading transfers O(P) rows per page (P page size) and uses O(P) UI memory, with database work in SwingWorker. Indexed filtering is typically O(log N + P) at the database level; exact timings depend on indexes, hardware and network.
