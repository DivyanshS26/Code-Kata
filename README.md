# Code-Kata

**Step 1**
Each method should have just one block of indentation:

1. No nested if/else, loops, or switch inside a method.

2. If you need more nesting, extract to a new method.

**Step 2** Don’t use the ELSE keyword
1. Avoided else blocks → replaced with early returns to keep code flow flat.

2. Separated logic into smaller methods (getAdvantageOrWin, etc.) → removed nesting.

3. Simplified wonPoint() → used early return instead of if/else.

4. Result: Cleaner, more linear code that reads top-to-bottom like a story.

**Step 3** Wrap all primitives and Strings
1. Replaced raw ints with Point objects for player scores.

2. Replaced raw Strings with PlayerName objects for player names.

3. Encapsulated logic in value objects (add, lessThan, equals) instead of scattering math.

4. Result: More expressive, self-documenting code (no more primitive obsession).