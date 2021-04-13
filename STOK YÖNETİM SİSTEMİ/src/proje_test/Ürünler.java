package proje_test;

public class Ürünler extends Bilgi{
    
    final private int ürünID;       //ürünID değiştirlemez
    private String ürünAd;          //tüm özelliklere get ile erişim sağlandı
    private int ürünStok;           //ürünID hariç tüm özellikler set edilebilir
    private double ürünFiyat;
    
    public Ürünler(int ürünID, String ürünAd, int ürünStok,double  ürünFiyat) {
        this.ürünID = ürünID;
        this.ürünAd = ürünAd;      //alınan bilgiler atandı
        this.ürünStok = ürünStok;
        this.ürünFiyat=ürünFiyat;
    }
    
    //***ENCAPSULATION,GET,SET
    public int getID() {          //get ile erişim, set ile değiştirme sağlandı       
        return this.ürünID;       //bir tek ürünID nin set fonksiyonu yok.
    }                             //çünkü ürünID değişsin istemeyiz
    public int getStok() {           
        return this.ürünStok;
    }
    public void setStok(int yeniStok)
    {
        this.ürünStok=yeniStok;        
    }
    public String getAd() {
        return this.ürünAd;
    }
    public void setAd(String yeniAd)
    {
        this.ürünAd=yeniAd;        
    }
    public double getFiyat() {
        return this.ürünFiyat;
    }
    public void setFiyat(double yeniFiyat)
    {
        this.ürünFiyat=yeniFiyat;        
    }
    
    @Override
    public void bilgiver() {        //ürün bilgileri
        System.out.println("ürün ID: " + ürünID + "\tÜrün Adı: " + ürünAd + "\tStok Adeti: "+ ürünStok);
    }
    
    void stokazalt(int miktar) {          
        if(ürünStok>0)                          //stokta varsa satış yapılabilir
            this.ürünStok = this.ürünStok - miktar;
        else                                    //stokta yoksa satış da yoktur
        {                           
            System.out.println("Stoklar tükendi...");
            ürünStok=0;
        }
    }
}
