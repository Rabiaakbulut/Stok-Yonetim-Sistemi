package proje_test;

public class Satışlar extends Bilgi{
    
    private int id;                //satışların özellikleri
    private int miktar;
    private Ürünler ürün;
    private Müşteriler müşteri;

    public Satışlar(int id, int miktar, Ürünler ürün, Müşteriler müşteri) {
	this.id = id;
	this.miktar = miktar;      //özellikleri atadık
	this.ürün = ürün;
	this.müşteri = müşteri;
	this.ürün.stokazalt(miktar);
    }

    @Override
    public void bilgiver() {    //satış bilgisi
	System.out.println("Satılan ürün ID: " + id + "\tmiktar" + miktar + "\türün: " + ürün + "\tmüşteri:" + this.müşteri);
    }
}
