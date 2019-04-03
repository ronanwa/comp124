Comp 124: Critters Lab
====

**Acknowledgement:** Paul Cantrell developed this lab, Shilad tweaked the Eye code, Bret tweaked the default critters, Libby added x, y offsets for Critters and a test program.

Today's lab is a bit of silly fun in the name of practicing graphics programming.

**When you get started, do not fork this repository. Clone the original repository directly.**

This project provides a framework for building little critters that wander around the screen.

Begin by studying one of the existing critters. Take a look at BoxBot, RoundBug, and Mario as examples. Run `CritterTester` to study the individual critters. Then run `CritterParty` to see all of them wandering around together.

Now create some new critters of your own! Create a new class that extends Critter. Add your name or initials to the class name, to make sure that your critter’s name is unique.

There are only three requirements for your critter:
- Add animated legs or eyes (or both), as the example critters do.
- Don’t make it so big that it hogs the screen.
- Have fun!

Test your new type of Critter using `CritterTester`. Change it to create one of your type of Critter rather than one of the examples. Design your critter so that it approximately fits within the grey guide box that `CritterTester` draws.

**Important notes:** 

* Add your name or initials to your critter class name and image names to avoid git conflicts.
* Look at the examples to see how they add the animated legs and eyes. Study how they use `addLeg(new Leg(...))`.
* If you want to use an image, as Mario does:
    - Make sure that your image is small enough that it fits within CritterTester’s guide box.
    - Place your image in the directory called `res`, not in `src`. This is the resources directory.
    - Load your image using `CritterUtils.loadCritterImage()`.
    - You should still add animated features so it looks good in the `CritterParty`. Don’t just drop in a fixed image and call it done.

The code in `CritterParty` is written to automatically detect new critters, but does so randomly, so it is best to only use this once you have your new Critter drawing properly in the `CritterTester`.

We hope that you will be able to finish at least one new critter of your own invention!

Once you have a new Critter working and **thoroughly tested**, then:
* Right-click on the CritterTester and do Git → Revert, to make sure you are NOT committing your changes to the tester. Make sure you **only revert changes to CritterTester**. Don’t lose your work!
* Now pull other people's changes by right-clicking on the whole repository and choosing Git → Repository → Pull. 
* Finally, push your changes. Do this by right-clicking on the whole repository and using Git → Commit and Push.

At the end of class, we'll have a critter party on the projector.
