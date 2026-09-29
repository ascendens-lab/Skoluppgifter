public class Member {

    private String firstName;
    private int memberID;
    private boolean borrowedBy = false;



    public Member(String f,String s,int memberID){
        this.firstName=f;
        this.memberID= memberID;


    }

    public String getFirstname(){
        return firstName;

    }


    public int getID(){
        return memberID;
    }
    public boolean getborrowedBY(){
        return borrowedBy;
    }

}




