# Task 4 – Event-Handling Forensics

The supplied method `mouseclicked` does not override `MouseAdapter.mouseClicked`; Java is case-sensitive, so the listener callback is never invoked. The label remains unchanged for the same reason. `getGraphics()` draws directly to a transient surface and does not preserve drawing state, so expose/restore repaint can erase the dots.

Repair: override `mouseClicked`, append `e.getPoint()` to a list, update the label and call `repaint()`. `paint` redraws every stored point at (x−3,y−3) with 6×6 size. `@Override` makes a misspelled method a compile-time error.

Alternative BufferedImage stores width×height pixels and paint copies the image; point list uses O(n) point storage and O(n) drawing per repaint. Image repaint is approximately O(width×height) copy with O(width×height) pixel storage.

Run: `javac DrawPad.java && java DrawPad`.
