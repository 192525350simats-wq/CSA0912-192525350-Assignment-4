# Task 5 – Four Event-Handling Styles

Four independent classes implement the same screen: frame implements ActionListener; named inner class; anonymous inner class; lambda. Each shares one handler between Convert and Enter in the amount field, displays a result dialog, and uses WindowAdapter for closing.

Comparison: frame listener is straightforward but couples the window to the listener interface; named inner class is explicit and reusable; anonymous class is local but verbose; lambda is concise for a single-method interface. For larger apps, a shared Swing `Action` or method reference can centralize behavior across buttons, menus and keyboard shortcuts.

The supplied INR conversion rates (USD 0.012, EUR 0.011) are fixed demonstration values only, not live exchange rates.

Run any version, e.g. `javac LambdaConverter.java && java LambdaConverter`.
