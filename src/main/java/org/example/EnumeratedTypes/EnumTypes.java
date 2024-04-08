package org.example.EnumeratedTypes;

enum FavoriteColor  {SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY} /*stand alone enum.*/

/*
  An Enumerated type defines a list of enumerated values
  A value of an Enumerated type is like a constant, hence it is defined as upperCase letters
  An Enum type is named as a class.
  Enum types is type-safe.
  An Enumerated type is treated as a special class.
  An Enumerated variable is a reference variable.
  you can use the name() method and ordinal() method on an enumerated object.
  Enum implement the compareTo method in the comparable interfaces.
  */
public  class EnumTypes {
//   enum FavoriteColor{MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY,SATURDAY, SUNDAY}; /* STAND-ALONE ENUM */

    void main() {
        FavoriteColor favoriteColor = FavoriteColor.WEDNESDAY;
        FavoriteColor favoriteColor1 = FavoriteColor.FRIDAY;
        System.out.println("day 1 favoriteColor day is "+ favoriteColor.name());
        System.out.println("day 2 favoriteColor day is "+ favoriteColor1.name());
        System.out.println("day 1 ordinal value " + favoriteColor.ordinal());
        System.out.println("day 2 ordinal value " + favoriteColor1.ordinal());
        System.out.println("day 2 string value " + favoriteColor1.toString());
        System.out.println("comparing.."+ favoriteColor1.compareTo(favoriteColor));


    }


}



