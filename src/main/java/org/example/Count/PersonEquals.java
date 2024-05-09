package org.example.Count;

public class PersonEquals {
    private final String name;
    PersonEquals(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        PersonEquals person = (PersonEquals) obj;
        return  person.equals(PersonEquals.class); // RETURNS THE OBJ EQUALS THE 'THIS' CLASS FIELD OBJECTS.

    }

}
