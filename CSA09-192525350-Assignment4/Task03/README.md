# Task 3 – Campus Library Search Screen

Layout choice: JFrame uses BorderLayout; title occupies NORTH; central panel occupies CENTER and uses BorderLayout; search row uses FlowLayout in NORTH; scrollable results list expands in CENTER; bottom controls use FlowLayout in SOUTH. The centre grows during resize while the top/bottom rows retain preferred height.

Alternative GridBagLayout offers precise constraints but more setup; absolute positioning is brittle on resize and font scaling. Nested containers add a small fixed number of components; layout calculation is linear in the number of contained components for common managers.

Run: `javac LibrarySearchScreen.java && java LibrarySearchScreen`. Test at 760×480, 600×400 and 500×340.
