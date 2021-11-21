import java.util.ArrayList;
import java.util.Random;

public class Bank {

    private  String name;

    private ArrayList<User>  users;

    private ArrayList<Account>  accounts;

    public Bank(String name ){
        this.name=name;
        this.users=new ArrayList<User>();
        this.accounts=new ArrayList<Account>();
    }

    /**
     *
     * Generate a new unique ID for a user.
     */
    public String getNewUserUUID(){
        String uuid;
        Random rng=new Random();
        int len = 6;
        boolean nonUnique;

        //cuntinue looping until we geta unique ID
        do {
            //GENERATE THE NUMBER
            uuid="";
            for (int c=0; c<len ; c++){
                uuid +=((Integer)rng.nextInt(10)).toString();
            }


            // check to make sure it is unique ID
            nonUnique=false;
            for(User u:this.users){
                if(uuid.compareTo(u.getUUID())==0){
                    nonUnique=true;
                    break;
                }
            }
        }while (nonUnique);

        return  uuid;

    }

    /**
     *
     * Generate a new unique ID for a account.
     */
    public String getNewAccountUUID(){
        String uuid;
        Random rng=new Random();
        int len = 10;
        boolean nonUnique;

        //cuntinue looping until we geta unique ID
        do {
            //GENERATE THE NUMBER
            uuid="";
            for (int c=0; c<len ; c++){
                uuid +=((Integer)rng.nextInt(10)).toString();
            }


            // check to make sure it is unique ID
            nonUnique=false;
            for(Account a:this.accounts){
                if(uuid.compareTo(a.getUUID())==0){
                    nonUnique=true;
                    break;
                }
            }
        }while (nonUnique);

        return  uuid;
    }

    public void addAccount(Account onAcct){
        this.accounts.add(onAcct);
    }

    public User addUser(String firstName,String lastName, String pin){

       //create a new user object and add it our list
        User newUser=new User(firstName,lastName,pin,this);
        this.users.add(newUser);


        //create a savings account for the user
        Account newAccount=new Account("Savings",newUser,this);
        newUser.addAccount(newAccount);
        this.accounts.add(newAccount);

        return newUser;
    }

    public User userLogin(String userID,String pin){
        for (User u:this.users){
            if(u.getUUID().compareTo(userID)==0 && u.validatePin(pin)){
                return u;
            }

        }
            //if we have not found the user and incorrect pin
            return null;
    }

    public String getName(){
        return this.name;
    }
}
