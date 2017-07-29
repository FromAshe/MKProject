package mkproject;

import javafx.beans.property.*;

/**
 *
 * @author Graham Smith
 */
public  class Person {

    private final  SimpleStringProperty idNumber;
    private final SimpleStringProperty firstName;
    private final  SimpleStringProperty lastName;
    private final  SimpleStringProperty grandName;
    private final  SimpleStringProperty birthDate;

    private final  SimpleStringProperty wereda;
   private final  SimpleStringProperty kebele;
    private final  SimpleStringProperty ketema;
     private final  SimpleStringProperty ageligilot;
     public Person(String idnum, String fName, String lName, String gName, String kebele,String ageligilot, String bDate, String wereda, String ketema) 
    {
       this.idNumber = new SimpleStringProperty(idnum);
        this.firstName = new SimpleStringProperty(fName);
        this.lastName = new SimpleStringProperty(lName);
        this.grandName = new SimpleStringProperty(gName);
        this.birthDate = new SimpleStringProperty(bDate);
        
        this.wereda = new SimpleStringProperty(wereda);
        this.ketema = new SimpleStringProperty(ketema);
       this.kebele = new SimpleStringProperty(kebele);
       this.ageligilot = new SimpleStringProperty(ageligilot);
    }
public Person(String idnum, String fName, String lName, String gName, String kebele, String bDate, String wereda, String ketema) 
    {
       this.idNumber = new SimpleStringProperty(idnum);
        this.firstName = new SimpleStringProperty(fName);
        this.lastName = new SimpleStringProperty(lName);
        this.grandName = new SimpleStringProperty(gName);
        this.birthDate = new SimpleStringProperty(bDate);
        
        this.wereda = new SimpleStringProperty(wereda);
        this.ketema = new SimpleStringProperty(ketema);
       this.kebele = new SimpleStringProperty(kebele);
       this.ageligilot = new SimpleStringProperty(ketema);
    }
    //
    public Person(String idnum, String fName, String lName, String gName, String bDate, String wereda, String ketema) 
    {
       this.idNumber = new SimpleStringProperty(idnum);
        this.firstName = new SimpleStringProperty(fName);
        this.lastName = new SimpleStringProperty(lName);
        this.grandName = new SimpleStringProperty(gName);
        this.birthDate = new SimpleStringProperty(bDate);
        
        this.wereda = new SimpleStringProperty(wereda);
        this.ketema = new SimpleStringProperty(ketema);
       this.kebele = new SimpleStringProperty(ketema);
       this.ageligilot = new SimpleStringProperty(ketema);
    }
     

    public String getIdNumber() {
        return idNumber.get();
    }

    public void setIdNumber(String idNumber) {
        this.idNumber.set(idNumber);
    }
    

    public String getFirstName() {
        return firstName.get();
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public String getLastName() {
        return lastName.get();
    }
     public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public void setGrandName(String grandName) {
        this.grandName.set(grandName);
    }


    public String getGrandName() {
        return grandName.get();
    }

   
     public String getBirthDate() {
        return birthDate.get();
    }

    public void setBirthDate(String birthDate) {
        this.birthDate.set(birthDate);
    }
 
 public String getWereda() {
        return wereda.get();
    }

    public void setWereda(String wereda) {
        this.wereda.set(wereda);
    }
  
     public String getKetema() {
        return ketema.get();
    }

    public void setKetema(String ketema) {
        this.ketema.set(ketema);
    }

    public String getKebele() {
        return kebele.get();
    }

    public void setKebele(String ageligilot) {
        this.kebele.set(ageligilot);}
   public String getAgeligilot() {
        return ageligilot.get();
    }

    public void setAgeligilot(String ageligilot) {
        this.ageligilot.set(ageligilot);}

}

