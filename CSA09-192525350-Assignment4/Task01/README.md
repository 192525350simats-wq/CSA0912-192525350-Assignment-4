# Task 1 – GUI Design Review

`FeeWindow` separates Swing presentation from `FeeService` validation/payment. The demo uses an in-memory receipt generator; it does not connect to a bank or database. A production JDBC repository should use `PreparedStatement`, try-with-resources and a `SwingWorker` for slow I/O.

**Defects diagnosed:** UI/business logic coupling; `==` for String comparison; no input validation; JDBC and `sleep` on the EDT; no visible feedback; Receipt falls into Clear branch; SQL concatenation enables injection; no connection cleanup; unhandled checked exceptions; no close policy.

**Alternative:** per-button listeners or shared Swing `Action` removes a k-way action-command chain. A chain can take O(k) comparisons in the worst case; direct listener dispatch is O(1) selection. k listener objects use O(k) extra references/objects.

Run: `javac FeeWindow.java && java FeeWindow`.
