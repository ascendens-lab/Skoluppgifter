public class Member {

    private String firstName;
    private String surName;
    private int memberID;
    private int activeLoans = 0;




    public Member(String f, String s, int memberID){
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


    public String getSurname() {
        return surName;
    }

    public int getActiveLoans(){
        return activeLoans;
    }
    public boolean canBorrowMore() {
        return activeLoans < 3;
    }

    public void setActiveLoans(int activeLoans) {
        this.activeLoans = activeLoans;
    }
}




