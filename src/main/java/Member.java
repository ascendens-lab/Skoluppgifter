public class Member {

    private String firstNname;
    private String  surName;
    private int id;



    public Member(String f,String s,int id){
        this.firstNname=f;
        this.surName=s;
        this.id= id;


    }

    public String getFirstname(){
        return firstNname;

    }

    public String getsurName(){
        return  surName;
    }

    public int getid(){
        return id;
    }



}




