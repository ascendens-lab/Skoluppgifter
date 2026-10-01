public class Member {

    private String firstName;
    private String surName;
    private int memberID;
    private int activeLoans = 0;




    public Member(String f, String s, int memberID){//Konstruerar datatypen Member som bestämmer vad vilken data som varje
                                                    //låntagare ska innehåll. .
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
    public boolean canBorrowMore() {//Sätter gränsen för hur många böcker varje låntagare på låna åt gången.
        return activeLoans < 3;
    }

    public void setActiveLoans(int activeLoans) {//Uppdaterar hur många aktiva lån låntagaren har.
        this.activeLoans = activeLoans;
    }
}




