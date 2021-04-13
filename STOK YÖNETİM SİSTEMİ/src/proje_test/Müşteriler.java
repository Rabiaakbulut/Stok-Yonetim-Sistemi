package proje_test;

//***INHERITANCE
public class Müşteriler extends Bilgi{                             
    final private int müşteriID;              //müşterilere ait bilgiler 
    final private String müşteriAd;           //bu bilgiler değiştirilemez
    final private long müşteriTel;             //bilgiler görüntülenemez
    final private String müşteriAdres;
    
    //***CONSTRUCTOR
    public Müşteriler() {                    //değer almayan constructor          
        this.müşteriID = 00000000;           //boş atamalar
        this.müşteriAd = "yeni müşteri";
        this.müşteriTel = 05000000000;
        this.müşteriAdres = "";
    }
    //***CONSTRUCTOR OVERLOADING
    public Müşteriler(int müşteriID, String müşteriAd, long müşteriTel, String müşteriAdres) {
        this.müşteriID = müşteriID;
        this.müşteriAd = müşteriAd;          //dışardan alınan bilgileri atadık
        this.müşteriTel = müşteriTel;
        this.müşteriAdres = müşteriAdres;
    }
    
    public int getID() {  //Müşterilerde sadece ID erişilebilir, değiştirilemez
        return this.müşteriID;
    }
    //***OVERRIDE
    @Override
    public void bilgiver() {   //müşteri bilgileri
        System.out.println("Müşteri ID: " + müşteriID + "\tİsim: " + müşteriAd + "\tTelefon: " + müşteriTel + "\tAdres: " + müşteriAdres);
    }  
}
