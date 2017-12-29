guy.niv


=============================
=      File description     =
=============================
SpaceShip.java - contains the abstract class SpaceShip. All the other spaceship extends this class.
SpaceShipFactory.java - has only one static method, which returns an array of spaceships that participate
                        in the game.
Human.java - contains the class Human, which represents a kind of spaceship that extends the SpaceShip class.
Runner.java - contains the class Human, which represents a kind of spaceship that extends the SpaceShip class.
Basher.java - contains the class Human, which represents a kind of spaceship that extends the SpaceShip class.
Aggressive.java - contains the class Human, which represents a kind of spaceship that extends the SpaceShip
                  class.
Drunkard.java - contains the class Human, which represents a kind of spaceship that extends the SpaceShip
                class.
Special.java - contains the class Human, which represents a kind of spaceship that extends the SpaceShip
               class.

=============================
=          Design           =
=============================
The program is a spaceship game. The SpaceShip class is an abstract class, and all the other kinds of
spaceships are extend this class. I made it this way because each of the spaceship has a lot in common, and
they only differ in their behavior, which means in only one method, so it is efficient and Intuitive to use
one abstract class and make all the other extends it. It also make it very easy to add new features to the
spaceship. All there's to do is put it in one class.In addition, I made the getImage method non-abstract,
because only the Human uses another image, so in the human class I overrided the method.

=============================
=  Implementation details   =
=============================
Drunkard explanation - this spaceship always accelerating, and gets its direction randomly
(33% for each direction), and committing ashot in a probability of < 1%.
Spacial explanation - this spaceship never accelerating, and always make sure to "look" to the direction of
the closest ship.If it gets close to another ship, it opens fire. If a ship gets even closer, it activates
its shield to prevent damage, and gain free energy.
=============================
=    Answers to questions   =
=============================
# Java-ex2
