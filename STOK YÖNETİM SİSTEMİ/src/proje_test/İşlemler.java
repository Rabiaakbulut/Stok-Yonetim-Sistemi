package proje_test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class İşlemler {   
    
    /*müşteri ekleme, satış yapma, stoğa ekleme, müşteri ve ürün bilgilerini
      görüntüleme gibi önemli işler bu sınıfta gerçekleşmektedir.*/
    
    //***Array List içerisinde nesne saklama(12),ekleme(32),silme(53)
    static ArrayList<Ürünler> ürünlistesi=new ArrayList<Ürünler>();   
    static ArrayList<Müşteriler> müşterilistesi=new ArrayList<Müşteriler>();
    static ArrayList<Satışlar> satışlistesi=new ArrayList<Satışlar>();
    //ArrayListlere statik eklemeseydik .add() gibi fonksiyonlarda hata alırdık
    
    //***Dizide nesne saklama,ekleme,silme (183. satırdan sonrası)
    double[][] ürünlerDiziListesi=new double[100][3];
    
    public static void depoyaÜrünEkle(String ürünAd,int ürünStok,double ürünFiyat) {  //////return yeniürün varıd
        
        try{
        String host="jdbc:derby://localhost:1527/proje";
        String uName="rabia";
        String uPass="123456789";        
        Connection con=DriverManager.getConnection(host,uName,uPass);
        
        //Ürünler yeniÜrün = new Ürünler(ürünID, ürünAd, ürünStok, ürünFiyat);
	//ürünlistesi.add(yeniÜrün);
        
        String sql = "INSERT INTO Ürünler VALUES (DEFAULT, ?, ?, ?)";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, ürünAd);
        stmt.setInt(2, ürünStok);
        stmt.setDouble(3, ürünFiyat);
        stmt.executeUpdate();
        
        
        }
        catch(SQLException err){
            System.out.println(err.getMessage());
        }        
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////
   
    static void depodanÜrünSat(int ürünId,int miktar,int müşteriId) { //ürün miktarı yeterliyese azaltsatışlara ekle	       
        try{
        String host="jdbc:derby://localhost:1527/proje";
        String uName="rabia";
        String uPass="123456789";        
        Connection con=DriverManager.getConnection(host,uName,uPass);
        String query = "SELECT * FROM Ürünler WHERE ürünId =?";
        PreparedStatement st= con.prepareStatement(query);
        st.setInt(1,ürünId);
        ResultSet rs = st.executeQuery();
        rs.next();
        int stok = rs.getInt("ürünStok");
        
        if(miktar>stok)
        {
            System.out.println("Satış işlemi başarısız!\n"
                    + "Ürün id: "+ürünId+"\tStok adeti: "+stok);
        }
        else
        {
            int sonStok=stok-miktar;
            String SQL2="UPDATE Ürünler SET ürünStok = ? WHERE ürünId =?";
            PreparedStatement st2= con.prepareStatement(SQL2);
            st2.setInt(1,sonStok);
            st2.setInt(2,ürünId);
            st2.executeUpdate();
            System.out.println("Satış işlemi başarılı");
            
            String sql = "INSERT INTO Satışlar VALUES (DEFAULT,?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, miktar);
            stmt.setInt(2, ürünId);
            stmt.setInt(3, müşteriId);
            stmt.executeUpdate();
        }        
        }
        catch(SQLException err){
            System.out.println(err.getMessage());
        }
    }    
    
    public static void müşteriEkle(String müşteriAd,String  müşteriTel,String müşteriAdres) {  //YAPILDI
        try{
        String host="jdbc:derby://localhost:1527/proje";
        String uName="rabia";
        String uPass="123456789";        
        Connection con=DriverManager.getConnection(host,uName,uPass);
        
        String sql = "INSERT INTO Müşteriler VALUES (DEFAULT, ?, ?, ?)";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, müşteriAd);
        stmt.setString(2, müşteriTel);
        stmt.setString(3, müşteriAdres);
        stmt.executeUpdate();
        }
        catch(SQLException err){
            System.out.println(err.getMessage());
        }  
    }
    
    /*satış yaparken müşteriID yoluyla müşteri bilgilerine ulaşan fonksiyon
      bu fonksiyonu depodanÜrünSat fonksiyonuyla dolaylı olarak çağırıyoruz */
    
    static void müşteriBilgileri(int müşteriId) {  
	try{
        String host="jdbc:derby://localhost:1527/proje";
        String uName="rabia";
        String uPass="123456789";        
        Connection con=DriverManager.getConnection(host,uName,uPass);
        
        String query = "SELECT * FROM Müşteriler WHERE müşteriId = ?";
        PreparedStatement pstmt = con.prepareStatement(query);
        pstmt.setInt(1, müşteriId);
        ResultSet rs = pstmt.executeQuery();
        while(rs.next()) {
            System.out.print("Müşteri id: "+müşteriId+", ");
            System.out.print("Müşteri Adı: "+rs.getString("müşteriAd")+", ");
            System.out.print("Müşteri Telefon: "+ rs.getString("müşteriTel")+", ");
            System.out.print("Müşteri Adres: "+rs.getString("müşteriAdres"));
            System.out.println();
        }
       }
        catch(SQLException err){
            System.out.println(err.getMessage());
        }
	}
    
    static void ürünDepoBilgisi(int ürünId) {   
	try{
        String host="jdbc:derby://localhost:1527/proje";
        String uName="rabia";
        String uPass="123456789";        
        Connection con=DriverManager.getConnection(host,uName,uPass);
        
        String query = "SELECT * FROM Ürünler WHERE ürünId = ?";
        PreparedStatement pstmt = con.prepareStatement(query);
        pstmt.setInt(1, ürünId);
        ResultSet rs = pstmt.executeQuery();
        while(rs.next()) {
            System.out.print("Ürün id: "+ürünId+", ");
            System.out.print("Ürün Adı: "+rs.getString("ürünAd")+", ");
            System.out.print("Ürün Stok: "+ rs.getString("ürünStok")+", ");
            System.out.print("Ürün Fiyat: "+rs.getString("ürünFiyat"));
            System.out.println();
        }
       }
        catch(SQLException err){
            System.out.println(err.getMessage());
        }
	}
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //stokta mevcut olan ürünleri ve bilgilerini yazdıran fonksiyon
    static void stoktakiÜrünler() {
        try{
        String host="jdbc:derby://localhost:1527/proje";
        String uName="rabia";
        String uPass="123456789";        
        Connection con=DriverManager.getConnection(host,uName,uPass);
        
        Statement stmt=con.createStatement();
        
        String SQL="SELECT *FROM Ürünler";
        ResultSet rs = stmt.executeQuery( SQL );
        
        while(rs.next( )){
            int ürünID = rs.getInt("ürünID");
            String ürünAd = rs.getString("ürünAd");
            int ürünStok = rs.getInt("ürünStok");
            double ürünFiyat = rs.getDouble("ürünFiyat");

            System.out.println( ürünID + " " + ürünAd + " " + ürünStok + " " + ürünFiyat );
        }
        }
        catch(SQLException err){
            System.out.println(err.getMessage());
        }
    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //kayıtta mevcut olan müşterileri ve bilgilerini yazdıran fonksiyon
    static void kayıtlıMüşteriler() {
	try{
        String host="jdbc:derby://localhost:1527/proje";
        String uName="rabia";
        String uPass="123456789";        
        Connection con=DriverManager.getConnection(host,uName,uPass);
        
        Statement stmt1=con.createStatement();
        
        String SQL1="SELECT *FROM MÜŞTERILER";
        ResultSet rs1 = stmt1.executeQuery( SQL1 );
        
        while(rs1.next( )){
            int müşteriId  = rs1.getInt("müşteriId");
            String müşteriAd  = rs1.getString("müşteriAd");
            String müşteriTel  = rs1.getString("müşteriTel");
            String müşteriAdres  = rs1.getString("müşteriAdres");

            System.out.println( müşteriId  + " " + müşteriAd  + " " + müşteriTel  + " " + müşteriAdres  );
        }
        }
        catch(SQLException err){
            System.out.println(err.getMessage());
        }
	}
    static void kayıtlıSatışlar() {
	try{
        String host="jdbc:derby://localhost:1527/proje";
        String uName="rabia";
        String uPass="123456789";        
        Connection con=DriverManager.getConnection(host,uName,uPass);
        
        Statement stmt1=con.createStatement();
        
        String SQL1="SELECT *FROM Satışlar";
        ResultSet rs1 = stmt1.executeQuery( SQL1 );
        
        while(rs1.next( )){
            int satışId  = rs1.getInt("satışId");
            int miktar  = rs1.getInt("miktar");
            int ürünId  = rs1.getInt("ürünId");
            int müşteriId  = rs1.getInt("müşteriId");

            System.out.println( satışId  + " " + miktar  + " " + ürünId  + " " + müşteriId  );
        }
        }
        catch(SQLException err){
            System.out.println(err.getMessage());
        }
	}
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////
    //***ArrayList üzerinden toplama işlemi
    //Stokta kaç adet mal olduğunu gösteren fonksiyon
    static public void stokToplamÜrün()    
    {
        try{
        String host="jdbc:derby://localhost:1527/proje";
        String uName="rabia";
        String uPass="123456789";        
        Connection con=DriverManager.getConnection(host,uName,uPass);
        
        Statement stmt = con.createStatement();
        String query = "select count(*) from Ürünler";
        ResultSet rs = stmt.executeQuery(query);
        rs.next();
        int count = rs.getInt(1);
        System.out.println("Stokta kayıtlı ürün türü sayısı: "+count);
        }
        catch(SQLException err){
            System.out.println(err.getMessage());
        }
    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////
    //***OVERLOADING
    //stokta özellikle belirtilen üründen kaç adet olduğunu gösteren fonksiyon
    //parametresiz olan tüm ürünleri getirirken burada istenilen ürün getirilir
    static public void stokToplamÜrün(int istenilenÜrünID)  
    {
       try{
        String host="jdbc:derby://localhost:1527/proje";
        String uName="rabia";
        String uPass="123456789";        
        Connection con=DriverManager.getConnection(host,uName,uPass);
        
        String query = "SELECT * FROM Ürünler WHERE ürünId = ?";
        PreparedStatement pstmt = con.prepareStatement(query);
        pstmt.setInt(1, istenilenÜrünID);
        ResultSet rs = pstmt.executeQuery();
        while(rs.next()) {
            System.out.print("Ürün adı: "+ rs.getString("ürünAd")+", ");
            System.out.print("Ürün stoğu: "+rs.getInt("ürünStok"));
            System.out.println();
        }
       }
        catch(SQLException err){
            System.out.println(err.getMessage());
        }
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////
    //bu satırdan sonra diziyle ilgili işlemler var
    //Bu kısımlar programım için çok mantıklı olmasa da ödevde dizi maddesinden 
    //dolayı bu satırları yazdım
    //Dizi yerine arraylist kullanarak daha rahat çalışma imkanı elde ettim
    
    //ürünlistesi ArrayListini diziye aktardım.
    public void diziÜrünListesi() 
    {
        int i=0;
        for (Ürünler herbirürün : ürünlistesi)
        {
            ürünlerDiziListesi[i][0]=herbirürün.getID();
            ürünlerDiziListesi[i][1]=herbirürün.getStok();
            ürünlerDiziListesi[i][2]=herbirürün.getFiyat();
            i++;
        }      	    
    }
    /*fiyatı 50 kuruştan düşük olan elemanları siler.
       Böylece kasadaki toplam fiyatları görüntülerken düşük maliyetli ürünler
       hesaplamaya katılmaz.*/
    public void diziÜrünListesiElemanSil() 
    {
        for (int i=0;i<ürünlerDiziListesi.length;i++)
        {
            if(ürünlerDiziListesi[i][2]<0.50)  
            {
                ürünlerDiziListesi[i][0]=ürünlerDiziListesi[i+1][0];
                ürünlerDiziListesi[i][1]=ürünlerDiziListesi[i+1][0];
                ürünlerDiziListesi[i][2]=ürünlerDiziListesi[i+1][0];
            }
        }      	    
    }
    //fiyatlarda bulunan 50 kuruştan yüksek olanların toplamı
    public void toplamFiyat() 
    {
        int toplam=0;
        for(int i=0;i<ürünlerDiziListesi.length;i++)
            toplam+=ürünlerDiziListesi[i][2];
        System.out.println(toplam);
    }
}
