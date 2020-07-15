<h1>The Problem Solving Framework : 'UPER'</h1>

* U = "Understand"
* P = "Plan"
* E = "Execute"
* R = "Reflect" / "Refactor"

<h2>1. Understanding the Problem</h2>



I am tasked with building a game in java.
I plan on building a text based adventure game with simple components of
dialogue and item finding to progess and finish the game. 
This will be a great example for using SOLID principles and especially inheritence 
in crafting this game.

How to make a GUI?
How to transition to new "areas"?
What functionality should be included in the game?
How to "finish" the game?
Creating a "story" or game world?




<h2>
    2. Planning the Solution
</h2>

I plan to have a 
- Title screen
- Main sequence
- Ending sequence
- Crossroads1 with 4 areas to explore
- Crossroads2 with another 4 areas of exploration
- Crossroads3 with another 4 areas of exploration
- Multiple Monsters to encounter
- Multiple NPCs to talk to
- Multiple weapons to find



<h2>
    3. Executing the Plan
</h2>

I have started putting it together, first for functionality, later for OOP.

JPanel and JFrame has been used for creating the GUI.

The areas you move into and out of are controlled by methods.
These methods are connected to other methods which are new areas.
This can easily be expanded in the future in the story class.

Creating weapons in their own class, based off a superweapon class.
New weapons can easily inherit from the super weapon class.
This can be applied as well to new monster encounters.
This as well can be easily expanded in the future for a more expanded game.




<h2>
    4. Reflection / Refactor
</h2>

I now understand why it is important to take the time to do the code
correct and to implement the OOP principles the first time as you code. 
I am refactoring my code to better include those principles but as time permits
I may not be able to fully implement them. I focused on getting the code to just work
on the first go around. I can see as project complexity grows, how important it is to
follow these principles. 

Encapsulation was hard to implement after the fact, maybe due to multiple packages, or
maybe due to a constantly changing variable(hp) in this case.




