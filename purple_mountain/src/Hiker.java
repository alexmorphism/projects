/**
 * Hiker.java
 * @author a_castro4
 * 
 * This is the Hiker class. It provides basic information about a hiker such as name. 
 * The Hiker class provides methods for getting a name for the hiker as well as a toString() and equals() method.
 */
public class Hiker {
  private String name;
  
  public Hiker(String name){
    this.name = name;
  }
  
  public Hiker(){
    this.name = "Hiker";
  }
  
  public String getName(){
    return name;
  }
  
  public String toString(){
    return name + "\n";
  }
  
  public boolean equals(Object obj){
    if (obj == this) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()){ 
      Hiker other = (Hiker) obj;  
      return name.equals(other.name);
    } else{
      return false;
    }
  }
  
  
}
