import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.security.MessageDigest;
import java.util.Collections;

public class User {

    private String firstName;

    private String lastName;

    /* The ID Number of user */
    private String uuid;

    /* The MD5 hash of the user's pin number  */
    private byte pinHas[];

    private ArrayList<Account> accounts;

    /**
     * Create a new user
     * @param firstName     the user's firt name
     * @param lastName      the user's last name
     * @param pin           the user's account pin number
     * @param theBank       the Bank object that the user is a customer
     */
    public User(String firstName , String lastName , String pin,Bank theBank){
            this.firstName=firstName;
            this.lastName=lastName;

            //MD5 pin , security reasons
        try {
            MessageDigest md=MessageDigest.getInstance("MD5");
            this.pinHas=md.digest(pin.getBytes());
        } catch (NoSuchAlgorithmException e) {
            System.out.println("Error , caught NoSuchAlgorithmException");
            e.printStackTrace();
            System.exit(1);
        }

        //get a new universal ID for the user;
        this.uuid=theBank.getNewUserUUID();

        //empty list of accounts
        this.accounts=new ArrayList<Account>();

        System.out.printf("New user %s, %s with ID %s create .\n",lastName,firstName,this.uuid);
    }


    public void addAccount(Account onAcct){
        this.accounts.add(onAcct);
    }

    public  String getUUID(){
        return this.uuid;
    }

    public boolean validatePin(String aPin){

        try {
            MessageDigest md=MessageDigest.getInstance("MD5");
            return MessageDigest.isEqual(md.digest(aPin.getBytes()),this.pinHas);
        } catch (NoSuchAlgorithmException e) {
            System.out.println("Error , caught NoSuchAlgorithmException");
            e.printStackTrace();
            System.exit(1);
        }
        return false;

    }

    public String getFirstName(){
        return this.firstName;
    }

    public void printAccountsSummary(){
        System.out.printf("\n\n%s's accounts summary\n",this.firstName);
        for (int a=0; a<this.accounts.size(); a++){
            System.out.printf("  %d) %s\n",a+1,
                    this.accounts.get(a).getSummaryLine());
        }
        System.out.println();
    }

    public int numAccounts(){
        return this.accounts.size();
    }

    public void printAcctTransHistory(int acctIdx){
        this.accounts.get(acctIdx).printTransHistory();
    }

    public double getAcctBalance(int acctIdx) {
        return this.accounts.get(acctIdx).getBalance();
    }

    public String getAcctUUID(int acctIdx){
        return this.accounts.get(acctIdx).getUUID();
    }

    public void addAcctTransaction(int acctIdx,double amount , String memo){
        this.accounts.get(acctIdx).addTransaction(amount,memo);
    }

}
