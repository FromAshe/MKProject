/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mkproject;

/**
 *
 * @author YOHY
 */
public class ValidateInput {
    public static boolean validateFirstName( String firstName )
 {
return firstName.matches( "[ሀ-ፖ]+(\\s[ሀ-ፖ]+)*" );
 }
     public static boolean validateSecondName( String secondName )
 {
return secondName.matches( "[ሀ-ፖ]/[ሀ-ፖ]+" );
 }// end method validateFirstName

 // validate last name
 public static boolean validateSex( String sex )
 {
return sex.matches( "[ሀ-ፖ]+" );
 } // end method validateLastName

 // validate address
 public static boolean validateAclass( String aclass )
 {
return aclass.matches("[ሀ-ፖ]+(\\s[ሀ-ፖ]+)*");

 } 
 public static boolean validateAclass2( String aclass )
 {
return aclass.matches("[ሀ-ፖ]/[ሀ-ፖ]+(\\s[ሀ-ፖ]+)*");

 }// end method validateAddress

 // validate city
 public static boolean validateCity( String city )
 {
return city.matches( "([a-zA-Z]+|[a-zA-Z]+\\s[a-zA-Z]+)" );
 } // end method validateCity

 // validate state
 public static boolean validateState( String state )
 {
return state.matches( "([a-zA-Z]+|[a-zA-Z]+\\s[a-zA-Z]+)" ) ;
 } // end method validateState

 // validate zip
 public static boolean validateYear( String year )
 {
return year.matches( "\\d{4}" );
 } 
public static boolean validateMonth( String mon )
 {
return mon.matches( "[ሀ-ፖ]+" );
 } 
public static boolean validateDay( String day )
 {
return day.matches( "\\d{2}" );
 } 
public static boolean validateId( String id )
 {
return id.matches( "\\d{4}/\\d{4}" );
 } // end method validateZip
public static boolean validateKebele( String keb )
 {
return keb.matches( "[0-9]+" );
 } // end method validateZip


 // validate phone
 public static boolean validatePhone( String phone )
 {
return phone.matches( "\\d{3}-\\d{3}-\\d{4}" );
 }
 public static boolean Kahinat( String kahin )
 {
return kahin.matches( "([A-Z]/[a-zA-Z]+\\s[A-Z][a-zA-Z]+\\s[A-Z][a-zA-z]+)" );
 }
 public static boolean validateCourse( String course )
 {
return course.matches( "[A-Z]*\\d*" );
 }
    
}