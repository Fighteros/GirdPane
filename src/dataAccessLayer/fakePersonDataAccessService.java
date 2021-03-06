package dataAccessLayer;

import userModel.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


 // all functions returns 0 if success , 1 if failure
public class fakePersonDataAccessService implements PersonDao {
    private static List<Person> DB = new ArrayList<>();

    @Override
    public int insertPerson(UUID id, Person person) {
        DB.add(new Person(id ,person.getUsername() ,person.getEmail(), person.getPassword()));
        return 0;
    }

    @Override
    public List<Person> selectAllPeople(){
        return DB;
    }

    @Override
    public int deletePerson(UUID id){
        Optional<Person> person = selectPersonById(id);
        if (person.isPresent()){
            DB.remove(person.get());
            return 0;
        }
        return 1;
    }

     @Override
     public Optional<Person> selectPersonByUsername(String username) {
         return  DB.stream()
                 .filter(person -> person.getUsername().equals(username))
                 .findFirst();
     }

     @Override
     public UUID getPersonIdByUsername(Person person) {
        Optional<Person> personOptional = selectPersonByUsername(person.getUsername());
         return personOptional.map(Person::getId).orElse(null);
     }

     @Override
    public int updatePersonById(UUID id, Person person){
        return selectPersonById(id).map(p -> {
            int indexOfPersonToUpdate = DB.indexOf(p);
            if (indexOfPersonToUpdate >= 0){
                DB.set(indexOfPersonToUpdate, new Person(id, person.getUsername(), person.getEmail(), person.getPassword()));
                        return 0;
            }
            return 1;
        })
                .orElse(0);
    }


    @Override
    public  Optional<Person> selectPersonById(UUID id){
        return DB.stream()
                .filter(person -> person.getId().equals(id))
                .findFirst();
    }

}