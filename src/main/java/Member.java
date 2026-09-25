public class Member {

    private String firstName;
    private String  surName;
    private int memberID;



    public Member(String f,String s,int memberID){
        this.firstName=f;
        this.surName=s;
        this.memberID= memberID;


    }

    public String getFirstname(){
        return firstName;

    }

    public String getsurName(){
        return  surName;
    }

    public int getID(){
        return memberID;
    }

   }




