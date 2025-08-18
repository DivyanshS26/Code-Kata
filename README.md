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

**Step 4** First class collections
1. Wrapped the raw array of score names inside a dedicated class PointNames.

2. All logic for point → word mapping moved into PointNames, not scattered.

3. Main class now asks pointNames.nameFor(p1) instead of touching arrays directly.

4. Result: Collections got a home; clear responsibility separation if scoring rules change.

**Step 5** Law of Demeter
1. Broke down chained calls in getNormalScore() to assign intermediate results to variables with one method call per line.

2. This makes the code easier to read and debug.

3. Maintains the existing logic and ensures that all your existing test cases will continue to pass.

4. Keeps adherence to the Law of Demeter for better design and maintainability.

**Step 6** Don't abbreviate
1. Abbreviations are removed from all variable, parameter, and method names.

2. Names are now self-explanatory and context-rich, making code easier to read and maintain.

3. Clear naming highlights possible design improvements and safeguards against misplaced logic.

**Step 7** Keep all entities small
1. Classes should ideally be less than 50 lines.

2. Packages should contain no more than 10 files.

3. Stick to Single Responsibility Principle: one class = one job.
4. Step-6 class (tennis game logic) already is relatively small and focused on scoring rules.

**Step 8** No classes with more than two instance
variables
1. No class should have more than two instance variables.

2. Encourages strong class cohesion and clear single responsibility.
