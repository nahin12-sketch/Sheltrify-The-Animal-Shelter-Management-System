import java.util.*;

abstract class Animal{
    private int id;
    private String name;
    private int age;
    private boolean adopted;

    Animal(int id, String name, int age){
        this.id = id;
        this.name = name;
        this.age = age;
        this.adopted = false;
    }

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }

    public boolean isAdopted(){
        return adopted;
    }

    public void setAdopted(boolean adopted){
        this.adopted = adopted;
    }

    abstract void display();
}

class PetAnimal extends Animal{

    PetAnimal(int id, String name, int age){
        super(id, name, age);
    }

    @Override
    void display(){
        System.out.println(getId() + " " + getName() + " " + getAge() + " : " + (isAdopted() ? "Adopted" : "Available"));
    }
}

class ShelterSystem{

    PetAnimal a1 = new PetAnimal(1, "Dog", 2);
    PetAnimal a2 = new PetAnimal(2, "Cat", 1);
    PetAnimal a3 = new PetAnimal(3, "Rabbit", 3);

    Scanner sc = new Scanner(System.in);

    void view(){
        if (a1 != null){
            a1.display();
        } 
        if (a2 != null){
            a2.display();
        } 
        if (a3 != null){
            a3.display();
        } 
    }

    void adopt(){
        System.out.print("Enter ID: ");
        int id = sc.nextInt();

        if (a1 != null && a1.getId() == id){
            a1.setAdopted(true);
            System.out.println("Adopted: " + a1.getName());
            a1 = null;
        }
        else if (a2 != null && a2.getId() == id){
            a2.setAdopted(true);
            System.out.println("Adopted: " + a2.getName());
            a2 = null;
        }
        else if (a3 != null && a3.getId() == id){
            a3.setAdopted(true);
            System.out.println("Adopted: " + a3.getName());
            a3 = null;
        }
        else{
            System.out.println("Not found or already adopted");
        }
    }

    void menu(){
        while (true){
            System.out.println("\n1.View 2.Adopt 3.Exit");
            int ch = sc.nextInt();

            if (ch == 1){
                view();
            } 
            else if (ch == 2){
                adopt();
            } 
            else{
                System.out.println("kamsahamnida!");
                break;
            }
        }
    }
}


public class Main{
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        System.out.print("ID: ");
        String id = sc.nextLine();

        System.out.print("Pass: ");
        String pass = sc.nextLine();

        if (id.equals("282") && pass.equals("Nahin27")){
            System.out.println("Login OK\n");
            new ShelterSystem().menu();
        } else {
            System.out.println("Wrong login");
        }
    }
}
