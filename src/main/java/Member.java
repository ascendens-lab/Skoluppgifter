public class Member {

    private String firstName;
    private String surName;
    private int memberID;
    private boolean borrowedBy = false;



    public Member(String f,String s,int memberID){
        this.firstName=f;
        this.surName=s;
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

    public String getSurname() {
        return surName;
    }
}




