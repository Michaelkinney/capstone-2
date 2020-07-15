Object Oriented Programming Concept Questions

As you should know by now, there are 4 pillars of Object Oriented Programming.

********************
1. Encapsulation


Encapsulation is protecting data for 1 object from being misused by other objects.
From my understanding this would be done by creating private classes and using
getters and setters to call that data elsewhere. 

public class Encapsulation
 {
  private String name;
  private int age;
  
  public String getName() {
        return name;
  }
  public void setName(String name) {
        this.name = name;
  }
  public int getInt() {
        return age;
  }
  public void setAge(int age) {
        this.age = age;      
  } }
  
        
  
  
********************
2. Inheritance

Inheritance is the ability of classes to acquire methods/fields from other classes.
Child classes can acquire traits/properties from their parent/super classes.
This is a great way to keep our code DRY. 

public class Fruit {
    public String toString(){
        return "Fruit";
    }
  }
    
class Orange extends Fruit {
    public String toString(){
        return "Orange";
    }
  }
  
Class Banana extends Fruit {
    public String toString(){
        return "Banana";
    }
  } 




********************
3. Abstraction

Abstraction simply put is hiding details of code and only allowing the
user to see essential data they need to see.
Abstraction can be achieved by interfaces and abstract classes.

This is an example of an abstract class set up

public abstract class Animal {
    private String name;
    
    public Animal(String name) {
        this.name = name;
    }
    
    public abstract void eat();
    public abstract void breathe();
    
    public String getName() {
        return name;
    }
  }

public class Dog extends Animal {

    public Dog(String name) {
        super(name);
    }
    
    @override
    public void eat() {
        system.out.println(getname() + " is eating");
    }
  }
  
public class Main {

    public static void main(String[] args) {
        Dog dog = new Dog("Yorkie");
        dog.eat();
        
Prints out - Yorkie is eating

********************
4. Polymorphism
   
Polymorphism is making a method accomplish different things depending on 
which object is calling that method.Tis is yet another way to keep our 
code DRY. This OOP principle is more easily explained 
by an example.

public class Animal{
    public void sound(){
        System.out.println("Animal is making a sound");
        }
      }
      
class Horse extends Animal {

    @Override
    public void sound(){
        System.out.println("Neigh");
        }
    public static void main(String args[]) {
        Animal obj = new Horse();
        obj.sound();
        }
      }
      
      Output = Neigh
      
      
      This shows that 1 object can be used by other methods for different outputs.
      This helping us keep our code DRY.








Please write 1-3 paragraphs explaining these 4 concepts further.  Please provide a sufficient enough explanation about these pillars, as well as some examples to illustrate the practical use cases of these principles.  



